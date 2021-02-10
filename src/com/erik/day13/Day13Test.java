package com.erik.day13;

import com.erik.InputProvider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

public class Day13Test {
    @Test
    void part1() {
        String[] input = new String[] {
                "939",
                "7,13,x,x,59,x,31,19"
        };
        Day13 day13 = new Day13(input);
        Assertions.assertEquals(295, day13.part1());
    }

    @Test
    void part1WithRealInput() throws InputProvider.FileError {
        Day13 day13 = new Day13(new InputProvider().getAsString("InputFiles/inputDay13.txt"));
        Assertions.assertEquals(296, day13.part1());
    }

    @Test
    void part2_1() {
        String[] input = new String[] {
                "939",
                "7,13,x,x,59,x,31,19"
        };
        Day13 day13 = new Day13(input);
        Assertions.assertEquals(1068781, day13.part2());
    }

    @Test
    void part2_2() {
        String[] input = new String[] {
                "939",
                "17,x,13,19"
        };
        Day13 day13 = new Day13(input);
        Assertions.assertEquals(3417, day13.part2());
    }

    @Test
    void part2_3() {
        String[] input = new String[] {
                "939",
                "67,7,59,61"
        };
        Day13 day13 = new Day13(input);
        Assertions.assertEquals(754018, day13.part2());
    }

    @Test
    void part2_4() {
        String[] input = new String[] {
                "939",
                "67,x,7,59,61"
        };
        Day13 day13 = new Day13(input);
        Assertions.assertEquals(779210, day13.part2());
    }

    @Test
    void part2_5() {
        String[] input = new String[] {
                "939",
                "67,7,x,59,61"
        };
        Day13 day13 = new Day13(input);
        Assertions.assertEquals(1261476, day13.part2());
    }

    @Test
    void part2_6() {
        String[] input = new String[] {
                "939",
                "1789,37,47,1889"
        };
        Day13 day13 = new Day13(input);
        Assertions.assertEquals(1202161486, day13.part2());
    }

    @Test
    void part2WithRealInput() {
        Day13 day13 =  new Day13(new InputProvider().get("inputDay13.txt"));
        Assertions.assertEquals(535296695251210L, day13.part2());
    }

    @Test
    void bezout() {
        String[] input = new String[] {
                "939",
                "1789,37,47,1889"
        };
        Day13 day13 = new Day13(input);
        Long[] expected = new Long[] {2L,-1L};
        Assertions.assertEquals(expected[0], day13.getBezoutCoefficients(7L,13L)[0]);
        Assertions.assertEquals(expected[1], day13.getBezoutCoefficients(7L,13L)[1]);
    }

    @Test
    void solveTwo() {
        String[] input = new String[] {
                "939",
                "3,x,x,4"
        };
        Day13 day13 = new Day13(input);
        Assertions.assertEquals( new BigInteger("9"), day13.solveTwo(new BigInteger("3"), new BigInteger("4")));
    }

    @Test
    void solveNBig() {
        String[] input = new String[] {
                "939",
                "3,x,x,4,5"
        };
        Day13 day13 = new Day13(input);
        Assertions.assertEquals(new BigInteger("21"), day13.solveN(new BigInteger[] {new BigInteger("3"), new BigInteger("4"), new BigInteger("5")}));
    }
}
