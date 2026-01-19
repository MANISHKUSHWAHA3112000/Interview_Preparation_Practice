package com.coreJava.interview.question.answer;



/**
 * ============================================
 * ENCAPSULATION IN JAVA - COMPLETE EXAMPLE
 * ============================================
 * Definition:
 * Encapsulation = Wrapping data (fields) and methods (getters/setters)
 * together inside a class, while restricting direct access to data.
 *
 * Key Points:
 * - Private fields → Data hiding
 * - Public getters/setters → Controlled access
 * - Validation logic → Ensures data integrity
 * - Constructors → Safe initialization
 * - toString() → Clean object representation
 * - Immutability → Possible if setters are removed
 *
 * Real-world Analogy:
 * Think of a Bank ATM:
 * - You don’t see the internal database (private fields).
 * - You interact only via controlled methods (insert card, enter PIN, withdraw).
 * - Validation ensures security (wrong PIN → denied).
 *
 * Difference between Encapsulation & Abstraction:
 * - Encapsulation = HOW you hide data (implementation detail).
 * - Abstraction = WHAT you expose (essential features only).
 *
 * Interview Q&A:
 * Q1: What is encapsulation?
 *     → Encapsulation is the process of hiding data using private fields
 *       and providing controlled access through public methods.
 *
 * Q2: Why is encapsulation important?
 *     → It improves security, maintains data integrity, and makes code flexible.
 *
 * Q3: How does encapsulation differ from abstraction?
 *     → Encapsulation hides implementation details inside a class,
 *       while abstraction hides complexity by exposing only essential features.
 *
 * Q4: Can encapsulation make a class immutable?
 *     → Yes, if you only provide getters and no setters, the object’s state
 *       cannot be changed after creation.
 *
 * Q5: Real-world example?
 *     → Capsule medicine: powder inside is hidden, you only consume it safely.
 */

public class OopsConcept {
    
    /**
     * Inner Class A (non-static)
     * Demonstrates encapsulation with private fields, getters, setters, validation, and toString.
     */
    class A {
        private String name;  // private field (data hiding)
        private int age;      // private field (data hiding)

        // Default constructor
        public A() {}

        // Parameterized constructor
        public A(String name, int age) {
            this.name = name;
            setAge(age); // use setter for validation
        }

        // Getter for name
        public String getName() {
            return name;
        }

        // Setter for name with validation
        public void setName(String name) {
            if(name != null && !name.isEmpty()) {
                this.name = name;
            } else {
                System.out.println("Invalid name!");
            }
        }

        // Getter for age
        public int getAge() {
            return age;
        }

        // Setter for age with validation
        public void setAge(int age) {
            if(age > 0 && age < 120) {
                this.age = age;
            } else {
                System.out.println("Invalid age! Must be between 1 and 120.");
            }
        }

        // toString method for clean printing
        @Override
        public String toString() {
            return "A [name=" + name + ", age=" + age + "]";
        }
    }

    /**
     * Static Nested Class B
     * Demonstrates encapsulation with private fields, getters, setters, validation, and toString.
     */
    static class B {
        private String name;
        private int age;

        // Constructor
        public B(String name, int age) {
            this.name = name;
            setAge(age); // use setter for validation
        }

        // Getter for name
        public String getName() {
            return name;
        }

        // Setter for name with validation
        public void setName(String name) {
            if(name != null && !name.isEmpty()) {
                this.name = name;
            } else {
                System.out.println("Invalid name!");
            }
        }

        // Getter for age
        public int getAge() {
            return age;
        }

        // Setter for age with validation
        public void setAge(int age) {
            if(age > 0 && age < 120) {
                this.age = age;
            } else {
                System.out.println("Invalid age! Must be between 1 and 120.");
            }
        }

        // toString method
        @Override
        public String toString() {
            return "B [name=" + name + ", age=" + age + "]";
        }
    }

    public static void main(String[] args) {
    	OopsConcept obj = new OopsConcept();

        // Using class A
        A a = obj.new A();
        a.setName("Manish");   // controlled access via setter
        a.setAge(24);          // controlled access via setter

        // Using class B
        B b = new B("Prince", 26);
        b.setName("Mannu");    // controlled access via setter
        b.setAge(25);          // controlled access via setter

        // Print objects using toString()
        System.out.println(a);
        System.out.println(b);

        // Demonstrating encapsulation benefits:
        // Validation prevents invalid data
        a.setAge(-5); // Invalid age
        b.setName(""); // Invalid name
    }
}
