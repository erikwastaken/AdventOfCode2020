package com.erik.day20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Day20 {
//    private final HashMap<Long, String[][]> images;
    private final Image[] images;

    public Day20(String[] input) {
        ArrayList<Image> imageList = new ArrayList<>();
        ArrayList<Integer> separators = new ArrayList<>();

        for (int i=0; i<input.length; i++) {
            if (input[i].length() == 0)
                separators.add(i);
        }

//        Image im = new Image(Arrays.copyOfRange(input,0,separators.get(0)));
        imageList.add(new Image(Arrays.copyOfRange(input,0,separators.get(0))));
        for (int i=0; i<separators.size()-1; i++) {
            imageList.add(new Image(Arrays.copyOfRange(input,separators.get(i)+1, separators.get(i+1))));
        }
        imageList.add(new Image(Arrays.copyOfRange(input,separators.get(separators.size()-1)+1,input.length-1)));
        this.images = imageList.toArray(new Image[imageList.size()]);
    }

    public long part1() {
        // assumption: pictures only fit together in one way;
        // algorithm will take two images and compare their edges (flipping and rotating)
        // i.e. 16 * 2 = 32 edge comparisons (16 = 4*4 for comparing the edges, do this again for the flipped version of one image)
        // will need to keep track of the matched sides per image to determine the final position in the arrangement;

        // create a class Image with an array for each side -> makes comparisons more readable; could even store a
        // reference to a matched object
        return -1;
    }
}
