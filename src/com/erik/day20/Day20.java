package com.erik.day20;

import java.util.*;

public class Day20 {
    private final ImageMatcher imageMatcher;
    public Day20(String[] input) {
        this.imageMatcher = new ImageMatcher(input);
    }

    public long part1() {
        Map<Long, Set<Long>> matches = imageMatcher.getMatches();
        long result = 1;
        for (Long uuid : matches.keySet()) {
            if (matches.get(uuid).size() == 2) {
                result *= uuid;
            }
        }
        return result;
    }

    public long part2() {
        return -1;
    }
}
