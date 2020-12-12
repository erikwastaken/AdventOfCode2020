package com.erik;

import com.erik.day10.Day10;
import com.erik.day11.Day11;
import com.erik.day12.Day12;

public class Main {

    public static void main(String[] args) {
        InputProvider inputProvider;
        if (args.length == 0)
            inputProvider = new InputProvider();
        else
            inputProvider = new InputProvider(args[0]);

        AdventDay today = new Day12(inputProvider.get("inputDay12.txt"));
        System.out.println(today.part1());
        System.out.println(today.part2());
    }
}
