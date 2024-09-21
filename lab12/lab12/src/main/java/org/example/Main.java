package org.example;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String classFilePath = args[0];
        loadAndAnalyzeClass(classFilePath);
    }

    private static void loadAndAnalyzeClass(String classFilePath) {
        ClassExplorer explorer = new ClassExplorer();
        List<Class<?>> classes;
        try {
            classes = explorer.exploreClasses(classFilePath);
        } catch (Exception e) {
            System.err.println("Failed to explore classes: " + e.getMessage());
            return;
        }

        ClassAnalyzer analyzer = new ClassAnalyzer();
        StatisticsCollector statistics = new StatisticsCollector();

        for (Class<?> clazz : classes) {
            analyzer.analyzeClass(clazz);
            statistics.collectClass();

            // Analyze the methods and invoke the ones annotated with @Test
            Method[] methods = clazz.getDeclaredMethods();
            for (Method method : methods) {
                Annotation[] annotations = method.getDeclaredAnnotations();
                for (Annotation annotation : annotations) {
                    if (annotation.annotationType().getSimpleName().equals("Test")) {
                        statistics.collectMethod();
                        statistics.collectTest();

                        // Invoke the method
                        try {
                            method.setAccessible(true); // In case the method is private
                            Object instance = clazz.newInstance();
                            method.invoke(instance);
                            statistics.collectPassedTest();
                        } catch (Exception e) {
                            System.err.println("Failed to invoke test method: " + method.getName());
                            e.printStackTrace();
                            statistics.collectFailedTest();
                        }
                    }
                }
            }
        }

        statistics.displayStatistics();
    }
}