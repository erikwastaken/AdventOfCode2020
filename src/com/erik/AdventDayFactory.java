package com.erik;

import java.lang.reflect.Constructor;

public class AdventDayFactory {
    public static AdventDay createByName(String name, String input) throws IllegalClassName {
        try {
            Class cls = Class.forName(name);
            Class[] parameterTypes = new Class[1];
            parameterTypes[0] = Class.forName("java.lang.String");
            Constructor ct = cls.getConstructor(parameterTypes);
            Object[] argList = new Object[1];
            argList[0] = input;
            Object retObj = ct.newInstance(argList);

            if (retObj instanceof AdventDay) {
                return (AdventDay) retObj;
            }
            throw new IllegalClassName();
        }
        catch (Throwable e) {
            throw new IllegalClassName();
        }
    }

    public static class IllegalClassName extends Exception {
    }
}
