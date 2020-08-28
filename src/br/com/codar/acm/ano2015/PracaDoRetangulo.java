package br.com.codar.acm.ano2015;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PracaDoRetangulo {
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner( System.in );
		
		Integer n = in.nextInt();
		
		List<Poste> postes = new ArrayList<>();
		List<Poste> postesVerificados = new ArrayList<>();
		
		int retangulos = 0;
		
		for (int i = 0; i < n; i++)
			postes.add( new Poste( in.nextInt(), in.nextInt() ) );
		
		for (int i = 0; i < n; i++) {
			
			Poste posteA = postes.get(i);

			for (int j = 0; j < n; j++) {
				
				Poste posteB = postes.get(j);
				
				if (posteB.equals(posteA) || postesVerificados.contains(posteB))
					continue;
				
				if (posteA.formamRetangulo(posteB)) {
					
					boolean temPosteDentro = false;
					
					for (int k = 0; k < n && !temPosteDentro; k++) {

						Poste posteAVerificar = postes.get(k);
						
						if (posteAVerificar.equals(posteA) || posteAVerificar.equals(posteB))
							continue;
						
						if (estaDentro(posteA, posteB, posteAVerificar))
							temPosteDentro = true;
					}
					
					if (!temPosteDentro)
						retangulos++;
				}
			
			}
			
			postesVerificados.add(posteA);
		}
			
		System.out.println(retangulos);
	
		in.close();
	}

	private static boolean estaDentro(Poste posteA, Poste posteB, Poste posteAVerificar) {
		
		boolean satisfazX = false;
		boolean satisfazY = false;
		
		if (posteA.x < posteB.x && posteAVerificar.x >= posteA.x && posteAVerificar.x <= posteB.x)
			satisfazX = true;
		
		else if (posteB.x < posteA.x && posteAVerificar.x >= posteB.x && posteAVerificar.x <= posteA.x)
			satisfazX = true;
		
		
		if (posteA.y < posteB.y && posteAVerificar.y >= posteA.y && posteAVerificar.y <= posteB.y)
			satisfazY = true;
		
		else if (posteB.y < posteA.y && posteAVerificar.y >= posteB.y && posteAVerificar.y <= posteA.y)
			satisfazY = true;
		
		return satisfazX && satisfazY;
	}
}

class Poste {
	
	int x;
	int y;
	
	public Poste(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public boolean formamRetangulo(Poste poste) {
		
		if ( this.x == poste.x || this.y == poste.y)
			return false;
		
		return true;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Poste other = (Poste) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
}