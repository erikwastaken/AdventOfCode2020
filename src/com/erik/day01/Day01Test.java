package com.erik.day01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day01Test {
    @Test
    public void testPart1() {
        Day01 day01 = new Day01();
        assertEquals(514579, day01.part1("1721 979 366 299 675 1456"));
    }

    @Test
    void testPart2() {
        Day01 day01 = new Day01();
        assertEquals(241861950, day01.part2("1721 979 366 299 675 1456"));
    }
}