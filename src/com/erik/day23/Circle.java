package com.erik.day23;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class Circle {
    private List<Integer> elements;
    private List<Integer> stash;
    private int stashIndex;

    public Circle(List<Integer> input) { this.elements = new ArrayList<>(input); }

    public int size() {
        return elements.size();
    }

    public int get(int i) {
        int index = i % elements.size();
        return elements.get(index);
    }

    public void stash(int index) {
        stashIndex = index;
        stash = new ArrayList(elements.subList(index, index + 1));
        elements.removeAll(stash);
    }

    public void stash(int startIncl, int endExcl) throws Exception{
        stashIndex = startIncl;
        stash = new ArrayList(elements.subList(startIncl, endExcl));
        elements.removeAll(stash);
    }

    public void retrieveStash() throws Exception {
        if (stash == null)
            throw new EmptyStackException();
        elements.addAll(stashIndex,stash);
    }

    public List<Integer> getElements() {
        return elements;
    }

    public void insertStash(int i) throws Exception {
        if (stash == null)
            throw new EmptyStackException();
        elements.addAll(i%elements.size(),stash);
    }

    public void makeCurrent(int i) {
        List<Integer> beginning = elements.subList(i,elements.size());
        List<Integer> end = elements.subList(0,i);
        elements = new ArrayList<>(beginning);
        elements.addAll(end);
    }

    public boolean contains(int value) {
        return elements.contains(value);
    }

    public int indexOf(int s) {
        return elements.indexOf(s);
    }

    public long max() {
        int largest = 0;
        for (int c : elements){
            if (c > largest) {
                largest = c;
            }
        }
        return largest;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i : elements)
            sb.append(i);
        return sb.toString();
    }
}
