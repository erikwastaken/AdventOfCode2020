package com.erik.day23;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day23Test {
    @Test
    void part1_1Move() {
        String input = "389125467";
        Day23 cut = new Day23(input);
        Assertions.assertEquals(54673289L, cut.processPart1(1));
    }

    @Test
    void part1_2Moves() {
        String input = "389125467";
        Day23 cut = new Day23(input);
        Assertions.assertEquals(32546789L, cut.processPart1(2));
    }

    @Test
    void part1_3Moves() {
        String input = "389125467";
        Day23 cut = new Day23(input);
        Assertions.assertEquals(34672589L, cut.processPart1(3));
    }

    @Test
    void part1_4Moves() {
        String input = "389125467";
        Day23 cut = new Day23(input);
        Assertions.assertEquals(32584679L, cut.processPart1(4));
    }

    @Test
    void part1_5Moves() {
        String input = "389125467";
        Day23 cut = new Day23(input);
        Assertions.assertEquals(36792584L, cut.processPart1(5));
    }

    @Test
    void part1_10Moves() {
        String input = "389125467";
        Day23 cut = new Day23(input);
        Assertions.assertEquals(92658374L, cut.processPart1(10));
    }

    @Test
    void part1_11Moves() {
        String input = "389125467";
        Day23 cut = new Day23(input);
        Assertions.assertEquals(92637458L, cut.processPart1(11));
    }

    @Test
    void part1_12Moves() {
        String input = "389125467";
        Day23 cut = new Day23(input);
        Assertions.assertEquals(92637458L, cut.processPart1(11));
    }

    @Test
    void part1_100Moves() {
        String input = "389125467";
        Day23 cut = new Day23(input);
        Assertions.assertEquals(67384529L, cut.processPart1(100));
    }

    @Test
    void part1WithRealInput_100Moves() {
        String input = "389547612";
        Day23 cut = new Day23(input);
        Assertions.assertEquals(45286397L, cut.processPart1(100));
    }

    @Test
    void part2() {
        String input = "389125467";
        Day23 cut = new Day23(input);
        Assertions.assertEquals(149245887792L, cut.part2());
    }
}
