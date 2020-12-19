package com.erik.day17;

import java.util.HashMap;
import java.util.HashSet;

public class Day17 {
    private static final String ACTIVE = "#";
    private static final String INACTIVE = ".";

    private final HashMap<String,String> space = new HashMap<>();

    public Day17(String[] input) {
        // (0,0,0) should be the middle? --> does it really matter?
        for (int i=0; i<input.length; i++) {
            String[] splits = input[i].split("");
            for (int j=0; j< splits.length; j++) {
                space.put(getKeyForCoordinates(i,j,0),splits[j]);
            }
        }
    }

    public long part1() {

        for (int cycle = 1; cycle <=6; cycle++) {
            HashSet<String> toFlip = new HashSet<>();

            HashSet<String> coordinates = new HashSet<>();
            for (String key : space.keySet()) {
                int[] c = getCoordinatesForKey(key);
                coordinates.add(getKeyForCoordinates(c[0] + 1, c[1], c[2]));
                coordinates.add(getKeyForCoordinates(c[0] - 1, c[1], c[2]));
                coordinates.add(getKeyForCoordinates(c[0], c[1] + 1, c[2]));
                coordinates.add(getKeyForCoordinates(c[0], c[1] - 1, c[2]));
                coordinates.add(getKeyForCoordinates(c[0], c[1], c[2] + 1));
                coordinates.add(getKeyForCoordinates(c[0], c[1], c[2] - 1));
            }

            for (String s : coordinates) {
                if (!space.keySet().contains(s)) {
                    space.put(s,INACTIVE);
                }
            }

            for (String key : space.keySet()) {
                int[] c = getCoordinatesForKey(key);
                long a = getNumberOfActiveNeighbors(new int[] {c[0],c[1],c[2]});
                if (space.get(key).equals(ACTIVE)) {
                    if (a < 2 || a > 3)
                        toFlip.add(key);
                } else {
                    if (a == 3)
                        toFlip.add(key);
                }
            }

            for (String key : toFlip) {
                if (space.getOrDefault(key, INACTIVE).equals(ACTIVE))
                    space.put(key, INACTIVE);
                else
                    space.put(key, ACTIVE);
            }
        }

        long activeCubes = 0;
        for (String value : space.values())
            if (value.equals(ACTIVE))
                activeCubes++;
        return activeCubes;
    }


    private long getNumberOfActiveNeighbors(int[] p) {
        long result = 0;
        for (int i = -1; i <= 1; i++){
            for (int j=-1; j<=1; j++) {
                for (int l=-1; l<=1; l++) {
                    if (i == 0 && j == 0 && l == 0)
                        continue;
                    if (space.getOrDefault(getKeyForCoordinates(p[0]+i,p[1]+j, p[2]+l), INACTIVE).equals(ACTIVE))
                        result++;
                }
            }
        }
        return result;
    }

    private String getKeyForCoordinates(int x, int y, int z) {
        return String.format("%s,%s,%s", x, y, z);
    }

    private int[] getCoordinatesForKey(String s) {
        String[] splits = s.split(",");
        int[] result = new int[splits.length];
        for (int i=0; i<splits.length; i++)
            result[i] = Integer.parseInt(splits[i]);
        return result;
    }
}
