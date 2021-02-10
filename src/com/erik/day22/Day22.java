package com.erik.day22;

import com.erik.AdventDay;

import java.util.*;

public class Day22 implements AdventDay {
    private final Queue<Integer> player1 = new LinkedList<>();
    private final Queue<Integer> player2 = new LinkedList<>();

    public Day22(String[] input) {
        boolean isPlayer1 = false;
        for (String line : input) {
            if (line.length() == 0)
                continue;
            if (line.contains("Player 1")) {
                isPlayer1 = true;
                continue;
            }
            if (line.contains("Player 2")) {
                isPlayer1 = false;
                continue;
            }
            if (isPlayer1) {
                player1.add(Integer.parseInt(line));
            } else {
                player2.add(Integer.parseInt(line));
            }
        }
    }
    public Day22(String inputStr) {
        String[] input = inputStr.split("\n");
        boolean isPlayer1 = false;
        for (String line : input) {
            if (line.length() == 0)
                continue;
            if (line.contains("Player 1")) {
                isPlayer1 = true;
                continue;
            }
            if (line.contains("Player 2")) {
                isPlayer1 = false;
                continue;
            }
            if (isPlayer1) {
                player1.add(Integer.parseInt(line));
            } else {
                player2.add(Integer.parseInt(line));
            }
        }
    }

    public long part1() {
        while (player1.size() > 0 && player2.size() > 0) {
            int cp1 = player1.remove();
            int cp2 = player2.remove();
            if (cp1 < cp2) {
                player2.add(cp2);
                player2.add(cp1);
            } else {
                player1.add(cp1);
                player1.add(cp2);
            }
        }

        if (player1.size() == 0)
            return calculatePoints(player2);
        else {
            return calculatePoints(player1);
        }
    }

    public long part2() {
        if (player1Wins(player1,player2))
            return calculatePoints(player1);
        else
            return calculatePoints(player2);
    }

    private long calculatePoints(Queue<Integer> player) {
        long result = 0;
        while (player.size() > 0) {
            result += (long) player.size() * player.remove();
        }
        return result;
    }

    private boolean player1Wins(Queue<Integer> p1, Queue<Integer> p2) {
        Set<Queue<Integer>> p1Cache = new HashSet<>();
        Set<Queue<Integer>> p2Cache = new HashSet<>();

        while (p1.size() > 0 && p2.size() > 0) {
            if (p1Cache.contains(p1) && p2Cache.contains(p2))
                return true;
            p1Cache.add(p1);
            p2Cache.add(p2);

            int cp1 = p1.remove();
            int cp2 = p2.remove();
            if (p1.size() >= cp1 && p2.size() >= cp2) {
                if (player1Wins(copySubQueue(p1,cp1), copySubQueue(p2,cp2))) {
                    p1.add(cp1);
                    p1.add(cp2);
                } else {
                    p2.add(cp2);
                    p2.add(cp1);
                }
                continue;
            }
            if (cp1 < cp2) {
                p2.add(cp2);
                p2.add(cp1);
            } else {
                p1.add(cp1);
                p1.add(cp2);
            }
        }

        return p1.size() != 0;
    }

    private Queue<Integer> copySubQueue(Queue<Integer> player, int length) {
        int c = 0;
        Queue<Integer> result = new LinkedList<>();
        Iterator<Integer> it = player.iterator();
        while (c < length) {
            result.add(it.next());
            c++;
        }
        return result;
    }
}
