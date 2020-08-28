package br.com.codar.acm.ano2015;

import java.util.Scanner;

public class Fatorial {

	public static void main(String[] args) {
		
		Scanner in = new Scanner( System.in );
		
		Integer n = in.nextInt();
		
		int[] fatoriaisValidos = {40320, 5040, 720, 120, 24, 6, 2, 1};
		
		int count = 0;
		int index = 0;
		
		while (n > 0) {
			
			if(n - fatoriaisValidos[index] >= 0) {
				n -= fatoriaisValidos[index];
				count++;
				
			} else {
				index++;
			}
		}
		
		System.out.println(count);
		
		in.close();
	}
}
