package com.erik.day12;


import com.erik.InputProvider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day12Test {
    @Test
    void part1() {
        String[] input = new String[]{
                "F10",
                "N3",
                "F7",
                "R90",
                "F11"
        };
        Day12 day12 = new Day12(input);
        Assertions.assertEquals(25, day12.part1());
    }

    @Test
    void part1WithRealInput() throws InputProvider.FileError {
        Day12 day12 = new Day12(new InputProvider().getAsString("InputFiles/inputDay12.txt"));
        Assertions.assertEquals(364, day12.part1());
    }

    @Test
    void part2() {
        String[] input = new String[]{
                "F10",
                "N3",
                "F7",
                "R90",
                "F11"
        };
        Day12 day12 = new Day12(input);
        Assertions.assertEquals(286, day12.part2());
    }

    @Test
    void part2WithRealInput() {
        Day12 day12 = new Day12(new InputProvider().get("inputDay12.txt"));
        Assertions.assertEquals(39518, day12.part2());
    }
}
