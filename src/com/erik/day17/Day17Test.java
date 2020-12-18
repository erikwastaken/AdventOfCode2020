package com.erik.day17;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day17Test {
    @Test
    void part1() {
        String[] input = new String[] {
                ".#.",
                "..#",
                "###"
        };
        Day17 cut = new Day17(input);
        Assertions.assertEquals(112, cut.part1());
    }
}
