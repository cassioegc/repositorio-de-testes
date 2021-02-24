package lp2.projetofinal.entidades;

/**
 * Classe responsavel por conter metodos e atributos de um objeto do tipo JogoEletronico (tipo especifico de Item).
 * 
 * Laboratorio de Programacao 2 - Projeto Final Parte 01
 * 
 * @author Thiago Santos de Moura - 116210967
 * @author Gabriel Almeida Azevedo - 116210009
 * @author Marcelo Gabriel dos Santos Queiroz Vitorino - 116211290
 */

import lp2.projetofinal.enums.PlataformaJogoEletronico;

public class JogoEletronico extends Item {

	private static final long serialVersionUID = 7016161167443155144L;
	
	private PlataformaJogoEletronico plataforma;

	/**
	 * Construtor de JogoEletronico. Esse construtor invoca o construtor da
	 * classe pai (Item) para setar os atributos herdados de Item e seta os
	 * atributos especificos.
	 * 
	 * @param nome
	 *            = nome do jogo.
	 * @param preco
	 *            = preco do jogo.
	 * @param plataforma
	 *            = plataforma onde o jogo eh rodado, ex: PS3, PS4 XBOX_ONE.
	 */
	public JogoEletronico(String nome, double preco, String plataforma) {
		super(nome, preco);

		this.plataforma = PlataformaJogoEletronico.indentificaPlataforma(plataforma);
	}

	/**
	 * 
	 * @return = String que representa a plataforma do jogo.
	 */
	public String getPlataforma() {
		return plataforma.getPlataforma();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = super.hashCode();
		result = prime * result + ((plataforma == null) ? 0 : plataforma.hashCode());
		return result;
	}

	/**
	 * Equals sobreescrito. Dois jogos eletronicos sao iguais se tem o mesmo
	 * nome e mesma plataforma.
	 */
	@Override
	public boolean equals(Object obj) {

		if (!super.equals(obj))
			return false;

		JogoEletronico ref = (JogoEletronico) obj;
		if (!ref.getPlataforma().equals(this.plataforma.getPlataforma()))
			return false;

		return true;
	}

	/**
	 * toString sobreescrito. O tString de Item compoe esse toString. Eh uma
	 * representacao em string do Jogo com seus atributos basicos.
	 */
	@Override
	public String toString() {
		return "JOGO ELETRONICO: " + super.toString() + this.getPlataforma();
	}

}
