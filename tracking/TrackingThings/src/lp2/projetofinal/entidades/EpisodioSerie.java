package lp2.projetofinal.entidades;

import java.io.Serializable;

/**
 * Classe responsavel por representar um objeto EpisodioSerie, que compoe a
 * classe BluRaySerie.
 * 
 * Laboratorio de Programacao 2 - Projeto Final Parte 01
 * 
 * @author Thiago Santos de Moura - 116210967
 * @author Gabriel Almeida Azevedo - 116210009
 * @author Marcelo Gabriel dos Santos Queiroz Vitorino - 116211290
 */

public class EpisodioSerie implements Serializable {

	private static final long serialVersionUID = 577931172507227147L;
	
	private int duracao;

	/**
	 * Cria um episodio de serie com duracao
	 *
	 * @param duracao
	 *            A duracao do episodio.
	 */
	public EpisodioSerie(int duracao) {
		this.duracao = duracao;
	}

	/**
	 * Recupera a duracao do episodio.
	 *
	 * @return A duracao do episodio.
	 */
	public int getDuracao() {
		return duracao;
	}

}
