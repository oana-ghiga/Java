package org.example;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ClassAnalyzer {
    public void analyzeClass(Class<?> clazz) {
        System.out.println("Class: " + clazz.getName());
        System.out.println("Modifiers: " + clazz.getModifiers());
        System.out.println("Superclass: " + clazz.getSuperclass());
        System.out.println("Implemented Interfaces: ");
        Class<?>[] interfaces = clazz.getInterfaces();
        for (Class<?> anInterface : interfaces) {
            System.out.println("- " + anInterface.getName());
        }
        System.out.println("Fields: ");
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            System.out.println("- " + field.getType().getSimpleName() + " " + field.getName());
        }
        System.out.println("Constructors: ");
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.print("- " + constructor.getName() + "(");
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            for (int i = 0; i < parameterTypes.length; i++) {
                System.out.print(parameterTypes[i].getSimpleName());
                if (i < parameterTypes.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println(")");
        }
        System.out.println("Methods: ");
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            System.out.print("- " + method.getReturnType().getSimpleName() + " " + method.getName() + "(");
            Class<?>[] parameterTypes = method.getParameterTypes();
            for (int i = 0; i < parameterTypes.length; i++) {
                System.out.print(parameterTypes[i].getSimpleName());
                if (i < parameterTypes.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println(")");
        }
        System.out.println();
    }
}
