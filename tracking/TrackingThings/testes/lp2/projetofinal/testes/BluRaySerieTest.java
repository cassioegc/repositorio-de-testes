package lp2.projetofinal.testes;

/**
 * Classe responsavel por conter testes para metodos de um objeto do tipo BluRaySerie(tipo especifico de BluRay).
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

import lp2.projetofinal.entidades.BluRaySerie;

public class BluRaySerieTest {
	
	private BluRaySerie bluray1;
	private BluRaySerie bluray2;
	
	
	@Before
	public void criaBluRaySerie(){
		bluray1 = new BluRaySerie("Big Time Rush", 30.00,"BTR in Paris", 60,"DEZESSEIS_ANOS","SUSPENSE", 1);
		bluray2 = new BluRaySerie("Big Time Rush", 35.00,"BTR in Londres", 120,"DEZESSEIS_ANOS", "SUSPENSE", 2);
	}
	
	@Test
	public void testConstrutorBluRaySerie() {
		assertEquals("Big Time Rush", bluray1.getNome());
		assertEquals(30.00, bluray1.getPreco(), 0.01);
		assertEquals(60, bluray1.getDuracao());
		assertEquals("DEZESSEIS_ANOS", bluray1.getClassificacao());
		assertEquals("SUSPENSE", bluray1.getGenero());
		assertEquals(1, bluray1.getNumeroTemporada());
	}
	
	@Test
	public void testToString() {
		assertEquals("SERIE: Big Time Rush, R$ 30.0, Nao emprestado, 60 min, DEZESSEIS_ANOS, SUSPENSE, Temporada 1",bluray1.toString());
		assertEquals("SERIE: Big Time Rush, R$ 35.0, Nao emprestado, 120 min, DEZESSEIS_ANOS, SUSPENSE, Temporada 2",bluray2.toString());
	}

	@Test
	public void testEqualsObject() {
		BluRaySerie bluray3 = new BluRaySerie("Big Time Rush", 50.00,"BTR in Madrid", 120,"DEZESSEIS_ANOS", "SUSPENSE", 2);
		
		assertFalse(bluray1.equals(bluray2));
		assertTrue(bluray2.equals(bluray3));
	}

	@Test
	public void testAdicionarBluRay() {
		assertEquals(0, bluray1.duracaoTotal());
		bluray1.adicionarBluRay(60);
		assertEquals(60,bluray1.duracaoTotal());
	}

	@Test
	public void testDuracaoTotal() {
		assertEquals(0, bluray2.duracaoTotal());
		bluray2.adicionarBluRay(60);
		assertEquals(60,bluray2.duracaoTotal());
		bluray2.adicionarBluRay(60);
		assertEquals(120,bluray2.duracaoTotal());
	}

	@Test
	public void testGetGenero() {
		assertEquals("SUSPENSE", bluray1.getGenero());
	}

	@Test
	public void testGetNumeroTemporada() {
		assertEquals(1, bluray1.getNumeroTemporada());
		assertEquals(2, bluray2.getNumeroTemporada());
	}

	@Test
	public void testGetDescricao() {
		assertEquals("BTR in Paris", bluray1.getDescricao());
		assertEquals("BTR in Londres", bluray2.getDescricao());
	}

}
