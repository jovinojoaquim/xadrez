package tabuleiro;

public abstract class Peca {
	protected Posicao posicao;
	private Tabuleiro tabuleiro;
	
	public Peca(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
		this.posicao = null;
	}

	protected Tabuleiro getTabuleiro() {
		return tabuleiro;
	}
	
	public abstract boolean[][] movimentosPossiveis();
	
	public boolean movimentoPossivel(Posicao posicao) {
		return movimentosPossiveis()[posicao.getLinha()][posicao.getColuna()];
	}
	
	/**
	 * Método que verifica se há algum movimento possível para as peças, método necessário para verificar possiveis travas de movimentos
	 * @return
	 */
	public boolean algumMovimentoPossivel() {
		boolean[][] matriz = movimentosPossiveis();
		for(int i =0; i< matriz.length; i++) {
			for(int j =0; j< matriz.length; j++) {
				if(matriz[i][j]) {
					return true;
				}
			}
		}
		return false;
	}
	
}
