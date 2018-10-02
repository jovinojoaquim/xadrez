package xadrez;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import tabuleiro.Peca;
import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;
import xadrez.pecas.Bispo;
import xadrez.pecas.Cavalo;
import xadrez.pecas.Peao;
import xadrez.pecas.Rainha;
import xadrez.pecas.Rei;
import xadrez.pecas.Torre;

public class PartidaXadrez {
	private Tabuleiro tabuleiro;
	private int turno;
	private Cor jogadoraAtual;
	private List<Peca> pecasDisponiveis = new ArrayList<>();
	private List<Peca> pecasCapturadas = new ArrayList<>();
	private boolean check;
	private boolean checkMate;

	/**
	 * Cria uma trix 8 x 8 e atribui o valor para a variável tabuleiro
	 */
	public PartidaXadrez() {
		tabuleiro = new Tabuleiro(8, 8);
		turno = 1;
		jogadoraAtual = Cor.BRANCO;
		inicioPartida();
	}

	public int getTurno() {
		return turno;
	}

	public Cor getJogadoraAtual() {
		return jogadoraAtual;
	}
	
	public boolean getCheck() {
		return check;
	}

	public boolean getCheckMate() {
		return checkMate;
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
		lugarNovoPeca('a', 1, new Torre(tabuleiro, Cor.BRANCO));
		lugarNovoPeca('h', 1, new Torre(tabuleiro, Cor.BRANCO));
		lugarNovoPeca('c', 1, new Bispo(tabuleiro, Cor.BRANCO));	
		lugarNovoPeca('f', 1, new Bispo(tabuleiro, Cor.BRANCO));	
		lugarNovoPeca('b', 1, new Cavalo(tabuleiro, Cor.BRANCO));	
		lugarNovoPeca('d', 1, new Rainha(tabuleiro, Cor.BRANCO));	
		lugarNovoPeca('g', 1, new Cavalo(tabuleiro, Cor.BRANCO));	
		lugarNovoPeca('e', 1, new Rei(tabuleiro, Cor.BRANCO));
		lugarNovoPeca('a', 2, new Peao(tabuleiro, Cor.BRANCO));	
		lugarNovoPeca('b', 2, new Peao(tabuleiro, Cor.BRANCO));	
		lugarNovoPeca('c', 2, new Peao(tabuleiro, Cor.BRANCO));	
		lugarNovoPeca('d', 2, new Peao(tabuleiro, Cor.BRANCO));	
		lugarNovoPeca('e', 2, new Peao(tabuleiro, Cor.BRANCO));	
		lugarNovoPeca('f', 2, new Peao(tabuleiro, Cor.BRANCO));	
		lugarNovoPeca('g', 2, new Peao(tabuleiro, Cor.BRANCO));	
		lugarNovoPeca('h', 2, new Peao(tabuleiro, Cor.BRANCO));	
		
		

		lugarNovoPeca('a', 8, new Torre(tabuleiro, Cor.PRETO));
		lugarNovoPeca('h', 8, new Torre(tabuleiro, Cor.PRETO));
		lugarNovoPeca('c', 8, new Bispo(tabuleiro, Cor.PRETO));	
		lugarNovoPeca('f', 8, new Bispo(tabuleiro, Cor.PRETO));
		lugarNovoPeca('b', 8, new Cavalo(tabuleiro, Cor.PRETO));
		lugarNovoPeca('d', 8, new Rainha(tabuleiro, Cor.PRETO));
		lugarNovoPeca('g', 8, new Cavalo(tabuleiro, Cor.PRETO));
		lugarNovoPeca('e', 8, new Rei(tabuleiro, Cor.PRETO));
		lugarNovoPeca('a', 7, new Peao(tabuleiro, Cor.PRETO));	
		lugarNovoPeca('b', 7, new Peao(tabuleiro, Cor.PRETO));	
		lugarNovoPeca('c', 7, new Peao(tabuleiro, Cor.PRETO));	
		lugarNovoPeca('d', 7, new Peao(tabuleiro, Cor.PRETO));	
		lugarNovoPeca('e', 7, new Peao(tabuleiro, Cor.PRETO));	
		lugarNovoPeca('f', 7, new Peao(tabuleiro, Cor.PRETO));	
		lugarNovoPeca('g', 7, new Peao(tabuleiro, Cor.PRETO));	
		lugarNovoPeca('h', 7, new Peao(tabuleiro, Cor.PRETO));	
	}

	private void lugarNovoPeca(char coluna, int linha, PecaXadrez peca) {
		tabuleiro.posicaoPeca(peca, new XadrezPosicao(coluna, linha).paraPosicao());
		pecasDisponiveis.add(peca);
	}

	public PecaXadrez movimentoXadrezPeca(XadrezPosicao origem, XadrezPosicao destino) {
		Posicao posicao = origem.paraPosicao();
		Posicao alvo = destino.paraPosicao();
		validaPosicaoOrigem(posicao);
		validaPosicaoDestino(posicao, alvo);
		Peca capturaPeca = mover(posicao, alvo);
		
		if(testarCheck(jogadoraAtual)) {
			desfazerMovimento(posicao, alvo, capturaPeca);
			throw new XadrezExcecao("Você não pode se colocar em cheque");
		}
		
		if(testarCheck(oponente(jogadoraAtual))) {
			check = true;
		}
		else {
			check = false;
		}
		if(testarCheck(oponente(jogadoraAtual))) {
			checkMate = true;
		}else {
			checkMate = false;
		}
		proximoTurno();
		return (PecaXadrez) capturaPeca;

	}

