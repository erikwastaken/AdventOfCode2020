package com.erik.day23;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Day23Test {
    @Test
    void part1_1Move() {
        List<Integer> input = List.of(3,8,9,1,2,5,4,6,7);
        Day23 cut = new Day23(input);
        Assertions.assertEquals(54673289L, cut.processPart1(1));
    }

    @Test
    void part1_2Moves() {
        List<Integer> input = List.of(3,8,9,1,2,5,4,6,7);
        Day23 cut = new Day23(input);
        Assertions.assertEquals(32546789L, cut.processPart1(2));
    }

    @Test
    void part1_3Moves() {
        List<Integer> input = List.of(3,8,9,1,2,5,4,6,7);
        Day23 cut = new Day23(input);
        Assertions.assertEquals(34672589L, cut.processPart1(3));
    }

    @Test
    void part1_4Moves() {
        List<Integer> input = List.of(3,8,9,1,2,5,4,6,7);
        Day23 cut = new Day23(input);
        Assertions.assertEquals(32584679L, cut.processPart1(4));
    }

    @Test
    void part1_5Moves() {
        List<Integer> input = List.of(3,8,9,1,2,5,4,6,7);
        Day23 cut = new Day23(input);
        Assertions.assertEquals(36792584L, cut.processPart1(5));
    }

    @Test
    void part1_10Moves() {
        List<Integer> input = List.of(3,8,9,1,2,5,4,6,7);
        Day23 cut = new Day23(input);
        Assertions.assertEquals(92658374L, cut.processPart1(10));
    }

    @Test
    void part1_11Moves() {
        List<Integer> input = List.of(3,8,9,1,2,5,4,6,7);
        Day23 cut = new Day23(input);
        Assertions.assertEquals(92637458L, cut.processPart1(11));
    }

    @Test
    void part1_12Moves() {
        List<Integer> input = List.of(3,8,9,1,2,5,4,6,7);
        Day23 cut = new Day23(input);
        Assertions.assertEquals(92637458L, cut.processPart1(11));
    }

    @Test
    void part1_100Moves() {
        List<Integer> input = List.of(3,8,9,1,2,5,4,6,7);
        Day23 cut = new Day23(input);
        Assertions.assertEquals(67384529L, cut.processPart1(100));
    }

    @Test
    void part1WithRealInput_100Moves() {
        List<Integer> input = List.of(3,8,9,5,4,7,6,1,2);
        Day23 cut = new Day23(input);
        Assertions.assertEquals(45286397L, cut.processPart1(100));
    }

    @Test
    void part2() {
        List<Integer> input = List.of(3,8,9,1,2,5,4,6,7);
        Day23 cut = new Day23(input);
        Assertions.assertEquals(149245887792L, cut.part2());
    }
}
