package com.erik.day05;

import com.erik.InputProvider;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class Day05Test {
    @Test
    public void testPart1() {
        String[] input = {"BFFFBBFRRR", "FFFBBBFRRR", "BBFFBBFRLL"};
        Day05 day05 = new Day05(input);
        Assertions.assertEquals(820, day05.part1());

        day05 = new Day05(new InputProvider().get("inputDay05.txt"));
        Assertions.assertEquals(848, day05.part1());
    }

    @Test
    public void testPart2() {
        String[] input = new InputProvider().get("inputDay05.txt");
        Day05 day05 = new Day05(input);
        Assertions.assertEquals(682, day05.part2());
    }
}
