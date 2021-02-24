package lp2.projetofinal.testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FakeItemTeste {
	private FakeItem fakeItem;

	@Before
	public void criaItem() {
		fakeItem = new FakeItem("Xadrez",50.00);
	}
	
	@Test
	public void testGetPreco() {
		assertEquals(50.00,fakeItem.getPreco(),0.01);
	}
	
	@Test
	public void testSetPreco() {
		assertEquals(50.00,fakeItem.getPreco(),0.01);
		fakeItem.setPreco(59.99);
		assertEquals(59.99,fakeItem.getPreco(),0.01);
	}
	
	@Test
	public void testGetNome() {
		assertEquals("Xadrez",fakeItem.getNome());
	}
	
	@Test
	public void testSetNome() {
		assertEquals("Xadrez",fakeItem.getNome());
		fakeItem.setNome("XadrezLuxo");
		assertEquals("XadrezLuxo",fakeItem.getNome());
	}
	
	@Test
	public void testGetEstadoItem() {
		assertEquals("Nao emprestado",fakeItem.getEstado());
		fakeItem.itemEmprestado();
		assertEquals("Emprestado",fakeItem.getEstado());
		fakeItem.itemDevolvido();
		assertEquals("Nao emprestado",fakeItem.getEstado());
	
	}
	
	@Test
	public void testAtualizarAtributo() {
		assertEquals("Xadrez",fakeItem.getNome());
		fakeItem.atualizar("Nome","Xadrez Imperial");
		assertEquals("Xadrez Imperial",fakeItem.getNome());
		
		assertEquals(50.00,fakeItem.getPreco(),0.01);
		fakeItem.atualizar("Preco","59.99");
		assertEquals(59.99,fakeItem.getPreco(),0.01);
		
	}
	
	@Test
	public void testGetInfoAtributo() {
		assertEquals("Xadrez",fakeItem.getInfo("Nome"));
		assertEquals("50.0",fakeItem.getInfo("Preco"));
		
		fakeItem.atualizar("Nome","Xadrez Imperial");
		fakeItem.atualizar("Preco","59.99");
		
		assertEquals("Xadrez Imperial",fakeItem.getInfo("Nome"));
		assertEquals("59.99",fakeItem.getInfo("Preco"));
	}
	
	@Test
	public void testItemEmprestado() {
		assertEquals("Nao emprestado",fakeItem.getEstado());
		fakeItem.itemEmprestado();
		assertEquals("Emprestado",fakeItem.getEstado());

	}
	
	@Test
	public void testItemDevolvido() {
		assertEquals("Nao emprestado",fakeItem.getEstado());
		fakeItem.itemDevolvido();
		assertEquals("Nao emprestado",fakeItem.getEstado());
	}
	
	@Test
	public void testToString() {
		assertEquals("Xadrez, R$ 50.0, Nao emprestado, ",fakeItem.toString());
		fakeItem.itemEmprestado();
		assertEquals("Xadrez, R$ 50.0, Emprestado, ",fakeItem.toString());

	}
	
	@Test
	public void testGetNumeroEmprestimosEAtualizaNumeroEmprestimos(){
		assertEquals(0, fakeItem.getNumeroEmprestimos());
		fakeItem.atualizaNumeroEmprestimos();
		fakeItem.atualizaNumeroEmprestimos();
		assertEquals(2, fakeItem.getNumeroEmprestimos());
	}
	
	@Test
	public void testCompareTo(){
		FakeItem fakeItemDois = new FakeItem("War", 200.00);
		assertEquals(-1, fakeItemDois.compareTo(fakeItem));
		assertEquals(0, fakeItem.compareTo(fakeItem));
		assertEquals(1, fakeItem.compareTo(fakeItemDois));
	}
	
}
