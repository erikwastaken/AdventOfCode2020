package com.erik.day08;

import com.erik.InputProvider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day08Test {
    @Test
    void part1() {
        String[] input = new String[] {"nop +0",
                "acc +1",
                "jmp +4",
                "acc +3",
                "jmp -3",
                "acc -99",
                "acc +1",
                "jmp -4",
                "acc +6"};
        Day08 day08 = new Day08(input);
        Assertions.assertEquals(5, day08.part1());

        day08 = new Day08(new InputProvider().get("inputDay08.txt"));
        Assertions.assertEquals(1331, day08.part1());
    }

    @Test
    void part2() {
        String[] input = new String[] {"nop +0",
                "acc +1",
                "jmp +4",
                "acc +3",
                "jmp -3",
                "acc -99",
                "acc +1",
                "jmp -4",
                "acc +6"};
        Day08 day08 = new Day08(input);
        Assertions.assertEquals(8, day08.part2());

        day08 = new Day08(new InputProvider().get("inputDay08.txt"));
        Assertions.assertEquals(1121, day08.part2());
    }
}
