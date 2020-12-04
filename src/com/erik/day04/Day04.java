package com.erik.day04;

import java.util.ArrayList;

public class Day04 {
    public int part1(final String[] input) {
        int numberOfValidPassports = 0;

        ArrayList<String> datasets = buildDatasets(input);

        for (String dataset : datasets) {
            if (isDataValid(dataset))
                numberOfValidPassports++;
        }
        return numberOfValidPassports;
    }

    private boolean isDataValid(String dataset) {
        if (dataset.split(" ").length < 7)
            return false;
        if (dataset.split(" ").length == 8)
            return true;
        if (dataset.contains("cid:")) {
            return false;
        }
        return true;
    }

    private ArrayList<String> buildDatasets(String[] input) {
        StringBuilder data = new StringBuilder();
        ArrayList<String> datasets = new ArrayList<>();
        for (int i=0; i<input.length; i++) {
            if (data.toString().length() == 0) {
                data.append(input[i]);
            } else {
                data.append(" ").append(input[i]);
            }
            if (input[i].length() == 0 || i == input.length-1) {
                datasets.add(data.toString());
                data = new StringBuilder();
            }
        }
        return datasets;
    }
}
