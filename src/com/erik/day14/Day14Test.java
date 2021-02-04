package com.erik.day14;

import com.erik.InputProvider;
import com.erik.day13.Day13;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day14Test {
    @Test
    void part1() {
        String[] input = new String[] {
                "mask = XXXXXXXXXXXXXXXXXXXXXXXXXXXXX1XXXX0X",
                "mem[8] = 11",
                "mem[7] = 101",
                "mem[8] = 0"
        };
        Day14 day14 = new Day14(input);
        Assertions.assertEquals(165L, day14.part1() );
    }

    @Test
    void part1WithRealInput() throws InputProvider.FileError {
        Day14 day14 = new Day14(new InputProvider().getAsString("InputFiles/inputDay14.txt"));
        Assertions.assertEquals(17481577045893L, day14.part1());
    }

    @Test
    void part2() {
        String[] input = new String[] {
                "mask = 000000000000000000000000000000X1001X",
                "mem[42] = 100",
                "mask = 00000000000000000000000000000000X0XX",
                "mem[26] = 1"
        };
        Day14 day14 = new Day14(input);
        Assertions.assertEquals(208, day14.part2());
    }
}
