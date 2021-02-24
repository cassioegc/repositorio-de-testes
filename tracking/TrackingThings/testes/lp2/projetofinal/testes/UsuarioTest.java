package lp2.projetofinal.testes;

/**
 * Classe responsavel por conter testes para metodos de um objeto do tipo Usuario.
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

import lp2.projetofinal.entidades.CartaoFreeRyder;
import lp2.projetofinal.entidades.CartaoNoob;
import lp2.projetofinal.entidades.Usuario;
import lp2.projetofinal.interfaces.CartaoFidelidade;

public class UsuarioTest {
	
	private Usuario usuarioUm;
	

	final String mensagemErroUm = "Valor invalido";
	final String mensagemErroDois = "Exibicao invalida";
	final String mensagemErroTres = "Adicionamento invalido";

	@Before
	public void criaUsuario() {
		usuarioUm = new Usuario("Raquel Vigolvino Lopes", "raquel@computacao.ufcg.edu.br", "(83) 9999-0000");
	}

	@Test
	public void testGetNome() {
		assertEquals(mensagemErroDois,"Raquel Vigolvino Lopes", usuarioUm.getNome());
	}

	@Test
	public void testSetNome() {
		assertEquals(mensagemErroDois,"Raquel Vigolvino Lopes", usuarioUm.getNome());
		usuarioUm.setNome("Livia Maria Pereira");
		assertEquals(mensagemErroDois,"Livia Maria Pereira", usuarioUm.getNome());
	}

	@Test
	public void testGetEmail() {
		assertEquals(mensagemErroDois,"raquel@computacao.ufcg.edu.br", usuarioUm.getEmail());
	}

	@Test
	public void testSetEmail() {
		assertEquals(mensagemErroDois,"raquel@computacao.ufcg.edu.br", usuarioUm.getEmail());
		usuarioUm.setEmail("raquel@gmail.com");
		assertEquals(mensagemErroDois,"raquel@gmail.com", usuarioUm.getEmail());
	}

	@Test
	public void testGetTelefone() {
		assertEquals(mensagemErroDois,"(83) 9999-0000", usuarioUm.getTelefone());
	}

	@Test
	public void testSetTelefone() {
		assertEquals(mensagemErroDois,"(83) 9999-0000", usuarioUm.getTelefone());
		usuarioUm.setTelefone("(83) 9 9999-0000");
		assertEquals(mensagemErroDois,"(83) 9 9999-0000", usuarioUm.getTelefone());
	}

	@Test
	public void testToString() {
		assertEquals(mensagemErroDois,"Raquel Vigolvino Lopes, raquel@computacao.ufcg.edu.br, (83) 9999-0000", usuarioUm.toString());
	}

	@Test
	public void testEqualsObject() {
		Usuario usuarioDois = new Usuario("Livia Maria", "livia@computacao.ufcg.edu.br", "(83) 9999-8888");
		Usuario usuarioTres = new Usuario("Raquel Vigolvino Lopes", "raquelVigolvino@computacao.ufcg.edu.br", "(83) 9999-0000");
		
		assertFalse(usuarioUm.equals(usuarioDois));
		assertTrue(usuarioUm.equals(usuarioTres));
	}
	
	@Test
	public void testGetReputacaoEAtualizaReputacao(){
		assertEquals(0.0, usuarioUm.getReputacao(), 0.01);
		usuarioUm.atualizaReputacao(7.30, true);
		assertEquals(7.30, usuarioUm.getReputacao(), 0.01);
	}
	
	@Test
	public void testCompareTo(){
		Usuario usuarioDois = new Usuario("Gabriel Almeida", "gabriel@ccc.ufcg.edu.br", "9999-7777");
		assertEquals(11, usuarioUm.compareTo(usuarioDois));
		assertEquals(0, usuarioUm.compareTo(usuarioUm));
	}
	
	@Test
	public void testGetCartaoESetCartao(){
		CartaoFidelidade cartao = new CartaoNoob();
		CartaoFidelidade cartao2 = new CartaoFreeRyder();
		
		usuarioUm.setCartao(cartao);
		assertEquals(cartao, usuarioUm.getCartao());
		usuarioUm.setCartao(cartao2);
		assertEquals(cartao2, usuarioUm.getCartao());
	}

}
