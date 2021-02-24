package lp2.projetofinal.testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import lp2.projetofinal.entidades.CartaoFreeRyder;
import lp2.projetofinal.entidades.Usuario;

public class CartaoFreeRyderTeste {
	private Usuario usuario;

	@Before
	public void criaUsuario() {
		usuario = new Usuario("Marcelo Gabriel Vitorino", "marcelo@computacao.ufcg.edu.br", "(83) 9999-0000");
	}

	@Test
	public void testPermisaoPegarEmprestado() {
		usuario.setCartao(new CartaoFreeRyder());
		assertTrue(usuario.getCartao().permisaoPegarEmprestado());
	}

	@Test
	public void testPrazoEmprestimo() {
		usuario.setCartao(new CartaoFreeRyder());
		assertEquals(5, usuario.getCartao().prazoEmprestimo());
	}

	@Test
	public void testGetNomeCartao() {
		usuario.setCartao(new CartaoFreeRyder());
		assertEquals("FreeRyder", usuario.getCartao().getNomeCartao());
	}

}
