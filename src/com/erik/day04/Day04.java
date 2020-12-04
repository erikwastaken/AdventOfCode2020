package com.erik.day04;

import java.util.ArrayList;

public class Day04 {
    final String[] input;

    public Day04(String[] input) {
        this.input = input;
    }

    public int part1() {
        int numberOfValidPassports = 0;
        ArrayList<String> datasets = buildDatasets(input);

        for (String dataset : datasets) {
            if (isDataComplete(dataset))
                numberOfValidPassports++;
        }
        return numberOfValidPassports;
    }

    public int part2() {
        ArrayList<String> datasets = buildDatasets(input);
        int numberOfValidPassports = 0;
        for (String dataset : datasets) {
            if (isDataComplete(dataset) && isDataValid(dataset))
                numberOfValidPassports++;
        }
        return numberOfValidPassports;
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

    private boolean isDataComplete(String dataset) {
        if (dataset.split(" ").length < 7)
            return false;
        if (dataset.split(" ").length == 8)
            return true;
        if (dataset.contains("cid:")) {
            return false;
        }
        return true;
    }

    private boolean isDataValid(String dataset) {
        String[] parameters = dataset.split(" ");
        for (String parameter : parameters) {
            if (!isParameterValid(parameter))
                return false;
        }
        return true;
    }

    private boolean isParameterValid(String parameter) {
        String key = parameter.substring(0,3);
        String value = parameter.substring(4);
        switch (key) {
            case "byr":
                return isBirthYearValid(value);
            case "iyr":
                return isIssuingYearValid(value);
            case "eyr":
                return isExpirationYearValid(value);
            case "hgt":
                return isHeightValid(value);
            case "hcl":
                return isHairColorValid(value);
            case "ecl":
                return isEyeColorValid(value);
            case "pid":
                return isPassportIdValid(value);
            case "cid":
                return true;
        }
        return false;
    }

    private boolean isExpirationYearValid(String value) {
        return (getYearAsInt(value) >= 2020 && getYearAsInt(value) <= 2030);
    }

    private boolean isIssuingYearValid(String value) {
        return (getYearAsInt(value) >= 2010 && getYearAsInt(value) <= 2020);
    }

    private boolean isBirthYearValid(String value) {
        return (getYearAsInt(value) >= 1920 && getYearAsInt(value) <= 2002);
    }

    private boolean isPassportIdValid(String passportId) {
        if (passportId.length() != 9)
            return false;
        for (String letter: passportId.split("")) {
            if (!"0123456789".contains(letter))
                return false;
        }
        return true;
    }

    private boolean isEyeColorValid(String eyeColor) {
        String[] checkValues = {"amb", "blu", "brn", "gry", "grn", "hzl", "oth"};
        for (String value : checkValues) {
            if (eyeColor.contains(value) && value.contains(eyeColor))
                return true;
        }
        return false;
    }

    private boolean isHairColorValid(String hairColor) {
        if (hairColor.charAt(0) != '#')
            return false;
        if (hairColor.length() != 7)
            return false;
        for (int i=1; i<hairColor.length(); i++) {
            if ("0123456789abcdefABCDEF".contains(String.valueOf(hairColor.charAt(i)))) {
                continue;
            }
            return false;
        }
        return true;
    }

    private boolean isHeightValid(String heightWithUnit) {
        int value;
        try {
            value = Integer.parseInt(heightWithUnit.substring(0, heightWithUnit.length() - 2));
        } catch (NumberFormatException e) {
            return false;
        }
        String unit = heightWithUnit.substring(heightWithUnit.length()-2);
        switch (unit) {
            case "cm":
                return (value >= 150 && value <= 193);
            case "in":
                return (value >= 59 && value <= 76);
            default:
                return false;
        }
    }

    private int getYearAsInt(String value) {
        return Integer.parseInt(value);
    }
}
