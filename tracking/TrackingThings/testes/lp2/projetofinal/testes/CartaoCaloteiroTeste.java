package lp2.projetofinal.testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import lp2.projetofinal.entidades.CartaoCaloteiro;
import lp2.projetofinal.entidades.Usuario;

public class CartaoCaloteiroTeste {
	private Usuario usuario;

	@Before
	public void criaUsuario() {
		usuario = new Usuario("Marcelo Gabriel Vitorino", "marcelo@computacao.ufcg.edu.br", "(83) 9999-0000");
	}

	@Test
	public void testPermisaoPegarEmprestado() {
		usuario.setCartao(new CartaoCaloteiro());
		assertFalse(usuario.getCartao().permisaoPegarEmprestado());
	}

	@Test
	public void testPrazoEmprestimo() {
		usuario.setCartao(new CartaoCaloteiro());
		assertEquals(0, usuario.getCartao().prazoEmprestimo());
	}

	@Test
	public void testGetNomeCartao() {
		usuario.setCartao(new CartaoCaloteiro());
		assertEquals("Caloteiro", usuario.getCartao().getNomeCartao());
	}

}
