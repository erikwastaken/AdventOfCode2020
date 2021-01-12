package com.erik.day20;

import java.util.*;

public class Day20 {
//    private final HashMap<Long, String[][]> images;
    private final Image[] images;

    public Day20(String[] input) {
        ArrayList<Image> imageList = new ArrayList<>();
        ArrayList<Integer> separators = new ArrayList<>();

        // account for last line being empty;
        for (int i=0; i<input.length-1; i++) {
            if (input[i].length() == 0)
                separators.add(i);
        }

        imageList.add(new Image(Arrays.copyOfRange(input,0,separators.get(0))));
        for (int i=0; i<separators.size()-1; i++) {
            imageList.add(new Image(Arrays.copyOfRange(input,separators.get(i)+1, separators.get(i+1))));
        }
        imageList.add(new Image(Arrays.copyOfRange(input,separators.get(separators.size()-1)+1,input.length-1)));
        this.images = imageList.toArray(new Image[0]);
    }

    public long part1() {
        HashMap<Long, Set<Long>> matches = new HashMap<>();
        for (int i = 0; i < images.length; i++) {
            Image currentImage = images[i];
            Set<Long> matchedImages = new HashSet<>();
            for (int ii = 0; ii < images.length; ii++) {
                if (ii == i)
                    continue;

                Image checkImage = images[ii];

                for (int iii=0; iii<4; iii++) {
                    if (currentImage.sharesEdgeWith(checkImage)) {
                        matchedImages.add(checkImage.getUuid());
                    }
                    checkImage.rotateLeft();
                }

                checkImage.flipHorizontally();
                for (int iii=0; iii<4; iii++) {
                    if (currentImage.sharesEdgeWith(checkImage)) {
                        matchedImages.add(checkImage.getUuid());
                    }
                    checkImage.rotateLeft();
                }
                checkImage.flipHorizontally();

                checkImage.flipVertically();
                for (int iii=0; iii<4; iii++) {
                    if (currentImage.sharesEdgeWith(checkImage)) {
                        matchedImages.add(checkImage.getUuid());
                    }
                    checkImage.rotateLeft();
                }
                checkImage.flipVertically();

                checkImage.flipHorizontally();
                for (int iii=0; iii<4; iii++) {
                    if (currentImage.sharesEdgeWith(checkImage)) {
                        matchedImages.add(checkImage.getUuid());
                    }
                    checkImage.rotateLeft();
                }
                checkImage.flipHorizontally();
            }
            matches.put(currentImage.getUuid(),matchedImages);
        }

        long result = 1;
        for (Long uuid : matches.keySet()) {
            if (matches.get(uuid).size() == 2) {
                result *= uuid;
            }
        }
        return result;
    }
}
