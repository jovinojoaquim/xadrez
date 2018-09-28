package application;

import xadrez.PartidaXadrez;
import xadrez.PecaXadrez;

public class Aplicacao {
	public static void main(String[] args) {
		PartidaXadrez partida = new PartidaXadrez();
		UI.imprimirTabuleiro(partida.getPecas());
	}
}
