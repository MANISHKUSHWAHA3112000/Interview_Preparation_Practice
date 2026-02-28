package com.coreJava.interview.question.answer;

import java.util.HashMap;
import java.util.Hashtable;

/**
ava is a pure object-oriented programming language (with minor exceptions like primitives). OOP is one of the most frequently tested topics in interviews. It models real-world entities using classes and objects and promotes code reusability, modularity and scalability.

1. What is an object-oriented paradigm and What are the main concepts of OOP in Java?
A paradigm means a method or style of programming. In programming, there are four main paradigms: Imperative, Logical, Functional and Object-Oriented. The object-oriented paradigm is based on using objects as the main entities. These objects can use features like encapsulation, inheritance, and polymorphism to build structured programs.

The main concepts of OOPs in Java are mentioned below:

Inheritance
Polymorphism
Abstraction
Encapsulation 
2. What is the difference between an object-oriented programming language and an object-based programming language?
Object-Oriented Programming Language

Object-Based Programming Language

Object-oriented programming language covers larger concepts like inheritance, polymorphism, abstraction, etc.   The scope of object-based programming is limited to the usage of objects and encapsulation.
It supports all the built-in objects    It doesn’t support all the built-in objects
Examples: Java, C#, etc.    Examples: Java script, visual basics, etc.
3. What are Classes in Java? 
In Java, Classes are the collection of objects sharing similar characteristics and attributes. Classes represent the blueprint or template from which objects are created.  Classes are not real-world entities but help us to create objects which are real-world entities. A class is declared using the class keyword. and It contains:

Fields / Variables (data of an object)
Methods (operations/functions)
Constructors
Nested classes
Blocks (static & instance)
Example: Below program creates a Car object, sets its brand and speed, and then displays those details to the user.

class Car {
    // fields
    String brand;
    int speed;

    // method
    void showDetails()
    {
        System.out.println(brand + " runs at " + speed
                           + " km/h");
    }
}

class GFG{
    public static void main(String[] args)
    {
        // creating object
        Car c1 = new Car();
        c1.brand = "BMW";
        c1.speed = 200;

        c1.showDetails();
    }
}

Output
BMW runs at 200 km/h
4. What is an object?
The object is a real-life entity that has certain properties and methods associated with it. The object is also defined as the instance of a class. An object can be declared using a new keyword.

Example:

class Dog{
    String name;
    void bark() {
        System.out.println(name + " is barking!");
    }
}

public class GFG {
    public static void main(String[] args) {
        Dog d1 = new Dog();   // object created
        d1.name = "Tommy";    // setting value
        d1.bark();            // calling method
    }
}

Output
Tommy is barking!
Explanation: d1 is an object of the Dog class that stores data and performs actions.

5. What are the different ways to create objects in Java?
Methods to create objects in Java are mentioned below:

Using new keyword
Using new instance
Using clone() method
Using deserialization
Using the newInstance() method of the Constructor class

6. How is the ‘new’ operator different from the ‘newInstance()’ operator in Java?
1. new Operator
The new operator is used to create objects at compile-time.
Type is known beforehand.
Example:
Car c = new Car();  // using new

2. newInstance() method:
newInstance() operator creates an object at runtime using reflection.
Type is decided dynamically.
Throws exceptions (e.g., InstantiationException).
Example:
Car c = Car.class.newInstance();  // using newInstance()

7. What is the difference between static (class) method and instance method?
Static(Class) method
Instance method

Static method is associated with a class rather than an object.
The instance method is associated with an object rather than a class.
Static methods can be called using the class name only without creating an instance of a class.
The instance methods can be called on a specific instance of a class using the object reference.
Static methods do not have access to this keyword.
Instance methods have access to this keyword.
Static methods can access only static members of the class.
Instance methods can access both static and non-static methods of the class.
Static methods can’t be overridden (resolved at compile-time by reference type).
While instance methods can be overridden (resolved at run-time by object type).

8. What is this keyword in Java?
‘this’ is a keyword used to reference a variable that refers to the current object.

9. What are the advantages and disadvantages of object cloning?
Advantages:
Unlike = which copies only references, clone() creates a new object copy.
Reduces code size since manual field copying is avoided.
Useful for replicating complex objects (similar to Prototype pattern).

Disadvantages:
clone() is protected, so classes must override it and implement Cloneable.
By default, it performs a shallow copy deep copy needs custom implementation.
Can be tricky to maintain if objects have nested references.

10. What is the difference between shallow cloning and deep cloning in Java?
Shallow cloning: Shallow cloning copies only the object’s top-level structure, meaning nested objects are shared between the original and the clone.
Deep cloning: Deep cloning creates a completely independent copy, including all nested objects.

11. What are Access Specifiers and Types of Access Specifiers?
Access Specifiers in Java help to restrict the scope of a class, constructor, variable, method, or data member. There are four types of Access Specifiers in Java mentioned below:
Public
Private
Protected
Default

12. What will be the initial value of an object reference which is defined as an instance variable?
The initial value of an object reference which is defined as an instance variable is a NULL value.

13. What is the constructor?
Constructor is a special method that is used to initialize objects. Constructor is called when a object is created. The name of constructor is same as of the class.
Purpose: To initialize the object’s state (i.e., assign values to instance variables) when an object is created.
Name: Must be the same as the class name.
No return type: Constructors do not have a return type.
Automatically called: It is called automatically when the new keyword is used.
Can be overloaded: We can define multiple constructors with different parameter

Example:
class XYZ{
      private int val;
      // Constructor
      XYZ(){
            val=0;
      }
};

14. How many types of constructors are used in Java.
There are four types of constructors in Java
Default Constructor
Parameterized Constructor
Copy Constructor
Private Constructor

15. What happens if we don't provide constructor in class?
If you don't provide a constructor in a class in Java, the compiler automatically generates a default constructor with no arguments and no operation which is a default constructor.

16. What is the purpose of a default constructor?
Constructors help to create instances of a class or can be said to create objects of a class. Constructor is called during the initialization of objects. A default constructor is a type of constructor which do not accept any parameter, So whatever value is assigned to properties of the objects are considered default values.

17. Where and how can you use a private constructor?
A private constructor is used if you don't want any other class to instantiate the object to avoid subclassing. Example: Singleton pattern.

18. What are the differences between the constructors and methods?
Constructor vs Method:
Purpose: Creates/initializes an object vs Performs an action
Name: Same as class name vs Any valid name
Return type: No return type vs Has a return type
Called when: Automatically vs Manually
Default provided by compiler: Yes vs No

19. What do you mean by data encapsulation?
Encapsulation is one of the core principles of OOP. It wraps data and methods into a single unit (class), restricting direct access.

20. What are the advantages of Encapsulation in Java?
Data Hiding
Flexibility
Reusability
Easy Testing

21. How do you implement Encapsulation?
Private variables + public getters/setters.

22. What is the use of Getters and Setters?
Getters: read private variables.
Setters: update private variables safely.

23. What is inheritance in Java?
Inheritance allows a class to acquire properties of another class.

24. What are the different types of inheritance in Java?
Single, Multilevel, Hierarchical, Multiple (only via interfaces).

25. What is multiple inheritance? Is it supported by Java?
Multiple inheritance allows a class to inherit from many parents. Java does not support it for classes, only interfaces.

26. Is there any limitation to using Inheritance?
Yes, subclasses can become clustered and error-prone.

27. What is the ‘IS-A‘ relationship in OOPs Java?
IS-A represents inheritance.

28. What is HAS-A relationship in OOP (Aggregation/Composition)?
HAS-A represents aggregation or composition.

29. What do you mean by aggregation?
Aggregation is a HAS-A relationship, weaker than composition.

30. What is an association?
Association is a relation between two classes via objects.

31. What is the composition of Java and State the difference between Composition and Aggregation?
Composition: Strong HAS-A, dependent objects.
Aggregation: Weak HAS-A, independent objects.

32. What is Polymorphism?
Polymorphism allows one interface/method to take many forms.

33. How many types of Polymorphism.
Compile-time (Overloading) and Runtime (Overriding).

34. What is method overriding and method overloading?
Overloading: Same name, different parameters.

34. What is method overriding and method overloading?
Method Overloading: In Java, Method Overloading allows different methods to have the same name, but different signatures where the signature can differ by the number of input parameters or type of input parameters, or a mixture of both.

Method overriding: When a subclass provides its own implementation of a method that is already defined in its parent class, it is called method overriding.

Method overloading in Java is also known as Compile-time Polymorphism, Static Polymorphism, or Early binding. In Method overloading compared to the parent argument, the child argument will get the highest priority.

35. Can we override the static method?
No, as static methods are part of the class rather than the object so we can't override them.

36. Can we change the scope of the overridden method in the subclass?
Yes, we can change the scope of an overridden method in the subclass, but only to make it wider or the same as the superclass method’s scope.

If the overridden method in the superclass is public, the subclass method must be public (it cannot be protected, default, or private).
If the overridden method in the superclass is protected, the subclass method can be protected or public, but not private or default.
If the overridden method in the superclass has default (package-private) access, the subclass method can be default, protected, or public, but not private.
A private method cannot be overridden because it is not visible to the subclass.

37. What is Abstraction?
Abstraction in Java is the process of hiding internal implementation details and showing only essential functionality to the user. It focuses on what an object does rather than how it does it.

Abstraction hides the complex details and shows only essential features.
Abstract classes may have methods without implementation and must be implemented by subclasses.
By abstracting functionality, changes in the implementation do not affect the code that depends on the abstraction.

38. How many ways to achieve abstraction in Java.
Java provides two ways to implement abstraction:
- Abstract Classes (Partial Abstraction)
- Interface (100% Abstraction)

39. What is Abstract class?
A class declared as abstract, cannot be instantiated i.e., the object cannot be created. It may or may not contain abstract methods but if a class has at least one abstract method, it must be declared abstract.

Example of an abstract class with abstract method:

abstract class Fruits {
    abstract void run();
}
class Apple extends Fruits {
    void run() {
        System.out.println("Abstract class example");
    }
    public static void main(String args[]) {
        Fruits obj = new Apple();
        obj.run();
    }
}

Output
Abstract class example

40. What is an Interface?
An interface in Java is a collection of static final variables and abstract methods that define the contract or agreement for a set of linked classes. Any class that implements an interface is required to implement a specific set of methods.

Example:

interface Shape {
    double getArea();
    double getPerimeter();
}
class Circle implements Shape {
    private double radius;
    public Circle(double radius) { this.radius = radius; }
    public double getArea() { return Math.PI * radius * radius; }
    public double getPerimeter() { return 2 * Math.PI * radius; }
}
class GFG {
    public static void main(String[] args) {
        Circle circle = new Circle(5.0);
        System.out.println("Area of circle is " + circle.getArea());
        System.out.println("Perimeter of circle is " + circle.getPerimeter());
    }
}

Output
Area of circle is 78.53981633974483
Perimeter of circle is 31.41592653589793

41. Give some features of the Interface.
Features:
- Helps achieve total abstraction.
- Allows multiple inheritance in Java.
- Any class can implement multiple interfaces.
- Used to achieve loose coupling.

42. What is a marker interface?
An Interface with no fields or methods is called a marker interface. Examples: Serializable, Cloneable, Remote.

43. What are the differences between abstract class and interface?
Abstract Class vs Interface:

Abstract Class:
- Can have abstract and non-abstract methods.
- Supports final methods.
- Does not support multiple inheritance.
- Declared using `abstract` keyword.
- Extended using `extends`.
- Members can be private, protected, etc.

Interface:
- Can have abstract, default, static (Java 8+) and private methods (Java 9+).
- Does not support final methods.
- Supports multiple inheritance.
- Declared using `interface` keyword.
- Implemented using `implements`.
- All members are public by default.


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
