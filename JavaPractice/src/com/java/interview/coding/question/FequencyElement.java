package com.java.interview.coding.question;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FequencyElement {
	public static int findFrequencyElement(int arr[],int n) {
		Map<Integer,Integer> map = new HashMap<>();
		
		for(int num : arr) {
			map.put(num, map.getOrDefault(num, 0)+ 1);
		}
		
		int maxFeq=0;
		int maxFreqElement=-1;
		
		for(Map.Entry<Integer,Integer> entry : map.entrySet()) {
			if(entry.getKey() > 0) {
				maxFeq=entry.getValue();
				maxFreqElement=entry.getKey();
			}
		}
		return maxFeq;
	}
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int arr[]= new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		
		int ans= findFrequencyElement(arr,n);
		
		System.out.println("Frequency element more than once : "+ ans);
		sc.close();

	}

}
