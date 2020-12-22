package com.erik.day20;

public class Image {

    private final long uuid;
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

    public void rotateLeft() {
        String oldTop = this.top;
        this.top = this.right;
        this.right = new StringBuilder(this.bottom).reverse().toString();
        this.bottom = this.left;
        this.left = new StringBuilder(oldTop).reverse().toString();
    }

    public boolean equals(Image img) {
        return this.top.equals(img.getTop()) && this.bottom.equals(img.getBottom()) && this.left.equals(img.getLeft()) && this.right.equals(img.getRight());
    }

    public void flipVertically() {
        String oldTop = this.top;
        this.top = this.bottom;
        this.right = new StringBuilder(this.right).reverse().toString();
        this.bottom = oldTop;
        this.left = new StringBuilder(left).reverse().toString();
    }

    public void flipHorizontally() {
        String oldRight = this.right;
        this.top = new StringBuilder(this.top).reverse().toString();
        this.right = this.left;
        this.bottom = new StringBuilder(this.bottom).reverse().toString();
        this.left = oldRight;
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
}
