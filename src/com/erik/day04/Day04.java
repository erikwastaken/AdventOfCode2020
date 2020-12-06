package com.erik.day04;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        Pattern pattern = Pattern.compile("[0-9]{9}");
        Matcher matcher = pattern.matcher(passportId);
        if (matcher.find())
            return true;
        return false;
    }

    private boolean isEyeColorValid(String eyeColor) {
        Pattern pattern = Pattern.compile("amb|blu|brn|gry|grn|hzl|oth");
        Matcher matcher = pattern.matcher(eyeColor);
        if (matcher.find())
            return true;
        return false;
    }

    private boolean isHairColorValid(String hairColor) {
        Pattern pattern = Pattern.compile("^#[0-9a-f]{6}");
        Matcher matcher = pattern.matcher(hairColor);
        if (matcher.find())
            return true;
        return false;
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
