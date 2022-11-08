/**
 * 
 */
package com.greatleaning.balancingbracketscheck;
import java.util.*;

/**
 * @author jasbirsingh
 *
 */
public class drivermain {

	/**
	 * @param args
	 * This Program will check weather the given string is Balanced Brackets or unbalanced string 
	 */
	
	public static String str1 = "([[{}]])";
	public static String str2 = "([[{}]]))";
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Testing -->"+ str1);
		if(isBalanced(str1))
			System.out.println("The entered String has Balanced Brackets");
		else
			System.out.println("The entered Strings do not contain Balanced Brackets");
		
		
		
		
		System.out.println("Testing -->"+ str2);	
		if(isBalanced(str2))
			System.out.println("The entered String has Balanced Brackets");
		else
			System.out.println("The entered Strings do not contain Balanced Brackets");	

	}

	
	public static boolean isBalanced(String str){
		
		String openingBrackets = "[{(<";  
		String closingBrackets = "]})>";  
		
		if (str.isEmpty())
	        return true;
		
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i=0;i<str.length();i++ ) {
			
			char current = str.charAt(i);
			int idx = openingBrackets.indexOf(current);
			
			if(idx>=0)
				stack.push(idx);

			
			if(closingBrackets.indexOf(current)>=0){	
				if(stack.empty())
					return false;

				if (closingBrackets.indexOf(current) == stack.peek())
					stack.pop();
				else
					return false;
				   
				}
			
			}
			return stack.isEmpty();
		
	}
	
}


