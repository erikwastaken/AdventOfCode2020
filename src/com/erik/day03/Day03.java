package com.erik.day03;

import com.erik.AdventDay;

public class Day03 implements AdventDay {
    private String[] grid;

    public Day03(String[] grid) {
        this.grid = grid;
    }
    public Day03(String inputStr) { this.grid = inputStr.split("\n"); }

    public long part1() {
        return executePart1(3,1);
    }

    private long executePart1(final int trajectoryX, final int trajectoryY) {
        int rowIndex = trajectoryX;
        int columnIndex = trajectoryY;
        int numberOfTreesHit = 0;
        int gridWidth = grid[0].length();

        while (columnIndex < grid.length) {
            if (grid[columnIndex].charAt(rowIndex) == '#')
                numberOfTreesHit++;
            rowIndex = (rowIndex + trajectoryX) % gridWidth;
            columnIndex += trajectoryY;
        }
        return numberOfTreesHit;
    }

    public long part2() {
        int[][] trajectories = { {1,1}, {3,1}, {5,1}, {7,1}, {1,2} };
        long productOfTreesHit = 1;

        for (int[] trajectory : trajectories)
            productOfTreesHit *= executePart1(trajectory[0], trajectory[1]);
        return productOfTreesHit;
    }
}
