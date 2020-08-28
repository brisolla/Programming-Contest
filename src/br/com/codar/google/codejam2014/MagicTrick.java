package br.com.codar.google.codejam2014;

import java.util.Scanner;

public class MagicTrick {
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		Integer qtdExecucoes = in.nextInt();
		Integer caso = 1;
		
		while (qtdExecucoes > 0) {
			
			Integer matrizUm[][] = new Integer[4][4];
			
			Integer linhaUm = in.nextInt() - 1;
			
			for (int i = 0; i < 4; i++) 
				for (int j = 0; j < 4; j++) 
					matrizUm[i][j] = in.nextInt();
			
			Integer matrizDois[][] = new Integer[4][4];
			
			Integer linhaDois = in.nextInt() - 1;
			
			for (int i = 0; i < 4; i++) 
				for (int j = 0; j < 4; j++) 
					matrizDois[i][j] = in.nextInt();
			
			Integer ocorrencias = 0;
			Integer numero = -1;
			
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					if (matrizUm[linhaUm][i] == matrizDois[linhaDois][j]) {
						ocorrencias++;
						numero = matrizUm[linhaUm][i];				
					}
				}
			}
			
			if (ocorrencias == 0)
				System.out.println("Case #" + caso++ + ": Volunteer cheated!");
			else if (ocorrencias > 1)
				System.out.println("Case #" + caso++ + ": Bad magician!");
			else
				System.out.println("Case #" + caso++ + ": " + numero);
			
			qtdExecucoes--;
		}
	}
}
