package com.erik.day01;

import com.erik.InputProvider;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day01Test {
    @Test
    public void testPart1() {
        Day01 day01 = new Day01();
        assertEquals(514579, day01.part1("1721 979 366 299 675 1456"));

        assertEquals(121396, day01.part1(new InputProvider().get("inputDay01.txt")[0]));
    }

    @Test
    void testPart2() {
        Day01 day01 = new Day01();
        assertEquals(241861950, day01.part2("1721 979 366 299 675 1456"));

        assertEquals(73616634, day01.part2(new InputProvider().get("inputDay01.txt")[0]));
    }
}