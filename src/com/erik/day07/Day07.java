package com.erik.day07;

import java.util.*;

public class Day07 {
    final private String[] input;
    int numberOfOptions = 0;
    Set<String> seenBags = new HashSet<>();

    public Day07(String[] input) {
        this.input = input;
    }

    public int part1() {
        final String checkValue = "shiny gold";
        Map<String,Map<String,Integer>> rules = buildRulesFromInput();
        checkContents(rules,checkValue);
        return numberOfOptions;
    }

    private void checkContents(Map<String,Map<String,Integer>> rules, String checkValue) {
        for (String key : rules.keySet()) {
            Map<String,Integer> currentRule = rules.get(key);
            if (currentRule.containsKey(checkValue)) {
                if (seenBags.add(key)) {
                    numberOfOptions++;
                    checkContents(rules, key);
                }
            }
        }
    }

    public long part2() {
        String checkValue = "shiny gold";
        Map<String, Map<String, Integer>> rules = buildRulesFromInput();
        return sumNumberOfContainedBags(rules,checkValue);
    }

    private Map<String, Map<String,Integer>> buildRulesFromInput() {
        Map<String,Map<String,Integer>> rules = new HashMap<>();

        for (String line : input) {
            String topBag = line.split(" bags contain ")[0];
            String[] contents = line.split(" bags contain ")[1].split(", ");

            Map<String, Integer> containedBagsWithQuantity = new HashMap<>();

            for (String content : contents) {
                Integer numberOfBags;
                try {
                    numberOfBags = Integer.parseInt(content.split(" ")[0]);
                } catch (NumberFormatException e) {
                    numberOfBags = 0;
                }
                String nameOfBag = content.split(" ")[1] + " " + content.split(" ")[2];
                containedBagsWithQuantity.putIfAbsent(nameOfBag,numberOfBags);
            }
            rules.putIfAbsent(topBag,containedBagsWithQuantity);
        }

        return rules;
    }

    private long sumNumberOfContainedBags(Map<String,Map<String,Integer>> rules, String checkValue) {
        Map<String,Integer> currentBag = rules.get(checkValue);
        long numberOfBags = 0;
        for (String key : currentBag.keySet()) {
            if (currentBag.get(key) != 0)
                numberOfBags += currentBag.get(key) + currentBag.get(key) * sumNumberOfContainedBags(rules,key);
        }
        return numberOfBags;
    }
}
