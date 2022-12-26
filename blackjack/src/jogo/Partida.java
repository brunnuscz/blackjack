package jogo;

import java.util.ArrayList;

public class Partida {
	Resultado resultado = new Resultado();
	InterfaceUsuario iu = new InterfaceUsuario();
	Validacao validacao = new Validacao();
	// LISTA DE JOGADORES DESSA PARTIDA JUNTAMENTE COM SUAS ULTIMAS CARTAS EM MÃOS
	ArrayList<Jogador> jogadoresDaPartida = new ArrayList<Jogador>();
	// MÉTODO QUE INICIA A PARTIDA DE FATO
	public void iniciarNovaPartida(Baralho baralho, ArrayList<Jogador> jogadores) {
		baralho.criarCartas();
		baralho.embaralharBaralho();
		
		distribuirCartasIniciais(jogadores, baralho);
		
		iu.cartasAtualEmMaosJogadores(jogadores);
		
		int op = 1;
		do {
			for(int i=0; i<jogadores.size(); i++) {
				do {
					if(validacao.verificarEstouroDeCartas(jogadores.get(i))) {
						op = iu.querMaisCartas(jogadores.get(i));
						if(op == 1) {
							int tam = baralho.cartas.size();
							jogadores.get(i).cartasNaMao.add(baralho.cartas.get(tam-1));
							baralho.cartas.remove(tam-1);					
						}						
					}
					iu.cartasAtualEmMaosJogadores(jogadores);
				}while(op == 1 && validacao.verificarEstouroDeCartas(jogadores.get(i)));
			}
		}while(!resultado.verificarEmpate(jogadores) && !resultado.verificarVitoria(jogadores));
		for(int i=0; i<jogadores.size(); i++) {
			jogadoresDaPartida.add(jogadores.get(i));			
		}
	}
	// MÉTODO QUE DISTRIBUI AS CARTAS
	public void distribuirCartasIniciais(ArrayList<Jogador> jogadores, Baralho baralho ) {
		for(int i=0; i<jogadores.size();i++) {
			int tam = baralho.cartas.size();
			jogadores.get(i).cartasNaMao.add(baralho.cartas.get(tam-1));
			jogadores.get(i).cartasNaMao.add(baralho.cartas.get(tam-2));
			baralho.cartas.remove(tam-1);
			baralho.cartas.remove(tam-2);
		}
	}
	
}
