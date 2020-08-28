package br.com.codar.acm.ano2015;

import java.util.Scanner;

public class BolsaDeValores {

	public static void main(String[] args) {

		Scanner in = new Scanner( System.in );
		
		int n = in.nextInt();
		int custo = in.nextInt();
		
		int acaoMaisBarata = Integer.MAX_VALUE;
		int acaoMaisLucrativa = 0;
		int lucro = 0;
		
		for (int i = 0; i < n; i++) {
			
			int acaoEntrada = in.nextInt();
			
			if (acaoEntrada - acaoMaisBarata > 0 && acaoEntrada > acaoMaisLucrativa) {
				acaoMaisLucrativa = acaoEntrada;
			
			} else if (acaoEntrada + custo <= acaoMaisBarata || acaoMaisLucrativa - acaoEntrada > custo) {

			      if (acaoMaisLucrativa > 0) {
			        lucro += acaoMaisLucrativa - acaoMaisBarata;
			        acaoMaisLucrativa = 0;
			      }
			      acaoMaisBarata = acaoEntrada + custo;
			}
		}

		if (acaoMaisLucrativa > 0)
			lucro += acaoMaisLucrativa - acaoMaisBarata;
		
		System.out.println(lucro);
		
		in.close();
	}
	
}
