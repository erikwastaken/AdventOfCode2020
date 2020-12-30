package com.erik.day23;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day23Test {
    @Test
    void part1_1Move() {
        String input = "389125467";
        Day23 cut = new Day23(input);
        Assertions.assertEquals("54673289", cut.part1(1));
    }

    @Test
    void part1_2Moves() {
        String input = "389125467";
        Day23 cut = new Day23(input);
        Assertions.assertEquals("32546789", cut.part1(2));
    }

    @Test
    void part1_3Moves() {
        String input = "389125467";
        Day23 cut = new Day23(input);
        Assertions.assertEquals("34672589", cut.part1(3));
    }

    @Test
    void part1_4Moves() {
        String input = "389125467";
        Day23 cut = new Day23(input);
        Assertions.assertEquals("32584679", cut.part1(4));
    }

    @Test
    void part1_5Moves() {
        String input = "389125467";
        Day23 cut = new Day23(input);
        Assertions.assertEquals("36792584", cut.part1(5));
    }

    @Test
    void part1_10Moves() {
        String input = "389125467";
        Day23 cut = new Day23(input);
        Assertions.assertEquals("92658374", cut.part1(10));
    }

    @Test
    void part1_11Moves() {
        String input = "389125467";
        Day23 cut = new Day23(input);
        Assertions.assertEquals("92637458", cut.part1(11));
    }

    @Test
    void part1_12Moves() {
        String input = "389125467";
        Day23 cut = new Day23(input);
        Assertions.assertEquals("92637458", cut.part1(11));
    }

    @Test
    void part1_100Moves() {
        String input = "389125467";
        Day23 cut = new Day23(input);
        Assertions.assertEquals("67384529", cut.part1(100));
    }

    @Test
    void part1WithRealInput_100Moves() {
        String input = "389547612";
        Day23 cut = new Day23(input);
        Assertions.assertEquals("45286397", cut.part1(100));
    }
}
