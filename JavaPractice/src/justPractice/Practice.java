package justPractice;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Practice {
	

	public static ArrayList<Integer> findArrayLeader(int arr[],int n) {
		ArrayList<Integer> result= new ArrayList<>();
		int maxFromRight=arr[n-1];
		result.add(maxFromRight);
		
		for(int i=n-2;i>=0;i--) {
			if(arr[i]>=maxFromRight) {
				result.add(arr[i]);
				maxFromRight=arr[i];
			}
		}
		Collections.reverse(result);
		return result;
	}

	public static void main(String[] args) {
		Practice p = new Practice();
		Scanner sc = new Scanner(System.in);
		
//		
//		String s = sc.nextLine();
//		StringBuffer str = new StringBuffer (s);
//		
//		System.out.println(" using stringbuffer : "+str.reverse().toString());
//		
//		String reversed= IntStream.rangeClosed(1, s.length()).mapToObj(i->s.charAt(s.length()-i)).map(String::valueOf)
//				.collect(Collectors.joining());
//		String reversed2 = IntStream.rangeClosed(1, s.length()).mapToObj(i -> s.charAt(s.length() - i))
//				.map(String::valueOf).collect(Collectors.joining());
//		
//		System.out.println("Using Java 8"+reversed + " "+ reversed2);
		
		int n = 6;
		int arr[]= {16,17,4,3,5,2};
		
		ArrayList<Integer> ans = findArrayLeader(arr,n);
		System.out.println(ans);
	   
		
	}
}
