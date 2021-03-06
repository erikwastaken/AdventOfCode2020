package com.erik.day23;

import com.erik.InputProvider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Day23Test {
    @Test
    void part1_1Move() {
        List<Integer> input = List.of(3,8,9,1,2,5,4,6,7);
        Day23 cut = new Day23(input);
        Assertions.assertEquals(54673289L, cut.part1(1));
    }

    @Test
    void part1_2Moves() {
        List<Integer> input = List.of(3,8,9,1,2,5,4,6,7);
        Day23 cut = new Day23(input);
        Assertions.assertEquals(32546789L, cut.part1(2));
    }

    @Test
    void part1_3Moves() {
        List<Integer> input = List.of(3,8,9,1,2,5,4,6,7);
        Day23 cut = new Day23(input);
        Assertions.assertEquals(34672589L, cut.part1(3));
    }

    @Test
    void part1_4Moves() {
        List<Integer> input = List.of(3,8,9,1,2,5,4,6,7);
        Day23 cut = new Day23(input);
        Assertions.assertEquals(32584679L, cut.part1(4));
    }

    @Test
    void part1_5Moves() {
        List<Integer> input = List.of(3,8,9,1,2,5,4,6,7);
        Day23 cut = new Day23(input);
        Assertions.assertEquals(36792584L, cut.part1(5));
    }

    @Test
    void part1_10Moves() {
        List<Integer> input = List.of(3,8,9,1,2,5,4,6,7);
        Day23 cut = new Day23(input);
        Assertions.assertEquals(92658374L, cut.part1(10));
    }

    @Test
    void part1_11Moves() {
        List<Integer> input = List.of(3,8,9,1,2,5,4,6,7);
        Day23 cut = new Day23(input);
        Assertions.assertEquals(92637458L, cut.part1(11));
    }

    @Test
    void part1_12Moves() {
        List<Integer> input = List.of(3,8,9,1,2,5,4,6,7);
        Day23 cut = new Day23(input);
        Assertions.assertEquals(92637458L, cut.part1(11));
    }

    @Test
    void part1_100Moves() {
        List<Integer> input = List.of(3,8,9,1,2,5,4,6,7);
        Day23 cut = new Day23(input);
        Assertions.assertEquals(67384529L, cut.part1(100));
    }

    @Test
    void part1WithRealInput_100Moves() {
        List<Integer> input = List.of(3,8,9,5,4,7,6,1,2);
        Day23 cut = new Day23(input);
        Assertions.assertEquals(45286397L, cut.part1());
    }

    @Test
    void part2() {
        String input = "389125467\n";
        Day23 cut = new Day23(input);
        Assertions.assertEquals(149245887792L, cut.part2());
    }

    @Test
    void part2WithRealInput() throws InputProvider.FileError {
        Day23 cut = new Day23(new InputProvider().getAsString("InputFiles/inputDay23.txt"));
        Assertions.assertEquals(836763710L, cut.part2());
    }

    @Test
    void part2CanBeRunAfterPart1() throws InputProvider.FileError {
        Day23 cut = new Day23(new InputProvider().getAsString("InputFiles/inputDay23.txt"));
        Assertions.assertEquals(45286397L, cut.part1());
        Assertions.assertEquals(836763710L, cut.part2());
    }
}
