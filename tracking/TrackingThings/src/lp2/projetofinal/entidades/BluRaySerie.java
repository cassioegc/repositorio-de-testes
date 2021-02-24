package lp2.projetofinal.entidades;

/**
 * Classe responsavel por conter metodos e atributos de um objeto do tipo BluRaySerie (tipo especifico de BluRay).
 * 
 * Laboratorio de Programacao 2 - Projeto Final Parte 01
 * 
 * @author Thiago Santos de Moura - 116210967
 * @author Gabriel Almeida Azevedo - 116210009
 * @author Marcelo Gabriel dos Santos Queiroz Vitorino - 116211290
 */

import java.util.HashSet;
import java.util.Set;

import lp2.projetofinal.enums.GeneroBluRay;

public class BluRaySerie extends BluRay {

	private static final long serialVersionUID = 5637453773118694637L;
	
	private GeneroBluRay genero;
	private int numeroTemporada;
	private Set<EpisodioSerie> episodios;
	private String descricao;

	/**
	 * Construtor de BluRaySerie. Invoca o construtor da classe Pai para setra
	 * os atributos herdados e seta os especificos.
	 * 
	 * @param nomeItem
	 *            = nome do BluRaySerie.
	 * @param preco
	 *            = preco do BluRay.
	 * @param descricao
	 *            = descricao da serie.
	 * @param duracao
	 *            = duracao da serie.
	 * @param classificacao
	 *            = classificacao da serie (faixa etaria).
	 * @param genero
	 *            = genero da serie.
	 * @param temporada
	 *            = numero da temporada.
	 */
	public BluRaySerie(String nomeItem, double preco, String descricao, int duracao, String classificacao,
			String genero, int temporada) {
		super(nomeItem, preco, duracao, classificacao);

		this.numeroTemporada = temporada;
		this.genero = GeneroBluRay.indentificaGenero(genero);
		this.episodios = new HashSet<>();
		this.descricao = descricao;
	}

	/**
	 * Metodo que adiciona um BluRayEpisodio a colecao de Episodios da serie.
	 * 
	 * @param duracao
	 *            = tempo de duracao do episodio, em minutos.
	 */
	public void adicionarBluRay(int duracao) {

		EpisodioSerie episodioSerie = new EpisodioSerie(duracao);

		episodios.add(episodioSerie);
	}

	/**
	 * Metodo que percorre todos os episodios e calcula a duracao total da
	 * serie.
	 * 
	 * @return = int com a soma das duracoes de cada episodio.
	 */
	public int duracaoTotal() {
		int duracaoTotal = 0;

		for (EpisodioSerie episodioSerie : episodios) {
			duracaoTotal += episodioSerie.getDuracao();
		}

		return duracaoTotal;
	}

	/**
	 * 
	 * @return = String com a representacao do genero da Serie.
	 */
	public String getGenero() {
		return genero.getGenero();
	}

	/**
	 * 
	 * @return = numero da temporada.
	 */
	public int getNumeroTemporada() {
		return numeroTemporada;
	}

	/**
	 * 
	 * @return = String com a descricao da serie.
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * toString sobreescrito. O tString de BluRay compoe esse toString. Eh uma
	 * representacao em string do BluRaySerie com seus atributos basicos.
	 */
	@Override
	public String toString() {
		return "SERIE: " + super.toString() + this.getGenero() + ", Temporada " + this.numeroTemporada;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = super.hashCode();
		result = prime * result + numeroTemporada;
		return result;
	}

	/**
	 * Equals sobreescrito. Uso do equals da classe pai para testar se os nomes
	 * sao iguais. Dois BluRaySerie sao iguais se possuem o mesmo nome e o mesmo
	 * numero de temporada.
	 * 
	 */
	@Override
	public boolean equals(Object obj) {

		if (!super.equals(obj))
			return false;
		BluRaySerie ref = (BluRaySerie) obj;
		if (ref.numeroTemporada != this.numeroTemporada) {
			return false;
		}
		return true;
	}

}
