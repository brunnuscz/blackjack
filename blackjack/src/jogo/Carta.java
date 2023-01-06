package jogo;

public class Carta {
	String nome;
	String naipe;
	int valor;
	// Valete Copa 11
	// CONSTRUTOR
	Carta(String nomeC, String naipeC, int valorC){
		this.nome = nomeC;
		this.naipe = naipeC;
		this.valor = valorC;
	}
	public String toString() {
		return this.nome+""+this.naipe;
	}
}
