package xadrez.pecas;

import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;
import xadrez.Cor;
import xadrez.PecaXadrez;

public class Bispo extends PecaXadrez{

	public Bispo(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro, cor);
	}

	@Override
	public boolean[][] movimentosPossiveis() {
		boolean[][] matriz = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];
		Posicao posicaoAuxiliar = new Posicao(0, 0);

		// Peça diagonal noroeste
		posicaoAuxiliar.setValor(posicao.getLinha() - 1, posicao.getColuna()-1);
		while (getTabuleiro().posicaoExiste(posicaoAuxiliar) && !getTabuleiro().verificaPecaPosicao(posicaoAuxiliar)) {
			matriz[posicaoAuxiliar.getLinha()][posicaoAuxiliar.getColuna()] = true;
			posicaoAuxiliar.setValor(posicao.getLinha() - 1, posicao.getColuna()-1);
		}
		if (getTabuleiro().posicaoExiste(posicaoAuxiliar) && eUmaPecaDoOponente(posicaoAuxiliar)) {
			matriz[posicaoAuxiliar.getLinha()][posicaoAuxiliar.getColuna()] = true;
		}

		// Peca diagonal ne
		posicaoAuxiliar.setValor(posicao.getLinha()-1, posicao.getColuna() + 1);
		while (getTabuleiro().posicaoExiste(posicaoAuxiliar) && !getTabuleiro().verificaPecaPosicao(posicaoAuxiliar)) {
			matriz[posicaoAuxiliar.getLinha()][posicaoAuxiliar.getColuna()] = true;
			posicaoAuxiliar.setValor(posicao.getLinha() - 1, posicao.getColuna()+1);
		}
		if (getTabuleiro().posicaoExiste(posicaoAuxiliar) && eUmaPecaDoOponente(posicaoAuxiliar)) {
			matriz[posicaoAuxiliar.getLinha()][posicaoAuxiliar.getColuna()] = true;
		}

		// Peca pra diagonal sudeste
		posicaoAuxiliar.setValor(posicao.getLinha()+1, posicao.getColuna() + 1);
		while (getTabuleiro().posicaoExiste(posicaoAuxiliar) && !getTabuleiro().verificaPecaPosicao(posicaoAuxiliar)) {
			matriz[posicaoAuxiliar.getLinha()][posicaoAuxiliar.getColuna()] = true;
			posicaoAuxiliar.setValor(posicao.getLinha()+1, posicao.getColuna() + 1);
		}
		if (getTabuleiro().posicaoExiste(posicaoAuxiliar) && eUmaPecaDoOponente(posicaoAuxiliar)) {
			matriz[posicaoAuxiliar.getLinha()][posicaoAuxiliar.getColuna()] = true;
		}

		// Peca diagona sudoeste
		posicaoAuxiliar.setValor(posicao.getLinha() + 1, posicao.getColuna()-1);
		while (getTabuleiro().posicaoExiste(posicaoAuxiliar) && !getTabuleiro().verificaPecaPosicao(posicaoAuxiliar)) {
			matriz[posicaoAuxiliar.getLinha()][posicaoAuxiliar.getColuna()] = true;
			posicaoAuxiliar.setValor(posicao.getLinha() + 1, posicao.getColuna()-1);
		}
		if (getTabuleiro().posicaoExiste(posicaoAuxiliar) && eUmaPecaDoOponente(posicaoAuxiliar)) {
			matriz[posicaoAuxiliar.getLinha()][posicaoAuxiliar.getColuna()] = true;
		}

		return matriz;
	}

	@Override
	public String toString() {
		return "B";
	}
	
}
