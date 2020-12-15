package com.erik.day15;

import com.erik.AdventDay;

import java.util.HashMap;

public class Day15 implements AdventDay {
    private String input;
    public Day15(String input) {
        this.input = input;
    }

    public long part1() {
        return getNthNumber(2020);
    }

    public long part2() {
        return getNthNumber(30000000);
    }

    private long getNthNumber(int n) {
        HashMap<Long, Integer> numberMap = new HashMap<>();

        String[] splits = input.split(",");
        // add starting numbers except the last one
        for (int i = 0; i < splits.length -1; i++) {
            long num = Long.parseLong(splits[i]);
            numberMap.put(num,i);
        }

        long lastNumber = Long.parseLong(splits[splits.length-1]);
        int counter = numberMap.size();
        while (counter < n) {
            long currentNumber = -1;
            // lastNumber has been seen before;
            if (numberMap.containsKey(lastNumber))
                currentNumber = counter - numberMap.get(lastNumber);
            else
                currentNumber = 0;
            numberMap.put(lastNumber,counter);
            if (counter < n-1)
                lastNumber = currentNumber;
            counter++;
        }
        return lastNumber;
    }
}
