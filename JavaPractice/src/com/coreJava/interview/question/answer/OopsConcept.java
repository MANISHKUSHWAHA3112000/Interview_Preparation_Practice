package com.coreJava.interview.question.answer;

import java.util.HashMap;
import java.util.Hashtable;

/**


Section 1: Core OOP Concepts
----------------------------
Q1. What is Object-Oriented Programming (OOP)?
A: OOP is a paradigm where software is designed around objects and is based on using the object as entites that encapsulate state and behavior.

Code Example:
// Class = blueprint
class Car {
    String color; // property
    void drive() { // behavior
    
        System.out.println("Car is driving");
    }
}

// Object = instance
Car myCar = new Car();
myCar.color = "Red";
myCar.drive();

Cross-question: How does OOP improve maintainability compared to procedural programming?
Answer: OOP improves maintainability by modularizing code into classes, promoting reusability, and reducing duplication.

Q2. What are the four pillars of OOP?
A: Encapsulation, Inheritance, Polymorphism, Abstraction.

Cross-question: Which pillar is most critical in large-scale system design?
Answer: Abstraction, because it hides complexity and exposes only essential features.

Q3. Is Java 100% object-oriented?
A: No, because it uses primitive data types (int, char, etc.).

Cross-question: How can you make Java closer to pure OOP?
Answer: By using wrapper classes like Integer, Double, Boolean instead of primitives.

---

Section 2: Encapsulation
------------------------
Q4. Define encapsulation.
A: Encapsulation is the practice of restricting direct access to fields and exposing controlled access via methods.

Code Example:
class BankAccount {
    private double balance; // hidden field

    public double getBalance() { return balance; }
    public void deposit(double amount) {
        if (amount > 0) balance += amount;
    }
}

Cross-question: Why should fields be private instead of public?
Answer: To prevent unauthorized modification, maintain integrity, and enforce validation logic.

---

Section 3: Inheritance
----------------------
Q5. What is inheritance?
A: Mechanism where one class acquires properties and behaviors of another.

Code Example:
class Vehicle {
    void start() { System.out.println("Vehicle starting"); }
}
class Car extends Vehicle {
    void honk() { System.out.println("Car honking"); }
}

Cross-question: Can constructors be inherited?
Answer: No, but subclass can call parent constructor using super().

Q6. Types of inheritance supported in Java?
A: Single, Multilevel, Hierarchical. (Multiple inheritance via interfaces only.)

Cross-question: Why doesn’t Java support multiple inheritance with classes?
Answer: To avoid ambiguity (diamond problem). Interfaces solve this by providing contracts only.

---

Section 4: Polymorphism
-----------------------
Q7. What is polymorphism?
A: Ability of an object to take many forms.

Code Example:
// Compile-time polymorphism (overloading)
class MathUtil {
    int add(int a, int b) { return a+b; }
    double add(double a, double b) { return a+b; }
}

// Runtime polymorphism (overriding)
class Animal {
    void sound() { System.out.println("Animal sound"); }
}
class Dog extends Animal {
    @Override
    void sound() { System.out.println("Dog barks"); }
}

Cross-question: Can static methods be overridden?
Answer: No, they are hidden, not overridden.

Q8. Difference between overloading and overriding?
A: Overloading = same method name, different parameters. Overriding = same method signature, different implementation in subclass.

Cross-question: Can private methods be overridden?
Answer: No, because they are not visible outside the class.

---

Section 5: Abstraction
----------------------
Q9. What is abstraction?
A: Hiding implementation details and exposing only essential features.

Code Example:
abstract class Shape {
    abstract void draw();
}
class Circle extends Shape {
    void draw() { System.out.println("Drawing Circle"); }
}

Cross-question: Can abstract classes have constructors?
Answer: Yes, but they cannot be instantiated directly. Subclasses call them.

Q10. Difference between abstract class and interface?
A: Abstract class can have state + behavior; interface defines contracts only. Interfaces support multiple inheritance.

Cross-question: Can interfaces have variables?
Answer: Yes, but they are implicitly public, static, and final.

---

Section 6: Object Class
-----------------------
Q11. What is the significance of Object class?
A: Root of all classes in Java. Provides methods like toString(), equals(), hashCode(), clone().

Code Example:
class Student {
    int id;
    String name;
    @Override
    public String toString() { return id + " - " + name; }
}

Cross-question: Why override equals() and hashCode() together?
Answer: To ensure consistent behavior in collections like HashMap and HashSet.

---

Section 7: Constructors
-----------------------
Q12. What is constructor chaining?
A: Calling one constructor from another using this() or super().

Code Example:
class Employee {
    String name;
    Employee() { this("Unknown"); } // calls parameterized constructor
    Employee(String name) { this.name = name; }
}

Cross-question: Can constructors be overridden?
Answer: No, because they are not inherited.

---

Section 8: Access Modifiers
---------------------------
Q13. What are access modifiers?
A: Keywords that define scope: public, private, protected, default.

Cross-question: Can we reduce visibility of overridden methods?
Answer: No, only increase or keep same.

---

Section 9: Static & Final
-------------------------
Q14. Difference between final, finally, finalize?
A:
- final: keyword to declare constants, prevent inheritance/overriding.
- finally: block for cleanup code in try-catch.
- finalize: method called by GC before object destruction.

Cross-question: Why is finalize() discouraged?
Answer: Because its execution is unpredictable and may not run before program termination.

---

Section 10: Advanced OOP Topics
-------------------------------
Q15. What is immutability?
A: Immutable objects cannot change state after creation.

Code Example:
final class ImmutableStudent {
    private final String name;
    ImmutableStudent(String name) { this.name = name; }
    public String getName() { return name; }
}

Cross-question: Why is immutability useful in multithreading?
Answer: Because immutable objects are inherently thread-safe.

Q16. Difference between aggregation and composition?
A:
- Aggregation: weak association (can exist independently).
- Composition: strong association (lifecycle tied).

Cross-question: Which is stronger, aggregation or composition?
Answer: Composition, because child objects cannot exist without parent.

Q17. What is shallow copy vs deep copy?
A: Shallow copy copies references; deep copy creates independent copies.

Cross-question: How do you implement deep copy in Java?
Answer: By overriding clone() and manually copying mutable fields.

---

Section 11: Design Patterns
---------------------------
Q18. What is Singleton?
A: A class that allows only one instance globally.

Code Example:
class Singleton {
    private static Singleton instance;
    private Singleton() {}
    public static Singleton getInstance() {
        if (instance == null) instance = new Singleton();
        return instance;
    }
}

Cross-question: How to make Singleton thread-safe?
Answer: Use synchronized or double-checked locking.

Q19. What is Factory pattern?
A: Provides object creation logic without exposing instantiation.

Cross-question: Difference between Factory and Builder?
Answer: Factory creates objects; Builder constructs complex objects step by step.

---

Section 12: Scenario-Based
--------------------------
Q20. Design a class hierarchy for Vehicle, Car, Bike.
A:
- Vehicle (base class)
- Car, Bike (subclasses)

Cross-question: How would you add ElectricCar without breaking hierarchy?
Answer: Extend Car class and add electric-specific behavior.

Q21. How would you override equals() and hashCode() in Student class?
A: Compare meaningful fields and generate consistent hash.

Code Example:
@Override
public boolean equals(Object obj) {
    if (this == obj) return true;
    if (!(obj instanceof Student)) return false;
    Student s = (Student) obj;
    return this.id == s.id;
}
@Override
public int hashCode() {
    return Objects.hash(id);
}

Cross-question: Why is hashCode important in HashMap?
Answer: Because it determines bucket placement for efficient lookup.

---

Section 13: Trick & Edge Cases
------------------------------
Q22. Can we overload main()?
A: Yes, but JVM calls only the standard signature.

Cross-question: Why would you overload main()?
Answer: For testing purposes or custom entry points.

Q23. Can constructors be private?
A: Yes, used in Singleton pattern.

Cross-question: How do you instantiate a class with private constructor?
Answer: Using static factory methods inside the class.

Q24. Can we create objects without new keyword?
A: Yes, via reflection, cloning, or deserialization.

Cross-question: Which method is most commonly used in frameworks?
Answer: Reflection, especially in dependency injection frameworks.

Q25. Can abstract classes have main()?
A: Yes, but cannot be instantiated directly.

Q26. Can interfaces extend multiple interfaces?
A: Yes, supports multiple inheritance.

Q27. Can a class implement multiple interfaces?
A: Yes, allows multiple contracts.

Cross-question: How does this solve multiple inheritance problem?
Answer: By separating contracts from implementation, avoiding ambiguity.

*/
public class OopsConcept {

