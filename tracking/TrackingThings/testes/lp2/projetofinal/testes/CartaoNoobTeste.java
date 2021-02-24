package lp2.projetofinal.testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import lp2.projetofinal.entidades.CartaoNoob;
import lp2.projetofinal.entidades.Usuario;

public class CartaoNoobTeste {
	private Usuario usuario;

	@Before
	public void criaUsuario() {
		usuario = new Usuario("Marcelo Gabriel Vitorino", "marcelo@computacao.ufcg.edu.br", "(83) 9999-0000");
	}

	@Test
	public void testPermisaoPegarEmprestado() {
		usuario.setCartao(new CartaoNoob());
		assertTrue(usuario.getCartao().permisaoPegarEmprestado());
	}

	@Test
	public void testPrazoEmprestimo() {
		usuario.setCartao(new CartaoNoob());
		assertEquals(7, usuario.getCartao().prazoEmprestimo());
	}

	@Test
	public void testGetNomeCartao() {
		usuario.setCartao(new CartaoNoob());
		assertEquals("Noob", usuario.getCartao().getNomeCartao());
	}
}
