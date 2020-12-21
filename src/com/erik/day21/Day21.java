package com.erik.day21;

import com.erik.AdventDay;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class Day21 implements AdventDay {
    String[] input;
    public Day21(String[] input) {
        this.input = input;
    }

    public long part1() {
        HashMap<String, HashSet<String>> possibleIngredientsForAllergen = new HashMap<>();
        HashSet<String> ingredients = new HashSet<>();
        for (String s : input) {
            // separate ingredient jibberish from allergens
            String[] splits = s.split(" \\(contains ");
            String[] ings = splits[0].split(" ");
            Collections.addAll(ingredients, ings);

            String[] allergens = splits[1].split(", ");
            // remove the ) on the last allergen;
            allergens[allergens.length-1] = allergens[allergens.length-1].substring(0,allergens[allergens.length-1].length()-1);

            for (String a : allergens) {
                if (possibleIngredientsForAllergen.containsKey(a)) {
                    possibleIngredientsForAllergen.get(a).retainAll(new HashSet<>(Arrays.asList(ings)));
                } else {
                    possibleIngredientsForAllergen.put(a, new HashSet<>(Arrays.asList(ings)));
                }
            }
        }

        HashSet<String> notAllergens = new HashSet<>(ingredients);

        for (String ingredient : ingredients) {
            for (HashSet<String> value : possibleIngredientsForAllergen.values()) {
                if (value.contains(ingredient))
                    notAllergens.remove(ingredient);
            }
        }


        long counter = 0;
        for (String ingredient : notAllergens) {
            for (String line : input) {
                // prevent miscount with line.contains(...), as ingredients might be substrings of other ingredients;
                for (String s : line.split(" \\(contains ")[0].split(" ")) {
                    if (s.equals(ingredient))
                        counter++;
                }
            }
        }
        return counter;
    }

    public long part2() {
        return -1;
    }
}
