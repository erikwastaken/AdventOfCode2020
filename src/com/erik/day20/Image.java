package com.erik.day20;

public class Image {

    private long uuid;
    private String top;
    private String bottom;
    private String left;
    private String right;

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
    }

    public boolean sharesEdgeWith(Image oim) {
        return this.bottom.equals(oim.getTop()) || this.top.equals(oim.getBottom()) || this.left.equals(oim.getRight()) || this.right.equals(oim.getLeft());
    }

    public long getUuid() {
        return uuid;
    }

    public String getTop() {
        return top;
    }

    public String getBottom() {
        return bottom;
    }

    public String getLeft() {
        return left;
    }

    public String getRight() {
        return right;
    }
}
