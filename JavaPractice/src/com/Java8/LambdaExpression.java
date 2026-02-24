package com.Java8;


/***
 * A Lambda Expression in Java (introduced in Java 8) is a concise way to represent an anonymous function—a block of code that can be passed around as data. 
It enables developers to treat functionality as a method argument or assign it to a variable, thereby supporting functional programming within Java.
 */
public class LambdaExpression {
	
	
	/**
	 * Rules to remember that :
	 *  Interface method are by default- public and abstract (unless marked default and static)
	 *  Interface variable are by default-public,static,final
	 * 
	 */
	@FunctionalInterface
	 abstract interface Add{
		int addition(int a,int b);
	}
	
	@FunctionalInterface
	abstract interface hello{
		void display(); // if we write this method as public abstract void display then both considered as same
	}
	
	@FunctionalInterface
	abstract interface Practice{
		public abstract String findVowel(String s);
	}

	public static void main(String[] args) {
		
		Add add = (a,b)->a+b;
		
		int ans = add.addition(10,20);
		
		hello h = () -> System.out.println("Hello I am Manish Kushwaha");
		h.display();
		
		System.out.println(ans);  /// for the ADD interface 
		
		Practice p = (s)-> {
			int count=0;
			StringBuilder result = new StringBuilder();
			for(char c : s.toLowerCase().toCharArray()) {
				if("aeiouAEIOU".indexOf(c)!=-1) {
					result.append(Character.toUpperCase(c));
					count++;
				}
				else {
					result.append(c);
				}
			}
			return "Vowel convert into Upper case:  = " + result.toString() + " and  the count of the vowels are :"+count;
		};
		System.out.println(p.findVowel("manish Kushwaha"));
	}

}
