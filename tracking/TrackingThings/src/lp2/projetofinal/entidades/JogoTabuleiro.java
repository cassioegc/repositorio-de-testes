package lp2.projetofinal.entidades;

/**
 * Classe responsavel por conter metodos e atributos de um objeto do tipo JogoTabuleiro (tipo especifico de Item).
 * 
 * Laboratorio de Programacao 2 - Projeto Final Parte 01
 * 
 * @author Thiago Santos de Moura - 116210967
 * @author Gabriel Almeida Azevedo - 116210009
 * @author Marcelo Gabriel dos Santos Queiroz Vitorino - 116211290
 */

import java.util.ArrayList;
import java.util.List;

public class JogoTabuleiro extends Item {

	private static final long serialVersionUID = 257560625865434596L;
	
	private List<String> pecasPerdidas;

	/**
	 * Construtor de JogoTabuleiro. Invoca o construtor da classe Pai para setra
	 * os atributos herdados e seta os especificos.
	 * 
	 * @param nome
	 *            = nome do jogo.
	 * @param preco
	 *            = preco do jogo.
	 */
	public JogoTabuleiro(String nome, double preco) {
		super(nome, preco);

		this.pecasPerdidas = new ArrayList<>();
	}

	/**
	 * Metodo que adiciona uma String com o nome da peca perdida (ex: "dado") a
	 * colecao de pecas perdidas.
	 * 
	 * @param peca
	 *            = string com o nome da peca perdida.
	 */
	public void adicionarPecaPerdida(String peca) {
		this.pecasPerdidas.add(peca);
	}

	/**
	 * Metodo responsavel por retornar uma string representando se existem pecas
	 * perdidas.
	 * 
	 * @return = String "COMPLETO" ou "COM PECAS PERDIDAS".
	 */
	public String contemPecasPerdidas() {
		if (pecasPerdidas.isEmpty())
			return "COMPLETO";
		else
			return "COM PECAS PERDIDAS";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = super.hashCode();
		result = prime * result + ((pecasPerdidas == null) ? 0 : pecasPerdidas.hashCode());
		return result;
	}

	/**
	 * Equals sobreescrito. Uso do equals da classe pai para testar se os nomes
	 * sao iguais. Dois jogos de tabuleiro sao iguais se possuem o mesmo nome e
	 * as mesmas pecas perdidas.
	 * 
	 */
	@Override
	public boolean equals(Object obj) {

		if (!super.equals(obj))
			return false;

		JogoTabuleiro ref = (JogoTabuleiro) obj;
		if (!ref.pecasPerdidas.equals(this.pecasPerdidas))
			return false;

		return true;
	}

	/**
	 * toString sobreescrito. O tString de Item compoe esse toString. Eh uma
	 * representacao em string do Jogo com seus atributos basicos.
	 */
	@Override
	public String toString() {
		return "JOGO DE TABULEIRO: " + super.toString() + this.contemPecasPerdidas();
	}

}
