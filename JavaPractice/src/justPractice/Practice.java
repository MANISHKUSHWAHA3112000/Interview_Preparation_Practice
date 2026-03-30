package justPractice;

import java.util.HashSet;
import java.util.Set;

public class Practice {

	public static void main(String[] args) {
		int arr[]= {1, 3, 3, 2, 3, 5};
		
		int count=0;
		
		for(int i=0;i<arr.length;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(arr[i]<arr[j] ) {
					System.out.println(arr[i]+" "+arr[j]);
					count++;
				}
			}
		}
		System.out.println(count);
		
	}
}
