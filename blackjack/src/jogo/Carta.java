package jogo;

public class Carta {
	String nome;
	String naipe;
	int valor;
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
