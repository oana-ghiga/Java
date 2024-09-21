package org.example;

import java.lang.reflect.Method;

public class MethodAnalyzer {

    public static void invokeMethod(Method method, Object instance, Object... args) {
        try {
            method.setAccessible(true);
            Object result = method.invoke(instance, args);
            System.out.println("Method invocation successful: " + method.getName());
            if (result != null) {
                System.out.println("Result: " + result.toString());
            }
        } catch (Exception e) {
            System.err.println("Failed to invoke method: " + method.getName());
            e.printStackTrace();
        }
    }
}
