package lp2.projetofinal.entidades;

import java.io.Serializable;

/**
 * Classe abstrata responsavel por conter metodos e atributos de um objeto do tipo Item.
 * Classe pai de BluRay, JogoEletronico e JogoTabuleiro.
 * 
 * Laboratorio de Programacao 2 - Projeto Final Parte 01
 * 
 * @author Thiago Santos de Moura - 116210967
 * @author Gabriel Almeida Azevedo - 116210009
 * @author Marcelo Gabriel dos Santos Queiroz Vitorino - 116211290
 */

import lp2.projetofinal.enums.EstadoItem;

public abstract class Item implements Comparable<Item>, Serializable{


	private static final long serialVersionUID = 5532259661608172523L;

	private String nome;
	private double preco;
	private EstadoItem estado;
	private int numeroEmprestimos;

	/**
	 * Cria um item com nome e preco.
	 *
	 * @param nome
	 *            O nome do item.
	 * @param preco
	 *            O preco do item.
	 * 
	 */
	public Item(String nome, double preco) {
		this.nome = nome;
		this.preco = preco;
		this.numeroEmprestimos = 0;
		this.estado = EstadoItem.NAO_EMPRESTADO;
	}

	/**
	 * Recupera o preco do item.
	 *
	 * @return O preco do item.
	 */
	public double getPreco() {
		return this.preco;
	}

	/**
	 * @param preco
	 *            O preco do item.
	 *
	 *            Atualiza o preco do item.
	 *
	 */
	public void setPreco(double preco) {
		this.preco = preco;
	}

	/**
	 * Recupera o nome do item.
	 *
	 * @return O nome do item.
	 */
	public String getNome() {
		return this.nome;
	}
	
	

	/**
	 * @param nome
	 *            O nome do item.
	 *
	 *            Atualiza o nome do item.
	 *
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Recupera o estado do item.
	 *
	 * @return O estado do item.
	 */
	public String getEstado() {
		return this.estado.getEstado();
	}

	/**
	 * Muda o estado do item.
	 */
	public void itemEmprestado() {
		this.estado = EstadoItem.EMPRESTADO;
	}

	/**
	 * Muda o estado do item.
	 */
	public void itemDevolvido() {
		this.estado = EstadoItem.NAO_EMPRESTADO;
	}

	/**
	 * Representacao em string do item.
	 *
	 * @return A representacao em string do item.
	 */
	@Override
	public String toString() {

		return this.nome + ", R$ " + this.preco + ", " + this.estado.getEstado() + ", ";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item ref = (Item) obj;

		if (!ref.getNome().equals(this.nome))
			return false;

		return true;
	}

	/**
	 * @param atributo
	 *            O atributo do item a ser atualizado.
	 * 
	 * @param valor
	 *            O valor do item a ser atualizado.
	 *
	 *            Atualiza um valor do item.
	 *
	 */
	public void atualizar(String atributo, String valor) {

		switch (atributo) {
		case "Nome":
			this.nome = valor;
			break;
		case "Preco":
			this.preco = Double.parseDouble(valor);
			break;
		}
	}

	/**
	 * Recupera uma informacao do item.
	 * 
	 * @param atributo Atributo que será retornado.
	 *
	 * @return Um atributo do item.
	 */
	public String getInfo(String atributo) {

		switch (atributo) {
		case "Nome":
			return this.nome;
		case "Preco":
			return "" + this.preco;
		default:
			return "";
		}
	}
	
	public void atualizaNumeroEmprestimos() {
		this.numeroEmprestimos ++;
	}
	
	public int getNumeroEmprestimos() {
		return this.numeroEmprestimos;
	}
	
	/**
	 * Objetos itens sao comparados pelo nome, de forma alfabetica.
	 */
	@Override
	public int compareTo(Item item) {
		return this.nome.compareTo(item.getNome());
	}
}
