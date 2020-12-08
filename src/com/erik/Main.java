package com.erik;

import com.erik.day08.Day08;

public class Main {

    public static void main(String[] args) {
        InputProvider inputProvider;
        if (args.length == 0)
            inputProvider = new InputProvider();
        else
            inputProvider = new InputProvider(args[0]);

        AdventDay today = new Day08(inputProvider.get("inputDay08.txt"));
        System.out.println(today.part1());
        System.out.println(today.part2());
    }
}
