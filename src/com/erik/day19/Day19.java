package com.erik.day19;

import com.erik.AdventDay;

import java.util.Arrays;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day19 implements AdventDay {
    private final HashMap<String, String> rules;
    private final String[] messages;
    public Day19(String[] input) {
        rules = buildRules(input);
        messages = buildMessages(input);
    }

    private String[] buildMessages(String[] input) {
        int start = -1;
        for (int i=0; i<input.length; i++) {
            if (input[i].length() == 0) {
                start = i + 1;
                break;
            }
        }
        return Arrays.copyOfRange(input,start,input.length);
    }

    private HashMap<String, String> buildRules(String[] input) {
        HashMap<String,String> rules = new HashMap<>();
        for (String line : input) {
            if (line.length() == 0)
                break;
            rules.put(line.split(": ")[0], line.split(": ")[1]);
        }
        return rules;
    }

    public long part1() {
        String ruleToMatch = resolveRule("0");
        long counter = 0;
        Pattern pattern = Pattern.compile("^" + ruleToMatch + "$");
        for (String message : messages) {
            Matcher matcher = pattern.matcher(message);
            if (matcher.find())
                counter++;
        }
        return counter;
    }

    private String resolveRule(String key) {
        StringBuilder exp = new StringBuilder();
        String rule = rules.get(key);
        if (rule.contains("a"))
            return "a";
        if (rule.contains("b"))
            return "b";

        exp.append("(");
        for (String split : rule.split(" ")) {
            if (split.equals("|")) {
                exp.append(split);
                continue;
            }
            exp.append(resolveRule(split));
        }
        exp.append(")");
        return exp.toString();
    }

    public long part2() {
        // 8 and 11 only occur in rule 0;
        // 0 -> 8 11 -> (42 | 42 8) (42 31 | 42 11 31)
        long counter = 0;
        String rule8 = resolveRule("8");
        String rule42 = resolveRule("42");
        String rule31 = resolveRule("31");

        // should be enough to include all cases given the input...
        // something like a recursion regex which would allow replacements like 42 11 31 does not seem possible...
        for (int i=1; i<10; i++) {
            String r = "^" + rule8 + "+" + "(" + rule42 + "{" + i + "}" + rule31 + "{" + i + "}" + ")" + "$";
            Pattern pattern = Pattern.compile(r);

            for (String message : messages) {
                Matcher matcher = pattern.matcher(message);
                if (matcher.find())
                    counter++;
            }
        }
        return counter;
    }
}
