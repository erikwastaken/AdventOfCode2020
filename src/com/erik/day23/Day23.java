package com.erik.day23;

import com.erik.AdventDay;
import java.util.ArrayList;
import java.util.List;

// idea https://github.com/frerich/aoc2020/blob/main/day23.py
// successors is an array in which the indexes represent the cups and the entries represent the following cup;
// circularity is achieved by having the array, being one entry larger than the number of cups, ignoring entry 0,
// and because there is only ever exactly one of each number;

public class Day23 implements AdventDay {
    private final List<Integer> input;
    private int currentCup;
    private int[] successors;

    public Day23(List<Integer> input) {
        this.input = input;
        parseInput(input);
    }

    public Day23(String str) {
        String input = str.split("\n")[0];
        String[] splits = input.split("");
        List<Integer> inputAsList = new ArrayList<>();
        for (String s : splits)
            inputAsList.add(Integer.parseInt(s));
        this.input = inputAsList;
        parseInput(inputAsList);
    }

    private void parseInput(List<Integer> input) {
        this.currentCup = input.get(0);
        int[] suc = new int[input.size() + 1];
        for (int i=0; i<input.size() -1; i++) {
            suc[input.get(i)] = input.get(i+1);
        }
        suc[input.get(input.size()-1)] = currentCup;
        this.successors = suc.clone();
    }

    private void reset() {
        parseInput(this.input);
    }

    public long part1(int numberOfMoves) {
        for (int i=0; i<numberOfMoves; i++) {
            move();
        }
        List<Integer> cups = new ArrayList<>();
        int cup = successors[1];
        while (cup != 1) {
            cups.add(cup);
            cup = successors[cup];
        }
        StringBuilder sb = new StringBuilder();
        for (int c : cups) {
            sb.append(c);
        }
        return Long.parseLong(sb.toString());
    }

    public long part1() {
        return part1(100);
    }

    public long part2() {
        reset();
        extendSuccessors();
        for (int i=0; i<10000000; i++) {
            move();
        }
        return (long) successors[1] * successors[successors[1]];
    }

    private void extendSuccessors() {
        int lastInput = input.get(input.size()-1);
        int firstInput = input.get(0);
        int[] successorsExtension = new int[1000000 + 2];

        System.arraycopy(successors, 0, successorsExtension, 0, successors.length);
        for (int i= successors.length; i<successorsExtension.length - 1; i++)
            successorsExtension[i] = i+1;
        successorsExtension[lastInput] = getMax() + 1;
        successorsExtension[1000000] = firstInput;
        successors = successorsExtension.clone();
    }

    private void move() {
        int p0 = successors[currentCup];
        int p1 = successors[p0];
        int p2 = successors[p1];
        int nextCup = successors[p2];

        int destCup = currentCup - 1;

        while (true) {
            if (destCup < 1)
                destCup = getMax();
            if (destCup != p0 && destCup != p1 && destCup != p2)
                break;
            destCup--;
        }

        successors[currentCup] = nextCup;
        successors[p2] = successors[destCup];
        successors[destCup] = p0;
        currentCup = nextCup;
    }

    private int getMax() {
        int result = 0;
        for (int s : successors) {
            if (s>result)
                result = s;
        }
        return result;
    }
}
