package com.erik;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day02Test {
    @Test
    void testPart1() {
        String[] input = {"1-3 a: abcde", "1-3 b: cdefg", "2-9 c: ccccccccc"};
        Day02 day02 = new Day02();
        Assertions.assertEquals(2, day02.part1(input));
    }
}
