package com.erik.day23;

import com.erik.AdventDay;

import java.util.ArrayList;
import java.util.List;
// idea https://github.com/frerich/aoc2020/blob/main/day23.py

public class Day23 implements AdventDay {
    private final Circle cups;
    private int currentCup;
    private int[] successors;
    private int lastInput;
    private int firstInput;

    public Day23(List<Integer> input) {
        cups = new Circle(input);
        parse(input);
    }

    private void parse(List<Integer> input) {
        this.currentCup = input.get(0);
        int[] suc = new int[input.size() + 1];
        for (int i=0; i<input.size() -1; i++) {
            suc[input.get(i)] = input.get(i+1);
        }
        suc[input.get(input.size()-1)] = currentCup;
        this.successors = suc.clone();
        firstInput = input.get(0);
        lastInput = input.get(input.size()-1);
    }

    public Day23(String str) {
        String input = str.split("\n")[0];
        String[] splits = input.split("");
        List<Integer> l = new ArrayList<>();
        for (String s : splits)
            l.add(Integer.parseInt(s));
        cups = new Circle(l);

        parse(l);
    }

    public long part1() {
//        return processPart1(100);
        for (int i=0; i<100; i++) {
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

    public long processPart1(int moves) {
        for (int i=0; i<moves; i++) {
            try {
                int currentCup = cups.get(0);
                cups.stash(1,4);
                int destinationCup = currentCup - 1;
                while (!cups.contains(destinationCup)) {
                    destinationCup--;
                    if (destinationCup < 1) {
                        destinationCup = cups.max();
                        break;
                    }
                }
                cups.makeCurrent(1);
                cups.insertStash(cups.indexOf(destinationCup) + 1);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        cups.makeCurrent(cups.indexOf(1));
        return Long.parseLong(cups.toString().substring(1));
    }

    public long part2() {
        int[] suc = new int[1000000 + 2];
        System.arraycopy(successors, 0, suc, 0, successors.length);
        for (int i= successors.length; i<suc.length - 1; i++)
            suc[i] = i+1;
        suc[lastInput] = getMax() + 1;
        suc[1000000] = firstInput;

        successors = suc.clone();

        for (int i=0; i<10000000; i++) {
            move();
        }

        return (long) successors[1] * successors[successors[1]];
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
