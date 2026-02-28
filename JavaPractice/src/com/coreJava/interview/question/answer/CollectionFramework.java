package com.coreJava.interview.question.answer;

public class CollectionFramework {
	
	/**
	Java Collections Framework (JCF) is a standard library that provides data structures and algorithms to store, retrieve and manipulate data efficiently. It is one of the most important topics in Java interviews.

	This covers the most important Collection Frameworks & Generics interview questions in Java, explained in a clear, concise manner with examples.

	------------------------------------------------------------
	1. What is the Collection Framework in Java?
	------------------------------------------------------------
	A Collection is a group of objects in Java. The collection framework is a set of interfaces and classes in Java that are used to represent and manipulate collections of objects in a variety of ways. The collection framework contains classes (ArrayList, Vector, LinkedList, PriorityQueue, TreeSet) and multiple interfaces (Set, List, Queue, Deque).

	Example:
	// Demonstrating a simple Collection
	import java.util.*;
	class Demo1 {
	    public static void main(String[] args) {
	        Collection<String> fruits = new ArrayList<>();
	        fruits.add("Apple");
	        fruits.add("Banana");
	        System.out.println(fruits);
	    }
	}

	------------------------------------------------------------
	2. Difference between Collection and Collections
	------------------------------------------------------------
	Collection:
	- Interface in java.util
	- Represents group of objects
	- Parent of List, Set, Queue

	Collections:
	- Utility class in java.util
	- Provides static methods like sort(), reverse()

	Example:
	// Using Collections utility class
	import java.util.*;
	class Demo2 {
	    public static void main(String[] args) {
	        List<String> names = new ArrayList<>();
	        names.add("Charlie");
	        names.add("Alice");
	        Collections.sort(names); // Sort using Collections
	        System.out.println(names);
	    }
	}

	------------------------------------------------------------
	4. List Interface
	------------------------------------------------------------
	- Maintains insertion order
	- Allows duplicates
	- Supports nulls
	- Bidirectional traversal

	Example:
	// List demonstration
	import java.util.*;
	class Demo3 {
	    public static void main(String[] args) {
	        List<String> list = new LinkedList<>();
	        list.add("A");
	        list.add("A"); // duplicate allowed
	        System.out.println(list);
	    }
	}

	------------------------------------------------------------
	5. Implementations of List
	------------------------------------------------------------
	- ArrayList
	- LinkedList
	- Vector
	- Stack

	Example:
	// Stack demonstration
	import java.util.*;
	class Demo4 {
	    public static void main(String[] args) {
	        Stack<Integer> stack = new Stack<>();
	        stack.push(10);
	        stack.push(20);
	        System.out.println("Top element: " + stack.peek());
	        System.out.println("Removed: " + stack.pop());
	    }
	}

	------------------------------------------------------------
	6. Synchronizing ArrayList
	------------------------------------------------------------
	Example:
	// Using synchronizedList
	import java.util.*;
	class Demo5 {
	    public static void main(String[] args) {
	        List<String> list = Collections.synchronizedList(new ArrayList<>());
	        list.add("ThreadSafe");
	        synchronized (list) {
	            for (String s : list) {
	                System.out.println(s);
	            }
	        }
	    }
	}

	------------------------------------------------------------
	10. Conversion between Array and ArrayList
	------------------------------------------------------------
	Example:
	// Array → ArrayList
	import java.util.*;
	class Demo6 {
	    public static void main(String[] args) {
	        String[] arr = {"A", "B", "C"};
	        List<String> list = Arrays.asList(arr);
	        System.out.println(list);
	    }
	}

	// ArrayList → Array
	import java.util.*;
	class Demo7 {
	    public static void main(String[] args) {
	        List<Integer> list = new ArrayList<>();
	        list.add(1); list.add(2);
	        Object[] arr = list.toArray();
	        System.out.println(Arrays.toString(arr));
	    }
	}

	------------------------------------------------------------
	12. Vector Example
	------------------------------------------------------------
	import java.util.*;
	class Demo8 {
	    public static void main(String[] args) {
	        Vector<String> vec = new Vector<>();
	        vec.add("Apple");
	        vec.add("Banana");
	        vec.add("Apple"); // duplicates allowed
	        System.out.println(vec);
	    }
	}

	------------------------------------------------------------
	13. Read-only ArrayList
	------------------------------------------------------------
	import java.util.*;
	class Demo9 {
	    public static void main(String[] args) {
	        List<String> list = new ArrayList<>();
	        list.add("X"); list.add("Y");
	        List<String> readOnly = Collections.unmodifiableList(list);
	        System.out.println(readOnly);
	    }
	}

	------------------------------------------------------------
	14. LinkedList Example
	------------------------------------------------------------
	import java.util.*;
	class Demo10 {
	    public static void main(String[] args) {
	        LinkedList<String> ll = new LinkedList<>();
	        ll.addFirst("Mango");
	        ll.addLast("Orange");
	        System.out.println(ll);
	    }
	}

	------------------------------------------------------------
	16. Set Interface Example
	------------------------------------------------------------
	import java.util.*;
	class Demo11 {
	    public static void main(String[] args) {
	        Set<String> set = new HashSet<>();
	        set.add("Apple");
	        set.add("Banana");
	        set.add("Apple"); // duplicate ignored
	        System.out.println(set);
	    }
	}

	------------------------------------------------------------
	20. Queue Interface Example
	------------------------------------------------------------
	import java.util.*;
	class Demo12 {
	    public static void main(String[] args) {
	        Queue<Integer> pq = new PriorityQueue<>();
	        pq.add(50); pq.add(20); pq.add(40);
	        System.out.println(pq);
	    }
	}

	------------------------------------------------------------
	24. Map Interface Example
	------------------------------------------------------------
	import java.util.*;
	class Demo13 {
	    public static void main(String[] args) {
	        Map<Integer, String> map = new HashMap<>();
	        map.put(1, "Apple");
	        map.put(2, "Banana");
	        System.out.println(map);
	    }
	}

	------------------------------------------------------------
	25. TreeMap Example
	------------------------------------------------------------
	import java.util.*;
	class Demo14 {
	    public static void main(String[] args) {
	        TreeMap<Integer, String> map = new TreeMap<>();
	        map.put(3, "Apple");
	        map.put(1, "Banana");
	        map.put(2, "Mango");
	        System.out.println(map);
	    }
	}

	------------------------------------------------------------
	28. ConcurrentHashMap Example
	------------------------------------------------------------
	import java.util.concurrent.*;
	class Demo15 {
	    public static void main(String[] args) {
	        ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();
	        map.put(1, "Amit");
	        map.put(2, "Rahul");
	        map.forEach((k,v) -> System.out.println(k + " => " + v));
	    }
	}

	------------------------------------------------------------
	41. FailFast vs FailSafe Iterator
	------------------------------------------------------------
	FailFast Example:
	import java.util.*;
	class Demo16 {
	    public static void main(String[] args) {
	        HashMap<Integer, String> map = new HashMap<>();
	        map.put(1, "one");
	        map.put(2, "two");
	        try {
	            for (Map.Entry<Integer, String> entry : map.entrySet()) {
	                if (entry.getKey() == 1) {
	                    map.remove(1); // causes ConcurrentModificationException
	                }
	            }
	        } catch (ConcurrentModificationException e) {
	            System.out.println("FailFast Exception: " + e);
	        }
	    }
	}

	FailSafe Example:
	import java.util.concurrent.*;
	class Demo17 {
	    public static void main(String[] args) {
	        ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();
	        map.put(1, "one");
	        map.put(2, "two");
	        for (Map.Entry<Integer, String> entry : map.entrySet()) {
	            if (entry.getKey() == 1) {
	                map.remove(1); // no exception
	            }
	        }
	        System.out.println(map);
	    }
	}

*/
	
	public static void main(String[] args) {
		
	}
}
