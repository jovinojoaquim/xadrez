package xadrez.pecas;

import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;
import xadrez.Cor;
import xadrez.PecaXadrez;

public class Rei extends PecaXadrez {

	public Rei(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro, cor);
	}

	@Override
	public String toString() {
		return "R";
	}

	/**
	 * Método Responsavel por validar se o rei pode movimentar para determianda
	 * posicao
	 * 
	 * @param posicao
	 * @return
	 */
	public boolean podeMover(Posicao posicao) {
		PecaXadrez peca = (PecaXadrez) getTabuleiro().peca(posicao);
		return peca == null || peca.getCor() != getCor();
	}

	@Override
	public boolean[][] movimentosPossiveis() {
		boolean[][] matriz = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];
		Posicao posicaoAuxiliar = new Posicao(0, 0);

		// posicao Acima
		posicaoAuxiliar.setValor(posicao.getLinha() - 1, posicao.getColuna());
		if (getTabuleiro().posicaoExiste(posicaoAuxiliar) && podeMover(posicaoAuxiliar)) {
			matriz[posicaoAuxiliar.getLinha()][posicaoAuxiliar.getColuna()] = true;
		}

		// posicao Abaixo
		posicaoAuxiliar.setValor(posicao.getLinha() + 1, posicao.getColuna());
		if (getTabuleiro().posicaoExiste(posicaoAuxiliar) && podeMover(posicaoAuxiliar)) {
			matriz[posicaoAuxiliar.getLinha()][posicaoAuxiliar.getColuna()] = true;
		}

		// posicao Esquerda
		posicaoAuxiliar.setValor(posicao.getLinha(), posicao.getColuna() - 1);
		if (getTabuleiro().posicaoExiste(posicaoAuxiliar) && podeMover(posicaoAuxiliar)) {
			matriz[posicaoAuxiliar.getLinha()][posicaoAuxiliar.getColuna()] = true;
		}

		// posicao Direita
		posicaoAuxiliar.setValor(posicao.getLinha(), posicao.getColuna() + 1);
		if (getTabuleiro().posicaoExiste(posicaoAuxiliar) && podeMover(posicaoAuxiliar)) {
			matriz[posicaoAuxiliar.getLinha()][posicaoAuxiliar.getColuna()] = true;
		}

		// posicao Diagonal acima esquerda
		posicaoAuxiliar.setValor(posicao.getLinha() - 1, posicao.getColuna()-1 );
		if (getTabuleiro().posicaoExiste(posicaoAuxiliar) && podeMover(posicaoAuxiliar)) {
			matriz[posicaoAuxiliar.getLinha()][posicaoAuxiliar.getColuna()] = true;
		}
		
		// posicao Diagonal acima direita
		posicaoAuxiliar.setValor(posicao.getLinha() - 1, posicao.getColuna()+1 );
		if (getTabuleiro().posicaoExiste(posicaoAuxiliar) && podeMover(posicaoAuxiliar)) {
			matriz[posicaoAuxiliar.getLinha()][posicaoAuxiliar.getColuna()] = true;
		}
		
		// posicao Diagonal abaixo esquerda
		posicaoAuxiliar.setValor(posicao.getLinha() + 1, posicao.getColuna()-1 );
		if (getTabuleiro().posicaoExiste(posicaoAuxiliar) && podeMover(posicaoAuxiliar)) {
			matriz[posicaoAuxiliar.getLinha()][posicaoAuxiliar.getColuna()] = true;
		}
		
		// posicao Diagonal abaixo diireta
		posicaoAuxiliar.setValor(posicao.getLinha() + 1, posicao.getColuna()+1 );
		if (getTabuleiro().posicaoExiste(posicaoAuxiliar) && podeMover(posicaoAuxiliar)) {
			matriz[posicaoAuxiliar.getLinha()][posicaoAuxiliar.getColuna()] = true;
		}

		return matriz;
	}

}
