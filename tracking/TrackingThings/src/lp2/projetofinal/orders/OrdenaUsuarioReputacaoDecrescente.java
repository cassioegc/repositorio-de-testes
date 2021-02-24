package lp2.projetofinal.orders;

/**
 * Classe responsavel por implementar a interface Comparator e criar um criterio de comparacao para usuarios. 
 * Criterio pela reputacao de forma decrescente.
 * 
 * Laboratorio de Programacao 2 - Projeto Final Parte 01
 * 
 * @author Thiago Santos de Moura - 116210967
 * @author Gabriel Almeida Azevedo - 116210009
 * @author Marcelo Gabriel dos Santos Queiroz Vitorino - 116211290
 */

import java.util.Comparator;

import lp2.projetofinal.entidades.Usuario;

public class OrdenaUsuarioReputacaoDecrescente implements Comparator<Usuario> {

	@Override
	public int compare(Usuario usuarioUm, Usuario usuarioDois) {

		double result = usuarioDois.getReputacao() - usuarioUm.getReputacao();
		
		if(result < 0)
			return -1;
		else if(result > 0)
			return 1;
		else
			return 0;
	}

}
