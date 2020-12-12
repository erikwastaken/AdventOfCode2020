package com.erik.day11;

import com.erik.InputProvider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day11Test {
    @Test
    void part1() {
        String[] input = new String[] {
            "L.LL.LL.LL",
            "LLLLLLL.LL",
            "L.L.L..L..",
            "LLLL.LL.LL",
            "L.LL.LL.LL",
            "L.LLLLL.LL",
            "..L.L.....",
            "LLLLLLLLLL",
            "L.LLLLLL.L",
            "L.LLLLL.LL"
        };
        Day11 day11 = new Day11(input);
        Assertions.assertEquals(37, day11.part1());

        day11 = new Day11(new InputProvider().get("inputDay11.txt"));
        Assertions.assertEquals(2303, day11.part1());
    }

    @Test
    void part2() {
        String[] input = new String[] {
                "L.LL.LL.LL",
                "LLLLLLL.LL",
                "L.L.L..L..",
                "LLLL.LL.LL",
                "L.LL.LL.LL",
                "L.LLLLL.LL",
                "..L.L.....",
                "LLLLLLLLLL",
                "L.LLLLLL.L",
                "L.LLLLL.LL"
        };
        Day11 day11 = new Day11(input);
        Assertions.assertEquals(26, day11.part2());

        day11 = new Day11(new InputProvider().get("inputDay11.txt"));
        Assertions.assertEquals(2057, day11.part2());
    }
}
