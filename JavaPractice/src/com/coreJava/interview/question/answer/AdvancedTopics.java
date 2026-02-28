package com.coreJava.interview.question.answer;

public class AdvancedTopics {

	/***
	 * 1. What is Exception Handling & How many types of exceptions can occur in a Java program?
An Exception is an Event that interrupts the normal flow of the program and requires special processing. During the execution of a program, errors and unplanned occurrences can be dealt with by using the Java Exception Handling mechanism. Below are some reasons why Exceptions occur in Java:

Device failure
Loss of Network Connection
Code Errors
Opening an Unavailable file
Invalid User Input
Physical Limitations (out of disk memory)

There are generally two types of exceptions in Java:

Built-in Exceptions: Built-in exceptions in Java are provided by the Java Libraries. These exceptions can be further divided into two subcategories i.e., checked and unchecked Exceptions. Below are some of the built-in exceptions in Java:
ArrayIndexOutOfBoundsExceptions
ClassNotFoundException
FileNotFoundException
IOException
NullPointerException
ArithmeticException
InterruptedException
RuntimeException

User-Defined Exceptions: User-defined exceptions are defined by the programmers themselves to handle some specific situations or errors which are not covered by built-in exceptions. To define user-defined exceptions a new class that extends the appropriate exception class must be defined. User-defined Exceptions in Java when built-in exceptions don’t cover specific cases.

2. Difference between an Error and an Exception.
Errors
- Recovering from Errors is not possible.
- Errors are all unchecked types in Java.
- Errors are mostly caused by the environment in which the program is running.
- Errors occur at runtime (e.g., OutOfMemoryError, StackOverflowError). Compile-time syntax mistakes are not Errors
- They are defined in java.lang.Error package.
- Examples: java.lang.StackOverflowError, java.lang.OutOfMemoryError

Exceptions
- Recover from exceptions by either using a try-catch block or throwing exceptions back to the caller.
- It includes both checked as well as unchecked types that occur.
- The program is mostly responsible for causing exceptions.
- All exceptions occur at runtime but checked exceptions are known to the compiler while unchecked are not.
- They are defined in java.lang.Exception package
- Examples: Checked Exceptions: SQLException, IOException Unchecked Exceptions: ArrayIndexOutOfBoundException, NullPointerException, ArithmeticException.

3. Explain the hierarchy of Java Exception classes.
All exception and error types in Java are subclasses of the class Throwable, which is the base class of the hierarchy. This class is then used for exceptional conditions that user programs should catch. NullPointerException is an example of such an exception. Another branch, Error, is used by the Java run-time system to indicate errors having to do with the JRE. StackOverflowError is an example of one of such error.

4. Explain Runtime Exceptions.
Runtime Exceptions are exceptions that occur during the execution of a code, as opposed to compile-time exceptions that occur during compilation. Runtime exceptions are unchecked exceptions, as they aren't accounted for by the JVM.

Examples of runtime exceptions in Java include:
- NullPointerException
- ArrayIndexOutOfBoundsException
- ArithmeticException
- IllegalArgumentException

Unlike checked exceptions, runtime exceptions do not require a declaration in the throws clause or capture in a try-catch block. However, handling runtime exceptions is advisable in order to provide meaningful error messages and prevent a system crash.

5. What is NullPointerException?
It is a runtime exception thrown when a program tries to use an object reference that is null. It usually indicates that no value has been assigned to a reference variable.

6. When is the ArrayStoreException thrown?
ArrayStoreException is thrown when an attempt is made to store the wrong type of object in an array of objects.

Example:
public class GFG {
    public static void main(String args[]) {
        Number[] a = new Double[2];
        a[0] = new Integer(4);
    }
}

Exception in thread "main" java.lang.ArrayStoreException: java.lang.Integer

7. Difference between Checked Exception and Unchecked Exception.
Checked Exception:
- Checked at compile time.
- Must handle using try-catch or declare with throws.
- Represent conditions outside program’s control (like I/O failures).
- Examples: IOException, SQLException, InterruptedException.

Unchecked Exception:
- Not checked at compile time, occur during runtime.
- Usually caused by programming errors.
- Examples: NullPointerException, ArrayIndexOutOfBoundsException, ArithmeticException.

8. Base class for Error and Exception.
Both Error and Exception inherit from java.lang.Throwable.

Error: JVM problems (OutOfMemoryError, StackOverflowError).
Exception: Conditions program might catch (IOException, NullPointerException).

9. Is try block always followed by catch?
No. A try block can be followed by a finally block instead.

10. What is exception propagation?
Exception propagation is when an exception moves up the call stack until caught or program ends.

11. System.exit(0) in try/catch?
If JVM exits, finally block will not execute. If SecurityException is thrown, finally executes.

12. Object Cloning.
Cloneable interface + overriding clone() method. Otherwise CloneNotSupportedException occurs.

13. Effect of unhandled exceptions.
Program terminates abruptly, code after exception not executed.

14. Purpose of final, finally, finalize.
- final: Prevents modification.
- finally: Always executes after try/catch.
- finalize: Called before object is garbage collected.

15. Difference between this() and super().
- this(): Refers to current class, calls constructor of same class.
- super(): Refers to parent class, calls constructor of base class.

16. Multitasking.
Executing multiple tasks simultaneously using threads.

17. Multithreaded program.
Program with multiple threads running concurrently.

18. Advantages of multithreading.
Responsiveness, resource sharing, economy, scalability, better communication, efficient use of multiprocessors.

19. Ways to create thread.
- Extending Thread class.
- Implementing Runnable interface.

20. What is a thread?
Lightweight subprocess with independent execution path, sharing memory.

21. Process vs Thread.
Process: Heavy, isolated, slower.
Thread: Lightweight, shares memory, faster.

22. Thread life cycle.
States: New, Runnable, Blocked, Waiting, Terminated.

23. suspend() method.
Pauses thread until resume() called. Deprecated due to deadlocks.

24. Main thread.
Parent thread executing main() method.

25. Daemon thread.
Low-priority background thread (e.g., garbage collection).

26. Ways thread enters waiting state.
sleep(), wait(), join(), I/O wait, synchronization issues.

27. Multithreading on single CPU.
Time-slicing by OS scheduler.

28. Thread priorities.
MIN_PRIORITY, MAX_PRIORITY, NORM_PRIORITY (default).

29. Garbage Collection necessity.
Avoids memory leaks, JVM manages memory automatically.

30. Drawbacks of Garbage Collection.
Pauses, non-deterministic, unpredictable behavior, increased memory usage.

31. Types of Garbage Collection.
- Minor GC (young generation).
- Major GC (old generation).
- Full GC (all generations).

32. Identifying GC types.
Minor prints "GC", Major prints "Full GC" with logging enabled.

33. Memory leak.
Objects not collected due to references. Causes wasted memory, performance issues.

34. Classes in java.util.regex.
Pattern, Matcher, PatternSyntaxException. Interface: MatchResult.

35. Regex for password validation.
^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])[A-Za-z][A-Za-z0-9@#$%^&+=]{7,19}$

36. JDBC.
API to connect Java applications with databases.

37. JDBC Driver.
Software component enabling Java DB interaction. Types: Bridge, Native-API, Network Protocol, Thin.

38. Steps to connect DB in Java.
Import packages → Load drivers → Register drivers → Establish connection → Create statement → Execute query → Close connection.

39. JDBC API components.
java.sql.* package.

40. JDBC Connection interface.
Allows Java applications to interact with databases.

41. JDBC ResultSet interface.
Stores and iterates over query results.

42. JDBC RowSet.
Stores data in tabular form. Types: JdbcRowSet, CachedRowSet, WebRowSet, FilteredRowSet, JoinRowSet.

43. JDBC DriverManager class.
Interface between users and drivers. Manages driver registration, connections.

	 */
	
	public static void main(String[] args) {
		
	}
}
