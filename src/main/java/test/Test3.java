package test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.ThreadLocalRandom;

public class Test3 {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Class<ThreadLocalRandom> clazz = ThreadLocalRandom.class;
        Method getMethod = null;
        Method advanceMethod = null;
        try {
            getMethod = clazz.getDeclaredMethod("getProbe");
            advanceMethod = clazz.getDeclaredMethod("advanceProbe", int.class);
            getMethod.setAccessible(true);
            advanceMethod.setAccessible(true);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }


    }
}


