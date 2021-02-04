package com.erik;

import java.lang.reflect.Constructor;

public class AdventDayFactory {
    public static AdventDay createByName(String name, String input) throws IllegalClassName {
        try {
            Class cls = Class.forName(name);
            Class partypes[] = new Class[1];
            partypes[0] = Class.forName("java.lang.String");
            Constructor ct = cls.getConstructor(partypes);
            Object arglist[] = new Object[1];
            arglist[0] = input;
            Object retobj = ct.newInstance(arglist);

            if (retobj instanceof AdventDay) {
                return (AdventDay) retobj;
            }
            throw new IllegalClassName();
        }
        catch (Throwable e) {
            System.err.println(e);
            throw new IllegalClassName();
        }
    }

    public static class IllegalClassName extends Exception {
    }
}
