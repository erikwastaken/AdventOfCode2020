package com.erik.day03;

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
    void testPart1() {
        Day03 day03 = new Day03(grid);
        Assertions.assertEquals(7, day03.part1(3,1));
    }

    @Test
    void testPart2() {
        Day03 day03 = new Day03(grid);
        Assertions.assertEquals(336, day03.part2());
    }
}
