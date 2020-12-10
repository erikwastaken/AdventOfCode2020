package com.erik.day10;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day10Test {
    @Test
    void part1() {
        String[] inputShort = new String[] {"16", "10", "15", "5", "1", "11", "7", "19", "6", "12", "4"};
        Day10 day10 = new Day10(inputShort);
        Assertions.assertEquals(35, day10.part1());

        String[] input = new String[] {"28", "33", "18", "42", "31", "14", "46", "20", "48", "47", "24", "23", "49", "45",
                "19", "38", "39", "11", "1", "32", "25", "35", "8", "17", "7", "9", "4", "2", "34", "10", "3"};
        day10 = new Day10(input);
        Assertions.assertEquals(220, day10.part1());
    }

    @Test
    void part2() {
        String[] inputShort = new String[] {"16", "10", "15", "5", "1", "11", "7", "19", "6", "12", "4"};
        Day10 day10 = new Day10(inputShort);
        Assertions.assertEquals(8, day10.part2());

        String[] input = new String[] {"28", "33", "18", "42", "31", "14", "46", "20", "48", "47", "24", "23", "49", "45",
                "19", "38", "39", "11", "1", "32", "25", "35", "8", "17", "7", "9", "4", "2", "34", "10", "3"};
        day10 = new Day10(input);
        Assertions.assertEquals(19208, day10.part2());
    }
}
