package com.erik.day23;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Day23 {
    private final Circle cups;

    public Day23(String input) {
        cups = new Circle(input);
    }

    public String part1(int moves) {
        for (int i=0; i<moves; i++) {
            try {
                int currentCup = cups.get(0);
                cups.stash(1,4);
                int destinationCup = currentCup - 1;
                while (!cups.contains(String.valueOf(destinationCup))) {
                    destinationCup--;
                    if (destinationCup < 1) {
                        destinationCup = Integer.parseInt(cups.max());
                        break;
                    }
                }
                cups.makeCurrent(1);
                cups.insertStash(cups.indexOf(String.valueOf(destinationCup)) + 1);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        cups.makeCurrent(cups.indexOf("1"));
        return cups.getElements().substring(1);
    }
}
