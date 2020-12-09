package com.erik.day09;

import com.erik.InputProvider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day09Test {
    @Test
    void testCheck() {
        String[] input = new String[]{
                "35",
                "20",
                "15",
                "25",
                "47",
                "40",
                "62",
                "55",
                "65",
                "95",
                "102",
                "117",
                "150",
                "182",
                "127",
                "219",
                "299",
                "277",
                "309",
                "576"
        };
        Day09 day09 = new Day09(input);
        Assertions.assertEquals(127, day09.check(5));
    }

    @Test
    void checkDoesNotReturn1689() {
        String[] input = new String[] {
        "447",
        "442",
        "463",
        "619",
        "749",
        "584",
        "591",
        "729",
        "641",
        "1049",
        "645",
        "947",
        "766",
        "784",
        "994",
        "877",
        "1307",
        "824",
        "846",
        "1661",
        "874",
        "1094",
        "1374",
        "889",
        "905",
        "1689"};
        // 784 + 905 = 1689
        Assertions.assertNotEquals(1689, new Day09(input).check(25));
    }

    @Test
    void part1() {
        Day09 day09 = new Day09(new InputProvider().get("inputDay09.txt"));
        Assertions.assertEquals(466456641, day09.part1());
    }
}
