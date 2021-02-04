package com.erik.day02;

import com.erik.AdventDay;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day02 implements AdventDay {
    private final String[] input;

    public Day02(String[] input){
        this.input = input;
    }
    public Day02(String inputStr) { this.input = inputStr.split("\n"); }

    public long part1() {
        int numberOfValidPasswords = 0;

        for (String data : input) {
            myEntry entry = myEntry.createFromString(data);

            int count = 0;
            Pattern p = Pattern.compile(entry.letter);
            Matcher m = p.matcher(entry.password);
            while (m.find()) {
                count++;
            }
            if (count <= entry.rangeHigh && count >= entry.rangeLow)
                numberOfValidPasswords++;
        }
        return numberOfValidPasswords;
    }

    public long part2() {
        int numberOfValidPasswords = 0;

        for (String data : input) {
            myEntry entry = myEntry.createFromString(data);

            if ((entry.password.charAt(entry.rangeLow - 1) == entry.letter.charAt(0) && entry.password.charAt(entry.rangeHigh - 1) != entry.letter.charAt(0)) || (entry.password.charAt(entry.rangeLow - 1) != entry.letter.charAt(0) && entry.password.charAt(entry.rangeHigh - 1) == entry.letter.charAt(0))) {
                numberOfValidPasswords++;
            }
        }
        return numberOfValidPasswords;
    }
}
