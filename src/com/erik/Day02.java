package com.erik;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day02 {

    public int part1(String[] input) {
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

    public int part2(String[] input) {
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
