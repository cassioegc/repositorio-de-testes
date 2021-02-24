
package lp2.projetofinal.testes;


/**
 * Classe responsavel por conter testes para metodos de um objeto do tipo BluRayShow(tipo especifico de BluRay).
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

import lp2.projetofinal.entidades.BluRayShow;

public class BluRayShowTeste {

	private BluRayShow bluray1;
	private BluRayShow bluray2;
	
	
	@Before
	public void criaBluRayShow(){
		bluray1 = new BluRayShow("Os Anjos Cantam", 25.90, 110, "LIVRE", "Jorge e Matheus", 12);
		bluray2 = new BluRayShow("Ivete 2017", 30.00, 135, "LIVRE", "Ivete Sangalo", 11);
	}
	
	@Test
	public void testConstrutorBluRayShow() {
		assertEquals("Os Anjos Cantam", bluray1.getNome());
		assertEquals(25.90, bluray1.getPreco(), 0.01);
		assertEquals(110, bluray1.getDuracao());
		assertEquals("Nao emprestado", bluray1.getEstado());
		assertEquals("LIVRE", bluray1.getClassificacao());
		assertEquals("Jorge e Matheus", bluray1.getNomeArtista());
		assertEquals(12, bluray1.getNumFaixas());
	}
	
	@Test
	public void testEqualsObject(){
		BluRayShow bluray3 = new BluRayShow("Os Anjos Cantam", 32.99, 115, "LIVRE", "Wesley Safadao", 10);
		
		assertTrue(bluray1.equals(bluray3));
		assertFalse(bluray2.equals(bluray1));
	}
	
	@Test
	public void testToString() {
		assertEquals("SHOW: Os Anjos Cantam, R$ 25.9, Nao emprestado, 110 min, LIVRE, Jorge e Matheus, 12 faixas", bluray1.toString());
		assertEquals("SHOW: Ivete 2017, R$ 30.0, Nao emprestado, 135 min, LIVRE, Ivete Sangalo, 11 faixas", bluray2.toString());
	}

	@Test
	public void testGetNomeArtista() {
		assertEquals("Ivete Sangalo", bluray2.getNomeArtista());
		assertEquals("Jorge e Matheus", bluray1.getNomeArtista());
	}

	@Test
	public void testGetNumFaixas() {
		assertEquals(12, bluray1.getNumFaixas());
		assertEquals(11, bluray2.getNumFaixas());
	}

}
