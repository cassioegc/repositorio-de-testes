package lp2.projetofinal.orders;

/**
 * Classe responsavel por implementar a interface Comparator e criar um criterio de comparacao para itens. 
 * Criterio pela quantidade de apostas.
 * 
 * Laboratorio de Programacao 2 - Projeto Final Parte 01
 * 
 * @author Thiago Santos de Moura - 116210967
 * @author Gabriel Almeida Azevedo - 116210009
 * @author Marcelo Gabriel dos Santos Queiroz Vitorino - 116211290
 */

import java.util.Comparator;

import lp2.projetofinal.entidades.Emprestimo;

public class OrdenaItemEmprestadoAlfabetico implements Comparator<Emprestimo> {

	@Override
	public int compare(Emprestimo emprestimoUm, Emprestimo emprestimoDois) {
		return emprestimoUm.getItem().getNome().compareTo(emprestimoDois.getItem().getNome());
	}

}
