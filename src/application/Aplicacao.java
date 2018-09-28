package application;

import java.util.Scanner;

import xadrez.PartidaXadrez;
import xadrez.PecaXadrez;
import xadrez.XadrezPosicao;

public class Aplicacao {
	public static void main(String[] args) {
		PartidaXadrez partida = new PartidaXadrez();
		Scanner s = new Scanner(System.in);
		
		while(true) {
			UI.imprimirTabuleiro(partida.getPecas());
			System.out.println();
			System.out.print("Posicao de Origem");
			XadrezPosicao origem = UI.lerXadrezPosicao(s);
			System.out.println();
			System.out.print("Posicao de Destino");
			XadrezPosicao destino = UI.lerXadrezPosicao(s);
			
			PecaXadrez pecaXadrez = partida.movimentoXadrezPeca(origem, destino);
		}
	}
}
