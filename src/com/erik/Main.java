package com.erik;

import com.erik.day01.Day01;
import com.erik.day02.Day02;
import com.erik.day03.Day03;

public class Main {

    public static void main(String[] args) {
        InputProvider inputProvider = new InputProvider();

//        Day01 day01 = new Day01();
//        System.out.println(day01.part1(inputProvider.get("inputDay01.txt")[0]));
//        System.out.println(day01.part2(inputProvider.get("inputDay01.txt")[0]));
//        Day02 day02 = new Day02();
//        System.out.println(day02.part1(inputProvider.get("inputDay02.txt")));
//        System.out.println(day02.part2(inputProvider.get("inputDay02.txt")));
        Day03 day03 = new Day03();
        System.out.println(day03.part1(inputProvider.get("inputDay03.txt"),3,1));
        System.out.println(day03.part2(inputProvider.get("inputDay03.txt")));
    }
}
