package jogo;

import java.util.ArrayList;

public class Jogo {
	// LISTA DE JOGADORES
	ArrayList<Jogador> jogadores = new ArrayList<Jogador>();
	// LISTA DE PARTIDAS
	ArrayList<Partida> partidas = new ArrayList<Partida>();
	// IU
	InterfaceUsuario iu = new InterfaceUsuario();
	// VALIDACAO
	Validacao validacao = new Validacao();
	// MÉTODO QUE INICIA A PARTIDA
	public void iniciarPartida() {
		Partida partida = new Partida();
		Baralho baralho = new Baralho();
		iu.listarJogador(jogadores);
		partida.iniciarNovaPartida(baralho,jogadores);
		partidas.add(partida);
		iu.resultadoPartida(partida, jogadores, baralho);
		iu.menu();
	}
	// MÉTODO QUE ADICIONAR JOGADOR NA LISTA
	public void adicionarJogadores(int quantidade) {
		for(int i=0; i < quantidade; i++) {
			jogadores.add(iu.criarJogador());
		}
	}
	// MÉTODO QUE INICIA O JOGO
	public void iniciarJogo() {
		int valor = iu.quemVaiJogar();
		adicionarJogadores(validacao.validarQuantJogadores(valor));
		int opcao = 1;
		while(opcao != 2) {
			if(opcao == 1) {
				iniciarPartida();
				resetarListaJogador();
			}else if(opcao != 1 && opcao != 2) {
				iu.msgOpcaoInvalida();				
			}
			opcao = iu.opcaoEscolhida();
		}
		iu.resultadoFinal(partidas);			
		iu.msgFinal();
	}
	// RESETAR LISTA DE JOGADORES
	public void resetarListaJogador() {
		for(int i=0; i<jogadores.size(); i++) {
			Jogador j = new Jogador();
			j.nome = jogadores.get(0).nome;
			jogadores.add(j);
			jogadores.remove(0);
		}
	}
}
