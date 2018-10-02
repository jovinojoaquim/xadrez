package xadrez.pecas;

import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;
import xadrez.Cor;
import xadrez.PecaXadrez;

public class Cavalo extends PecaXadrez {

	public Cavalo(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro, cor);
	}

	@Override
	public boolean[][] movimentosPossiveis() {
		boolean[][] matriz = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];
		Posicao posicaoAuxiliar = new Posicao(0, 0);

		posicaoAuxiliar.setValor(posicao.getLinha() - 1, posicao.getColuna()-2);
		if (getTabuleiro().posicaoExiste(posicaoAuxiliar) && podeMover(posicaoAuxiliar)) {
			matriz[posicaoAuxiliar.getLinha()][posicaoAuxiliar.getColuna()] = true;
		}
		
		posicaoAuxiliar.setValor(posicao.getLinha()-1, posicao.getColuna() + 2);
		if (getTabuleiro().posicaoExiste(posicaoAuxiliar) && podeMover(posicaoAuxiliar)) {
			matriz[posicaoAuxiliar.getLinha()][posicaoAuxiliar.getColuna()] = true;
		}

		posicaoAuxiliar.setValor(posicao.getLinha() -2, posicao.getColuna() -1);
		if (getTabuleiro().posicaoExiste(posicaoAuxiliar) && podeMover(posicaoAuxiliar)) {
			matriz[posicaoAuxiliar.getLinha()][posicaoAuxiliar.getColuna()] = true;
		}

		posicaoAuxiliar.setValor(posicao.getLinha()-2, posicao.getColuna() + 1);
		if (getTabuleiro().posicaoExiste(posicaoAuxiliar) && podeMover(posicaoAuxiliar)) {
			matriz[posicaoAuxiliar.getLinha()][posicaoAuxiliar.getColuna()] = true;
		}

		posicaoAuxiliar.setValor(posicao.getLinha() + 1, posicao.getColuna()+2 );
		if (getTabuleiro().posicaoExiste(posicaoAuxiliar) && podeMover(posicaoAuxiliar)) {
			matriz[posicaoAuxiliar.getLinha()][posicaoAuxiliar.getColuna()] = true;
		}
		
		posicaoAuxiliar.setValor(posicao.getLinha() +2, posicao.getColuna()+1 );
		if (getTabuleiro().posicaoExiste(posicaoAuxiliar) && podeMover(posicaoAuxiliar)) {
			matriz[posicaoAuxiliar.getLinha()][posicaoAuxiliar.getColuna()] = true;
		}
		
		posicaoAuxiliar.setValor(posicao.getLinha() +2, posicao.getColuna()-1 );
		if (getTabuleiro().posicaoExiste(posicaoAuxiliar) && podeMover(posicaoAuxiliar)) {
			matriz[posicaoAuxiliar.getLinha()][posicaoAuxiliar.getColuna()] = true;
		}
		
		posicaoAuxiliar.setValor(posicao.getLinha() + 1, posicao.getColuna()-2 );
		if (getTabuleiro().posicaoExiste(posicaoAuxiliar) && podeMover(posicaoAuxiliar)) {
			matriz[posicaoAuxiliar.getLinha()][posicaoAuxiliar.getColuna()] = true;
		}

		return matriz;
	}

	private boolean podeMover(Posicao posicaoAuxiliar) {
		PecaXadrez peca = (PecaXadrez) getTabuleiro().peca(posicao);
		return peca == null || peca.getCor() != getCor();
	}

	@Override
	public String toString() {
		return "C";
	}
}
