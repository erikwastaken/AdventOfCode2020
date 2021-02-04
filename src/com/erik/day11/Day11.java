package com.erik.day11;

import com.erik.AdventDay;

public class Day11 implements AdventDay {
    private static final String SEAT_OCCUPIED = "#";
    private static final String SEAT_OPEN = "L";
    private static final String SEAT_FLOOR = ".";

    private final String[] input;
    private String[][] grid;
    private final int GRID_ROWS;
    private final int GRID_COLUMNS;

    public Day11(String[] input) {
        this.input = input;
        this.grid = new String[input.length][input[0].length()];

        this.GRID_ROWS = grid.length;
        this.GRID_COLUMNS = grid[0].length;
    }
    public Day11(String inputStr) {
        this.input = inputStr.split("\n");
        this.grid = new String[input.length][input[0].length()];

        this.GRID_ROWS = grid.length;
        this.GRID_COLUMNS = grid[0].length;
    }

    public long part1() {
        buildGrid();

        int prevCount = -1;
        while (prevCount != getTotalOccupiedSeats()) {
            prevCount = getTotalOccupiedSeats();

            String[][] currentState = new String[grid.length][grid[0].length];
            for (int i=0; i< currentState.length; i++)
                currentState[i] = grid[i].clone();

            for (int i = 0; i < GRID_ROWS; i++) {
                for (int j = 0; j < GRID_COLUMNS; j++) {
                    int occ = getNumberOfOccupiedAdjacentSeats(i, j);
                    if (grid[i][j].equals(SEAT_OPEN) && occ == 0)
                        currentState[i][j] = SEAT_OCCUPIED;
                    if (grid[i][j].equals(SEAT_OCCUPIED) && occ >= 4)
                        currentState[i][j] = SEAT_OPEN;
                }
            }

            for (int i=0; i<currentState.length; i++)
                grid[i] = currentState[i].clone();
        }
        return getTotalOccupiedSeats();
    }

    public long part2() {
        buildGrid();

        int prevCount = -1;
        while (prevCount != getTotalOccupiedSeats()) {
            prevCount = getTotalOccupiedSeats();

            String[][] currentState = new String[grid.length][grid[0].length];
            for (int i=0; i< currentState.length; i++)
                currentState[i] = grid[i].clone();

            for (int i = 0; i < GRID_ROWS; i++) {
                for (int j = 0; j < GRID_COLUMNS; j++) {
                    int occ = getNumberOfOccupiedVisibleSeats(i, j);
                    if (grid[i][j].equals(SEAT_OPEN) && occ == 0)
                        currentState[i][j] = SEAT_OCCUPIED;
                    if (grid[i][j].equals(SEAT_OCCUPIED) && occ >= 5)
                        currentState[i][j] = SEAT_OPEN;
                }
            }

            for (int i=0; i<currentState.length; i++)
                grid[i] = currentState[i].clone();
        }
        return getTotalOccupiedSeats();
    }

    private void buildGrid() {
        for (int i=0; i<input.length;i++) {
            this.grid[i] = input[i].split("");
        }
    }

    public void printGrid() {
        for (int i = 0; i < GRID_ROWS; i++) {
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < GRID_COLUMNS; j++)
                row.append(grid[i][j]);
            System.out.println(row);
        }
    }

    private int getNumberOfOccupiedAdjacentSeats(int x, int y) {
        int counter = 0;
        for (int i=x-1; i<=x+1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (i==x && j==y)
                    continue;
                if (i < 0 || i==GRID_ROWS || j<0 || j==GRID_COLUMNS)
                    continue;
                if (grid[i][j].equals("#"))
                    counter++;
            }
        }
        return counter;
    }

    private int getNumberOfOccupiedVisibleSeats(int x, int y) {
        int counter = 0;
        int[] trajectories = new int[] {-1, 0, 1};

        for (int i : trajectories) {
            for (int j : trajectories) {
                if (i==0 && j==0)
                    continue;
                if (isFirstSeatOccupiedInDirection(new int[] {x,y}, i, j))
                    counter++;
            }
        }
        return counter;
    }

    private boolean isFirstSeatOccupiedInDirection(int[] point, int x, int y) {
        int cX = point[0] + x;
        int cY = point[1] + y;

        while (cX < GRID_ROWS && cX >= 0 && cY < GRID_COLUMNS && cY >= 0) {
            if (grid[cX][cY].equals(SEAT_FLOOR)) {
                cX += x;
                cY += y;
            } else {
                return (grid[cX][cY].equals(SEAT_OCCUPIED));
            }
        }
        return false;
    }

    private int getTotalOccupiedSeats() {
        int counter = 0;

        for (int i=0; i<GRID_ROWS; i++) {
            for (int j=0; j<GRID_COLUMNS; j++) {
                if (grid[i][j].equals(SEAT_OCCUPIED))
                    counter++;
            }
        }
        return counter;
    }
}
