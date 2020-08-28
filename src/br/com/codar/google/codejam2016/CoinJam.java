package br.com.codar.google.codejam2016;

import java.util.Scanner;

public class CoinJam {
	
	private static long[] nonTrivialDivisors = new long[9];
	
	private static int base;
	
	public static void main(String[] args) {

		Scanner input = new Scanner( System.in );
		
		input.nextInt();
			 
		int n = input.nextInt();
		int j = input.nextInt();
		
		int countResults = 0;
		
		System.out.println("Case #1:");
	    	 
	    for (int i = 9; true; i++) {
	    	
	    	String middle = Integer.toBinaryString(i);
	    	
	    	while (middle.length() < n - 2) {
	    		middle = "0" + middle;
	    	}
	    	
	    	String number = "1" + middle + "1";
	    	
	    	long[] array = new long[9];
	    	
	    	for (int base = 2; base <= 10; base++)
	    		array[base - 2] = toDecimal(number, base, n);
	    	
	    	if (isValidBaseArray(array)) {

		    	System.out.print(number);
		    	
		    	for(int c = 0; c < 9; c++) 
		    		System.out.print(" " + nonTrivialDivisors[c]);
		    	
		    	countResults++;
		    	
		    	if(countResults == j)
		    		break;
		    	else
			    	System.out.print("\n");
	    	}
	    }
	    input.close();
	}
	
	private static boolean isValidBaseArray(long[] array) {

    	nonTrivialDivisors = new long[9];
    	
		for (int i = 0; i < array.length; i++) {
			
			base = i;
			
			if (ehPrimo(array[i]))
				return false;
		}
		
		return true;		
	}
	
	private static boolean ehPrimo(long n) {
				
		if (n <= 1) {
	        return false;
		
		} else if (n <= 3) {
	        return true;
		
		} else if (n % 2 == 0) {
			nonTrivialDivisors[base] = 2;
	        return false;
	        
	    } else if (n % 3 == 0) {
			nonTrivialDivisors[base] = 3;
	        return false;
	    }
	    
	    long i = 5;
	    
	    while (i * i <= n) {
	        if (n % i == 0) {
				nonTrivialDivisors[base] = i;
	            return false;
	        
	        } else if (n % (i + 2) == 0) {
				nonTrivialDivisors[base] = i + 2;
	            return false;
	        }
	        
	        i = i + 6;
	    }
	    return true;
	}
	
	public static long toDecimal(String entrada, int base, int n) {

	    long total = 0;
	    
	    for (int i = 0; i < entrada.length(); i++, n--)
	        total += (entrada.charAt(i) - '0') * Math.pow(base, n-1);
	    
	    return total;
	}		
}
