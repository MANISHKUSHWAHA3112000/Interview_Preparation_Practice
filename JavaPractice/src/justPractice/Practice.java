package justPractice;

import java.util.ArrayList;
import java.util.Arrays;

public class Practice {
	
	

	public static void main(String[] args) {
		int arr[] = {3,5,2,5,7,8}; 
		
		 Arrays.sort(arr);
	       int left = 0 ; 
	       int right = arr.length-1;
	       
	       int tastyChocolate = arr[0];
	       
	       for(int i=0;i<arr.length;i++) {
	           if(tastyChocolate<right){
	               right--;
	           }
	           else if(tastyChocolate==left){
	               System.out.println( tastyChocolate);
	           }
	           else{
	               left++;
	           }
	       }
	       
//	       System.out.println(tastyChocolate);
		


	}
}
