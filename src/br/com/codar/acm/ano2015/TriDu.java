package br.com.codar.acm.ano2015;

import java.util.Scanner;

public class TriDu {
	public static void main(String[] args) {
		
		Scanner in = new Scanner( System.in );
		
		Integer carta1 = in.nextInt();
		Integer carta2 = in.nextInt();
		
		if (carta1 == carta2)
			System.out.println(carta1);
		
		else if (carta1 > carta2)
			System.out.println(carta1);
		
		else
			System.out.println(carta2);
			
		in.close();
	}
}
