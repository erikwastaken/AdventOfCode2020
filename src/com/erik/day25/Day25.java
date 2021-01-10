package com.erik.day25;

public class Day25 {
    private final long SUBJECT_NUMBER = 7;
    private final long DIVISOR = 20201227;
    private final long CARD_KEY;
    private final long DOOR_KEY;

    public Day25(String[] input) {
        this.CARD_KEY = Long.parseLong(input[0]);
        this.DOOR_KEY = Long.parseLong(input[1]);
    }

    public long part1() {
        long cardLoopSize = 0;
        long value = 1;
        while (value != CARD_KEY) {
            value *= SUBJECT_NUMBER;
            value = value % DIVISOR;
            cardLoopSize++;
        }

        return transform(cardLoopSize, DOOR_KEY);
    }

    private long transform(final long loopSize, final long subjectNumber) {
        long value;
        value = 1;
        for (int i = 0; i < loopSize; i++) {
            value *= subjectNumber;
            value = value % DIVISOR;
        }
        return value;
    }

}
