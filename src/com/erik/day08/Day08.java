package com.erik.day08;

import java.util.HashSet;
import java.util.Set;

public class Day08 {
    private String[] input;
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
            String currentStatement = "";
            String command = input[i].split(" ")[0];
            String value = input[i].split(" ")[1];
            switch (command) {
                case "jmp":
                    currentStatement = "nop " + value;
                    break;
                case "nop":
                    currentStatement = "jmp " + value;
                    break;
            }
            if (currentStatement.length() == 0)
                continue;

            String[] newInput = new String[input.length];
            for (int k=0; k<newInput.length; k++)
                newInput[k] = input[k];
            newInput[i] = currentStatement;

            Set<Integer> seenLines = new HashSet<>();
            this.counter = 0;
            this.accumulator = 0;
            while (seenLines.add(counter)) {
                processInput(newInput[counter]);
                if (counter == input.length)
                    return accumulator;
            }
        }
        return -1;
    }
}
