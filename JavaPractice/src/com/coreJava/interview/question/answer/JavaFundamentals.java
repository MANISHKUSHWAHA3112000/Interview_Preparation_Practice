package com.coreJava.interview.question.answer;

/**
 * JavaFundamentals
 * ----------------
 * This class demonstrates the foundational building blocks of Java:
 * - Variables
 * - Data Types
 * - Operators
 * - Control Flow
 *
 * Each section is annotated with professional-level comments that define
 * the concept, explain its purpose, and show practical usage.
 */
public class JavaFundamentals {
    public static void main(String[] args) {
        
        // ============================================================
        // 🔹 VARIABLES
        // ------------------------------------------------------------
        // Definition:
        // A variable is a symbolic name associated with a memory location
        // that stores data. In Java, every variable must be declared with
        // a specific type, ensuring type safety and predictability.
        //
        // Key Points:
        // - Variables provide a way to label and manipulate data.
        // - Follow camelCase naming convention for readability.
        // - Scope determines the lifetime and accessibility of a variable.
        // ============================================================
        
        int age = 25;              // Primitive integer variable
        double salary = 26000.75;  // Primitive floating-point variable
        String name = "Manish";     // Reference type variable (String object)
        boolean isActive = true;   // Boolean variable (true/false)

        System.out.println("Name: " + name + ", Age: " + age);

        // ============================================================
        // 🔹 DATA TYPES
        // ------------------------------------------------------------
        // Definition:
        // Java is a statically typed language, meaning every variable
        // must have a declared type. Data types define the kind of values
        // a variable can hold and the operations that can be performed.
        //
        // Categories:
        // 1. Primitive Types: byte, short, int, long, float, double, char, boolean
        //    - Stored directly in memory, efficient for computation.
        // 2. Reference Types: Objects, Arrays, Classes
        //    - Store references (memory addresses) pointing to actual data.
        // ============================================================
        
        int count = 100;           // Integer primitive
        double pi = 3.14159;       // Double precision floating-point
        char grade = 'A';          // Character literal
        boolean flag = false;      // Boolean literal
        String message = "Hello Java"; // Reference type (String object)

        System.out.println("Count: " + count + ", Pi: " + pi);

        // ============================================================
        // 🔹 OPERATORS
        // ------------------------------------------------------------
        // Definition:
        // Operators are special symbols that perform operations on operands.
        // They enable arithmetic, comparison, logical evaluation, and assignment.
        //
        // Categories:
        // - Arithmetic: +, -, *, /, %
        // - Relational: ==, !=, >, <, >=, <=
        // - Logical: &&, ||, !
        // - Assignment & Unary: =, +=, -=, ++, --
        // ============================================================

        int a = 10, b = 3;

        // Arithmetic Operators
        System.out.println("Sum: " + (a + b));        // Addition
        System.out.println("Division: " + (a / b));   // Integer division
        System.out.println("Remainder: " + (a % b));  // Modulus (remainder)

        // Relational Operators
        System.out.println(a > b);    // true → 10 is greater than 3
        System.out.println(a == b);   // false → 10 is not equal to 3

        // Logical Operators
        boolean result = (a > 5 && b < 5); // true because both conditions hold
        System.out.println(result);

        // Assignment & Unary Operators
        int x = 5;
        x += 2;   // Compound assignment → x = x + 2 → x = 7
        System.out.println(++x); // Pre-increment → increments before use → prints 8

        // ============================================================
        // 🔹 CONTROL FLOW
        // ------------------------------------------------------------
        // Definition:
        // Control flow structures determine the order in which statements
        // are executed. They allow branching, looping, and conditional execution.
        //
        // Categories:
        // - Conditional Statements (if-else)
        // - Multi-branch (switch)
        // - Iterative Constructs (for, while, do-while)
        // ============================================================

        // Conditional Statements (if-else)
        int score = 85;
        if (score >= 90) {
            System.out.println("Excellent");
        } else if (score >= 75) {
            System.out.println("Good");
        } else {
            System.out.println("Needs Improvement");
        }

        // Switch Statement (multi-branch control)
        int day = 3;
        switch(day) {
            case 1: System.out.println("Monday"); break;
            case 2: System.out.println("Tuesday"); break;
            case 3: System.out.println("Wednesday"); break;
            default: System.out.println("Invalid day");
        }

        // Loops
        // For loop: executes a block for a known number of iterations
        for (int i = 1; i <= 5; i++) {
            System.out.println("Iteration: " + i);
        }

        // While loop: executes repeatedly while condition is true
        int j = 1;
        while (j <= 3) {
            System.out.println("While loop: " + j);
            j++;
        }

        // Do-while loop: executes at least once, then checks condition
        int k = 1;
        do {
            System.out.println("Do-while loop: " + k);
            k++;
        } while (k <= 2);
    }
}
