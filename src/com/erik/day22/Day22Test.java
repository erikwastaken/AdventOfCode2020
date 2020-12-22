package com.erik.day22;

import com.erik.InputProvider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day22Test {
    @Test
    void part1() {
        String[] input = new String[] {
                "Player 1:",
                "9",
                "2",
                "6",
                "3",
                "1",
                "",
                "Player 2:",
                "5",
                "8",
                "4",
                "7",
                "10"
        };
        Day22 cut = new Day22(input);
        Assertions.assertEquals(306L, cut.part1());
    }

    @Test
    void part1WithRealInput() {
        Day22 cut = new Day22(new InputProvider().get("inputDay22.txt"));
        Assertions.assertEquals(35818L, cut.part1());
    }

    @Test
    void part2() {
        String[] input = new String[] {
                "Player 1:",
                "9",
                "2",
                "6",
                "3",
                "1",
                "",
                "Player 2:",
                "5",
                "8",
                "4",
                "7",
                "10"
        };
        Day22 cut = new Day22(input);
        Assertions.assertEquals(291L, cut.part2());
    }

    @Test
    void part2WithRealInput() {
        Day22 cut = new Day22(new InputProvider().get("inputDay22.txt"));
        Assertions.assertEquals(34771L, cut.part2());
    }
}
