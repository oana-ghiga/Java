package org.example;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class AnnotationProcessor {

    public static void processAnnotations(Class<?> clazz) {
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            Annotation[] annotations = method.getDeclaredAnnotations();
            for (Annotation annotation : annotations) {
                if (annotation.annotationType().getSimpleName().equals("Test")) {
                    invokeTestMethod(method, clazz);
                }
            }
        }
    }

    private static void invokeTestMethod(Method method, Class<?> clazz) {
        try {
            Object instance = null; // If the method is static, instance is null
            if (!Modifier.isStatic(method.getModifiers())) {
                instance = clazz.getDeclaredConstructor().newInstance();
            }

            method.setAccessible(true);
            method.invoke(instance);
            System.out.println("Invoked test method: " + method.getName());
        } catch (Exception e) {
            System.err.println("Failed to invoke test method: " + method.getName());
            e.printStackTrace();
        }
    }
}
