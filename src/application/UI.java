package application;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import xadrez.Cor;
import xadrez.PartidaXadrez;
import xadrez.PecaXadrez;
import xadrez.XadrezPosicao;

public class UI {

	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";

	public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
	public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
	public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
	public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
	public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
	public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
	public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
	public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

	public static void imprimirTabuleiro(PecaXadrez[][] pecas) {
		for (int i = 0; i < pecas.length; i++) {
			System.out.print(8 - i + " ");
			for (int j = 0; j < pecas.length; j++) {
				imprimirPeca(pecas[i][j], false);
			}
			System.out.println();
		}
		System.out.println("  a b c d e f g h");
	}

	private static void imprimirPeca(PecaXadrez peca, boolean background) {
		if (background) {
			System.out.print(ANSI_BLUE_BACKGROUND);
		}
		if (peca == null) {
			System.out.print("-" + ANSI_RESET);
		} else {
			if (peca.getCor() == Cor.BRANCO) {
				System.out.print(ANSI_WHITE + peca + ANSI_RESET);
			} else {
				System.out.print(ANSI_YELLOW + peca + ANSI_RESET);
			}
		}
		System.out.print(" ");
	}

	public static XadrezPosicao lerXadrezPosicao(Scanner s) {
		try {
			String st = s.nextLine();
			char coluna = st.charAt(0);
			int linha = Integer.parseInt(st.substring(1));
			return new XadrezPosicao(coluna, linha);
		} catch (RuntimeException e) {
			throw new InputMismatchException("Erro na posição do Xadrez, possição correta a1 até h8");
		}
	}

	public static void clearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

	public static void imprimirTabuleiro(PecaXadrez[][] pecas, boolean[][] possiveisMovimentos) {
		for (int i = 0; i < pecas.length; i++) {
			System.out.print(8 - i + " ");
			for (int j = 0; j < pecas.length; j++) {
				imprimirPeca(pecas[i][j], possiveisMovimentos[i][j]);
			}
			System.out.println();
		}
		System.out.println("  a b c d e f g h");
	}

	public static void imprimirPartida(PartidaXadrez partida, List<PecaXadrez> capturadas) {
		imprimirTabuleiro(partida.getPecas());
		System.out.println();
		imprimirPecasCapturadas(capturadas);
		System.out.println();
		System.out.println("Turno: " + partida.getTurno());
		if (!partida.getCheckMate()) {
			System.out.println("Aguardando Jogador: " + partida.getJogadoraAtual());
			if (partida.getCheck()) {
				System.out.println("Check!");
			}
		}else {
			System.out.println("Checkmate");
			System.out.println("Vencedor: " + partida.getJogadoraAtual());
		}
	}

	private static void imprimirPecasCapturadas(List<PecaXadrez> capturadas) {
		List<PecaXadrez> branca = capturadas.stream().filter(x -> x.getCor() == Cor.BRANCO)
				.collect(Collectors.toList());
		List<PecaXadrez> preta = capturadas.stream().filter(x -> x.getCor() == Cor.PRETO).collect(Collectors.toList());
		System.out.println("Pecas Capturadas");
		System.out.print("Pecas Brancas: ");
		System.out.print(ANSI_WHITE);
		System.out.println(Arrays.toString(branca.toArray()));
		System.out.print(ANSI_RESET);
		System.out.print("Pecas Pretas: ");
		System.out.print(ANSI_YELLOW);
		System.out.println(Arrays.toString(preta.toArray()));
		System.out.print(ANSI_RESET);

	}
}
