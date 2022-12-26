package jogo;
import java.util.ArrayList;
import java.util.Scanner;

public class InterfaceUsuario {
	// SCANNER
	Scanner sc = new Scanner(System.in);
	// METÓDO PEGA AS INFORMAÇÕES DO JOGADOR
	public Jogador criarJogador() {
		Jogador jogador = new Jogador();
		System.out.print(" - Nome: ");
		jogador.nome = sc.next();
		return jogador;
	}
	// MENU PRINCIPAL
	public void menu() {
		System.out.println("============= MENU ===========");
		System.out.println("=    1 - Continuar Jogando   =");
		System.out.println("=     2 - Encerrar o Jogo    =");
		System.out.println("==============================");
	}
	// MÉTODO QUE PEGA INFORMAÇÕES DE QUANTOS JOGADORES IRÃO JOGAR
	public int quemVaiJogar() {
		System.out.println("\n====== NUMERO JOGADORES ======");
		System.out.print(" - Quantidade: ");
		int quantidade = sc.nextInt();
		System.out.println("\n==== ADICIONAR JOGADORES =====");
		return quantidade;
	}
	// MÉTODO QUE LISTA TODOS OS JOGADORES
	public void listarJogador(ArrayList<Jogador> j) {
		System.out.println("\n=========== JOGADORES ========");
		for(int i=0; i < j.size(); i++) {
			System.out.println("   "+j.get(i).nome);
		}
	}
	// MÉTODO QUE IMPRIME COMO O BARALHO TÁ ATUALMENTE
	public void imprimirBaralho(ArrayList<Carta> c) {
		System.out.println("\n======= BARALHO ATUAL ========");
		for(int i=0; i < c.size(); i++) {
			System.out.print(" "+c.get(i));
			if(i == 12 || i == 25 || i == 38) {
				System.out.println();
			}
		}
		System.out.println();
	}
	// MÉTODO QUE VAI MOSTRAR AS CARTAS ATUAIS EM MÃOS DOS JOGADORES
	public void cartasAtualEmMaosJogadores(ArrayList<Jogador> jogadores) {
		System.out.println("\n======= CARTAS EM MAOS =======");
		for(int i=0; i < jogadores.size(); i++) {
			System.out.println(" * Jogador "+jogadores.get(i).nome+":");
			for(int j=0; j < jogadores.get(i).cartasNaMao.size(); j++) {
				System.out.println("   > "+jogadores.get(i).cartasNaMao.get(j));
			}
		}
	}
	// MÉTODO QUE PEGA A INFORMAÇÃO SE O USUÁRIO QUE OU NÃO MAIS CARTAS
	public int querMaisCartas(Jogador jogador) {
		System.out.println("\n======== PEDIR CARTAS ========");
		int op = 0;
		do {
			System.out.println(" * Jogador "+jogador.nome);			
			System.out.println(" * PARAR [0] ou [1] CONTINUAR");
			System.out.print("   - Escolha: ");
			op = sc.nextInt();
		}while(op != 0 && op != 1);
		
		return op;
	}
	// MÉTODO QUE SOMA AS CARTAS
	public int somaDeCartas(Jogador jogador) {
		int soma = 0;
		if(jogador != null) {
			int tam = jogador.cartasNaMao.size();
			for(int i=0; i<tam; i++) {
				soma = soma + jogador.cartasNaMao.get(i).valor;			
			}
		}
		return soma;
	}
	// PEGAR A OPÇÃO ESCOLHIDA DO USÚARIO
	public int opcaoEscolhida() {
		System.out.print(" - Opcao: ");
		int opcaoEscolhida = sc.nextInt();
		return opcaoEscolhida;
	}
	// IMPRIMIR RESULTADO DA ULTIMA PARTIDA JOGADA
	public void resultadoPartida(Partida p, ArrayList<Jogador> j, Baralho b) {
		System.out.println("\n==== RESULTADO DA PARTIDA ====");
		for(int i=0; i<j.size(); i++) {
			System.out.println("______________________________\n");
			System.out.println(" * JOGADOR "+j.get(i).nome+": ");
			System.out.println("   + Total Soma: "+ somaDeCartas(j.get(i)));
			System.out.println("   + Total Cartas: "+ j.get(i).cartasNaMao.size());
			System.out.println("   + Cartas em Maos: ");
			int tam = j.get(i).cartasNaMao.size();
			for(int k=0; k<tam; k++) {
				System.out.println("     > "+j.get(i).cartasNaMao.get(k));
			}
		}
		System.out.println("______________________________\n");
	}
	// IMPRIMIR RESULTADO FINAL DE TODAS AS PARTIDAS
	public void resultadoFinal(ArrayList<Partida> partidas) {
		System.out.println("\n======= RESULTADO FINAL ======");
		
		for(int i=0; i<partidas.size(); i++) {
			System.out.println("\n__________ PARTIDA "+(i+1)+" _________\n");
			if(partidas.get(i).resultado.vitorioso != null) {
				System.out.println(" * Resultado: Vencedor "+partidas.get(i).resultado.vitorioso.nome);				
			}else {
				System.out.println(" * Resultado: Empate");
			}
			System.out.println(" * Jogadores: ");
			for(int j=0; j<partidas.get(i).jogadoresDaPartida.size(); j++) {
				System.out.println("   - "+partidas.get(i).jogadoresDaPartida.get(j).nome);
				int n = partidas.get(i).jogadoresDaPartida.get(j).cartasNaMao.size();
				System.out.println("     * Cartas:");
				for(int c=0; c<n; c++) {
					System.out.println("       > "+partidas.get(i).jogadoresDaPartida.get(j).cartasNaMao.get(c));
				}
				System.out.println("     * Quantidade: "+n);
				System.out.println("     * Soma: "+somaDeCartas(partidas.get(i).jogadoresDaPartida.get(j)));
			}
		}
		System.out.println("______________________________\n");
		
	}
	// MENSAGENS
	public void msgInicial() {
		System.out.println("\n==============================");
		System.out.println("=        BEM-VINDOS AO       =");
		System.out.println("=          BLACKJACK         =");
		System.out.println("==============================");
	}
	public void msgEmpate() {
		System.out.println("\n ::: Deu Empate");
	}
	public void msgVitoria(Jogador j) {
		System.out.println("\n ::: Vencedor "+j.nome);
	}
	public void msgOpcaoInvalida() {
		System.out.println(" <!> Opcao Invalida");
	}
	public void msgFinal() {
		System.out.println(" ::: Saindo do Jogo");
	}
	public void msgQuantJog(int v) {
		if(v == 2) {
			System.out.println(" <!> No Minimo 2 Jogadores");
		}else {
			System.out.println(" <!> No Maximo 5 Jogadores");			
		}
	}
	public void msgEstorou(Jogador jogador) {
		System.out.println("\n <!> Jogador "+jogador.nome+" Estorou");
	}
}
