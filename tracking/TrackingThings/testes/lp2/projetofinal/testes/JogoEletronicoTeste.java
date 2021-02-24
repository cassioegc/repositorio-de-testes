package lp2.projetofinal.testes;

/**
 * Classe responsavel por conter testes para metodos de um objeto do tipo JogoEletronico(heranca de Item).
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

import lp2.projetofinal.entidades.JogoEletronico;

public class JogoEletronicoTeste {
	
	private JogoEletronico jogo1;
	private JogoEletronico jogo2;
	private JogoEletronico jogo3;

	@Before
	public void criaJogoEletronico(){
		jogo1 = new JogoEletronico("Fifa 2017", 150.00, "PS4");
		jogo2 = new JogoEletronico("PES 2017", 139.99, "PS3");
		jogo3 = new JogoEletronico("Fifa 2017", 165.00, "PS4");
	}
	
	@Test
	public void testConstrutorJogoEletronico() {
		assertEquals("Fifa 2017", jogo1.getNome());
		assertEquals(150.0, jogo1.getPreco(), 0.01);
		assertEquals("Nao emprestado", jogo1.getEstado());
		assertEquals("PS4", jogo1.getPlataforma());
	}

	@Test
	public void testToString() {
		assertEquals("JOGO ELETRONICO: Fifa 2017, R$ 150.0, Nao emprestado, PS4", jogo1.toString());
	}

	@Test
	public void testEqualsObject() {
		assertTrue(jogo1.equals(jogo3));
		assertFalse(jogo1.equals(jogo2));
	}

	@Test
	public void testGetPlataforma() {
		assertEquals("PS4", jogo1.getPlataforma());
		assertEquals("PS3", jogo2.getPlataforma());
	}

}
