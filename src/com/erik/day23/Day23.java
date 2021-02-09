package com.erik.day23;

import com.erik.AdventDay;

import java.util.List;

public class Day23 implements AdventDay {
    private final Circle cups;

    public Day23(List<Integer> input) {
        cups = new Circle(input);
    }

    public long part1() {
        return processPart1(100);
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
                        destinationCup = (int) cups.max();
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
        return -1;
    }
}
