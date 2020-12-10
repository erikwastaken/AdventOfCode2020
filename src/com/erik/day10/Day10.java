package com.erik.day10;

import com.erik.AdventDay;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Day10 implements AdventDay {
    private String[] input;
    public Day10(String[] input) {
        this.input = input;
    }


    public long part1() {
        long[] inputLongs = new long[input.length+1];
        inputLongs[0] = 0;
        for (int i=1; i<inputLongs.length; i++)
            inputLongs[i] = Long.parseLong(input[i-1]);
        Arrays.sort(inputLongs);

        int singleJolts = 0;
        int tripleJolts = 1; // start with 1, because the final connection will always be 3 jolts per definition

        for (int j=0; j<inputLongs.length-1; j++) {
            long difference = inputLongs[j+1] - inputLongs[j];
            if (difference == 1)
                singleJolts++;
            if (difference == 3)
                tripleJolts++;
        }
        return singleJolts * tripleJolts;
    }

    public long part2() {
        long[] inputLongs = new long[input.length+2];
        inputLongs[0] = 0;
        long max = 0;
        for (int i=1; i<inputLongs.length-1; i++) {
            inputLongs[i] = Long.parseLong(input[i - 1]);
            if (inputLongs[i] > max)
                max = inputLongs[i];
        }
        inputLongs[inputLongs.length-1] = max+3;
        Arrays.sort(inputLongs);

        Map<Long, Long> ans = new HashMap<Long, Long>();
        ans.put(0L, 1L);
        for (long key : inputLongs) {
            if (key == 0)
                continue;
            long value = ans.getOrDefault(key-1,0L) + ans.getOrDefault(key-2, 0L) + ans.getOrDefault(key-3,0L);
            ans.put(key,value);
        }
        return ans.getOrDefault(inputLongs[inputLongs.length-1],0L);
    }
}

