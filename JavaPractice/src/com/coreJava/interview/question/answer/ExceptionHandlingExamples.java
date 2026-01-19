package com.coreJava.interview.question.answer;

/**
 * ============================================================
 * Java Exception Handling: try-catch-finally, throw/throws, custom exceptions
 * ============================================================
 *
 * Author: Professional Demonstration
 * Purpose: To explain exception handling mechanisms in Java with
 *          professional comments and runnable examples.
 *
 * ------------------------------------------------------------
 * DEFINITIONS:
 * ------------------------------------------------------------
 * 1. try-catch-finally:
 *    - try: Block of code where exceptions may occur.
 *    - catch: Block that handles the exception.
 *    - finally: Block that always executes (cleanup code).
 *
 * 2. throw:
 *    - Used to explicitly throw an exception object.
 *    - Example: throw new IOException("Error message");
 *
 * 3. throws:
 *    - Declares exceptions that a method may throw.
 *    - Example: public void readFile() throws IOException
 *
 * 4. Custom Exceptions:
 *    - User-defined exceptions by extending Exception or RuntimeException.
 *    - Useful for domain-specific error handling.
 *
 * ------------------------------------------------------------
 * COMPARISON TABLE:
 * ------------------------------------------------------------
 * | Keyword/Concept | Purpose                                | Example Usage                     |
 * |-----------------|----------------------------------------|-----------------------------------|
 * | try             | Code that may throw exception          | try { riskyCode(); }              |
 * | catch           | Handle specific exception              | catch(IOException e) { ... }      |
 * | finally         | Always executes (cleanup)              | finally { closeResource(); }      |
 * | throw           | Explicitly throw exception             | throw new Exception("Error");     |
 * | throws          | Declare exception in method signature  | void method() throws IOException  |
 * | Custom Exception| User-defined exception class           | class MyException extends Exception|
 *
 * ============================================================
 */

public class ExceptionHandlingExamples {

    public static void main(String[] args) {
        // ------------------------------------------------------------
        // 1. TRY-CATCH-FINALLY DEMO
        // ------------------------------------------------------------
        try {
            int result = 10 / 0; // ArithmeticException
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Caught Exception: " + e.getMessage());
        } finally {
            System.out.println("Finally block always executes (cleanup code).");
        }

        // ------------------------------------------------------------
        // 2. THROW DEMO
        // ------------------------------------------------------------
        try {
            validateAge(15); // Will throw exception
        } catch (IllegalArgumentException e) {
            System.out.println("Caught Exception from throw: " + e.getMessage());
        }

        // ------------------------------------------------------------
        // 3. THROWS DEMO
        // ------------------------------------------------------------
        try {
            riskyMethod(); // Method declares throws IOException
        } catch (java.io.IOException e) {
            System.out.println("Caught Exception from throws: " + e.getMessage());
        }

        // ------------------------------------------------------------
        // 4. CUSTOM EXCEPTION DEMO
        // ------------------------------------------------------------
        try {
            checkBalance(200); // Will throw custom exception
        } catch (InsufficientFundsException e) {
            System.out.println("Caught Custom Exception: " + e.getMessage());
        }
    }

    // ------------------------------------------------------------
    // Method demonstrating 'throw'
    // ------------------------------------------------------------
    public static void validateAge(int age) {
        if (age < 18) {
            // Explicitly throwing exception
            throw new IllegalArgumentException("Age must be 18 or above.");
        }
        System.out.println("Age is valid.");
    }

    // ------------------------------------------------------------
    // Method demonstrating 'throws'
    // ------------------------------------------------------------
    public static void riskyMethod() throws java.io.IOException {
        // Declaring that this method may throw IOException
        throw new java.io.IOException("Simulated IO error.");
    }

    // ------------------------------------------------------------
    // Custom Exception Class
    // ------------------------------------------------------------
    static class InsufficientFundsException extends Exception {
        public InsufficientFundsException(String message) {
            super(message);
        }
    }

    // ------------------------------------------------------------
    // Method using Custom Exception
    // ------------------------------------------------------------
    public static void checkBalance(int balance) throws InsufficientFundsException {
        int requiredAmount = 500;
        if (balance < requiredAmount) {
            throw new InsufficientFundsException("Balance is less than required amount of " + requiredAmount);
        }
        System.out.println("Sufficient balance available.");
    }
}

