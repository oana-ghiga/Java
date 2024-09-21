package org.example;

import java.io.FileInputStream;
import java.io.IOException;

public class CustomClassLoader extends ClassLoader {

    public Class<?> loadClassFromFile(String classFilePath) throws ClassNotFoundException {
        try {
            byte[] classData = getClassData(classFilePath);
            String className = getClassName(classFilePath);
            return defineClass(className, classData, 0, classData.length);
        } catch (IOException e) {
            throw new ClassNotFoundException("Failed to load class from file: " + classFilePath, e);
        }
    }

    private byte[] getClassData(String classFilePath) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(classFilePath);
        byte[] buffer = new byte[fileInputStream.available()];
        fileInputStream.read(buffer);
        fileInputStream.close();
        return buffer;
    }

    private String getClassName(String classFilePath) {
        String className = classFilePath.replace('/', '.');
        className = className.substring(0, className.length() - ".class".length());
        return className;
    }
}
