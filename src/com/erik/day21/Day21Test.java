package com.erik.day21;

import com.erik.InputProvider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day21Test {
    @Test
    void part1() {
        String[] input = new String[] {
                "mxmxvkd kfcds sqjhc nhms (contains dairy, fish)",
                "trh fvjkl sbzzf mxmxvkd (contains dairy)",
                "sqjhc fvjkl (contains soy)",
                "sqjhc mxmxvkd sbzzf (contains fish)"
        };
        Day21 cut = new Day21(input);
        Assertions.assertEquals(5L, cut.part1());
    }

    @Test
    void part1WithRealInput() {
        Day21 cut = new Day21(new InputProvider().get("inputDay21.txt"));
        Assertions.assertEquals(2659L, cut.part1());
    }
}