	// ================================
	// 1. ENCAPSULATION
	// ================================
	/**
	 * Q: What is Encapsulation? Definition (to the point): Encapsulation in Java
	 * means hiding the internal state of an object by making fields private and
	 * exposing controlled access through methods. It ensures data security,
	 * controlled modification, and maintainability.
	 * 
	 * Analogy (simple): Like an ATM machine: you can withdraw or deposit money only
	 * through defined operations, but you cannot directly open the bank’s database
	 * and change your balance. Example: Class A and B below demonstrate
	 * encapsulation.
	 */
	public class Student {
		// Private fields (hidden data)
		private String name;
		private int age;

		// Constructor
		public Student(String name, int age) {
			setName(name); // reuse validation
			setAge(age);
		}

		// Getter and Setter with validation (controlled access)
		public String getName() {
			return name;
		}

		public void setName(String name) {
			if (name == null || name.isBlank()) {
				throw new IllegalArgumentException("Name cannot be empty");
			}
			this.name = name.trim();
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			if (age < 0 || age > 150) {
				throw new IllegalArgumentException("Age must be between 0 and 150");
			}
			this.age = age;
		}

		@Override
		public String toString() {
			return "Student{name='" + name + "', age=" + age + "}";
		}

	}

	static class B {
		private String name;
		private int age;

