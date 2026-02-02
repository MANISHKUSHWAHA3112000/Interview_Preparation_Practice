package com.java.interview.coding.question;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArraySubSets {
	
	public static boolean findArraySubSets(int a[],int n1,int a2[],int n2) {
		
		List<Integer> result1 = new ArrayList<>();
		List<Integer> result2 = new ArrayList<>();
		
		for(int num : a) {
			result1.add(num);
		}
		
		for(int num : a2) {
			result2.add(num);
		}
		
		for(int num : a2) {
			if(result1.contains(num)) {
				result1.remove(Integer.valueOf(num));
			}
			else {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		
		int n1= sc.nextInt();
		int a[]= new int[n1];
		
		for(int i=0;i<n1;i++) {
			a[i]= sc.nextInt();
		}
		
		int n2 = sc.nextInt();
		int a2[]= new int[n2];
		
		for(int i=0;i<n2;i++) {
			a2[i]= sc.nextInt();
		}
		
		boolean ans = findArraySubSets(a,n1,a2,n2);
		
		System.out.println("Array subsets are : "+ans);
	}

}
