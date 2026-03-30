package justPractice;

import java.util.HashSet;
import java.util.Set;

public class Practice {

	public static void main(String[] args) {
		int a[] = {89, 24, 75, 11, 23}; int b[] = {89, 2, 4};
		int ans = 0;
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        
        for(int num1 : a){
            set1.add(num1);
        }
        
        for(int num2:b){
            set2.add(num2);
        }
        
        if(set1.contains(set2)){
            ans = set1
    
        }
       System.out.println(ans);
	}
}
