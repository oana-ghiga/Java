package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
    Faker faker = new Faker();

    String name = faker.name().fullName(); // Miss Samanta Schmidt
    String firstName = faker.name().firstName(); // Emory
    String lastName = faker.name().lastName(); // Barton

    String streetAddress = faker.address().streetAddress();
}