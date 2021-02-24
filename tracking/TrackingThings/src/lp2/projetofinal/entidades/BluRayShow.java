package lp2.projetofinal.entidades;

/**
 * Classe responsavel por conter metodos e atributos de um objeto do tipo
 * BluRayShow (tipo especifico de BluRay).
 * 
 * Laboratorio de Programacao 2 - Projeto Final Parte 01
 * 
 * @author Thiago Santos de Moura - 116210967
 * @author Gabriel Almeida Azevedo - 116210009
 * @author Marcelo Gabriel dos Santos Queiroz Vitorino - 116211290
 */

public class BluRayShow extends BluRay {

	private static final long serialVersionUID = -7807249517166765913L;
	
	private String nomeArtista;
	private int numFaixas;

	/**
	 * Construtor de BluRayShow. Invoca o construtor da classe Pai para setra os
	 * atributos herdados e seta os especificos.
	 * 
	 * @param nome
	 *            = nome do BluRayShow.
	 * @param preco
	 *            = preco do BluRay.
	 * @param duracao
	 *            = duracao do show.
	 * @param classificacao
	 *            = classificacao do show.
	 * @param nomeArtista
	 *            = nome do artista que faz o show.
	 * @param numFaixas
	 *            = quantidade de musicas que o show contem.
	 */
	public BluRayShow(String nome, double preco, int duracao, String classificacao, String nomeArtista, int numFaixas) {
		super(nome, preco, duracao, classificacao);

		this.nomeArtista = nomeArtista;
		this.numFaixas = numFaixas;
	}

	/**
	 * 
	 * @return = String com o nome do artista que faz o show.
	 */
	public String getNomeArtista() {
		return nomeArtista;
	}

	/**
	 * 
	 * @return = retorna o atributo numFaixas do show (quantas musicas tem).
	 */
	public int getNumFaixas() {
		return numFaixas;
	}

	/**
	 * toString sobreescrito. O tString de BluRay compoe esse toString. Eh uma
	 * representacao em string do BluRayShow com seus atributos basicos.
	 */
	@Override
	public String toString() {
		return "SHOW: " + super.toString() + this.getNomeArtista() + ", " + this.getNumFaixas() + " faixas";
	}

}
