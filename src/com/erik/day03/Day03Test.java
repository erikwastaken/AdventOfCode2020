package com.erik.day03;

import com.erik.InputProvider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day03Test {
    private String[] grid = {
            "..##.......",
            "#...#...#..",
            ".#....#..#.",
            "..#.#...#.#",
            ".#...##..#.",
            "..#.##.....",
            ".#.#.#....#",
            ".#........#",
            "#.##...#...",
            "#...##....#",
            ".#..#...#.#"
    };

    @Test
    void testPart1() throws InputProvider.FileError {
        Day03 day03 = new Day03(grid);
        Assertions.assertEquals(7, day03.part1());

        day03 = new Day03(new InputProvider().getAsString("InputFiles/inputDay03.txt"));
        Assertions.assertEquals(205, day03.part1());
    }

    @Test
    void testPart2() {
        Day03 day03 = new Day03(grid);
        Assertions.assertEquals(336, day03.part2());

        day03 = new Day03(new InputProvider().get("inputDay03.txt"));
        Assertions.assertEquals(3952146825L, day03.part2());
    }
}
