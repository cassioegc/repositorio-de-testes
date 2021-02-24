package lp2.projetofinal.testes;

/**
 * Classe responsavel por conter testes para metodos de um objeto do tipo ControllerEmprestimos,
 * (controller que possui uma colecao de emprestimos realizados entre os usuarios do Traking Things).
 * 
 * Laboratorio de Programacao 2 - Projeto Final Parte 01
 * 
 * @author Thiago Santos de Moura - 116210967
 * @author Gabriel Almeida Azevedo - 116210009
 * @author Marcelo Gabriel dos Santos Queiroz Vitorino - 116211290
 */

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import lp2.projetofinal.controllers.ControllerEmprestimos;
import lp2.projetofinal.entidades.Emprestimo;
import lp2.projetofinal.entidades.Item;
import lp2.projetofinal.entidades.JogoEletronico;
import lp2.projetofinal.entidades.Usuario;

public class ControllerEmprestimosTeste {

	private ControllerEmprestimos controllerEmprestimos;
	private Emprestimo emprestimo1;
	private Emprestimo emprestimo2;
	private Usuario usuario1;
	private Usuario usuario2;
	private Item item1;
	private Item item2;
	
	@Before
	public void criaController(){
		controllerEmprestimos = new ControllerEmprestimos();
		usuario1 = new Usuario("Gabriel", "Gabriel@ccc.ufcg.edu.br", "(83) 9999-9898");
		usuario2 = new Usuario("Thiago", "Thiago@ccc.ufcg.edu.br", "(83) 8888-8888");
		item1 = new JogoEletronico("PES", 140.00, "PS4");
		item2 = new JogoEletronico("FIFA", 160.00, "PS4");
		emprestimo1 = new Emprestimo(usuario1, usuario2, item1, "08/08/2017", 4);
		emprestimo2 = new Emprestimo(usuario2, usuario1, item2, "10/08/2017", 14);
	}

	/**
	 * Teste para mostrar que o emprestimo nao se encontra na colecao de emprestimos do Controller.
	 */
	@Test (expected = IllegalArgumentException.class)
	public void testColecaoDeEmprestimosVazia() {
		assertEquals(emprestimo1, controllerEmprestimos.identificaEmprestimo(usuario1, usuario2, "08/08/2017"));
	}
	
	/**
	 * Teste para mostrar que o emprestimo foi adicionado corretamente a colecao de emprestimos do Controller.
	 */
	@Test
	public void testRegistrarEmprestimo() {
		assertEquals("Nao emprestado", item1.getEstado());
		controllerEmprestimos.registrarEmprestimo(usuario1, usuario2, item1, "08/08/2017", 4);
		assertEquals(emprestimo1, controllerEmprestimos.identificaEmprestimo(usuario1, usuario2, "08/08/2017"));
		assertEquals("Emprestado", item1.getEstado());
	}

	/**
	 * Teste para verificar se eh lancada uma excessao caso  o item esteja emprestado no momento.
	 */
	@Test (expected = IllegalArgumentException.class)
	public void testRegistrarEmprestimoITEMEMPRESTADO() {
		Usuario usuario3 = new Usuario("Marcelo", "Marcelo@ccc.ufcg.edu.br", "(83) 7979-9898");
		controllerEmprestimos.registrarEmprestimo(usuario1, usuario2, item1, "08/08/2017", 4);
		controllerEmprestimos.registrarEmprestimo(usuario1, usuario3, item1, "11/08/2017", 8);
	}
	
	@Test
	public void testIdentificaEmprestimo() {
		controllerEmprestimos.registrarEmprestimo(usuario2, usuario1, item2, "10/08/2017", 14);
		assertEquals(emprestimo2, controllerEmprestimos.identificaEmprestimo(usuario2, usuario1, "10/08/2017"));
	}
	
	@Test
	public void testDevolverItem() {
		controllerEmprestimos.registrarEmprestimo(usuario2, usuario1, item2, "10/08/2017", 14);
		assertEquals("Emprestado", item2.getEstado());
		assertEquals(-4, controllerEmprestimos.devolverItem(usuario2, usuario1, item2, "10/08/2017", "20/08/2017"));
		assertEquals("Nao emprestado", item2.getEstado());
		
		controllerEmprestimos.registrarEmprestimo(usuario2, usuario1, item2, "22/08/2017", 5);
		assertEquals(2, controllerEmprestimos.devolverItem(usuario2, usuario1, item2, "22/08/2017", "29/08/2017"));	
	}
	
}
