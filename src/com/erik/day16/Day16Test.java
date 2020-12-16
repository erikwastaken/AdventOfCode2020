package com.erik.day16;

import com.erik.InputProvider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Day16Test {
    @Test
    void part1() {
        String[] input = new String[] {
            "class: 1-3 or 5-7",
            "row: 6-11 or 33-44",
            "seat: 13-40 or 45-50",
            "",
            "your ticket:",
            "7,1,14",
            "",
            "nearby tickets:",
            "7,3,47",
            "40,4,50",
            "55,2,20",
            "38,6,12"
        };
        Day16 day16 = new Day16(input);
        Assertions.assertEquals(71, day16.part1());
    }

    @Test
    void part1WithRealInput() {
        Day16 day16 = new Day16(new InputProvider().get("inputDay16.txt"));
        Assertions.assertEquals(26869,day16.part1());
    }

    @Test
    void returnsAllIndexesForFieldAndTicket() {
        String[] input = new String[] {
        "class: 0-1 or 4-19",
        "row: 0-5 or 8-19",
        "seat: 0-13 or 16-19",
        "",
        "your ticket:",
        "11,12,13",
        "",
        "nearby tickets:",
        "3,9,18",
        "15,1,5",
        "5,14,9"
        };

        Day16 cut = new Day16(input);
        Assertions.assertEquals(new HashSet<>(Arrays.asList(1,2)), cut.getPossibleIndexesForField("seat", "15,1,5"));
        Assertions.assertEquals(new HashSet<>(Arrays.asList(0,1,2)), cut.getPossibleIndexesForField("seat", "3,9,18"));
    }

    @Test
    void identifiesFieldIndexes() {
        String[] input = new String[] {
                "class: 0-1 or 4-19",
                "row: 0-5 or 8-19",
                "seat: 0-13 or 16-19",
                "",
                "your ticket:",
                "11,12,13",
                "",
                "nearby tickets:",
                "3,9,18",
                "15,1,5",
                "5,14,9"
        };
        Day16 cut = new Day16(input);
        HashMap<String, Integer> expected = new HashMap<>();
        expected.put("row", 0);
        expected.put("class", 1);
        expected.put("seat", 2);

        Assertions.assertEquals(expected, cut.identifyFieldIndexes());
    }

    @Test
    void part2WithRealInput() {
        Day16 cut = new Day16(new InputProvider().get("inputDay16.txt"));
        Assertions.assertEquals(855275529001L, cut.part2());
    }
}
