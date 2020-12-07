package com.erik;

import com.erik.day01.Day01;
import com.erik.day02.Day02;
import com.erik.day03.Day03;
import com.erik.day04.Day04;
import com.erik.day05.Day05;
import com.erik.day06.Day06;
import com.erik.day07.Day07;

public class Main {

    public static void main(String[] args) {
        InputProvider inputProvider;
        if (args.length == 0)
            inputProvider = new InputProvider();
        else
            inputProvider = new InputProvider(args[0]);
//        Day01 day01 = new Day01();
//        System.out.println(day01.part1(inputProvider.get("inputDay01.txt")[0]));
//        System.out.println(day01.part2(inputProvider.get("inputDay01.txt")[0]));
//        Day02 day02 = new Day02();
//        System.out.println(day02.part1(inputProvider.get("inputDay02.txt")));
//        System.out.println(day02.part2(inputProvider.get("inputDay02.txt")));
//        Day03 day03 = new Day03(inputProvider.get("inputDay03.txt"));
//        System.out.println(day03.part1(3,1));
//        System.out.println(day03.part2());
//        Day04 day04 = new Day04(inputProvider.get("inputDay04.txt"));
//        System.out.println(day04.part1());
//        System.out.println(day04.part2());
//        Day05 day05 = new Day05(inputProvider.get("inputDay05.txt"));
//        System.out.println(day05.part1());
//        System.out.println(day05.part2());
//        Day06 day06 = new Day06(inputProvider.get("inputDay06.txt"));
//        System.out.println(day06.part1());
//        System.out.println(day06.part2());
        Day07 day07 = new Day07(inputProvider.get("inputDay07.txt"));
        System.out.println(day07.part1());
        System.out.println(day07.part2());
    }
}
