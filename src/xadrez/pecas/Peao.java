package xadrez.pecas;

import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;
import xadrez.Cor;
import xadrez.PecaXadrez;

public class Peao extends PecaXadrez {

	public Peao(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro, cor);
	}

	@Override
	public boolean[][] movimentosPossiveis() {
		boolean[][] matriz = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];
		Posicao posicaoAuxiliar = new Posicao(0, 0);

		if (getCor() == Cor.BRANCO) {
			posicaoAuxiliar.setValor(posicao.getLinha() - 1, posicao.getColuna());
			if (getTabuleiro().posicaoExiste(posicaoAuxiliar) && !getTabuleiro().verificaPecaPosicao(posicaoAuxiliar)) {
				matriz[posicaoAuxiliar.getLinha()][posicaoAuxiliar.getColuna()] = true;
			}
			posicaoAuxiliar.setValor(posicao.getLinha() - 2, posicao.getColuna());
			Posicao posicaoAuxiliar2 = new Posicao(posicaoAuxiliar.getLinha() - 1, posicaoAuxiliar.getColuna());
			if (getTabuleiro().posicaoExiste(posicaoAuxiliar) && !getTabuleiro().verificaPecaPosicao(posicaoAuxiliar)
					&& getTabuleiro().posicaoExiste(posicaoAuxiliar2)
					&& !getTabuleiro().verificaPecaPosicao(posicaoAuxiliar2) && getContadorMovimentos() == 0) {
				matriz[posicaoAuxiliar.getLinha()][posicaoAuxiliar.getColuna()] = true;
			}
			posicaoAuxiliar.setValor(posicao.getLinha() - 1, posicao.getColuna() - 1);
			if (getTabuleiro().posicaoExiste(posicaoAuxiliar) && eUmaPecaDoOponente(posicaoAuxiliar)) {
				matriz[posicaoAuxiliar.getLinha()][posicaoAuxiliar.getColuna()] = true;
			}
			posicaoAuxiliar.setValor(posicao.getLinha() - 1, posicao.getColuna() + 1);
			if (getTabuleiro().posicaoExiste(posicaoAuxiliar) && eUmaPecaDoOponente(posicaoAuxiliar)) {
				matriz[posicaoAuxiliar.getLinha()][posicaoAuxiliar.getColuna()] = true;
			}
		}
		
		if (getCor() == Cor.PRETO) {
			posicaoAuxiliar.setValor(posicao.getLinha() + 1, posicao.getColuna());
			if (getTabuleiro().posicaoExiste(posicaoAuxiliar) && !getTabuleiro().verificaPecaPosicao(posicaoAuxiliar)) {
				matriz[posicaoAuxiliar.getLinha()][posicaoAuxiliar.getColuna()] = true;
			}
			posicaoAuxiliar.setValor(posicao.getLinha() + 2, posicao.getColuna());
			Posicao posicaoAuxiliar2 = new Posicao(posicaoAuxiliar.getLinha() - 1, posicaoAuxiliar.getColuna());
			if (getTabuleiro().posicaoExiste(posicaoAuxiliar) && !getTabuleiro().verificaPecaPosicao(posicaoAuxiliar)
					&& getTabuleiro().posicaoExiste(posicaoAuxiliar2)
					&& !getTabuleiro().verificaPecaPosicao(posicaoAuxiliar2) && getContadorMovimentos() == 0) {
				matriz[posicaoAuxiliar.getLinha()][posicaoAuxiliar.getColuna()] = true;
			}
			posicaoAuxiliar.setValor(posicao.getLinha() + 1, posicao.getColuna() - 1);
			if (getTabuleiro().posicaoExiste(posicaoAuxiliar) && eUmaPecaDoOponente(posicaoAuxiliar)) {
				matriz[posicaoAuxiliar.getLinha()][posicaoAuxiliar.getColuna()] = true;
			}
			posicaoAuxiliar.setValor(posicao.getLinha() + 1, posicao.getColuna() + 1);
			if (getTabuleiro().posicaoExiste(posicaoAuxiliar) && eUmaPecaDoOponente(posicaoAuxiliar)) {
				matriz[posicaoAuxiliar.getLinha()][posicaoAuxiliar.getColuna()] = true;
			}
		}
		return matriz;
	}

	@Override
	public String toString() {
		return "P";
	}

	
	
}
