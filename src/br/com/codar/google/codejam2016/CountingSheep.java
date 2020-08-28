package br.com.codar.google.codejam2016;

import java.util.Scanner;

public class CountingSheep {

	public static void main(String[] args) {
		
		 Scanner input = new Scanner(System.in);
		 
	     int t = input.nextInt();
	     
	     for (int i = 1; i <= t; i++) {
	    	 
	    	 int n = input.nextInt();
	    	 
	    	 int beta = n;
	    	 
	    	 int array[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
	    	 
	    	 for (int j = 2; true; j++) {

		    	 for (int k = n; k > 0; k = k / 10)
		    		 array[k % 10] = 1;
		    	 
		    	 if (checkResult(array)) {
		    		 System.out.println("Case #" + i + ": " + n);
		    		 break;
		    	 
		    	 } else {
		    		 
		    		 if (n == 0) {
			    		 System.out.println("Case #" + i + ": INSOMNIA");
			    		 break;
		    		 }
		    		 
		    		 n = beta * j;
		    	 }
	    	 }
	     }
	     
	     input.close();
	}
	
	
	private static boolean checkResult(int[] array) {
		
		for (int i : array)
			if (i == 0)
				return false;
		
		return true;
	}
}
