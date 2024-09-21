package org.example;
import org.junit.Test;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Random;

public class ClassTester {
    private Random random = new Random();

    public void runTests(Class<?> clazz) throws IllegalAccessException, InstantiationException {
        Object instance = clazz.newInstance();
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Test.class)) {
                if (method.getParameterCount() == 0) {
                    invokeTest(method, instance);
                } else {
                    // Generate mock values for arguments
                    Object[] arguments = generateMockValues(method);
                    invokeTest(method, instance, arguments);
                }
            }
        }
    }

    private void invokeTest(Method method, Object instance, Object... arguments) {
        try {
            method.invoke(instance, arguments);
            System.out.println("Test passed: " + method.getName());
        } catch (InvocationTargetException e) {
            System.out.println("Test failed: " + method.getName() + ", Error: " + e.getCause().getMessage());
        } catch (Exception e) {
            System.out.println("Error invoking test: " + method.getName() + ", Error: " + e.getMessage());
        }
    }

    private Object[] generateMockValues(Method method) {
        Class<?>[] parameterTypes = method.getParameterTypes();
        Object[] arguments = new Object[parameterTypes.length];
        for (int i = 0; i < parameterTypes.length; i++) {
            Class<?> parameterType = parameterTypes[i];
            if (parameterType.equals(int.class)) {
                arguments[i] = random.nextInt();
            } else if (parameterType.equals(String.class)) {
                arguments[i] = "MockString";
            } else {
                arguments[i] = null; // For other types, set as null for simplicity
            }
        }
        return arguments;
    }
}
