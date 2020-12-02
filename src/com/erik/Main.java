package com.erik;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        InputProvider inputProvider = new InputProvider();

        Day01 day01 = new Day01();
        System.out.println(day01.part1(inputProvider.get("inputDay01.txt")[0]));
        System.out.println(day01.part2(inputProvider.get("inputDay01.txt")[0]));
        Day02 day02 = new Day02();
        System.out.println(day02.part1(inputProvider.get("inputDay02.txt")));
        System.out.println(day02.part2(inputProvider.get("inputDay02.txt")));
    }
}
