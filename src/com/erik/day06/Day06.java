package com.erik.day06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Day06 {
    private String[] input;
    public Day06(String[] input) {
        this.input = input;
    }

    public int part1() {
        ArrayList<String> groupAnswersList = getGroupAnswersAsSingleStrings();

        return getSumOfDistinctAnswersPerGroup(groupAnswersList);
    }

    private int getSumOfDistinctAnswersPerGroup(ArrayList<String> groupAnswersList) {
        int result = 0;
        for (int j = 0; j< groupAnswersList.size(); j++) {
            String group = groupAnswersList.get(j);
            Set<String> distinctAnswersPerGroup = new HashSet<>();
            for (int k=0; k<group.length(); k++) {
                String answer = String.valueOf(group.charAt(k));
                if (!answer.contains(" "))
                    distinctAnswersPerGroup.add(answer);
            }
            result += distinctAnswersPerGroup.size();
        }
        return result;
    }

    private ArrayList<String> getGroupAnswersAsSingleStrings() {
        ArrayList<String> groupAnswersList = new ArrayList<>();
        String groupAnswers = "";
        for (int i=0; i<input.length; i++) {
            if (groupAnswers.length() == 0)
                groupAnswers += input[i];
            else
                groupAnswers = groupAnswers + " " + input[i];

            if (input[i].length() == 0 || i == input.length - 1) {
                groupAnswersList.add(groupAnswers);
                groupAnswers = "";
            }
        }
        return groupAnswersList;
    }

    public int part2() {
        ArrayList<String> groupAnswersList = getGroupAnswersAsSingleStrings();

        return getSumOfAgreedAnswersPerGroup(groupAnswersList);
    }

    private int getSumOfAgreedAnswersPerGroup(ArrayList<String> groupAnswersList) {
        int sum = 0;

        for (String group : groupAnswersList) {
            sum += getNumberOfCommonAnswers(group);
        }
        return sum;
    }

    private int getNumberOfCommonAnswers(String group) {
        String[] answersPerMember = group.split(" ");
        Set<String> commonAnswers = new HashSet<>(Arrays.asList(answersPerMember[0].split("")));

        for (int i=1; i<answersPerMember.length; i++) {
            Set<String> current = new HashSet<>(Arrays.asList(answersPerMember[i].split("")));
            commonAnswers.retainAll(current);
        }
        return commonAnswers.size();
    }
}
