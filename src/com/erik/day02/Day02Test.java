package com.erik.day02;

import com.erik.InputProvider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day02Test {
    String[] input = {"1-3 a: abcde", "1-3 b: cdefg", "2-9 c: ccccccccc"};

    @Test
    void testPart1() throws InputProvider.FileError {
        Day02 day02 = new Day02(input);
        Assertions.assertEquals(2, day02.part1());
        day02 = new Day02(new InputProvider().getAsString("InputFiles/inputDay02.txt"));
        Assertions.assertEquals(456, day02.part1());
    }

    @Test
    void testPart2() {
        Day02 day02 = new Day02(input);
        Assertions.assertEquals(1, day02.part2());
        day02 = new Day02(new InputProvider().get("inputDay02.txt"));
        Assertions.assertEquals(308, day02.part2());
    }
}
