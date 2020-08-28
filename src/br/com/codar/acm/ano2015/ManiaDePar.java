package br.com.codar.acm.ano2015;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// TODO - not working for some cases

public class ManiaDePar {

	public static void main(String[] args) {
		
		Scanner in = new Scanner( System.in );
		
		Integer cidades = in.nextInt();
		Integer estradas = in.nextInt();
		
		int[][] grafo = new int[cidades + 1][cidades + 1];
		
		for (int i = 0; i < estradas; i++) {

			int cidadeA = in.nextInt();
			int cidadeB = in.nextInt();
			int distancia = in.nextInt();
			
			grafo[cidadeA][cidadeB] = distancia;
			grafo[cidadeB][cidadeA] = distancia;
		}
		
		int[][] grafoBalanceado = new int[cidades + 1][cidades + 1];
		
		balancearGrafo(cidades, grafo, grafoBalanceado);

		int menorDistancia = dijkstra(grafoBalanceado);
		
		if (menorDistancia == Integer.MAX_VALUE)
			System.out.println("-1");
		else
			System.out.println( menorDistancia );
		
		in.close();
	}
	
	private static int dijkstra(int[][] grafoBalanceado) {
		
		int[] dist = new int[grafoBalanceado.length];
		
		int[] prev = new int[grafoBalanceado.length];
		
		List<Integer> q = new ArrayList<>();
		
		for (int i = 1; i < dist.length; i++) {
			dist[i] = Integer.MAX_VALUE;
			prev[i] = -1;
			q.add(i);
		}
		
		dist[1] = 0;
		
		while ( !q.isEmpty() ) {
			
			Integer u = selectMin(q, dist);
			
			q.remove(u);
			
			for (int i = 1; i < grafoBalanceado.length; i++) {
				
				if (grafoBalanceado[u][i] != 0) {
					
					int alt = dist[u] + grafoBalanceado[u][i];
					
					if ( alt < dist[i] ) {
						dist[i] = alt;
						prev[i] = u;
					}
				}
			}
		}
		return dist[grafoBalanceado.length - 1];
	}

	private static Integer selectMin(List<Integer> q, int[] dist) {

		int aux = Integer.MAX_VALUE;
		int u = 0;
		
		for (Integer vertice : q) {
			if( dist[vertice] < aux ) {
				u = vertice;
				aux = dist[vertice];
			}
		}
		return u;
	}

	/**
	 * Substitui duas cidades ligadas por duas estradas 
	 * em uma estrada só com a soma das distâncias.
	 */
	private static void balancearGrafo(Integer cidades, int[][] grafo, int[][] grafoBalanceado) {
		
		for (int i = 1; i <= cidades; i++) {
			
			for(int j = 1; j <= cidades; j++) {
				
				// se tiver uma estrada ligando a cidade i com a cidade j
				if(grafo[i][j] != 0) {
					
					// verifica se há estrada para cada cidade k de j
					for(int k = 1; k <= cidades; k++) {
						
						if(grafo[j][k] != 0 && i != k) {
							
							int somaEstradas = grafo[i][j] + grafo[j][k];
							
							// verifica se ja existe um caminho de i para k, e armazena o menor caminho
							if(grafoBalanceado[i][k] == 0 || grafoBalanceado[i][k] > somaEstradas)
								grafoBalanceado[i][k] = somaEstradas;
							
						}
					}
				}
			}
		}
	}
}

