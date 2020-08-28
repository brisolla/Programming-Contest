package br.com.codar.acm.ano2015;

import java.util.Scanner;

public class JogoDeEstrategia {

	public static void main(String[] args) {
		
		Scanner in = new Scanner( System.in );
		
		int jogadores = in.nextInt();
		int rodadas = in.nextInt();
		
		int[] pontosJogador = new int[jogadores + 1];
		
		int jogadorVencedor = 0;
		int pontosVencedor = 0;
		
		for (int i = 0, j = 1; i < (rodadas * jogadores); i++) {
						
			pontosJogador[j] += in.nextInt();
			
			if (pontosVencedor <= pontosJogador[j]) {
				jogadorVencedor = j;
				pontosVencedor = pontosJogador[j];
			}
			
			if (++j > jogadores)
				j = 1;
		}
		
		System.out.println(jogadorVencedor);
			
		in.close();
	}
}
