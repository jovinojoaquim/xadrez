package application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import xadrez.PartidaXadrez;
import xadrez.PecaXadrez;
import xadrez.XadrezExcecao;
import xadrez.XadrezPosicao;

public class Aplicacao {
	public static void main(String[] args) {
		PartidaXadrez partida = new PartidaXadrez();
		Scanner s = new Scanner(System.in);
		List<PecaXadrez> capturadas = new ArrayList<>();
		
		while(true) {
			try {
				UI.clearScreen();
				UI.imprimirPartida(partida, capturadas);
				System.out.println();
				System.out.print("Posicao de Origem: ");
				XadrezPosicao origem = UI.lerXadrezPosicao(s);
				
				boolean[][] possiveisMovimentos = partida.movimentosPossiveis(origem);
				UI.clearScreen();
				UI.imprimirTabuleiro(partida.getPecas(), possiveisMovimentos);
				
				
				System.out.println();
				System.out.print("Posicao de Destino: ");
				XadrezPosicao destino = UI.lerXadrezPosicao(s);
				
				PecaXadrez pecaXadrez = partida.movimentoXadrezPeca(origem, destino);
				
				if(pecaXadrez != null) {
					capturadas.add(pecaXadrez);
				}
			}catch (XadrezExcecao e) {
				System.out.println(e.getMessage());
				s.nextLine();
			}catch (InputMismatchException e) {
				System.out.println(e.getMessage());
				s.nextLine();
			}
		}
	}
}
