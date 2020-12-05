package com.erik.day05;

import java.util.Arrays;

public class Day05 {
    final private String[] input;
    public Day05(String[] input) {
        this.input = input;
    }

    public int part1() {
        int maxSeatId = 0;

        for (int i=0; i<input.length; i++) {
            int currentSeatId = convertToSeatId(input[i]);

            if (currentSeatId > maxSeatId)
                maxSeatId = currentSeatId;
        }

        return maxSeatId;
    }

    public int part2() {
        int[] seatIds = new int[input.length];
        for (int i=0; i< input.length; i++) {
            seatIds[i] = convertToSeatId(input[i]);
        }

        Arrays.sort(seatIds);

        for (int j=0; j<seatIds.length - 1; j++) {
            if (seatIds[j]+1 != seatIds[j+1]) {
                return seatIds[j]+1;
            }
        }
        return -1;
    }

    private int convertToSeatId(String input) {
        String letterRow = input.substring(0,7);
        String letterColumn = input.substring(7);

        String binaryRow = letterRow.replaceAll("F", "0");
        binaryRow = binaryRow.replaceAll("B", "1");

        String binaryColumn = letterColumn.replaceAll("L", "0");
        binaryColumn = binaryColumn.replaceAll("R", "1");

        int rowNumber = Integer.parseInt(binaryRow, 2);
        int columnNumber = Integer.parseInt(binaryColumn,2);
        return rowNumber * 8 + columnNumber;
    }
}
