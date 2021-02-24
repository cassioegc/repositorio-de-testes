package lp2.projetofinal.entidades;

/**
 * Classe responsavel por conter metodos e atributos de um objeto do tipo BluRayFilme (tipo especifico de BluRay).
 * 
 * Laboratorio de Programacao 2 - Projeto Final Parte 01
 * 
 * @author Thiago Santos de Moura - 116210967
 * @author Gabriel Almeida Azevedo - 116210009
 * @author Marcelo Gabriel dos Santos Queiroz Vitorino - 116211290
 */

import lp2.projetofinal.enums.GeneroBluRay;;

public class BluRayFilme extends BluRay {

	private static final long serialVersionUID = 3512995529374676940L;
	
	private int anoLancamento;
	private GeneroBluRay genero;

	/**
	 * Construtor de BluRayFilme. Invoca o construtor da classe Pai para setra
	 * os atributos herdados e seta os especificos.
	 * 
	 * @param nome
	 *            = nome do filme.
	 * @param preco
	 *            = preco do bluray.
	 * @param duracao
	 *            = duracao do filme.
	 * @param genero
	 *            = genero do filme.
	 * @param classificacao
	 *            = classificacao do filme(faixa etaria).
	 * @param novoAnoLancamento
	 *            = ano de lancamento do filme.
	 */
	public BluRayFilme(String nome, double preco, int duracao, String genero, String classificacao,
			int novoAnoLancamento) {
		super(nome, preco, duracao, classificacao);

		this.anoLancamento = novoAnoLancamento;
		this.genero = GeneroBluRay.indentificaGenero(genero);
	}

	/**
	 * 
	 * @return = retorna o atributo AnoLancamento do objeto BluRayFilme.
	 */
	public int getAnoLancamento() {
		return anoLancamento;
	}

	/**
	 * 
	 * @return = retorna uma representacao em string do genero desse objeto.
	 */
	public String getGenero() {
		return genero.getGenero();
	}

	/**
	 * toString sobreescrito. O tString de BluRay compoe esse toString. Eh uma
	 * representacao em string do BluRayFilme com seus atributos basicos.
	 */
	@Override
	public String toString() {
		return "FILME: " + super.toString() + this.getGenero() + ", " + this.getAnoLancamento();
	}

}