		public B(String name, int age) {
			this.name = name;
			setAge(age);
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			if (name != null && !name.isEmpty())
				this.name = name;
			else
				System.out.println("Invalid name!");
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			if (age > 0 && age < 120)
				this.age = age;
			else
				System.out.println("Invalid age! Must be between 1 and 120.");
		}

		@Override
		public String toString() {
			return "B [name=" + name + ", age=" + age + "]";
		}
	}

	// ================================
	// 2. INHERITANCE
	// ================================
	/**
	 * Q: What is Inheritance? A: Inheritance allows one class to acquire properties
	 * and methods of another class. Example: Child inherits from Parent.
	 */
	class Parent {
		public void showMessage() {
			System.out.println("Message from Parent class.");
		}
	}

	class Child extends Parent {
		@Override
		public void showMessage() {
			System.out.println("Message overridden in Child class.");
		}
	}

	// ================================
	// 3. POLYMORPHISM
	// ================================
	/**
	 * Q: What is Polymorphism? A: Polymorphism means "many forms". It allows
	 * methods to behave differently based on context. - Compile-time polymorphism →
	 * Method Overloading - Runtime polymorphism → Method Overriding
	 */
	class Calculator {
		public int add(int a, int b) {
			return a + b;
		}

		public double add(double a, double b) {
			return a + b;
		}
	}

	class Animal {
		public void sound() {
			System.out.println("Animal makes a sound");
		}
	}

	class Dog extends Animal {
		@Override
		public void sound() {
			System.out.println("Dog barks");
		}
	}

	class Cat extends Animal {
		@Override
		public void sound() {
			System.out.println("Cat meows");
		}
	}

	// ================================
	// 4. ABSTRACTION
	// ================================
	/**
	 * Q: What is Abstraction? A: Abstraction hides implementation details and shows
	 * only essential features. Example: Abstract class Vehicle with abstract method
	 * start().
	 */
	abstract class Vehicle {
		abstract void start();

