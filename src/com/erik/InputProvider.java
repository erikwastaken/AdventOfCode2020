package com.erik;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputProvider {
    private static String directoryPath = "/Users/erikschwab/Documents/Java/AdventOfCode/InputFiles/";//"../InputFiles/";

    public String[] get(String filename) {
        List<String> resultList = new ArrayList<>();
        try {
            File file = new File(directoryPath + filename);
            Scanner fileReader = new Scanner(file);

            while (fileReader.hasNextLine()) {
                resultList.add(fileReader.nextLine());
            }
        } catch (FileNotFoundException e) {
            // TODO: error handling;
            System.out.println("An error occurred");
            e.printStackTrace();
        }
        String[] result = new String[resultList.size()];
        result = resultList.toArray(result);
        return result;
    }
}
