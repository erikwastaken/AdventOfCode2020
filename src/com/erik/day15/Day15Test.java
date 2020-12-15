package com.erik.day15;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day15Test {
    @Test
    void part1_1() {
        String input = "0,3,6";
        Day15 day15 = new Day15(input);
        Assertions.assertEquals(436, day15.part1());
    }

    @Test
    void part1_2() {
        String input = "1,3,2";
        Day15 day15 = new Day15(input);
        Assertions.assertEquals(1, day15.part1());
    }

    @Test
    void part1_3() {
        String input = "2,1,3";
        Day15 day15 = new Day15(input);
        Assertions.assertEquals(10, day15.part1());
    }

    @Test
    void part1_4() {
        String input = "1,2,3";
        Day15 day15 = new Day15(input);
        Assertions.assertEquals(27, day15.part1());
    }

    @Test
    void part1_5() {
        String input = "2,3,1";
        Day15 day15 = new Day15(input);
        Assertions.assertEquals(78, day15.part1());
    }

    @Test
    void part1_6() {
        String input = "3,2,1";
        Day15 day15 = new Day15(input);
        Assertions.assertEquals(438, day15.part1());
    }

    @Test
    void part1_7() {
        String input = "3,1,2";
        Day15 day15 = new Day15(input);
        Assertions.assertEquals(1836, day15.part1());
    }

    @Test
    void part1WithRealInput() {
        String input = "11,0,1,10,5,19";
        Day15 day15 = new Day15(input);
        Assertions.assertEquals(870, day15.part1());
    }

    @Test
    void part2_1() {
        String input = "0,3,6";
        Day15 day15 = new Day15(input);
        Assertions.assertEquals(175594, day15.part2());
    }

    @Test
    void part2_2() {
        String input = "1,3,2";
        Day15 day15 = new Day15(input);
        Assertions.assertEquals(2578, day15.part2());
    }

    @Test
    void part2_3() {
        String input = "2,1,3";
        Day15 day15 = new Day15(input);
        Assertions.assertEquals(3544142, day15.part2());
    }

    @Test
    void part2_4() {
        String input = "1,2,3";
        Day15 day15 = new Day15(input);
        Assertions.assertEquals(261214, day15.part2());
    }

    @Test
    void part2_5() {
        String input = "2,3,1";
        Day15 day15 = new Day15(input);
        Assertions.assertEquals(6895259, day15.part2());
    }

    @Test
    void part2_6() {
        String input = "3,2,1";
        Day15 day15 = new Day15(input);
        Assertions.assertEquals(18, day15.part2());
    }

    @Test
    void part2_7() {
        String input = "3,1,2";
        Day15 day15 = new Day15(input);
        Assertions.assertEquals(362, day15.part2());
    }

    @Test
    void part2WithRealInput() {
        String input = "11,0,1,10,5,19";
        Day15 day15 = new Day15(input);
        Assertions.assertEquals(9136, day15.part2());
    }
}
