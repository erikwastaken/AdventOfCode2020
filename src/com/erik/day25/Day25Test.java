package com.erik.day25;

import com.erik.InputProvider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day25Test {
    @Test
    void part1() {
        String[] input = new String[] {
                "5764801",
                "17807724"
        };

        Day25 cut = new Day25(input);
        Assertions.assertEquals(14897079L, cut.part1());
    }

    @Test
    void part1WithRealInput() {
        Day25 cut = new Day25(new InputProvider().get("inputDay25.txt"));
        Assertions.assertEquals(6198540L, cut.part1());
    }
}
