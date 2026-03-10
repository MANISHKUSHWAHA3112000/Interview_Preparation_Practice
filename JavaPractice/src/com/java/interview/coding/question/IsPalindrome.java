package com.java.interview.coding.question;

import java.util.Scanner;

public class IsPalindrome {
	
	public static boolean isPalindromeOrNot(String s) {
		// Nitin
		int left=0;int right=s.length()-1;
		
		while(left<=right) {
			if(s.charAt(left)!=s.charAt(right)) {
				return false;
			}
			left++;
			right--;
			
		}
		return true;
		
	}
	
	/**
	 import java.util.Scanner;

public class Main

{
    // if a string is single string 
    // public static boolean findPalindrom(String s){
    //     int start=0;int end=s.length()-1;
        
    //     for(int i=0;i<s.length();i++){
    //         if(s.charAt(start)!=s.charAt(end)){
    //             return false;
    //         }
    //         start++;
    //         end--;
    //     }
    //     return true;
    // }
    
    //if a string is sentences then this
    public static boolean findPalindrom(String s){
        String checkString = s.replaceAll("[^a-zA-Z]","").toLowerCase();
        
        String result= new StringBuilder(checkString).reverse().toString();
        
        if(checkString.equals(result)){
            return true;
        }
        else{
            return false;
        }
    }
    
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		
		boolean ans = findPalindrom(s);
		
		System.out.println(ans);
	}
}
	 */

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String s = sc.nextLine();
		boolean ans = isPalindromeOrNot(s);
		System.out.println(ans);
		sc.close();
	}
}
