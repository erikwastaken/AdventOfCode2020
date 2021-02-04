package com.erik.day13;

import com.erik.AdventDay;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class Day13 implements AdventDay {
    private int earliestDeparture;
    // to solve are equations of the form
    // ex. "3,x,x,4,5"
    // t = 0 mod 3
    // t + 1 = 3 mod 4
    // t + 2 = 4 mod 5
    // t + offset = value mod key
    private Map<Long,Long> offsetsForBusIds;
    private Map<BigInteger, BigInteger> bigCongruencesForModulo = new HashMap<>();

    public Day13(String[] input) {
        this.earliestDeparture = Integer.parseInt(input[0]);
        this.offsetsForBusIds = buildIdMap(input[1].split(","));
        for (Long id : offsetsForBusIds.keySet()) {
            long value = (id - offsetsForBusIds.get(id)) % id;
            if (value < 0)
                value += id;
            this.bigCongruencesForModulo.put(BigInteger.valueOf(id), BigInteger.valueOf(value));
        }
    }
    public Day13(String inputStr) {
        String[] input = inputStr.split("\n");
        this.earliestDeparture = Integer.parseInt(input[0]);
        this.offsetsForBusIds = buildIdMap(input[1].split(","));
        for (Long id : offsetsForBusIds.keySet()) {
            long value = (id - offsetsForBusIds.get(id)) % id;
            if (value < 0)
                value += id;
            this.bigCongruencesForModulo.put(BigInteger.valueOf(id), BigInteger.valueOf(value));
        }
    }

    public long part1() {
        long minWaitTime = earliestDeparture;
        long minBusId = 0;
        for (long id : offsetsForBusIds.keySet()) {
            long waitTime = id - earliestDeparture % id;
            if (waitTime < minWaitTime) {
                minWaitTime = waitTime;
                minBusId = id;
            }
        }
        return minBusId * minWaitTime;
    }

    public long part2() {
        int numberOfKeys = bigCongruencesForModulo.keySet().size();
        BigInteger[] keys = new BigInteger[numberOfKeys];
        int k=0;
        for (BigInteger key : bigCongruencesForModulo.keySet())
            keys[k++] = key;
        return solveN(keys).longValue();
    }

    private Map<Long, Long> buildIdMap(String[] busIds) {
        Map<Long, Long> map = new HashMap<>();
        for (int i=0; i<busIds.length; i++) {
            if (busIds[i].equals("x"))
                continue;
            Long key = Long.parseLong(busIds[i]);
            Long value = (long) i;
            map.put(key,value);
        }
        return map;
    }

    private Long systematicApproach() {
        long counter = 1;
        long maxId = getMaxId();
        long checkValue = maxId - offsetsForBusIds.get(maxId);
        while (!numberFulfillsConditions(checkValue)) {
            checkValue = maxId*counter - offsetsForBusIds.get(maxId);
            counter++;
        }
        return checkValue;
    }

    private boolean numberFulfillsConditions(long value) {
        for (Long id : offsetsForBusIds.keySet()) {
            if (value % id != (id - offsetsForBusIds.get(id)) % id ) {
                if (value == 782) {
                    System.out.println(id);
                    System.out.println(offsetsForBusIds.get(id));
                    System.out.println(value % id);
                    System.out.println(id - offsetsForBusIds.get(id) % id);
                }
                return false;
            }
        }
        return true;
    }

    private long getMaxId() {
        long result = 0;
        for (long id : offsetsForBusIds.keySet())
            if (id>result)
                result = id;
        return result;
    }

    public Long[] getBezoutCoefficients(Long a, Long b) {
        Long old_r = a;
        Long r = b;
        long old_s = 1L;
        long s = 0L;
        long old_t = 0L;
        long t = 1L;

        while (r!=0) {
            long quotient = old_r / r;
            long tmp;

            tmp = r;
            r = old_r - quotient * r;
            old_r = tmp;

            tmp = s;
            s = old_s - quotient * s;
            old_s = tmp;

            tmp = t;
            t = old_t - quotient * t;
            old_t = tmp;
        }
        return new Long[] {old_s, old_t};
    }

    public BigInteger solveTwo(BigInteger key1, BigInteger key2) {
        return bigCongruencesForModulo.get(getKeyForSolutionOfTwo(key1, key2));
    }

    private BigInteger getKeyForSolutionOfTwo(BigInteger key1, BigInteger key2) {
        Long[] bezout = getBezoutCoefficients(key1.longValue(), key2.longValue());
        // a1 * m2 * n2 + a2 + m1 + n1
        BigInteger summand1 = bigCongruencesForModulo.get(key1).multiply(key2).multiply(BigInteger.valueOf(bezout[1]));
        BigInteger summand2 = bigCongruencesForModulo.get(key2).multiply(key1).multiply(BigInteger.valueOf(bezout[0]));
        BigInteger solution = summand1.add(summand2);
        BigInteger newKey = key1.multiply(key2);

        if (solution.compareTo(BigInteger.ZERO) == -1) {
            BigInteger multiplier = solution.divide(newKey).multiply(new BigInteger("-1"));
            solution = solution.add(newKey.multiply(multiplier));
        }
        while (solution.compareTo(BigInteger.ZERO) == -1)
            solution = solution.add(newKey);
        solution = solution.mod(newKey);
        bigCongruencesForModulo.put(newKey, solution);
        return newKey;
    }

    public BigInteger solveN(BigInteger[] keys) {
        return bigCongruencesForModulo.get(getKeyForSolutionOfN(keys));
    }

    private BigInteger getKeyForSolutionOfN(BigInteger[] keys) {
        if (keys.length == 2)
            return getKeyForSolutionOfTwo(keys[0], keys[1]);
        BigInteger[] remainingKeys = new BigInteger[keys.length-1];
        remainingKeys[0] = getKeyForSolutionOfTwo(keys[0], keys[1]);
        System.arraycopy(keys, 2, remainingKeys, 1, remainingKeys.length - 1);
        return getKeyForSolutionOfN(remainingKeys);
    }
}
