package lp2.projetofinal.entidades;

import java.io.Serializable;

/**
 * Representacao de um emprestimo cadastrado no Sistema, todo emprestimo no
 * sistema tem o dono do item, o usuario requerente ,item,data de emprestimo,
 * numero de dias para o emprestimo e data de devolucao.
 * 
 * Laboratorio de Programacao 2 - Projeto Final Parte 01
 * 
 * @author Thiago Santos de Moura - 116210967
 * @author Gabriel Almeida Azevedo - 116210009
 * @author Marcelo Gabriel dos Santos Queiroz Vitorino - 116211290
 */
public class Emprestimo implements Serializable {


	private static final long serialVersionUID = -8552283230885947000L;

	private Usuario donoDoItem;

	private Usuario usuarioRequerente;

	private Item item;

	private String dataEmprestimo;

	private int numeroDias;

	private String dataDevolucao;

	/**
	 * Cria um emprestimo com dono do item, usuarioRequerente do
	 * emprestimo,item, A data do Emprestimo, e o O numero de Dias para
	 * emprestimo.
	 *
	 * @param donoDoItem
	 *            O donoDoItem para emprestimo.
	 * @param usuarioRequerente
	 *            O usuarioRequerente do emprestimo.
	 * @param item
	 *            O item do emprestimo.
	 * @param dataEmprestimo
	 *            A data do Emprestimo.
	 * @param numeroDias
	 *            O numero de Dias para emprestimo.
	 * 
	 */
	public Emprestimo(Usuario donoDoItem, Usuario usuarioRequerente, Item item, String dataEmprestimo, int numeroDias) {

		this.donoDoItem = donoDoItem;
		this.usuarioRequerente = usuarioRequerente;
		this.item = item;
		this.dataEmprestimo = dataEmprestimo;
		this.dataDevolucao = "Emprestimo em andamento";
		this.numeroDias = numeroDias;

	}

	/**
	 * Cria um emprestimo com dono do item, usuarioRequerente do emprestimo e a
	 * data do Emprestimo.
	 *
	 * @param donoDoItem
	 *            O donoDoItem para emprestimo.
	 * @param usuarioRequerente
	 *            O usuarioRequerente do emprestimo.
	 * @param dataEmprestimo
	 *            A data do Emprestimo.
	 * 
	 */
	public Emprestimo(Usuario donoDoItem, Usuario usuarioRequerente, String dataEmprestimo) {
		this.donoDoItem = donoDoItem;
		this.usuarioRequerente = usuarioRequerente;
		this.dataEmprestimo = dataEmprestimo;
	}

	/**
	 * @param dataDevolucao
	 *            A data de devolucao do emprestimo.
	 *
	 *            Atualiza a data de devolucao do emprestimo.
	 *
	 */
	public void setDataDevolucao(String dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	/**
	 * Representacao em string do emprestimo.
	 *
	 * @return A representacao em string do emprestimo.
	 */
	@Override
	public String toString() {

		return "EMPRESTIMO - De: " + this.donoDoItem.getNome() + ", Para: " + this.usuarioRequerente.getNome() + ", "
				+ this.item.getNome() + ", " + this.dataEmprestimo + ", " + this.numeroDias + " dias, ENTREGA: "
				+ this.dataDevolucao;
	}
	
	
	public Usuario getDonoDoItem() {
		return donoDoItem;
	}

	public Usuario getUsuarioRequerente() {
		return usuarioRequerente;
	}
	
	public Item getItem() {
		return this.item;
	}
	
	public int getNumeroDias() {
		return numeroDias;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataEmprestimo == null) ? 0 : dataEmprestimo.hashCode());
		result = prime * result + ((donoDoItem == null) ? 0 : donoDoItem.hashCode());
		result = prime * result + ((usuarioRequerente == null) ? 0 : usuarioRequerente.hashCode());
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

		Emprestimo ref = (Emprestimo) obj;

		if (!this.donoDoItem.equals(ref.donoDoItem))
			return false;
		if (!this.usuarioRequerente.equals(ref.usuarioRequerente))
			return false;
		if (!this.dataEmprestimo.equals(ref.dataEmprestimo))
			return false;

		return true;
	}

}
