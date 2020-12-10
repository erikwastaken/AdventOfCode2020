package com.erik;

import com.erik.day09.Day09;
import com.erik.day10.Day10;

public class Main {

    public static void main(String[] args) {
        InputProvider inputProvider;
        if (args.length == 0)
            inputProvider = new InputProvider();
        else
            inputProvider = new InputProvider(args[0]);

        AdventDay today = new Day10(inputProvider.get("inputDay10.txt"));
        System.out.println(today.part1());
        System.out.println(today.part2());
    }
}
