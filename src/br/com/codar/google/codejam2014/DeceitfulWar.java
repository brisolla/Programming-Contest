package br.com.codar.google.codejam2014;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class DeceitfulWar {
	
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		
		Integer qtdExecucoes = in.nextInt();
		Integer caso = 1;
		
		while (qtdExecucoes > 0) {
			
			Integer blocos = in.nextInt();
			List<Double> naomiBlocosTrue = new ArrayList<>();
			List<Double> naomiBlocosFalse = new ArrayList<>();
			List<Double> kenBlocosTrue = new ArrayList<>();
			List<Double> kenBlocosFalse = new ArrayList<>();
			
			for (int i = 0; i < blocos; i++) {
				String naomiBloco = in.next();
				naomiBlocosTrue.add(Double.valueOf(naomiBloco));
				naomiBlocosFalse.add(Double.valueOf(naomiBloco));
			}
			for (int i = 0; i < blocos; i++) { 
				String kenBloco = in.next();
				kenBlocosTrue.add(Double.valueOf(kenBloco));
				kenBlocosFalse.add(Double.valueOf(kenBloco));			
			}
			
			Collections.sort(naomiBlocosTrue);
			Collections.sort(naomiBlocosFalse);
			Collections.sort(kenBlocosTrue);
			Collections.sort(kenBlocosFalse);

			naomiTrue(naomiBlocosTrue, kenBlocosTrue);
			naomiFalse(naomiBlocosFalse, kenBlocosFalse);
			
			System.out.println("Case #" + caso++ + ": " + naomiBlocosFalse.size() + " " + naomiBlocosTrue.size());
			
			qtdExecucoes--;
		}

	}

	private static void naomiTrue(List<Double> naomiBlocos, List<Double> kenBlocos) {
		
		for (int i = 0, j = 0; i < naomiBlocos.size() && j < kenBlocos.size();){
			while ( j < kenBlocos.size() ){
				if (kenBlocos.get(j) > naomiBlocos.get(i)){
					kenBlocos.remove(j);
					naomiBlocos.remove(i);
				} else if (kenBlocos.get(j) <= naomiBlocos.get(i)){
					j++;
				}
			}
		}
	}
	
	private static void naomiFalse(List<Double> naomiBlocos, List<Double> kenBlocos) {
		
		for (int i = 0, j = 0; i < naomiBlocos.size() && j < kenBlocos.size();){
			while ( j < kenBlocos.size() ){
				if (naomiBlocos.get(i) < kenBlocos.get(j)){
					kenBlocos.remove(kenBlocos.size() - 1);
					naomiBlocos.remove(i);
				} else if (naomiBlocos.get(i) > kenBlocos.get(j)){
					i++;
					j++;
				}
			}
		}
	}

}
