package lp2.projetofinal.testes;

/**
 * Classe responsavel por conter testes para metodos de um objeto do tipo ChaveNomeTelefone(esse objeto sera chave do Map de usuarios em ControllerUsuarios).
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

import lp2.projetofinal.entidades.ChaveNomeTelefone;

public class ChaveNomeTelefoneTeste {

	private ChaveNomeTelefone chave1;
	private ChaveNomeTelefone chave2;
	
	@Before
	public void criaChaveNomeTelefone(){
		chave1 = new ChaveNomeTelefone("Gabriel", "(83) 8888-9999");
		chave2 = new ChaveNomeTelefone("Marcelo", "(83) 9999-7777");
	}
	
	@Test
	public void testConstrutorChaveNomeTelefone() {
		assertEquals("Gabriel", chave1.getNome());
		assertEquals("(83) 8888-9999", chave1.getTelefone());
	}

	@Test
	public void testGetTelefone() {
		assertEquals("(83) 9999-7777", chave2.getTelefone());
		assertEquals("(83) 8888-9999", chave1.getTelefone());
	}

	@Test
	public void testGetNome() {
		assertEquals("Gabriel", chave1.getNome());
		assertEquals("Marcelo", chave2.getNome());
	}

	@Test
	public void testEqualsObject() {
		ChaveNomeTelefone chave3 = new ChaveNomeTelefone("Gabriel ", "(83) 8888-9999");
		ChaveNomeTelefone chave4 = new ChaveNomeTelefone("Gabriel", " (83) 8888-9999");
		ChaveNomeTelefone chave5 = new ChaveNomeTelefone("Gabriel", "(83) 8888-9999");
		
		assertFalse(chave3.equals(chave4));
		assertTrue(chave1.equals(chave5));
		
	}

}
