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

    public long part2(int preambleLength) {
        long[] inputLongs = getLongArrayFromInput();
        long target = check(preambleLength);
        for (int i=0; i<inputLongs.length; i++) {
            long sum = 0;
            long smallest = inputLongs[i];
            long largest = 0;
            int counter = i;
            while (sum < target) {
                sum += inputLongs[counter];
                if (inputLongs[counter] < smallest)
                    smallest = inputLongs[counter];
                if (inputLongs[counter] > largest)
                    largest = inputLongs[counter];
                counter++;
            }
            if (sum == target)
                return smallest + largest;
        }
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
