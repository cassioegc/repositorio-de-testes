package lp2.projetofinal.testes;

/**
 * Classe responsavel por conter testes para metodos de um objeto do tipo Emprestimo.
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

import lp2.projetofinal.entidades.Emprestimo;
import lp2.projetofinal.entidades.Item;
import lp2.projetofinal.entidades.JogoEletronico;
import lp2.projetofinal.entidades.Usuario;

public class EmprestimoTeste {

	private Emprestimo emprestimo1;
	private Emprestimo emprestimo2;
	private Usuario usuario1;
	private Usuario usuario2;
	private Item item1;
	private Item item2;
	
	@Before
	public void criaEmprestimo(){
		usuario1 = new Usuario("Gabriel", "Gabriel@ccc.ufcg.edu.br", "(83) 9999-9898");
		usuario2 = new Usuario("Thiago", "Thiago@ccc.ufcg.edu.br", "(83) 8888-8888");
		item1 = new JogoEletronico("PES", 140.00, "PS4");
		item2 = new JogoEletronico("FIFA", 160.00, "PS4");
		emprestimo1 = new Emprestimo(usuario1, usuario2, item1, "09/08/2017", 7);
		emprestimo2 = new Emprestimo(usuario2, usuario1, item2, "10/08/2017", 14);
	}
	
	@Test
	public void testConstrutorEmprestimoEtoString() {
		assertEquals("EMPRESTIMO - De: Gabriel, Para: Thiago, PES, 09/08/2017, 7 dias, ENTREGA: Emprestimo em andamento", emprestimo1.toString());
		assertEquals("EMPRESTIMO - De: Thiago, Para: Gabriel, FIFA, 10/08/2017, 14 dias, ENTREGA: Emprestimo em andamento", emprestimo2.toString());
	}

	@Test
	public void testSetDataDevolucaoEtoString() {
		assertEquals("EMPRESTIMO - De: Gabriel, Para: Thiago, PES, 09/08/2017, 7 dias, ENTREGA: Emprestimo em andamento", emprestimo1.toString());
		emprestimo1.setDataDevolucao("16/08/2017");
		assertEquals("EMPRESTIMO - De: Gabriel, Para: Thiago, PES, 09/08/2017, 7 dias, ENTREGA: 16/08/2017", emprestimo1.toString());
	}

	@Test
	public void testEqualsObject() {
		Emprestimo emprestimo3 = new Emprestimo(usuario1, usuario2, item2, "09/08/2017", 14);
		assertFalse(emprestimo1.equals(emprestimo2));
		assertTrue(emprestimo1.equals(emprestimo3));
	}

}