		public void fuelType() {
			System.out.println("Most vehicles use petrol or diesel.");
		}
	}

	class Car extends Vehicle {
		@Override
		void start() {
			System.out.println("Car starts with a key.");
		}
	}

	class Bike extends Vehicle {
		@Override
		void start() {
			System.out.println("Bike starts with a self-start button.");
		}
	}

	// ================================
	// 5. ACCESS MODIFIERS
	// ================================
	/**
	 * Q: What are Access Modifiers? A: They define the scope of
	 * variables/methods/classes. - private → within class - default → within
	 * package - protected → package + subclasses - public → everywhere
	 */
	class AccessExample {
		private int privateVar = 1;
		int defaultVar = 2;
		protected int protectedVar = 3;
		public int publicVar = 4;
	}

	// ================================
	// 6. IMMUTABLE CLASS
	// ================================
	/**
	 * Q: How to create an Immutable class? A: Use final class, private final
	 * fields, and only getters (no setters).
	 */
	final class Employee {
		private final String name;
		private final int id;

		public Employee(String name, int id) {
			this.name = name;
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public int getId() {
			return id;
		}
	}

	// ================================
	// 7. COMPOSITION vs INHERITANCE
	// ================================
	/**
	 * Q: What is the difference between Composition and Inheritance? A: -
	 * Inheritance → "is-a" relationship. Subclass derives behavior from Parent. -
	 * Composition → "has-a" relationship. Class contains another class instance. -
	 * Inheritance: compile-time, can cause tight coupling. - Composition: runtime,
	 * promotes flexibility and loose coupling.
	 */
	class Vehicle1 {
		public void move() {
			System.out.println("Vehicle moves...");
		}
	}

	class CarWithInheritance extends Vehicle1 {
	}

	class Engine {
		public void start() {
			System.out.println("Engine starts...");
		}
	}

	class CarWithComposition {
		private Engine engine = new Engine();

		public void startCar() {
			engine.start();
			System.out.println("Car runs using Engine.");
		}
	}

	// ================================
	// 8. INTERFACE vs ABSTRACT CLASS
	// ================================
	/**
	 * Q: When would you use an Interface vs an Abstract Class? A: An Interface is
	 * used when you want to define a contract that multiple classes can implement,
	 * regardless of their position in the class hierarchy. It tells what a class
	 * CAN DO. For example, Flyable means any class that implements it must provide
	 * the fly() behavior. Interfaces support multiple inheritance, so a class can
	 * implement many interfaces.
	 *
	 * An Abstract Class is used when you want to provide a common base type with
	 * some shared code and also enforce rules. It tells what a class IS. Abstract
	 * classes can have both abstract methods (without body) and concrete methods
	 * (with body). They can also define fields and state. A class can extend only
	 * one abstract class, so it is single inheritance.
	 *
	 * In short: - Interface → capability (CAN DO). - Abstract Class → base type
	 * (IS).
	 */
	interface Flyable {
		void fly();
	}

	abstract class Animal1 {
		public void eat() {
			System.out.println("Animal eats.");
		}

		public abstract void makeSound();
	}

	class Bird extends Animal1 implements Flyable {
		@Override
		public void fly() {
			System.out.println("Bird flies in sky.");
		}

		@Override
		public void makeSound() {
			System.out.println("Bird chirps.");
		}
	}

	// ================================
	// 9. METHOD OVERRIDING vs OVERLOADING
	// ================================
	/**
	 * Q: What is the difference between Method Overloading and Method Overriding?
	 * A: - Overloading → same method name, different parameters (compile-time
	 * polymorphism). - Overriding → subclass redefines parent method with same
	 * signature (runtime polymorphism). - Overloading: compile-time binding, no
	 * inheritance required. - Overriding: runtime binding, requires inheritance.
	 */
	class OverloadOverrideExample {
		public void greet(String name) {
			System.out.println("Hello " + name);
		}

		public void greet(String name, int age) {
			System.out.println("Hello " + name + ", age: " + age);
		}
	}

