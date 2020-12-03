package com.erik.day03;

public class Day03 {
    public int part1(String[] grid, final int trajectoryX, final int trajectoryY) {
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
}
