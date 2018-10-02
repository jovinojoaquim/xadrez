package xadrez;

import tabuleiro.Peca;
import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;

public abstract class PecaXadrez extends Peca{
	private Cor cor;
	private int contadorMovimentos;

	public PecaXadrez(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro);
		this.cor = cor;
	}

	public Cor getCor() {
		return cor;
	}
	
	public int getContadorMovimentos() {
		return contadorMovimentos;
	}

	public XadrezPosicao getXadrezPosicao() {
		return XadrezPosicao.daPosicao(posicao);
	}
	
	protected boolean eUmaPecaDoOponente(Posicao posicao) {
		PecaXadrez peca = (PecaXadrez) getTabuleiro().peca(posicao);
		return peca != null && peca.getCor() != cor;
	}
	
	public void somarMovimento() {
		contadorMovimentos++;
	}
	
	public void subtrairMovimento() {
		contadorMovimentos--;
	}
	
}