	class OverrideParent {
		public void greet() {
			System.out.println("Hello from Parent");
		}
	}

	class OverrideChild extends OverrideParent {
		@Override
		public void greet() {
			System.out.println("Hello from Child");
		}
	}

	// ================================
	// 10. == vs equals()
	// ================================
	/**
	 * Q: Difference between == and equals()? A: == compares references, equals()
	 * compares values.
	 */
	class EqualsExample {
		public void testEquals() {
			String s1 = new String("Hello");
			String s2 = new String("Hello");
			System.out.println("== result: " + (s1 == s2));
			System.out.println("equals() result: " + s1.equals(s2));
		}
	}

	// ================================
	// 11. final, finally, finalize()
	// ================================
	/**
	 * Q: Difference between final, finally, finalize()? A: - final → keyword
	 * (constant, prevent inheritance/overriding). - finally → block in exception
	 * handling that always executes. - finalize() → method called by GC before
	 * object destruction.
	 */
	class FinalExample {
		final int x = 10;

		public void testFinally() {
			try {
				System.out.println("Try block");
			} finally {
				System.out.println("Finally block always executes");
			}
		}

		@Override
		protected void finalize() {
			System.out.println("Finalize called before GC");
		}
	}

	// ================================
	// 12. String vs StringBuilder vs StringBuffer
	// ================================
	/**
	 * Q: Difference between String, StringBuilder, StringBuffer? A: - String →
	 * Immutable - StringBuilder → Mutable, not thread-safe - StringBuffer →
	 * Mutable, thread-safe
	 */
	class StringExample {
		public void testStrings() {
			String str = "Hello";
			str.concat(" World"); // new object
			System.out.println("String: " + str);

			StringBuilder sb = new StringBuilder("Hello");
			sb.append(" World");
			System.out.println("StringBuilder: " + sb);

			// ================================
			// 13. HashMap vs Hashtable
			// ================================
			/**
			 * Q: Difference between HashMap and Hashtable? A: - HashMap → Not synchronized,
			 * allows one null key and multiple null values. - Hashtable → Synchronized,
			 * does not allow null keys/values.
			 */
		}
	}

	class MapExample {
		public void testMaps() {
			HashMap<Integer, String> map = new java.util.HashMap<>();
			map.put(1, "One");
			map.put(null, "NullKey"); // allowed
			System.out.println("HashMap: " + map);

			Hashtable<Integer, String> table = new java.util.Hashtable<>();
			table.put(1, "One");
			System.out.println("Hashtable: " + table);
		}
	}

	// ================================
	// 14. ArrayList vs LinkedList
	// ================================
	/**
	 * Q: Difference between ArrayList and LinkedList? A: - ArrayList → Backed by
	 * array, fast random access, slower insert/delete in middle. - LinkedList →
	 * Doubly linked list, fast insert/delete, slower random access.
	 */
	class ListExample {
		public void testLists() {
			java.util.ArrayList<String> arrayList = new java.util.ArrayList<>();
			arrayList.add("A");
			arrayList.add("B");
			System.out.println("ArrayList: " + arrayList);

			java.util.LinkedList<String> linkedList = new java.util.LinkedList<>();
			linkedList.add("X");
			linkedList.add("Y");
			System.out.println("LinkedList: " + linkedList);
		}
	}

