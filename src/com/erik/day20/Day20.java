package com.erik.day20;

import java.util.HashMap;

public class Day20 {
    private static final String EMPTY = ".";
    private static final String FULL = "#";

    HashMap<Long, String[][]> images;
    public Day20(String[] input) {
        images = new HashMap<>();
        String[][] image = new String[10][10];
        int lineCount = 0;
        long uuid = 0;

        for (String line : input) {
            if (line.length() == 0) {
                continue;
            }

            if (line.startsWith("Tile")) {
                uuid = Long.parseLong(line.substring(5,line.length()-1));
                continue;
            }

            for (int i = 0; i < line.length(); i++) {
                image[lineCount][i] = String.valueOf(line.charAt(i));
            }
            lineCount++;

            if (lineCount == 10) {
                images.put(uuid,image);
                uuid = 0;
                image = new String[10][10];
                lineCount = 0;
            }
        }
    }

    public long part1() {
        // assumption: pictures only fit together in one way;
        
        return -1;
    }
}
