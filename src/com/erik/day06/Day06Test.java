package com.erik.day06;

import com.erik.InputProvider;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class Day06Test {
    @Test
    public void testPart1() {
        String[] input = {"abc", "", "a", "b", "c", "", "ab", "ac", "", "a", "a", "a", "a", "", "b"};
        Day06 day06 = new Day06(input);
        Assertions.assertEquals(11, day06.part1());

        day06 = new Day06(new InputProvider().get("inputDay06.txt"));
        Assertions.assertEquals(6585, day06.part1());
    }

    @Test
    public void testPart2() {
        String[] input = {"abc", "", "a", "b", "c", "", "ab", "ac", "", "a", "a", "a", "a", "", "b"};
        Day06 day06 = new Day06(input);
        Assertions.assertEquals(6, day06.part2());

        day06 = new Day06(new InputProvider().get("inputDay06.txt"));
        Assertions.assertEquals(3276, day06.part2());
    }
}
