package com.erik.day07;

import com.erik.InputProvider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day07Test {
    @Test
    void part1() throws InputProvider.FileError {
        String[] input = {"light red bags contain 1 bright white bag, 2 muted yellow bags.",
                "dark orange bags contain 3 bright white bags, 4 muted yellow bags.",
                "bright white bags contain 1 shiny gold bag.",
                "muted yellow bags contain 2 shiny gold bags, 9 faded blue bags.",
                "shiny gold bags contain 1 dark olive bag, 2 vibrant plum bags.",
                "dark olive bags contain 3 faded blue bags, 4 dotted black bags.",
                "vibrant plum bags contain 5 faded blue bags, 6 dotted black bags.",
                "faded blue bags contain no other bags.",
                "dotted black bags contain no other bags."};
        Day07 day07 = new Day07(input);
        Assertions.assertEquals(4, day07.part1());

        day07 = new Day07(new InputProvider().getAsString("InputFiles/inputDay07.txt"));
        Assertions.assertEquals(378, day07.part1());
    }

    @Test
    void part2() {
        String[] input = {"light red bags contain 1 bright white bag, 2 muted yellow bags.",
                "dark orange bags contain 3 bright white bags, 4 muted yellow bags.",
                "bright white bags contain 1 shiny gold bag.",
                "muted yellow bags contain 2 shiny gold bags, 9 faded blue bags.",
                "shiny gold bags contain 1 dark olive bag, 2 vibrant plum bags.",
                "dark olive bags contain 3 faded blue bags, 4 dotted black bags.",
                "vibrant plum bags contain 5 faded blue bags, 6 dotted black bags.",
                "faded blue bags contain no other bags.",
                "dotted black bags contain no other bags."};
        Day07 day07 = new Day07(input);
        Assertions.assertEquals(32, day07.part2());

        input = new String[]{"shiny gold bags contain 2 dark red bags.",
                "dark red bags contain 2 dark orange bags.",
                "dark orange bags contain 2 dark yellow bags.",
                "dark yellow bags contain 2 dark green bags.",
                "dark green bags contain 2 dark blue bags.",
                "dark blue bags contain 2 dark violet bags.",
                "dark violet bags contain no other bags."};
        day07 = new Day07(input);
        Assertions.assertEquals(126,day07.part2());

        day07 = new Day07(new InputProvider().get("inputDay07.txt"));
        Assertions.assertEquals(27526, day07.part2());
    }
}
