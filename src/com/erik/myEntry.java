package com.erik;

public class myEntry {
    public int rangeLow;
    public int rangeHigh;
    public String letter;
    public String password;

    public static myEntry createFromString(String str) {
        String[] data = str.split(" ");
        myEntry entry = new myEntry();
        entry.rangeLow = Integer.parseInt(data[0].split("-")[0]);
        entry.rangeHigh = Integer.parseInt(data[0].split("-")[1]);
        entry.letter = data[1].substring(0,1);
        entry.password = data[2];

        return entry;
    }
}
