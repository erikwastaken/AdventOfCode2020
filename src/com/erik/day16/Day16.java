package com.erik.day16;

import com.erik.AdventDay;

import java.util.*;

public class Day16 implements AdventDay {

    private final HashMap<String, String> rules = new HashMap<>();
    private final String myTicket;
    private final String[] nearbyTickets;
    private final HashMap<String, Integer[][]> ranges;
    private final HashMap<String, HashSet<Integer>> possibleIndexesForField = new HashMap<>();

    public Day16(String[] input) {
        ArrayList<Integer> separators = new ArrayList<>();
        for (int i=0; i<input.length; i++) {
            if (input[i].length() == 0)
                separators.add(i);
        }

        for (int i=0; i<separators.get(0); i++) {
            String[] splits = input[i].split(": ");
            this.rules.put(splits[0], splits[1]);
        }

        this.myTicket = input[separators.get(0) + 2];
        this.nearbyTickets = Arrays.copyOfRange(input, separators.get(1) + 2, input.length);
        this.ranges = buildRanges();
    }
    public Day16(String inputStr) {
        String[] input = inputStr.split("\n");
        ArrayList<Integer> separators = new ArrayList<>();
        for (int i=0; i<input.length; i++) {
            if (input[i].length() == 0)
                separators.add(i);
        }

        for (int i=0; i<separators.get(0); i++) {
            String[] splits = input[i].split(": ");
            this.rules.put(splits[0], splits[1]);
        }

        this.myTicket = input[separators.get(0) + 2];
        this.nearbyTickets = Arrays.copyOfRange(input, separators.get(1) + 2, input.length);
        this.ranges = buildRanges();
    }

    public long part1() {
        return getTotalRateOfError();
    }

    private HashMap<String, Integer[][]> buildRanges() {
        HashMap<String, Integer[][]> ranges = new HashMap<>();
        for (String key : rules.keySet()) {
            String[] splits1 = rules.get(key).split(" or ");
            Integer[] firstRange = new Integer[] {Integer.parseInt(splits1[0].split("-")[0]), Integer.parseInt(splits1[0].split("-")[1])};
            Integer[] secondRange = new Integer[] {Integer.parseInt(splits1[1].split("-")[0]), Integer.parseInt(splits1[1].split("-")[1])};
            ranges.put(key, new Integer[][] {firstRange, secondRange});
        }
        return ranges;
    }

    private long getTotalRateOfError() {
        long rateOfError = 0;
        for (String ticket : nearbyTickets) {
            rateOfError += getRateOfErrorForTicket(ticket);
        }
        return rateOfError;
    }

    private long getRateOfErrorForTicket(String ticket) {
        String[] singleNumbers = ticket.split(",");
        long rateOfError = 0;

        for (String number : singleNumbers) {
            int num = Integer.parseInt(number);

            if (!isNumberValid(num))
                rateOfError += num;
        }
        return rateOfError;
    }

    private boolean isNumberValid(int number) {
        for (String key : ranges.keySet())
            for (int i=0; i<2; i++)
                if (number >= ranges.get(key)[i][0] && number <= ranges.get(key)[i][1])
                    return true;
        return false;
    }

    public long part2() {
        HashMap<String, Integer> identifiedFields = identifyFieldIndexes();

        String[] splits = myTicket.split(",");
        int[] mineTicket = new int[splits.length];
        for (int i=0; i<splits.length; i++)
            mineTicket[i] = Integer.parseInt(splits[i]);

        long result = 1;
        for (String field : identifiedFields.keySet()) {
            if (field.startsWith("departure"))
                result *= mineTicket[identifiedFields.get(field)];
        }
        return result;
    }

    HashMap<String, Integer> identifyFieldIndexes() {
        ArrayList<String> validTickets = getValidTickets();

        initializeFieldsWithAllPossibleIndexes();
        determineIndexesFromRanges(validTickets);
        removeDeterminedIndexesFromOtherFields();

        return getIdentifiedFields();
    }

    private HashMap<String, Integer> getIdentifiedFields() {
        HashMap<String, Integer> identifiedFields = new HashMap<>();
        for (String field : possibleIndexesForField.keySet()) {
            if (possibleIndexesForField.get(field).size() == 1) {
                int index = -1;
                for (Integer element : possibleIndexesForField.get(field))
                    index = element;
                identifiedFields.put(field, index);
            }
        }
        return identifiedFields;
    }

    private ArrayList<String> getValidTickets() {
        ArrayList<String> validTickets = new ArrayList<>();
        for (String ticket : nearbyTickets) {
            if (getRateOfErrorForTicket(ticket) == 0)
                validTickets.add(ticket);
        }
        return validTickets;
    }

    private void initializeFieldsWithAllPossibleIndexes() {
        for (String field : ranges.keySet()) {
            HashSet<Integer> indexes = new HashSet<>();
            for (int i=0; i<ranges.keySet().size(); i++)
                indexes.add(i);
            possibleIndexesForField.put(field,indexes);
        }
    }

    private void removeDeterminedIndexesFromOtherFields() {
        Set<String> fields = new HashSet<>(possibleIndexesForField.keySet());

        while (uniqueFieldExists(fields)) {
            for (String field : possibleIndexesForField.keySet()) {
                if (possibleIndexesForField.get(field).size() == 1) {
                    int index = -1;
                    for (Integer element : possibleIndexesForField.get(field))
                        index = element;

                    for (String key : possibleIndexesForField.keySet()) {
                        if (!key.equals(field))
                            possibleIndexesForField.get(key).remove(index);
                    }
                }
            }
        }
    }

    private void determineIndexesFromRanges(ArrayList<String> validTickets) {
        for (String field : possibleIndexesForField.keySet()) {
            for (String ticket : validTickets) {
                HashSet<Integer> indexes = getPossibleIndexesForField(field, ticket);
                possibleIndexesForField.get(field).retainAll(indexes);
            }
            if (possibleIndexesForField.get(field).size() == 1) {
                int index = -1;
                for (Integer element : possibleIndexesForField.get(field))
                    index = element;

                for (String key : possibleIndexesForField.keySet()) {
                    if (!key.equals(field))
                        possibleIndexesForField.get(key).remove(index);
                }
            }
        }
    }

    private boolean uniqueFieldExists(Set<String> fields) {
        for (String field : fields) {
            if (possibleIndexesForField.get(field).size() == 1) {
                fields.remove(field);
                return true;
            }
        }
        return false;
    }

     HashSet<Integer> getPossibleIndexesForField(String field, String ticket) {
        HashSet<Integer> indexes = new HashSet<>();
        String[] singleNumbers = ticket.split(",");
        Integer[][] range = ranges.get(field);

        for (int i=0; i<singleNumbers.length; i++) {
            int number = Integer.parseInt(singleNumbers[i]);
            for (int j=0; j<2; j++)
                if (number >= range[j][0] && number <= range[j][1])
                    indexes.add(i);
        }
        return indexes;
    }
}
