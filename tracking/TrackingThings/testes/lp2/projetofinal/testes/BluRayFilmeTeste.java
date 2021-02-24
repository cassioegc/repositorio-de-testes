package lp2.projetofinal.testes;

/**
 * Classe responsavel por conter testes para metodos de um objeto do tipo BluRayFilme(tipo especifico de BluRay).
 * 
 * Laboratorio de Programacao 2 - Projeto Final Parte 01
 * 
 * @author Thiago Santos de Moura - 116210967
 * @author Gabriel Almeida Azevedo - 116210009
 * @author Marcelo Gabriel dos Santos Queiroz Vitorino - 116211290
 */

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import lp2.projetofinal.entidades.BluRayFilme;

public class BluRayFilmeTeste {

	private BluRayFilme bluray1;
	private BluRayFilme bluray2;
	
	@Before
	public void criaBluRayFilme(){
		bluray1 = new BluRayFilme("Moana", 45.99, 140, "ANIMACAO", "LIVRE", 2017);
		bluray2 = new BluRayFilme("Velozes e Furiosos 7", 34.00, 175,"ACAO", "DEZESSEIS_ANOS", 2016);
	}

	@Test
	public void testConstrutorBluRayFilme() {
		assertEquals("Moana", bluray1.getNome());
		assertEquals(45.99, bluray1.getPreco(), 0.01);
		assertEquals(140, bluray1.getDuracao());
		assertEquals("ANIMACAO", bluray1.getGenero());
		assertEquals("LIVRE", bluray1.getClassificacao());
		assertEquals(2017, bluray1.getAnoLancamento());
	}

	@Test
	public void testGetAnoLancamento() {
		assertEquals(2017, bluray1.getAnoLancamento());
		assertEquals(2016, bluray2.getAnoLancamento());
	}

	@Test
	public void testGetGenero() {
		assertEquals("ANIMACAO", bluray1.getGenero());
		assertEquals("ACAO", bluray2.getGenero());
	}
	
	@Test
	public void testEqualsObject(){
		BluRayFilme bluray3 = new BluRayFilme("Velozes e Furiosos 7", 32.99, 180, "ACAO", "DEZOITO_ANOS", 2017);
		
		assertFalse(bluray1.equals(bluray2));
		assertTrue(bluray2.equals(bluray3));
	}
	
	@Test
	public void testToString() {
		assertEquals("FILME: Moana, R$ 45.99, Nao emprestado, 140 min, LIVRE, ANIMACAO, 2017", bluray1.toString());
	}

}
