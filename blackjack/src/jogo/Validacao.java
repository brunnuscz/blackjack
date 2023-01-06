package jogo;

public class Validacao{
	InterfaceUsuario iu = new InterfaceUsuario();
	// MÉTODO QUE VALIDA A QUANTIDADE DE JOGADORES
	public int validarQuantJogadores(int quant) {
		if(quant > 5) {
			iu.msgQuantJog(5);
			return 5;
		}else if(quant < 2) {
			iu.msgQuantJog(2);
			return 2;
		}
		return quant;
	}
	// MÉTODO QUE VALIDA O ESTOURO DE CARTAS DOS JOGADORES
	public boolean verificarEstouroDeCartas(Jogador jogador) {
		int soma = 0;
		for(int i=0; i<jogador.cartasNaMao.size(); i++) {
			soma = soma + jogador.cartasNaMao.get(i).valor;
		}
		if(soma > 21) {
			iu.msgEstorou(jogador);
			return true;
		}
		return false;
	}

}
