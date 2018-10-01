package xadrez.pecas;

import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;
import xadrez.Cor;
import xadrez.PecaXadrez;

public class Torre extends PecaXadrez {

	public Torre(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro, cor);
	}

	@Override
	public String toString() {
		return "T";
	}

	@Override
	public boolean[][] movimentosPossiveis() {
		boolean[][] matriz = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];
		Posicao posicaoAuxiliar = new Posicao(0, 0);

		// Peca Acima
		posicaoAuxiliar.setValor(posicao.getLinha() - 1, posicao.getColuna());
		while (getTabuleiro().posicaoExiste(posicaoAuxiliar) && !getTabuleiro().verificaPecaPosicao(posicaoAuxiliar)) {
			matriz[posicaoAuxiliar.getLinha()][posicaoAuxiliar.getColuna()] = true;
			posicaoAuxiliar.setLinha(posicaoAuxiliar.getLinha() - 1);
		}
		if (getTabuleiro().posicaoExiste(posicaoAuxiliar) && eUmaPecaDoOponente(posicaoAuxiliar)) {
			matriz[posicaoAuxiliar.getLinha()][posicaoAuxiliar.getColuna()] = true;
		}

		// Poeca para Esquerda
		posicaoAuxiliar.setValor(posicao.getLinha(), posicao.getColuna() - 1);
		while (getTabuleiro().posicaoExiste(posicaoAuxiliar) && !getTabuleiro().verificaPecaPosicao(posicaoAuxiliar)) {
			matriz[posicaoAuxiliar.getLinha()][posicaoAuxiliar.getColuna()] = true;
			posicaoAuxiliar.setColuna(posicaoAuxiliar.getColuna() - 1);
		}
		if (getTabuleiro().posicaoExiste(posicaoAuxiliar) && eUmaPecaDoOponente(posicaoAuxiliar)) {
			matriz[posicaoAuxiliar.getLinha()][posicaoAuxiliar.getColuna()] = true;
		}

		// Poeca para Direita
		posicaoAuxiliar.setValor(posicao.getLinha(), posicao.getColuna() + 1);
		while (getTabuleiro().posicaoExiste(posicaoAuxiliar) && !getTabuleiro().verificaPecaPosicao(posicaoAuxiliar)) {
			matriz[posicaoAuxiliar.getLinha()][posicaoAuxiliar.getColuna()] = true;
			posicaoAuxiliar.setColuna(posicaoAuxiliar.getColuna() + 1);
		}
		if (getTabuleiro().posicaoExiste(posicaoAuxiliar) && eUmaPecaDoOponente(posicaoAuxiliar)) {
			matriz[posicaoAuxiliar.getLinha()][posicaoAuxiliar.getColuna()] = true;
		}

		// Poeca para baixo
		posicaoAuxiliar.setValor(posicao.getLinha() + 1, posicao.getColuna());
		while (getTabuleiro().posicaoExiste(posicaoAuxiliar) && !getTabuleiro().verificaPecaPosicao(posicaoAuxiliar)) {
			matriz[posicaoAuxiliar.getLinha()][posicaoAuxiliar.getColuna()] = true;
			posicaoAuxiliar.setLinha(posicaoAuxiliar.getLinha() + 1);
		}
		if (getTabuleiro().posicaoExiste(posicaoAuxiliar) && eUmaPecaDoOponente(posicaoAuxiliar)) {
			matriz[posicaoAuxiliar.getLinha()][posicaoAuxiliar.getColuna()] = true;
		}

		return matriz;
	}

}
