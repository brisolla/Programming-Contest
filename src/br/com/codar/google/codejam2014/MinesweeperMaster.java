package br.com.codar.google.codejam2014;

import java.util.Scanner;

public class MinesweeperMaster {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		
		Integer qtdExecucoes = in.nextInt();
		Integer caso = 1;
		
		while(qtdExecucoes > 0) {
			
			Integer linhas = in.nextInt();
			Integer colunas = in.nextInt();
			Integer minas = in.nextInt();
			
			System.out.println("Case #" + caso++ + ":");
			
			if (linhas == 1 || colunas == 1) {
				if (linhas * colunas - minas >= 2 )
					desenha(linhas, colunas, minas);
				else
					System.out.println("Impossible");
			}
			
			if (linhas >= 2 && colunas >= 2) {
				if( (linhas * colunas - minas) >= 4 )
					desenha(linhas, colunas, minas);
				else
					System.out.println("Impossible");
			}
		}
	}

	private static void desenha(Integer linhas, Integer colunas, Integer minas) {

		char campo[][] = new char[linhas][colunas];
		
		if(linhas == 1) {
			for(int i = 1; i < colunas; i++)
				campo[0][i] = '.';
			
			for(int i = colunas - 1; minas > 0; i--, minas--) {
				campo[0][i] = '*';
			}
		
		} else if (colunas == 1) {
			for (int i = 1; i < linhas; i++)
				campo[i][0] = '.';
			
			for (int i = linhas - 1; minas > 0; i--, minas--)
				campo[i][0] = '*';
			
		} else {
			for (int i = 0; i < linhas; i++) 
				for (int j = 0; j < colunas; j++) 
					campo[i][j] = '.';
			
			for (int i = linhas - 1; minas > 0 && i > 0; i--) {
				for (int j = colunas - 1; minas > 0 && j > 0; j--) {
					// TODO
				}
			}
		}
		
		campo[0][0] = 'c';
		
		for (int i = 0; i < linhas; i++){
			for (int j = 0; j < colunas; j++){
				System.out.print(campo[i][j]);
			}
			System.out.println();
		}
	}

}
