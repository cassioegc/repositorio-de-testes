package lp2.projetofinal.testes;

/**
 * Classe de teste da classe FakeBluRay, responsavel por testar metodos da Classe FakeBluRay que na verdade sao todos herdados da classe abstrata BluRay.
 * Assim essa classe de teste eh uma forma de testar a classe ABSTRATA BluRay.
 */

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FakeBluRayTeste {

	private FakeBluRay fakeBluRay;
	private FakeBluRay fakeBluRay2;
	
	@Before
	public void criaFakeBluRay() {
		fakeBluRay = new FakeBluRay("Big Time Rush", 39.99, 60, "LIVRE");
		fakeBluRay2 = new FakeBluRay("TEKKEN", 29.00, 122, "DEZESSEIS_ANOS");
	}
	
	@Test
	public void testConstrutorFakeBluRay() {
		assertEquals("Big Time Rush", fakeBluRay.getNome());
		assertEquals(39.99, fakeBluRay.getPreco(), 0.01);
		assertEquals(60, fakeBluRay.getDuracao());
		assertEquals("LIVRE", fakeBluRay.getClassificacao());
	}

	@Test
	public void testToString() {
		assertEquals("Big Time Rush, R$ 39.99, Nao emprestado, 60 min, LIVRE, ", fakeBluRay.toString());
		assertEquals("TEKKEN, R$ 29.0, Nao emprestado, 122 min, DEZESSEIS_ANOS, ", fakeBluRay2.toString());
	}

	@Test
	public void testAtualizar() {
		assertEquals(60, fakeBluRay.getDuracao());
		fakeBluRay.atualizar("Duracao", "65");
		assertEquals(65, fakeBluRay.getDuracao());
		
		assertEquals("LIVRE", fakeBluRay.getClassificacao());
		fakeBluRay.atualizar("Classificacao", "QUATORZE_ANOS");
		assertEquals("QUATORZE_ANOS", fakeBluRay.getClassificacao());	
	}

	@Test
	public void testGetInfo() {
		assertEquals("60", fakeBluRay.getInfo("Duracao"));
		assertEquals("LIVRE", fakeBluRay.getInfo("Classificacao"));
	}

	@Test
	public void testGetDuracao() {
		assertEquals(60, fakeBluRay.getDuracao());
		assertEquals(122, fakeBluRay2.getDuracao());
	}

	@Test
	public void testGetClassificacao() {
		assertEquals("LIVRE", fakeBluRay.getClassificacao());
		assertEquals("DEZESSEIS_ANOS", fakeBluRay2.getClassificacao());
	}

}