	private void validaPosicaoDestino(Posicao posicao, Posicao alvo) {
		if (!tabuleiro.peca(posicao).movimentoPossivel(alvo)) {
			throw new XadrezExcecao("A peça escolhida não pode se mover para o destino");
		}
	}

	/**
	 * Método responsável por executar o movimento
	 * @param origem
	 * @param alvo
	 * @return
	 */
	private Peca mover(Posicao origem, Posicao alvo) {
		PecaXadrez pecaX = (PecaXadrez) tabuleiro.removePeca(origem);
		pecaX.somarMovimento();
		Peca peca = tabuleiro.removePeca(origem);
		Peca capturada = tabuleiro.removePeca(alvo);
		if(capturada!=null) {
			pecasDisponiveis.remove(capturada);
			pecasCapturadas.add(capturada);
		}
		tabuleiro.posicaoPeca(peca, alvo);
		return capturada;
	}

	private void validaPosicaoOrigem(Posicao posicao) {
		if (!tabuleiro.verificaPecaPosicao(posicao)) {
			throw new XadrezExcecao("Não existe peca na posicao de origem");
		}
		if(jogadoraAtual != ((PecaXadrez) tabuleiro.peca(posicao)).getCor()) {
			throw new XadrezExcecao("A peca escolhida nao e sua!");
		}
		if (tabuleiro.peca(posicao).movimentoPossivel(posicao)) {
			throw new XadrezExcecao("Não existe movimento Possívellll");
		}
	}

	public boolean[][] movimentosPossiveis(XadrezPosicao origemPosicao) {
		Posicao posicao = origemPosicao.paraPosicao();
		validaPosicaoOrigem(posicao);
		return tabuleiro.peca(posicao).movimentosPossiveis();
	}
	
	private void desfazerMovimento(Posicao origem, Posicao alvo, Peca peca) {
		PecaXadrez pecaX = (PecaXadrez) tabuleiro.removePeca(alvo);
		Peca p = tabuleiro.removePeca(alvo);
		pecaX.subtrairMovimento();		
		tabuleiro.posicaoPeca(p, origem);
		if(peca != null) {
			tabuleiro.posicaoPeca(peca, alvo);
			pecasCapturadas.remove(peca);
			pecasDisponiveis.add(peca);
		}
	}
	
	private Cor oponente(Cor cor) {
		return (cor==Cor.BRANCO)? Cor.PRETO : Cor.BRANCO;
	}
	
	
	/**
	 * Verifica se há algum rei disponível no tabuleiro
	 * @param cor
	 * @return
	 */
	private PecaXadrez rei(Cor cor) {
		List<Peca> lista = pecasDisponiveis.stream().filter(x -> ((PecaXadrez)x).getCor() == cor).collect(Collectors.toList());
		for(Peca p : lista) {
			if(p instanceof Rei) {
				return (PecaXadrez) p;
			}
		}
		throw new IllegalStateException("Não há nenhum rei no tabuleiro da cor "+ cor);
	}
	
	/**
	 * Insere uma mensagem que há um Check em andamento
	 * @param cor
	 * @return
	 */
	private boolean testarCheck(Cor cor) {
		Posicao reiPosicao = rei(cor).getXadrezPosicao().paraPosicao();
		List<Peca> pecasOponente = pecasDisponiveis.stream().filter(x -> ((PecaXadrez)x).getCor() == oponente(cor)).collect(Collectors.toList());
		for(Peca p : pecasOponente) {
			boolean matriz[][] = p.movimentosPossiveis();
			if(matriz[reiPosicao.getLinha()][reiPosicao.getColuna()]) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Executa o ChequeMate
	 * @param cor
	 * @return
	 */
	private boolean tesarChequeMate(Cor cor) {
		if(!testarCheck(cor)) {
			return false;
		}
		List<Peca> pecas = pecasDisponiveis.stream().filter(x -> ((PecaXadrez)x).getCor() == cor).collect(Collectors.toList());
		for(Peca p : pecas) {
			boolean[][] matriz = p.movimentosPossiveis();
			for(int i =0; i< tabuleiro.getLinhas(); i++) {
				for(int j = 0; j<tabuleiro.getColunas(); j++) {
					if(matriz[i][j]) {
						Posicao origem = ((PecaXadrez)p).getXadrezPosicao().paraPosicao();
						Posicao alvo = new Posicao(i, j);
						Peca pecaCapturada = mover(origem, alvo);
						boolean testarcheck = testarCheck(cor);
						desfazerMovimento(origem, alvo, p);
					}
				}
			}
		}
		return true;

	}
	
	/**
	 * Método responsável por alternar os jogadores
	 */
	private void proximoTurno() {
		turno++;
		if(jogadoraAtual == Cor.BRANCO) {
			jogadoraAtual = Cor.PRETO;
		}else {
			jogadoraAtual= Cor.BRANCO;
		}
	}
	
	
	

}
