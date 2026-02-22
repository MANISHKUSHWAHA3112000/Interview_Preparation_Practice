package com.java.interview.coding.question;

import java.util.Scanner;

public class SumEvenOdd {
	
	public static int findSumEvenOdd(int n) {
		int evenSum=0;
		int oddSum=0;
		
		while(n>0) {
			int lastDigit=n%10;
			System.out.println(lastDigit);
			if(lastDigit%2==0) {
				evenSum+=lastDigit;
			}
			else {
				oddSum+=lastDigit;
			}
			n/=10;
		}
		
		return evenSum+oddSum;
	}
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
	   int ans = findSumEvenOdd(n);
	   System.out.println(ans);
	}

}
