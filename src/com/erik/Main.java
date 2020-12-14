package com.erik;

import com.erik.day10.Day10;
import com.erik.day11.Day11;
import com.erik.day12.Day12;
import com.erik.day13.Day13;
import com.erik.day14.Day14;

public class Main {

    public static void main(String[] args) {
        InputProvider inputProvider;
        if (args.length == 0)
            inputProvider = new InputProvider();
        else
            inputProvider = new InputProvider(args[0]);

        AdventDay today = new Day14(inputProvider.get("inputDay14.txt"));
        System.out.println(today.part1());
        System.out.println(today.part2());
    }
}
