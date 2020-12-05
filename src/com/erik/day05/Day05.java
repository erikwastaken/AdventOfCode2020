package com.erik.day05;

public class Day05 {
    final private String[] input;
    public Day05(String[] input) {
        this.input = input;
    }

    public int part1() {
        int maxSeatId = 0;

        for (int i=0; i<input.length; i++) {
            String letterRow = input[i].substring(0,7);
            String letterColumn = input[i].substring(7);

            String binaryRow = letterRow.replaceAll("F", "0");
            binaryRow = binaryRow.replaceAll("B", "1");

            String binaryColumn = letterColumn.replaceAll("L", "0");
            binaryColumn = binaryColumn.replaceAll("R", "1");

            int rowNumber = Integer.parseInt(binaryRow, 2);
            int columnNumber = Integer.parseInt(binaryColumn,2);
            int currentSeatId = rowNumber * 8 + columnNumber;
            if (currentSeatId > maxSeatId)
                maxSeatId = currentSeatId;
        }

        return maxSeatId;
    }
}
