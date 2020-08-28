package br.com.codar.google.codejam2016;

import java.util.Scanner;

public class RevengeOfThePancakes {

	public static void main(String[] args) {
		Scanner input = new Scanner( System.in );
		 
	    int t = input.nextInt();
	     
	    for (int i = 1; i <= t; i++) {
	    	
	    	String pancakes = input.next();
	    	
	    	int moves = 0;

	    	if (pancakes.toCharArray()[pancakes.toCharArray().length - 1] == '-') {
	    		pancakes = upsideDown(pancakes);
	    		moves++;
	    	}
	    	
	    	Character currentChar = pancakes.toCharArray()[0];
	    	
	    	for (Character c : pancakes.toCharArray()) {
	    		
	    		if (c != currentChar) {
	    			currentChar = c;
	    			moves++;
	    		}
	    	}
	    	
	    	System.out.println("Case #" + i + ": " + moves);
	    }
	    input.close();
	}

	private static String upsideDown(String pancakes) {
		
		String puncakes = "";
		
		for (Character c : pancakes.toCharArray()) {
    		
    		if (c == '-')
    			puncakes = "+" + puncakes;
    		else
    			puncakes = "-" + puncakes;
    	}
		return puncakes;
	}
	
}
