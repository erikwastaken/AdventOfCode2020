package com.erik.day12;

import com.erik.AdventDay;

public class Day12 implements AdventDay {
    private static final String NORTH = "N";
    private static final String SOUTH = "S";
    private static final String EAST = "E";
    private static final String WEST = "W";
    private static final String FORWARD = "F";
    private static final String LEFT = "L";
    private static final String RIGHT = "R";
    private static final String[] DIRECTIONS = new String[] {NORTH,EAST,SOUTH,WEST};

    private final String[] input;
    private int[] waypoint = new int[] {10,1};
    private int[] currentPosition = new int[] {0,0};
    private String currentDirection = EAST;

    public Day12(String[] input) {
        this.input = input;
    }
    public Day12(String inputStr) { this.input = inputStr.split("\n"); }

    public void resetState() {
        this.currentDirection = EAST;
        this.currentPosition = new int[] {0,0};
        this.waypoint = new int[] {10,1};
    }

    public long part1() {
        resetState();
        for (String s : input) processInputPart1(s);
        return getManhattanDistance();
    }

    public long part2() {
        resetState();
        for (String s : input) processInputPart2(s);
        return getManhattanDistance();
    }

    private void processInputPart1(String instruction) {
        String action = instruction.substring(0,1);
        int value = Integer.parseInt(instruction.substring(1));
        switch (action) {
            case NORTH -> currentPosition[1] += value;
            case SOUTH -> currentPosition[1] -= value;
            case EAST -> currentPosition[0] += value;
            case WEST -> currentPosition[0] -= value;
            case LEFT -> {
                value = 360 - value;
                turnRightByDegrees(value);
            }
            case RIGHT -> turnRightByDegrees(value);
            case FORWARD -> moveForwardByValue(value);
        }
    }

    private void processInputPart2(String instruction) {
        String action = instruction.substring(0, 1);
        int value = Integer.parseInt(instruction.substring(1));
        // assumption: 0 <= value <= 360
        switch (action) {
            case NORTH -> waypoint[1] += value;
            case SOUTH -> waypoint[1] -= value;
            case EAST -> waypoint[0] += value;
            case WEST -> waypoint[0] -= value;
            case LEFT -> {
                value = 360 - value;
                rotateWaypointRightByDegrees(value);
            }
            case RIGHT -> rotateWaypointRightByDegrees(value);
            case FORWARD -> moveTowardWaypoint(value);
        }
    }

    private long getManhattanDistance() {
        return Math.abs(currentPosition[0]) + Math.abs(currentPosition[1]);
    }

    private void moveTowardWaypoint(int value) {
        currentPosition[0] += waypoint[0] * value;
        currentPosition[1] += waypoint[1] * value;
    }

    private void rotateWaypointRightByDegrees(int value) {
        int turnBy = (value / 90) % 4;
        int[] newWp = new int[] {0,0};
        switch (turnBy) {
            case 1 -> {
                newWp[0] = waypoint[1];
                newWp[1] = -waypoint[0];
            }
            case 2 -> {
                newWp[0] = -waypoint[0];
                newWp[1] = -waypoint[1];
            }
            case 3 -> {
                newWp[0] = -waypoint[1];
                newWp[1] = waypoint[0];
            }
        }
        waypoint[0] = newWp[0];
        waypoint[1] = newWp[1];
    }

    private void moveForwardByValue(int value) {
        switch (currentDirection) {
            case NORTH -> currentPosition[1] += value;
            case SOUTH -> currentPosition[1] -= value;
            case EAST -> currentPosition[0] += value;
            case WEST -> currentPosition[0] -= value;
        }
    }

    private void turnRightByDegrees(int value) {
        int turnBy = (value / 90) % 4;
        int index = getIndexOfCurrentDirection();

        if (index >= 0) {
            int newIndex = (index+turnBy) % 4;
            currentDirection = DIRECTIONS[newIndex];
        }
    }

    private int getIndexOfCurrentDirection() {
        int index = -1;
        for (int j=0;j<DIRECTIONS.length; j++) {
            if (DIRECTIONS[j].equals(currentDirection))
                index = j;
        }
        return index;
    }
}
