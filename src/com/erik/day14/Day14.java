package com.erik.day14;

import com.erik.AdventDay;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day14 implements AdventDay {
    private final String[] input;
    private Map<String,Long> memory = new HashMap<>();

    public Day14(String[] input) {
        this.input = input;
    }
    public Day14(String inputStr) { this.input = inputStr.split("\n"); }

    public long part1() {
        String currentMask = "";
        String address;
        long value;
        for (String s : input) {
            if (s.contains("mask")) {
                currentMask = s.split(" = ")[1];
                continue;
            }
            address = s.split(" = ")[0];
            value = Long.parseLong(s.split(" = ")[1]);
            memory.put(address, applyMask(value, currentMask));
        }
        return sumMemory();
    }

    public long part2() {
        clearMemory();
        return executePart2();
    }

    private long applyMask(long value, String mask) {
        long maskOff = Long.parseLong(mask.replaceAll("X", "1"),2);
        long maskOn = Long.parseLong(mask.replaceAll("X", "0"),2);

        return (value & maskOff) | maskOn;
    }

    private long sumMemory() {
        long result = 0;
        for (long value : memory.values())
            result += value;
        return result;
    }

    private void clearMemory() {
        this.memory = new HashMap<>();
    }

    private long executePart2() {
        String currentMask = "";
        List<Integer> occurrencesOfX = new ArrayList<>();

        for (String s : input) {
            String[] splits = s.split(" = ");
            occurrencesOfX = new ArrayList<>();
            if (splits[0].contains("mask")) {
                currentMask = splits[1];
                continue;
            }

            long currentValue = Long.parseLong(splits[1]);
            String currentAddress = Long.toBinaryString(Long.parseLong(splits[0].substring(4, splits[0].length()-1)));

            while (currentAddress.length() < currentMask.length())
                currentAddress = "0" + currentAddress;

            StringBuilder buildAddress = new StringBuilder(currentAddress);

            for (int i=0; i<currentMask.length(); i++) {
                char currentChar = currentMask.charAt(i);
                if (currentChar == '0')
                    continue;
                if (currentChar == 'X')
                    occurrencesOfX.add(i);
                buildAddress.setCharAt(i,currentChar);
            }
            String floatingAddress = buildAddress.toString();
            int n = occurrencesOfX.size();

            for (int i=0; i < Math.pow(2, n); i++) {
                String bin = Integer.toBinaryString(i);
                // make binary representation the correct length;
                while (bin.length() < n)
                    bin = "0" + bin;

                StringBuilder floater = new StringBuilder(floatingAddress);
                for (int j=0; j < n; j++) {
                    floater.setCharAt(occurrencesOfX.get(j), bin.charAt(j));
                }
                memory.put(floater.toString(),currentValue);
            }
        }
        return sumMemory();
    }
}
