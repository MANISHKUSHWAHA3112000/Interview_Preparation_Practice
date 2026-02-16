package justPractice;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Practice {
	
	public int findSecondLargest(int arr[],int n) {

		Set<Integer> result = new HashSet<>();
		
		
	
		int max=Integer.MIN_VALUE;
		for(int i=0;i<n;i++) {
			result.add(arr[i]);
		}
		if(result.size()<2)return -1;
		
		
		for(int i=0;i<n-1;i++) {
			if(arr[i]>max) {
				max=arr[i];
			}
		}
		return max;
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
		int n= 4;
//		int arr[]= {5,10,10,5};
		int arr[]= {4,24,424,2444};
//		int arr[]= {10,10,10,10};
		
		
		int ans = p.findSecondLargest(arr,n);
		
		System.out.println(ans);
	   
		
	}
}
