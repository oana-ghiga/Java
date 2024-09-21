package org.example;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class AnnotationAnalyzer {

    public static void analyzeAnnotations(Class<?> clazz) {
        Annotation[] classAnnotations = clazz.getAnnotations();
        System.out.println("Annotations applied to class: " + clazz.getName());
        for (Annotation annotation : classAnnotations) {
            System.out.println(annotation.annotationType().getSimpleName());
        }

        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            Annotation[] methodAnnotations = method.getDeclaredAnnotations();
            System.out.println("\nAnnotations applied to method: " + method.getName());
            for (Annotation annotation : methodAnnotations) {
                System.out.println(annotation.annotationType().getSimpleName());
            }
        }
    }
}
