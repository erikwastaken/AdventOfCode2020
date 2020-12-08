package com.erik.day08;

import com.erik.AdventDay;

import java.util.HashSet;
import java.util.Set;

public class Day08 implements AdventDay {
    final private String[] input;
    private int accumulator = 0;
    private int counter = 0;

    public Day08(String[] input) {
        this.input = input;
    }

    public int part1() {
        Set<Integer> seenLines = new HashSet<>();

        while (seenLines.add(counter)) {
            processInput(input[counter]);
        }
        return accumulator;
    }

    private void processInput(String input) {
        String command = input.split(" ")[0];
        int value = Integer.parseInt(input.split(" ")[1]);

        switch (command) {
            case "acc":
                accumulator += value;
                counter++;
                break;
            case "jmp":
                counter += value;
                break;
            case "nop":
                counter++;
        }
    }

    public int part2() {
        for (int i=0; i<input.length; i++) {
            String currentStatement = buildChangedStatement(input[i]);
            if (currentStatement.length() == 0)
                continue;

            String[] newInput = input.clone();
            newInput[i] = currentStatement;

            Set<Integer> seenLines = new HashSet<>();
            resetCounters();
            while (seenLines.add(counter)) {
                processInput(newInput[counter]);
                if (counter == input.length)
                    return accumulator;
            }
        }
        return -1;
    }

    private void resetCounters() {
        this.counter = 0;
        this.accumulator = 0;
    }

    private String buildChangedStatement(String input) {
        String currentStatement = "";
        String command = input.split(" ")[0];
        String value = input.split(" ")[1];
        switch (command) {
            case "jmp":
                currentStatement = "nop " + value;
                break;
            case "nop":
                currentStatement = "jmp " + value;
                break;
        }
        return currentStatement;
    }
}
