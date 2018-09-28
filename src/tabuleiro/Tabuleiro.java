package tabuleiro;

public class Tabuleiro {
	private int linhas;
	private int colunas;
	private Peca[][] pecas;

	public Tabuleiro(int linhas, int colunas) {
		if(linhas < 1 || colunas < 1) {
			throw new TabuleiroExcecao("Erro ao criar um tabuleiro, é necessário ao menos uma linha e uma coluna");
		}
		this.linhas = linhas;
		this.colunas = colunas;
		pecas = new Peca[linhas][colunas];
	}

	public int getLinhas() {
		return linhas;
	}

	public int getColunas() {
		return colunas;
	}

	/**
	 * Retorna a peça que tem na determinada posição
	 * @param posicao posicao que será verificada a existencia da peca
	 * @return
	 */
	public Peca peca (int linha, int coluna) {
		if(!posicaoExiste(linha, coluna)) {
			throw new TabuleiroExcecao("Posição não existente");
		}
		return pecas[linha][coluna];
	}
	
	/**
	 * Retorna a peça que tem na determinada posição
	 * @param posicao posicao que será verificada a existencia da peca
	 * @return
	 */
	public Peca peca (Posicao posicao) {
		if(!posicaoExiste(posicao)) {
			throw new TabuleiroExcecao("Posição não existente");
		}
		return pecas[posicao.getLinha()][posicao.getColuna()];
	}
	
	/**
	 * Método Respnsável por definir a nova posição(movimentar) a peça no tabuleiro
	 * @param peca Peca que será movimentada
	 * @param posicao Nova posição da Peça
	 */
	public void posicaoPeca(Peca peca, Posicao posicao) {
		if(verificaPecaPosicao(posicao)) {
			throw new TabuleiroExcecao("Existe uma peça nessa posição");
		}
		pecas[posicao.getLinha()][posicao.getColuna()] = peca;
		peca.posicao = posicao;
	}
	
	/**
	 * Retorna se existe uma posiçao inserida pelo usuário
	 * @param posicao posicao que será verificada a existencia da peca
	 * @return
	 */
	public boolean posicaoExiste(Posicao posicao) {
		return posicaoExiste(posicao.getLinha(), posicao.getColuna());
	}
	
	/**
	 * Retorna se existe uma posição inseria pelo usuário
	 * @param linha 
	 * @param coluna
	 * @return
	 */
	private boolean posicaoExiste(int linha, int coluna) {
		if(linha >=0 && linha < linhas && coluna >=0 && coluna < colunas) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean verificaPecaPosicao (Posicao posicao) {
		return peca(posicao)!= null;		
	}
	
	public Peca removePeca(Posicao posicao) {
		if(!posicaoExiste(posicao)) {
			throw new TabuleiroExcecao("Posição não existente");
		}
		if(peca(posicao) == null) {
			return null;
		}
		Peca aux = peca(posicao);
		aux.posicao = null;
		pecas[posicao.getLinha()][posicao.getColuna()] = null;
		return aux;
	
	}
}
