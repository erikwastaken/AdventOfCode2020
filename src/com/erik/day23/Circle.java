package com.erik.day23;

import java.util.EmptyStackException;

public class Circle {
    private String elements;
    private String stash;
    private int stashIndex;

    public Circle(String input) {
        this.elements = input;
    }

    public int size() {
        return elements.length();
    }

    public int get(int i) {
        int index = i % elements.length();
        return Character.getNumericValue(elements.charAt(index));
    }

    public void stash(int index) {
        stashIndex = index;
        stash = elements.substring(index, index + 1);
        elements = elements.substring(0,index) + elements.substring(index+1);
    }

    public void stash(int startIncl, int endExcl) throws Exception{
        stashIndex = startIncl;
        stash = elements.substring(startIncl,endExcl);
        elements = elements.substring(0,startIncl) + elements.substring(endExcl);
    }

    public void retrieveStash() throws Exception {
        if (stash == null)
            throw new EmptyStackException();
        elements = elements.substring(0,stashIndex) + stash + elements.substring(stashIndex);
    }

    public String getElements() {
        return elements;
    }

    public void insertStash(int i) throws Exception {
        if (stash == null)
            throw new EmptyStackException();
        elements = elements.substring(0,i % elements.length()) + stash + elements.substring(i % elements.length());
    }

    public void makeCurrent(int i) {
        elements = elements.substring(i) + elements.substring(0,i);
    }

    public boolean contains(String value) {
        return elements.contains(value);
    }

    public int indexOf(String s) {
        return elements.indexOf(s);
    }

    public String max() {
        int largest = 0;
        for (char c : elements.toCharArray()){
            int cn = Character.getNumericValue(c);
            if (cn > largest) {
                largest = cn;
            }
        }
        return String.format("%s",largest);
    }
}
