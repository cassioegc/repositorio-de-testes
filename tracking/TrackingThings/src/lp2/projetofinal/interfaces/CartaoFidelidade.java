package lp2.projetofinal.interfaces;

/**
 * Interface Cartao Fidelidade, implementada pelos tipo de cartao do sistema. Possibilitando o uso do strategy. 
 * 
 * Laboratorio de Programacao 2 - Projeto Final Parte 01
 * 
 * @author Thiago Santos de Moura - 116210967
 * @author Gabriel Almeida Azevedo - 116210009
 * @author Marcelo Gabriel dos Santos Queiroz Vitorino - 116211290
 */

public interface CartaoFidelidade {
	
	public boolean permisaoPegarEmprestado();
	
	public int prazoEmprestimo();
	
	public String getNomeCartao();
	
}
