package com.erik.day09;

import java.util.Arrays;

public class Day09 {
    String[] input;
    public Day09(String[] input) {
        this.input = input;
    }

    public long part1() {
        final int preambleLength = 25;
        return check(preambleLength);
    }

    public int part2() {
        return -1;
    }

    public long check(int preambleLength) {
        long[] inputLongs = getLongArrayFromInput();

        for (int j=preambleLength; j<inputLongs.length; j++) {
            long[] options = Arrays.copyOfRange(inputLongs, j-preambleLength, j);
            if (!valueIsSumOfOptions(inputLongs[j], options))
                return inputLongs[j];
        }
        return -1;
    }

    private long[] getLongArrayFromInput() {
        long[] inputLongs = new long[input.length];

        for (int i = 0; i < input.length; i++) {
            inputLongs[i] = Long.parseLong(input[i]);
        }
        return inputLongs;
    }

    private boolean valueIsSumOfOptions(long value, long[] options) {
        Arrays.sort(options);
        for (int k=0; k<options.length-1; k++){
            long toFind = value - options[k];
            int foundIndex = Arrays.binarySearch(Arrays.copyOfRange(options, k+1, options.length),toFind);
            if (foundIndex >= 0) {
                return true;
            }
        }
        return false;
    }
}
