package com.practice1;

public class ImmutablePerson {
        private final String name;
        private final int age;

        // Constructor to initialize the fields
        public ImmutablePerson(String name, int age) {
            this.name = name;
            this.age = age;
        }

        // Getter methods to access the fields
        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        // No setters to ensure the fields cannot be modified

        // Override toString for better representation
        @Override
        public String toString() {
            return "ImmutablePerson{name='" + name + "', age=" + age + "}";
        }
}

class Main3 {
    public static void main(String[] args) {
        ImmutablePerson person = new ImmutablePerson("John Doe", 30);
        System.out.println(person);

        // Attempting to modify fields (will cause a compilation error)
        // person.name = "Jane Doe"; // Error: The final field ImmutablePerson.name cannot be assigned
        // person.age = 31; // Error: The final field ImmutablePerson.age cannot be assigned
    }
}
