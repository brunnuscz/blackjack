package jogo;

import java.util.ArrayList;

public class Resultado {
	InterfaceUsuario iu = new InterfaceUsuario();
	Jogador vitorioso;
	// MÉTODO QUE VERIFICA A VITORIA
	public boolean verificarVitoria(ArrayList<Jogador> jogadores) {
		Jogador[] lista = new Jogador[jogadores.size()];
		// COLOCAR NA LISTA TODOS QUE TIVEREM PARADO EM MENOS DE 21 OU IGUAL
		for(int i=0; i<jogadores.size(); i++) {
			// 19
			if(iu.somaDeCartas(jogadores.get(i)) <= 21) {
				lista[i] = jogadores.get(i);		
			}
		}
		// ORDENAR A LISTA DE JOGADORES EM ORDEM DECRESCENTE
		for(int i=0; i < lista.length; i++) { // i=21
			for(int j=0; j < lista.length; j++) { // j=21
				Jogador aux = lista[i];
				if(iu.somaDeCartas(lista[i]) > iu.somaDeCartas(lista[j])) {
					lista[i] = lista[j];
					lista[j] = aux;
				}
			}
		}
		// SE O PRIMEIRO DA LISTA FOR NULL ISSO QUER DIZER QUE NINGUEM GANHOU
		if(lista[0] != null && lista[1] == null) {
			iu.msgVitoria(lista[0]);
			vitorioso = lista[0];
			return true;
		}else {
			if(iu.somaDeCartas(lista[0]) == iu.somaDeCartas(lista[1])) {
				iu.msgEmpate();
				vitorioso = null;
				return true;
			}else {
				iu.msgVitoria(lista[0]);
				vitorioso = lista[0];
				return true;
			}			
		}
	}
	// MÉTODO QUE VERIFICA O EMPATE
	public boolean verificarEmpate(ArrayList<Jogador> jogadores) {
		int cont = 0;
		for(int i=0; i<jogadores.size(); i++) {
			if(iu.somaDeCartas(jogadores.get(i)) > 21) {
				cont++;
			}
		}
		if(cont == jogadores.size()) {
			iu.msgEmpate();
			vitorioso = null;
			return true;
		}
		return false;
	}

}
