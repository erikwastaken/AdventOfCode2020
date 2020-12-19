package com.erik.day17;

import com.erik.InputProvider;
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
        // cycle - active cubes after cycle
        // 1     - 11
        // 2     - 21
        // 3     - 40
        Day17 cut = new Day17(input);
        Assertions.assertEquals(112L, cut.part1());
    }

    @Test
    void part1WithRealInput() {
        Day17 cut = new Day17(new InputProvider().get("inputDay17.txt"));
        Assertions.assertEquals(424L, cut.part1());
    }

    @Test
    void part2() {
        String[] input = new String[] {
                ".#.",
                "..#",
                "###"
        };
        Day17 cut = new Day17(input);
        Assertions.assertEquals(848L, cut.part2());
    }
}
