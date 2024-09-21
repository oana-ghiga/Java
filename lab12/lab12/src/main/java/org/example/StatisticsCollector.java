package org.example;

public class StatisticsCollector {
    private int totalClasses;
    private int totalMethods;
    private int totalTests;
    private int passedTests;
    private int failedTests;

    public void collectClass() {
        totalClasses++;
    }

    public void collectMethod() {
        totalMethods++;
    }

    public void collectTest() {
        totalTests++;
    }

    public void collectPassedTest() {
        passedTests++;
    }

    public void collectFailedTest() {
        failedTests++;
    }

    public void displayStatistics() {
        System.out.println("Total Classes: " + totalClasses);
        System.out.println("Total Methods: " + totalMethods);
        System.out.println("Total Tests: " + totalTests);
        System.out.println("Passed Tests: " + passedTests);
        System.out.println("Failed Tests: " + failedTests);
    }
}
