package lp2.projetofinal.util;

/**
 * Classe que contem metodos estaticos responsaveis por lancar excessoes
 * chacadas dentro do metodo.
 * 
 * Laboratorio de Programacao 2 - Projeto Final Parte 01
 * 
 * @author Thiago Santos de Moura - 116210967
 * @author Gabriel Almeida Azevedo - 116210009
 * @author Marcelo Gabriel dos Santos Queiroz Vitorino - 116211290
 */

public class Exceptions {

	/**
	 * Metodo que lanca excessao caso o usuario que esta sendo criado ja exista.
	 */
	public static void usuarioJaCadastradoException() {
		throw new IllegalArgumentException("Usuario ja cadastrado");
	}

	/**
	 * Metodo que anca excessa caso o item pesquisado nao exista.
	 */
	public static void itemNaoEncontradoException() {
		throw new IllegalArgumentException("Item nao encontrado");
	}

	/**
	 * Metodo que lanca excessao caso o usuario passado nao exista.
	 */
	public static void usuarioInvalidoException() {
		throw new IllegalArgumentException("Usuario invalido");
	}

	/**
	 * Metodo que lanca excessao caso o atributo seja diferente de "Email",
	 * "Telefone" e "Nome".
	 */
	public static void atributoInvalidoException() {
		throw new IllegalArgumentException("Atributo invalido");
	}

	/**
	 * Metodo que lanca excessao caso o item cujo emprestimo esta sendo realizado ja
	 * esteja emprestado.
	 */
	public static void itemEmprestadoNoMomento() {
		throw new IllegalArgumentException("Item emprestado no momento");
	}

	/**
	 * Metodo que lanca excessao caso nao exista determinado emprestimo.
	 */
	public static void emprestimoNaoEncontrado() {
		throw new IllegalArgumentException("Emprestimo nao encontrado");
	}

	/**
	 * Metodo que lanca excessao caso o usuario nao tenha nenhum item emprestado.
	 */
	public static void nenhumItemEmprestado() {
		throw new IllegalArgumentException("Nenhum item emprestado");
	}

	/**
	 * Metodo que lanca excessao caso o usuario tenha uma reputacao negativa.
	 */
	public static void usuarioNaoPodePegarItemException() {
		throw new IllegalArgumentException("Usuario nao pode pegar nenhum item emprestado");
	}

	/**
	 * Metodo que lanca excessao caso o usuario tente pegar um item por um periodo
	 * maior do que o cartao dele permite.
	 */
	public static void usuarioImpossibilitadoDePegarItemNessePeriodoException() {
		throw new IllegalArgumentException("Usuario impossiblitado de pegar emprestado por esse periodo");
	}

}
