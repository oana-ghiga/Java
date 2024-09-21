package org.example;

import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.util.ConfigurationBuilder;
import org.reflections.util.FilterBuilder;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ClassExplorer {
    public List<Class<?>> exploreClasses(String path) throws Exception {
        List<Class<?>> classes = new ArrayList<>();

        File file = new File(path);
        if (file.isDirectory()) {
            exploreDirectory(file, classes);
        } else if (file.isFile() && file.getName().endsWith(".jar")) {
            exploreJar(file, classes);
        }

        return classes;
    }

    private void exploreDirectory(File directory, List<Class<?>> classes) throws Exception {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    exploreDirectory(file, classes);
                } else if (file.isFile() && file.getName().endsWith(".class")) {
                    String className = file.getPath()
                            .replace(directory.getPath() + File.separator, "")
                            .replace(File.separator, ".")
                            .replace(".class", "");
                    Class<?> clazz = Class.forName(className);
                    classes.add(clazz);
                }
            }
        }
    }

    private void exploreJar(File jarFile, List<Class<?>> classes) throws Exception {
        URLClassLoader classLoader = new URLClassLoader(new URL[]{jarFile.toURI().toURL()});
        Reflections reflections = new Reflections(new ConfigurationBuilder()
                .addUrls(jarFile.toURI().toURL())
                .addClassLoader(classLoader)
                .filterInputsBy(new FilterBuilder().include(FilterBuilder.prefix(""))));

        Set<Class<?>> jarClasses = reflections.getSubTypesOf(Object.class);
        classes.addAll(jarClasses);
    }
}
