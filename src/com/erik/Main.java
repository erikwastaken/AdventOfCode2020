package com.erik;

public class Main {

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("No class/file has been given");
            return;
        }
        String className = String.format("com.erik.%s.%s", args[0].toLowerCase(), args[0]);
        InputProvider inputProvider = new InputProvider();
        try {
            AdventDay today = AdventDayFactory.createByName(className, inputProvider.getAsString(args[1]));
            System.out.println(today.part1());
            System.out.println(today.part2());
        } catch (AdventDayFactory.IllegalClassName | InputProvider.FileError e) {
            e.printStackTrace();
        }
    }
}
