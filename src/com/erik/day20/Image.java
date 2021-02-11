package com.erik.day20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Image {

    private final long uuid;
    private String top;
    private String bottom;
    private String left;
    private String right;
    private String[] wholeImage;
    private final int size;

    public Image(String[] input) {
        this.uuid = Long.parseLong(input[0].substring(5,input[0].length()-1));
        this.top = input[1];
        this.bottom = input[input.length-1];

        StringBuilder l = new StringBuilder();
        StringBuilder r = new StringBuilder();
        for (String line : input) {
            if (line.startsWith("Tile"))
                continue;
            l.append(line.charAt(0));
            r.append(line.charAt(line.length()-1));
        }
        this.left = l.toString();
        this.right = r.toString();

        if (input[0].startsWith("Tile"))
            wholeImage = Arrays.copyOfRange(input,1,input.length);
        else
            wholeImage = input.clone();

        this.size = wholeImage.length;
    }

    public boolean sharesEdgeWith(Image oim) {
        return this.bottom.equals(oim.getTop()) || this.top.equals(oim.getBottom()) || this.left.equals(oim.getRight()) || this.right.equals(oim.getLeft());
    }

    public void rotateLeft() {
        String oldTop = this.top;
        this.top = this.right;
        this.right = new StringBuilder(this.bottom).reverse().toString();
        this.bottom = this.left;
        this.left = new StringBuilder(oldTop).reverse().toString();

        String[] newImg = new String[size];
        for (int i=0; i<size; i++) {
            StringBuilder newRow = new StringBuilder();
            for (int ii=0; ii<size; ii++) {
                newRow.append(wholeImage[ii].charAt(i));
            }
            newImg[size- 1 - i] = newRow.toString();
        }
        this.wholeImage = newImg.clone();
    }

    public boolean equals(Image img) {
        String[] checkImg = img.getWholeImage();
        for (int i=0; i<wholeImage.length; i++) {
            if (!wholeImage[i].equals(checkImg[i]))
                return false;
        }
        return true;
    }

    public void flipVertically() {
        String oldTop = this.top;
        this.top = this.bottom;
        this.right = new StringBuilder(this.right).reverse().toString();
        this.bottom = oldTop;
        this.left = new StringBuilder(left).reverse().toString();

        String[] newImg = new String[size];
        for (int i=0; i<size; i++) {
            newImg[i] = wholeImage[size-1-i];
        }
        wholeImage = newImg.clone();
    }

    public void flipHorizontally() {
        String oldRight = this.right;
        this.top = new StringBuilder(this.top).reverse().toString();
        this.right = this.left;
        this.bottom = new StringBuilder(this.bottom).reverse().toString();
        this.left = oldRight;

        String[] newImg = new String[size];
        for (int i=0; i<size; i++) {
            newImg[i] = new StringBuilder(wholeImage[i]).reverse().toString();
        }
        wholeImage = newImg.clone();
    }

    public long getUuid() {
        return uuid;
    }

    public String getTop() { return top; }

    public String getBottom() {
        return bottom;
    }

    public String getLeft() {
        return left;
    }

    public String getRight() {
        return right;
    }

    public String[] getWholeImage() { return wholeImage; }
}
