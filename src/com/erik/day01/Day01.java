package com.erik.day01;

import com.erik.AdventDay;

import java.util.Arrays;

public class Day01 implements AdventDay {
    private String input;

    public Day01(String input) {
        this.input = input;
    }

    public long part1() {
        int[] array = convertStringToSortedIntArray(input);

        for (int i = 0; i<array.length - 1; i++) {
            int toFind = 2020 - array[i];
            int index = findValueInSubArray(array, i+1, toFind);
            if (index>=0)
                return array[i]*array[index];
        }
        return -1;
    }

    public long part2() {
        int[] array = convertStringToSortedIntArray(input);

        for (int i = 0; i<array.length-2; i++) {
            for (int j = i+1; j<array.length-1; j++) {
                int toFind = 2020 - array[i] - array[j];
                int index = findValueInSubArray(array, j+1, toFind);
                if (index >= 0) {
                    return array[i]*array[j]*array[index];
                }
            }
        }
        return -1;
    }

    private int[] convertStringToSortedIntArray(String str) {
        String[] stringArray = str.split(" ");
        int[] intArray = new int[stringArray.length];

        for (int i = 0; i<stringArray.length; i++) {
            intArray[i] = Integer.parseInt(stringArray[i]);
        }
        Arrays.sort(intArray);

        return intArray;
    }

    private int findValueInSubArray(int[] arr, int startingIndex, int toFind) {
        int index = Arrays.binarySearch(Arrays.copyOfRange(arr, startingIndex, arr.length), toFind);
        if (index >= 0)
            return index + startingIndex;
        return -1;
    }
}
