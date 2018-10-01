package xadrez;

import tabuleiro.Peca;
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

	public PecaXadrez[][] getPecas() {
		PecaXadrez[][] partida = new PecaXadrez[tabuleiro.getLinhas()][tabuleiro.getColunas()];
		for (int i = 0; i < tabuleiro.getLinhas(); i++) {
			for (int j = 0; j < tabuleiro.getColunas(); j++) {
				partida[i][j] = (PecaXadrez) tabuleiro.peca(i, j);
			}
		}
		return partida;
	}

	/**
	 * Método Responsável por inicializar as peças no tabuleiro
	 */
	private void inicioPartida() {
		lugarNovoPeca('c', 1, new Torre(tabuleiro, Cor.BRANCO));
		lugarNovoPeca('c', 2, new Torre(tabuleiro, Cor.BRANCO));
		lugarNovoPeca('d', 2, new Torre(tabuleiro, Cor.BRANCO));
		lugarNovoPeca('e', 2, new Torre(tabuleiro, Cor.BRANCO));
		lugarNovoPeca('e', 1, new Torre(tabuleiro, Cor.BRANCO));
		lugarNovoPeca('d', 1, new Rei(tabuleiro, Cor.BRANCO));
		
		lugarNovoPeca('c', 7, new Torre(tabuleiro, Cor.PRETO));
		lugarNovoPeca('c', 8, new Torre(tabuleiro, Cor.PRETO));
		lugarNovoPeca('d', 7, new Torre(tabuleiro, Cor.PRETO));
		lugarNovoPeca('e', 7, new Torre(tabuleiro, Cor.PRETO));
		lugarNovoPeca('e', 8, new Torre(tabuleiro, Cor.PRETO));
		lugarNovoPeca('d', 8, new Rei(tabuleiro, Cor.PRETO));
	}

	private void lugarNovoPeca(char coluna, int linha, Peca peca) {
		tabuleiro.posicaoPeca(peca, new XadrezPosicao(coluna, linha).paraPosicao());
	}
	
	public PecaXadrez movimentoXadrezPeca(XadrezPosicao origem, XadrezPosicao destino) {
		Posicao posicao = origem.paraPosicao();
		Posicao alvo = destino.paraPosicao();
		validaPosicaoOrigem(posicao);
		validaPosicaoDestino(posicao, alvo);
		Peca capturaPeca = mover(posicao, alvo);
		return (PecaXadrez) capturaPeca;
		
	}

	private void validaPosicaoDestino(Posicao posicao, Posicao alvo) {
		if(!tabuleiro.peca(posicao).movimentoPossivel(alvo)) {
			throw new XadrezExcecao("A peça escolhida não pode se mover para o destino");
		}
	}

	private Peca mover(Posicao origem, Posicao alvo) {
		Peca peca = tabuleiro.removePeca(origem);
		Peca capturada = tabuleiro.removePeca(alvo);
		tabuleiro.posicaoPeca(peca, alvo);
		return null;
	}

	private void validaPosicaoOrigem(Posicao posicao) {
		if(!tabuleiro.verificaPecaPosicao(posicao)) {
			throw new XadrezExcecao("Não existe peca na posicao de origem");
		}
		if(tabuleiro.peca(posicao).movimentoPossivel(posicao)) {
			throw new XadrezExcecao("Não existe movimento Possívellll");
		}
	}
	
	public boolean[][] movimentosPossiveis(XadrezPosicao origemPosicao){
		Posicao posicao = origemPosicao.paraPosicao();
		validaPosicaoOrigem(posicao);
		return tabuleiro.peca(posicao).movimentosPossiveis();
	}

}