	// ================================
	// 15. throw vs throws
	// ================================
	/**
	 * Q: Difference between throw and throws? A: - throw → Used to explicitly throw
	 * an exception. - throws → Declares exceptions a method may throw.
	 */
	class ExceptionExample {
		public void testThrow() {
			try {
				throw new Exception("Explicit exception using throw");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

		public void testThrows() throws Exception {
			throw new Exception("Method declares exception using throws");
		}
	}

	// ================================
	// 16. Checked vs Unchecked Exceptions
	// ================================
	/**
	 * Q: Difference between Checked and Unchecked exceptions? A: - Checked → Must
	 * be handled at compile-time (e.g., IOException). - Unchecked → Runtime
	 * exceptions (e.g., NullPointerException).
	 */
	class CheckedUncheckedExample {
		public void testExceptions() {
			try {
				java.io.FileReader fr = new java.io.FileReader("file.txt"); // Checked Exception
			} catch (java.io.IOException e) {
				System.out.println("Handled checked exception: " + e.getMessage());
			}

			try {
				String str = null;
				System.out.println(str.length()); // Unchecked Exception
			} catch (NullPointerException e) {
				System.out.println("Handled unchecked exception: " + e.getMessage());
			}
		}
	}

	// ================================
	// 17. Garbage Collection
	// ================================
	/**
	 * Q: Explain Garbage Collection in Java. A: - Automatic memory management. -
	 * Removes unused objects from heap. - Can request GC using System.gc(), but not
	 * guaranteed.
	 */
	class GarbageCollectionExample {
		@Override
		protected void finalize() {
			System.out.println("Finalize called before GC");
		}

		public void testGC() {
			GarbageCollectionExample obj = new GarbageCollectionExample();
			obj = null; // eligible for GC
			System.gc(); // request GC
		}
	}

	// ================================
	// MAIN METHOD
	// ================================
	public static void main(String[] args) {
		OopsConcept obj = new OopsConcept();

		Student s = obj.new Student("Rahul", 22);
		System.out.println(s); // Student{name='Rahul', age=22}

		B b = new B("Prince", 26); // static inner
		System.out.println(s);
		System.out.println(b);

		// Inheritance
		Parent p = obj.new Parent();
		Child c = obj.new Child();
		p.showMessage();
		c.showMessage();

		// Polymorphism
		Calculator calc = obj.new Calculator();
		System.out.println("Sum (int): " + calc.add(5, 10));
		System.out.println("Sum (double): " + calc.add(5.5, 10.5));
		Animal dog = obj.new Dog();
		Animal cat = obj.new Cat();
		dog.sound();
		cat.sound();

		// Abstraction
		Vehicle car = obj.new Car();
		Vehicle bike = obj.new Bike();
		car.start();
		bike.start();
		car.fuelType();

		// Access Modifiers
		AccessExample ae = obj.new AccessExample();
		System.out.println("Public var: " + ae.publicVar);

		// Immutable Class (top-level)
//                Employee emp = new Employee("John", 101);
//                System.out.println("Immutable Employee: " + emp.getName() + ", " + emp.getId());

		// Composition
		CarWithComposition compCar = obj.new CarWithComposition();
		compCar.startCar();

		// Interface
		Bird bird = obj.new Bird();
		bird.fly();

		// Overloading vs Overriding
		OverloadOverrideExample ovr = obj.new OverloadOverrideExample();
		ovr.greet("Alice");
		ovr.greet("Bob", 30);
		OverrideParent op = obj.new OverrideParent();
		OverrideChild oc = obj.new OverrideChild();
		op.greet();
		oc.greet();

		// == vs equals()
		EqualsExample eq = obj.new EqualsExample();
		eq.testEquals();

		// final, finally, finalize()
		FinalExample fe = obj.new FinalExample();
		fe.testFinally();

		// String vs StringBuilder vs StringBuffer
		StringExample se = obj.new StringExample();
		se.testStrings();

		// HashMap vs Hashtable
		MapExample me = obj.new MapExample();
		me.testMaps();

		// ArrayList vs LinkedList
		ListExample le = obj.new ListExample();
		le.testLists();

		// throw vs throws
		ExceptionExample ex = obj.new ExceptionExample();
		ex.testThrow();
		try {
			ex.testThrows();
		} catch (Exception e) {
			System.out.println("Caught exception from throws: " + e.getMessage());
		}

		// Checked vs Unchecked Exceptions
		CheckedUncheckedExample cue = obj.new CheckedUncheckedExample();
		cue.testExceptions();

		// Garbage Collection (top-level)
//                GarbageCollectionExample gce = new GarbageCollectionExample();
//                gce.testGC();
	}
}
