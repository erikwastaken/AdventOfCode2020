package com.erik.day24;

import java.util.*;

public class Day24 {
    private static final char NORTH = 'n';
    private static final char SOUTH = 's';
    private static final char EAST = 'e';
    private static final char WEST = 'w';

    private static final Vector3 UNIT_EAST = new Vector3(1,-1,0);
    private static final Vector3 UNIT_NORTHEAST = new Vector3(1,0,-1);
    private static final Vector3 UNIT_SOUTHEAST = new Vector3(0,-1,1);

    private static final Vector3[] DIRECTIONS = new Vector3[] {
            UNIT_EAST, UNIT_NORTHEAST, UNIT_SOUTHEAST,
            UNIT_EAST.multiplyScalar(-1), UNIT_NORTHEAST.multiplyScalar(-1), UNIT_SOUTHEAST.multiplyScalar(-1)
    };

    private final Vector3[] instructions;
    private final Set<Vector3> flippedTiles = new HashSet<>();
    public Day24(String[] input) {
        this.instructions = parseInput(input);
        flipTiles();
    }

    public long part1() {
        return flippedTiles.size();
    }

    private void flipTiles() {
        // options for data model: https://math.stackexchange.com/questions/2254655/hexagon-grid-coordinate-system
        // use cube coordinates (x = 0 SE of ref., y = 0 NE of ref., and z = 0 E of ref.)
        // coordinates of adjacent tiles (x,y,z):
        // East (1,-1,0), West (-1,1,0)
        // NorthEast (1,0,-1), SouthWest (-1,0,1)
        // SouthEast (0,-1,1), NorthWest (0,1,-1)
        // --> final coordinates of a set of instructions (x,y,z) = East * (1,-1,0) + NorthEast * (1,0,-1) + SouthEast * (0,-1,1)
        for (Vector3 v3 : instructions) {
            Vector3 n3 = UNIT_EAST.multiplyScalar(v3.x).add(UNIT_NORTHEAST.multiplyScalar(v3.y)).add(UNIT_SOUTHEAST.multiplyScalar(v3.z));
            if (!flippedTiles.add(n3)) {
                flippedTiles.remove(n3);
            }
        }
    }

    public long part2() {
        for (int i=0; i<100; i++) {
            Set<Vector3> toBlack = new HashSet<>();
            Set<Vector3> toWhite = new HashSet<>();
            for (Vector3 tile : flippedTiles) {
                int n = getNumberOfBlackNeighbourTiles(tile);
                if (n == 0 || n > 2)
                    toWhite.add(tile);
                // check surrounding tiles
                for (Vector3 d : DIRECTIONS) {
                    Vector3 st = tile.add(d);
                    if (!flippedTiles.contains(st) && getNumberOfBlackNeighbourTiles(st) == 2)
                        toBlack.add(st);
                }
            }
            toWhite.forEach(flippedTiles::remove);
            flippedTiles.addAll(toBlack);
        }
        return flippedTiles.size();
    }

    private int getNumberOfBlackNeighbourTiles(Vector3 v) {
        int result = 0;
        for (Vector3 d : DIRECTIONS) {
            if (flippedTiles.contains(v.add(d)))
                result++;
        }
        return result;
    }
    // returns (east, northEast, southEast)
    private Vector3[] parseInput(String[] input) {
        ArrayList<Vector3> result = new ArrayList<>();
        for (String line : input) {
            int k = 0;
            int east = 0;
            int northEast = 0;
            int southEast = 0;
            char[] cl = line.toCharArray();

            while (k<cl.length) {
                switch (cl[k]) {
                    case EAST -> east++;
                    case WEST -> east--;
                    case NORTH -> {
                        if (cl[++k] == 'e')
                            northEast++;
                        else
                            southEast--;
                    }
                    case SOUTH -> {
                        if (cl[++k] == 'e')
                            southEast++;
                        else
                            northEast--;
                    }
                }
                k++;
            }
            result.add(new Vector3(east,northEast,southEast));
        }
        return result.toArray(new Vector3[0]);
    }

    public Vector3[] getInstructions() {
        return instructions;
    }
}
