package justPractice;

import java.util.ArrayList;
import java.util.Arrays;

public class Practice {
	
	

	public static void main(String[] args) {
		String s = "bbbbbxxhhelllllooudd";
		String word="hello";
		
		for(int i=0;i<s.length();i++) {
			if(s.contains(word)) {
				System.out.println(true);
			}
			else {
				System.out.println(false);
			}
		}


	}
}
