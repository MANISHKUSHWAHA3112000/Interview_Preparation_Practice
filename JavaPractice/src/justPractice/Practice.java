package justPractice;

import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Practice {

	public static void main(String[] args) {
		Practice p = new Practice();
		Scanner sc = new Scanner(System.in);
		
		
		String s = sc.nextLine();
		StringBuffer str = new StringBuffer (s);
		
		System.out.println(" using stringbuffer : "+str.reverse().toString());
		
		String reversed= IntStream.rangeClosed(1, s.length()).mapToObj(i->s.charAt(s.length()-i)).map(String::valueOf)
				.collect(Collectors.joining());
		String reversed2 = IntStream.rangeClosed(1, s.length()).mapToObj(i -> s.charAt(s.length() - i))
				.map(String::valueOf).collect(Collectors.joining());
		
		System.out.println("Using Java 8"+reversed + " "+ reversed2);
		

	}
}
