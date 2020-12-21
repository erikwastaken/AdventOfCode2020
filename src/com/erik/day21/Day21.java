package com.erik.day21;

import com.erik.AdventDay;

import java.lang.reflect.Array;
import java.util.*;

public class Day21 implements AdventDay {
    String[] input;
    HashMap<String, HashSet<String>> possibleIngredientsForAllergen = new HashMap<>();
    HashSet<String> ingredients = new HashSet<>();

    public Day21(String[] input) {
        this.input = input;
        parseInput(input);
    }

    public long part1() {
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

    private void parseInput(String[] input) {
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
    }

    public long part2() {
        return -1;
    }

    public String part2String() {
        HashSet<String> allergens = new HashSet<>(possibleIngredientsForAllergen.keySet());
        HashMap<String, String> uniqueIngredientForAllergen = new HashMap<>();

        while (uniqueIngredientExists(allergens)) {
            for (String allergen : possibleIngredientsForAllergen.keySet()) {
                if (possibleIngredientsForAllergen.get(allergen).size() == 1) {
                    String ingredient = "";
                    for (String element : possibleIngredientsForAllergen.get(allergen))
                        ingredient = element;

                    for (String key : possibleIngredientsForAllergen.keySet()) {
                        if (!key.equals(allergen))
                            possibleIngredientsForAllergen.get(key).remove(ingredient);
                    }
                }
            }
        }

        for (String key : possibleIngredientsForAllergen.keySet()) {
            for (String element : possibleIngredientsForAllergen.get(key)) {
                uniqueIngredientForAllergen.put(key,element);
            }
        }
        String[] sortedAllergens = uniqueIngredientForAllergen.keySet().toArray(new String[0]);
        Arrays.sort(sortedAllergens);
        StringBuilder result = new StringBuilder();
        for (int i = 0; i<sortedAllergens.length; i++) {
            result.append(uniqueIngredientForAllergen.get(sortedAllergens[i]));
            if (i<sortedAllergens.length -1)
                result.append(",");
        }
        return result.toString();
    }

    private boolean uniqueIngredientExists(Set<String> allergens) {
        for (String allergen : allergens) {
            if (possibleIngredientsForAllergen.containsKey(allergen)) {
                HashSet<String> ingredients = possibleIngredientsForAllergen.get(allergen);
                if (ingredients.size() == 1) {
                    allergens.remove(allergen);
                    return true;
                }
            }
        }
        return false;
    }
}
