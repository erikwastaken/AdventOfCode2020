package com.erik.day05;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class Day05Test {
    @Test
    public void testPart1() {
        String[] input = {"BFFFBBFRRR", "FFFBBBFRRR", "BBFFBBFRLL"};
        Day05 day05 = new Day05(input);
        Assertions.assertEquals(820, day05.part1());
    }
}
