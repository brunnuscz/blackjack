package jogo;

public class Main {
	public static void main(String[] args) {
		// IU
		InterfaceUsuario iu = new InterfaceUsuario();
		// BOAS VINDAS
		iu.msgInicial();
		// JOGO
		Jogo jogo = new Jogo();
		// INICIAR
		jogo.iniciarJogo();
	}
}
