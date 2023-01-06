package jogo;
import java.util.ArrayList;
import java.util.Random;

public class Baralho {
	// 52 CARTAS
	// 4 NAIPES
	// 13 VALORES PARA CADA NAIPE
	
	// LISTA DE CARTAS
	ArrayList<Carta> cartas = new ArrayList<Carta>();
	// RANDOM
	Random r = new Random();
	// METÓDP QUE CRIA AS CARTAS
	public void criarCartas() {
		String naipe = "";
		// VAI ENTRAR 4 VEZES POIS SÃO 4 NAIPES
		for(int i=1; i <= 4; i++) {
			if(i == 1) {
				naipe = "C";
			}else if(i == 2){
				naipe = "O";
			}else if(i == 3){
				naipe = "E";
			}else if(i == 4){
				naipe = "P";
			}
			// VAI CRIAR UMA CARTA E INSERIR ELA NA LISTA
			inserirCartas(new Carta("A", naipe, 1));
			inserirCartas(new Carta("2", naipe, 2));
			inserirCartas(new Carta("3", naipe, 3));
			inserirCartas(new Carta("4", naipe, 4));
			inserirCartas(new Carta("5", naipe, 5));
			inserirCartas(new Carta("6", naipe, 6));
			inserirCartas(new Carta("7", naipe, 7));
			inserirCartas(new Carta("8", naipe, 8));
			inserirCartas(new Carta("9", naipe, 9));
			inserirCartas(new Carta("10", naipe, 10));
			inserirCartas(new Carta("J", naipe, 10));
			inserirCartas(new Carta("Q", naipe, 10));
			inserirCartas(new Carta("K", naipe, 10));
		}
	}
	// METÓDO QUE INSERI AS ARTAS
	public void inserirCartas(Carta c) {
		cartas.add(c);
	}
	// METÓDP QUE EMBRALHA A LISTA DE CARTAS
	public void embaralharBaralho() {
		for(int i=0; i < cartas.size(); i++) {
			Carta c = cartas.get(r.nextInt(cartas.size() + 0));
			cartas.remove(c);
			cartas.add(c);
		}
	}
	
}
