package com.erik.day18;

import com.erik.InputProvider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day18Test {
    @Test
    void part1_1() {
        String[] input = new String[] {
                "1 + 2 * 3 + 4 * 5 + 6"
        };
        Day18 cut = new Day18(input);
        Assertions.assertEquals(71L, cut.part1());
    }
    @Test
    void part1_2() {
        String[] input = new String[] {
                "1 + (2 * 3) + (4 * (5 + 6))"
        };
        Day18 cut = new Day18(input);
        Assertions.assertEquals(51L, cut.part1());
    }
    @Test
    void part1_3() {
        String[] input = new String[] {
                "2 * 3 + (4 * 5)"
        };
        Day18 cut = new Day18(input);
        Assertions.assertEquals(26L, cut.part1());
    }
    @Test
    void part1_4() {
        String[] input = new String[] {
                "5 + (8 * 3 + 9 + 3 * 4 * 3)"
        };
        Day18 cut = new Day18(input);
        Assertions.assertEquals(437L, cut.part1());
    }
    @Test
    void part1_5() {
        String[] input = new String[] {
                "5 * 9 * (7 * 3 * 3 + 9 * 3 + (8 + 6 * 4))"
        };
        Day18 cut = new Day18(input);
        Assertions.assertEquals(12240L, cut.part1());
    }
    @Test
    void part1_6() {
        String[] input = new String[] {
                "((2 + 4 * 9) * (6 + 9 * 8 + 6) + 6) + 2 + 4 * 2"
        };
        Day18 cut = new Day18(input);
        Assertions.assertEquals(13632L, cut.part1());
    }

    @Test
    void part1WithRealInput() throws InputProvider.FileError {
        Day18 cut = new Day18(new InputProvider().getAsString("InputFiles/inputDay18.txt"));
        Assertions.assertEquals(2743012121210L, cut.part1());
    }

    @Test
    void part2_1() {
        String[] input = new String[] {
                "1 + 2 * 3 + 4 * 5 + 6"
        };
        Day18 cut = new Day18(input);
        Assertions.assertEquals(231L, cut.part2());
    }
    @Test
    void part2_2() {
        String[] input = new String[] {
                "1 + (2 * 3) + (4 * (5 + 6))"
        };
        Day18 cut = new Day18(input);
        Assertions.assertEquals(51L, cut.part2());
    }
    @Test
    void part2_3() {
        String[] input = new String[] {
                "2 * 3 + (4 * 5)"
        };
        Day18 cut = new Day18(input);
        Assertions.assertEquals(46L, cut.part2());
    }
    @Test
    void part2_4() {
        String[] input = new String[] {
                "5 + (8 * 3 + 9 + 3 * 4 * 3)"
        };
        Day18 cut = new Day18(input);
        Assertions.assertEquals(1445L, cut.part2());
    }
    @Test
    void part2_5() {
        String[] input = new String[] {
                "5 * 9 * (7 * 3 * 3 + 9 * 3 + (8 + 6 * 4))"
        };
        Day18 cut = new Day18(input);
        Assertions.assertEquals(669060L, cut.part2());
    }
    @Test
    void part2_6() {
        String[] input = new String[] {
                "((2 + 4 * 9) * (6 + 9 * 8 + 6) + 6) + 2 + 4 * 2"
        };
        Day18 cut = new Day18(input);
        Assertions.assertEquals(23340L, cut.part2());
    }

    @Test
    void part2WithRealInput() {
        Day18 cut = new Day18(new InputProvider().get("inputDay18.txt"));
        Assertions.assertEquals(65658760783597L, cut.part2());
    }
}
