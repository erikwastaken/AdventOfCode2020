package com.erik;

import java.util.Arrays;

public class Day01 {
    public int part1(String input) {
        int[] array = convertStringToSortedIntArray(input);

        for (int i = 0; i<array.length - 1; i++) {
            int toFind = 2020 - array[i];
            int index = Arrays.binarySearch(array, toFind);
            if (index>=0)
                return array[i]*array[index];
        }
        return 0;
    }

    public int part2(String input) {
        int[] array = convertStringToSortedIntArray(input);

        for (int i = 0; i<array.length-2; i++) {
            for (int j = i+1; j<array.length-1; j++) {
                int toFind = 2020 - array[i] - array[j];
                int index = Arrays.binarySearch(array,toFind);
                if (index >= 0)
                    return array[i]*array[j]*array[index];
            }
        }
        return 0;
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
}
