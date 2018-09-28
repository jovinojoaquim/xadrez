package xadrez;

import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;
import xadrez.pecas.Rei;
import xadrez.pecas.Torre;

public class PartidaXadrez {
	private Tabuleiro tabuleiro;
	
	/**
	 * Cria uma trix 8 x 8 e atribui o valor para a variável tabuleiro
	 */
	public PartidaXadrez() {
		tabuleiro = new Tabuleiro(8, 8);
		inicioPartida();
	}
	
	public PecaXadrez[][] getPecas(){
		PecaXadrez[][] partida = new PecaXadrez[tabuleiro.getLinhas()][tabuleiro.getColunas()];
		for(int i =0; i<tabuleiro.getLinhas(); i++) {
			for(int j = 0; j< tabuleiro.getColunas(); j++) {
				partida[i][j] = (PecaXadrez) tabuleiro.peca(i, j); 
			}
		}
		return partida;
	}
	
	/**
	 * Método Responsável por inicializar as peças no tabuleiro
	 */
	private void inicioPartida() {
		tabuleiro.posicaoPeca(new Torre(tabuleiro, Cor.BRANCO), new Posicao(0, 7));
		tabuleiro.posicaoPeca(new Rei(tabuleiro, Cor.PRETO), new Posicao(0,4));
		tabuleiro.posicaoPeca(new Rei(tabuleiro, Cor.BRANCO), new Posicao(7,4));
	}
}
