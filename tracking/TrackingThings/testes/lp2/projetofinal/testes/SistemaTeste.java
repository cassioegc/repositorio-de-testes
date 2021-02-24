package lp2.projetofinal.testes;

import static org.junit.Assert.*;

import java.text.ParseException;

import org.junit.Before;
import org.junit.Test;

import lp2.projetofinal.controllers.Sistema;

public class SistemaTeste {

	private Sistema sistema;

	@Before
	public void criaSistema() {
		sistema = new Sistema();
	}

	@Test
	public void testCadastrarUsuario() {
		sistema.cadastrarUsuario("Gabriel", "(83) 9999-0000", "gabriel@ccc.ufcg.edu.br");
		assertEquals("gabriel@ccc.ufcg.edu.br", sistema.getInfoUsuario("Gabriel", "(83) 9999-0000", "Email"));

	}

	@Test
	public void testGetInfoUsuario() {
		sistema.cadastrarUsuario("Thiago", "(83) 9898-0000", "thiago@ccc.ufcg.edu.br");

		assertEquals("thiago@ccc.ufcg.edu.br", sistema.getInfoUsuario("Thiago", "(83) 9898-0000", "Email"));
		assertEquals("(83) 9898-0000", sistema.getInfoUsuario("Thiago", "(83) 9898-0000", "Telefone"));
		assertEquals("Thiago", sistema.getInfoUsuario("Thiago", "(83) 9898-0000", "Nome"));
		assertEquals("FreeRyder", sistema.getInfoUsuario("Thiago", "(83) 9898-0000", "Cartao"));
	}

	@Test
	public void testAtualizarUsuario() {
		sistema.cadastrarUsuario("Gabriel", "(83) 9999-0000", "gabriel@ccc.ufcg.edu.br");

		assertEquals("gabriel@ccc.ufcg.edu.br", sistema.getInfoUsuario("Gabriel", "(83) 9999-0000", "Email"));

		sistema.atualizarUsuario("Gabriel", "(83) 9999-0000", "Email", "gabriel@gmail.com");

		assertEquals("gabriel@gmail.com", sistema.getInfoUsuario("Gabriel", "(83) 9999-0000", "Email"));

		sistema.atualizarUsuario("Gabriel", "(83) 9999-0000", "Nome", "Gabriel Almeida");

		assertEquals("Gabriel Almeida", sistema.getInfoUsuario("Gabriel Almeida", "(83) 9999-0000", "Nome"));

		sistema.atualizarUsuario("Gabriel Almeida", "(83) 9999-0000", "Telefone", "(83) 9 9999-0000");

		assertEquals("(83) 9 9999-0000", sistema.getInfoUsuario("Gabriel Almeida", "(83) 9 9999-0000", "Telefone"));
	}

	@Test
	public void testCadastrarEletronico() {
		sistema.cadastrarUsuario("Gabriel", "(83) 9999-0000", "gabriel@ccc.ufcg.edu.br");
		assertEquals("1: Gabriel - Reputacao: 0,00|", sistema.listarTop10MelhoresUsuarios());
		
		sistema.cadastrarEletronico("Gabriel", "(83) 9999-0000", "GTA V", 150.00, "PS4");
		assertEquals("1: Gabriel - Reputacao: 7,50|", sistema.listarTop10MelhoresUsuarios());

		assertEquals("GTA V", sistema.getInfoItem("Gabriel", "(83) 9999-0000", "GTA V", "Nome"));
		assertEquals("150.0", sistema.getInfoItem("Gabriel", "(83) 9999-0000", "GTA V", "Preco"));
	}

	@Test
	public void testCadastrarJogoTabuleiro() {
		sistema.cadastrarUsuario("Gabriel", "(83) 9999-0000", "gabriel@ccc.ufcg.edu.br");
		assertEquals("1: Gabriel - Reputacao: 0,00|", sistema.listarTop10MelhoresUsuarios());

		sistema.cadastrarJogoTabuleiro("Gabriel", "(83) 9999-0000", "Xadrez", 70.00);
		assertEquals("1: Gabriel - Reputacao: 3,50|", sistema.listarTop10MelhoresUsuarios());

		assertEquals("Xadrez", sistema.getInfoItem("Gabriel", "(83) 9999-0000", "Xadrez", "Nome"));
		assertEquals("70.0", sistema.getInfoItem("Gabriel", "(83) 9999-0000", "Xadrez", "Preco"));
	}

	@Test
	public void testCadastrarBluRayFilme() {
		sistema.cadastrarUsuario("Gabriel", "(83) 9999-0000", "gabriel@ccc.ufcg.edu.br");
		assertEquals("1: Gabriel - Reputacao: 0,00|", sistema.listarTop10MelhoresUsuarios());

		sistema.cadastrarBluRayFilme("Gabriel", "(83) 9999-0000", "Frozen", 45.99, 120, "ANIMACAO", "LIVRE", 2013);
		assertEquals("1: Gabriel - Reputacao: 2,30|", sistema.listarTop10MelhoresUsuarios());
		
		assertEquals("Frozen", sistema.getInfoItem("Gabriel", "(83) 9999-0000", "Frozen", "Nome"));
		assertEquals("45.99", sistema.getInfoItem("Gabriel", "(83) 9999-0000", "Frozen", "Preco"));
	}

	@Test
	public void testCadastrarBluRayShow() {

		sistema.cadastrarUsuario("Gabriel", "(83) 9999-0000", "gabriel@ccc.ufcg.edu.br");
		assertEquals("1: Gabriel - Reputacao: 0,00|", sistema.listarTop10MelhoresUsuarios());

		sistema.cadastrarBluRayShow("Gabriel", "(83) 9999-0000", "Natiruts Ao Vivo em Remigio", 50.00, 140, 11, "LIVRE",
				"Natiruts");
		assertEquals("1: Gabriel - Reputacao: 2,50|", sistema.listarTop10MelhoresUsuarios());

		assertEquals("Natiruts Ao Vivo em Remigio",
				sistema.getInfoItem("Gabriel", "(83) 9999-0000", "Natiruts Ao Vivo em Remigio", "Nome"));
		assertEquals("50.0", sistema.getInfoItem("Gabriel", "(83) 9999-0000", "Natiruts Ao Vivo em Remigio", "Preco"));

	}

	@Test
	public void testCadastrarBluRaySerie() {

		sistema.cadastrarUsuario("Gabriel", "(83) 9999-0000", "gabriel@ccc.ufcg.edu.br");
		assertEquals("1: Gabriel - Reputacao: 0,00|", sistema.listarTop10MelhoresUsuarios());
		
		sistema.cadastrarBluRaySerie("Gabriel", "(83) 9999-0000", "Big Time Rush", 30.00, "BTR in Paris", 60,
				"DEZESSEIS_ANOS", "SUSPENSE", 1);
		assertEquals("1: Gabriel - Reputacao: 1,50|", sistema.listarTop10MelhoresUsuarios());

		assertEquals("Big Time Rush", sistema.getInfoItem("Gabriel", "(83) 9999-0000", "Big Time Rush", "Nome"));

		assertEquals("30.0", sistema.getInfoItem("Gabriel", "(83) 9999-0000", "Big Time Rush", "Preco"));

	}

	@Test
	public void testAtualizarItem() {
		sistema.cadastrarUsuario("Gabriel", "(83) 9999-0000", "gabriel@ccc.ufcg.edu.br");

		sistema.cadastrarJogoTabuleiro("Gabriel", "(83) 9999-0000", "Xadrez", 70.00);

		assertEquals("Xadrez", sistema.getInfoItem("Gabriel", "(83) 9999-0000", "Xadrez", "Nome"));

		sistema.atualizarItem("Gabriel", "(83) 9999-0000", "Xadrez", "Nome", "Xadrez Azul");

		assertEquals("Xadrez Azul", sistema.getInfoItem("Gabriel", "(83) 9999-0000", "Xadrez Azul", "Nome"));

		sistema.atualizarItem("Gabriel", "(83) 9999-0000", "Xadrez Azul", "Preco", "80.00");

		assertEquals("80.0", sistema.getInfoItem("Gabriel", "(83) 9999-0000", "Xadrez Azul", "Preco"));

	}

	@Test
	public void testGetInfoItem() {
		sistema.cadastrarUsuario("Gabriel", "(83) 9999-0000", "gabriel@ccc.ufcg.edu.br");

		sistema.cadastrarJogoTabuleiro("Gabriel", "(83) 9999-0000", "Xadrez", 70.00);

		assertEquals("Xadrez", sistema.getInfoItem("Gabriel", "(83) 9999-0000", "Xadrez", "Nome"));

		assertEquals("70.0", sistema.getInfoItem("Gabriel", "(83) 9999-0000", "Xadrez", "Preco"));

	}

	@Test
	public void testPesquisarDetalhesItem() {
		sistema.cadastrarUsuario("Gabriel", "(83) 9999-0000", "gabriel@ccc.ufcg.edu.br");

		sistema.cadastrarJogoTabuleiro("Gabriel", "(83) 9999-0000", "Xadrez", 70.00);

		assertEquals("JOGO DE TABULEIRO: Xadrez, R$ 70.0, Nao emprestado, COMPLETO",
				sistema.pesquisarDetalhesItem("Gabriel", "(83) 9999-0000", "Xadrez"));
	}
	
	@Test
	public void testRemoverItem(){
		sistema.cadastrarUsuario("gabriel", "9999-7777", "gabriel@ccc.ufcg.edu.br");
		sistema.cadastrarBluRayFilme("gabriel", "9999-7777", "GIJoe", 45.99, 120, "LUTA", "DEZESSEIS_ANOS", 2012);
		
		assertEquals("FILME: GIJoe, R$ 45.99, Nao emprestado, 120 min, DEZESSEIS_ANOS, OUTRO, 2012|", sistema.listarItensOrdenadosPorNome());
		sistema.removerItem("gabriel", "9999-7777", "GIJoe");
		assertEquals("", sistema.listarItensOrdenadosPorNome());
	}
	
	@Test
	public void testRemoverUsuario(){
		sistema.cadastrarUsuario("gabriel", "9999-7777", "gabriel@ccc.ufcg.edu.br");
		sistema.cadastrarBluRayFilme("gabriel", "9999-7777", "GIJoe", 45.99, 120, "LUTA", "DEZESSEIS_ANOS", 2012);
		
		assertEquals("1: gabriel - Reputacao: 2,30|", sistema.listarTop10MelhoresUsuarios());
		sistema.removerUsuario("gabriel", "9999-7777");
		assertEquals("", sistema.listarTop10MelhoresUsuarios());
	}
	

	@Test(expected = IllegalArgumentException.class)
	public void testNomeVazio() {
		sistema.cadastrarUsuario("", "(83) 9999-0000", "gabriel@ccc.ufcg.edu.br");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testTelefoneVazio() {
		sistema.cadastrarUsuario("Gabriel", "", "gabriel@ccc.ufcg.edu.br");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testEmailVazio() {
		sistema.cadastrarUsuario("Gabriel", "(83) 9999-0000", "");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testEmailNulo() {
		sistema.cadastrarUsuario("Gabriel", "(83) 9999-0000", " ");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAtributoVazio() {
		sistema.getInfoUsuario("Gabriel", "(83) 9999-0000", "");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAtributoNulo() {
		sistema.getInfoUsuario("Gabriel", "(83) 9999-0000", " ");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAtributoInvalido() {
		sistema.atualizarUsuario("Gabriel", "(83) 9999-0000", "", "mgs.gmail.com");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testValorVazio() {
		sistema.atualizarUsuario("Gabriel", "(83) 9999-0000", "Email", "");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testVerificaNomeItemVazio() {
		sistema.cadastrarJogoTabuleiro("Gabriel", "(83) 9999-0000", "", 70.00);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testVerificaNomeItemNulo() {
		sistema.cadastrarJogoTabuleiro("Gabriel", "(83) 9999-0000", " ", 70.00);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testVerificaValorItemZero() {
		sistema.cadastrarJogoTabuleiro("Gabriel", "(83) 9999-0000", "Xadrez ", 0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testVerificaValorItemMenorQueZero() {
		sistema.cadastrarJogoTabuleiro("Gabriel", "(83) 9999-0000", "Xadrez ", -1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testVerificaPlataformaNula() {
		sistema.cadastrarEletronico("Gabriel", "(83) 9999-0000", "GTA V", 150.00, " ");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testVerificaPlataformaVazia() {
		sistema.cadastrarEletronico("Gabriel", "(83) 9999-0000", "GTA V", 150.00, "");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testDuracaoZero() {
		sistema.cadastrarBluRayFilme("Gabriel", "(83) 9999-0000", "Frozen", 45.99, 0, "ANIMACAO", "LIVRE", 2013);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testDuracaoNegativa() {
		sistema.cadastrarBluRayFilme("Gabriel", "(83) 9999-0000", "Frozen", 45.99, -1, "ANIMACAO", "LIVRE", 2013);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testGeneroVazio() {
		sistema.cadastrarBluRayFilme("Gabriel", "(83) 9999-0000", "Frozen", 45.99, 120, " ", "LIVRE", 2013);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testClassificacaoVazia() {
		sistema.cadastrarBluRayFilme("Gabriel", "(83) 9999-0000", "Frozen", 45.99, 120, "ANIMACAO", "", 2013);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAnoLancamentoZero() {
		sistema.cadastrarBluRayFilme("Gabriel", "(83) 9999-0000", "Frozen", 45.99, 120, "ANIMACAO", "LIVRE", 0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAnoLancamentoZeroNulo() {
		sistema.cadastrarBluRayFilme("Gabriel", "(83) 9999-0000", "Frozen", 45.99, 120, "ANIMACAO", "LIVRE", -2013);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testNumeroFaixasZero() {
		sistema.cadastrarBluRayShow("Gabriel", "(83) 9999-0000", "Natiruts Ao Vivo em Remigio", 50.00, 140, 0, "LIVRE",
				"Natiruts");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testNumeroFaixasNegativo() {
		sistema.cadastrarBluRayShow("Gabriel", "(83) 9999-0000", "Natiruts Ao Vivo em Remigio", 50.00, 140, -11,
				"LIVRE", "Natiruts");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testDescricaoVazia() {
		sistema.cadastrarBluRaySerie("Gabriel", "(83) 9999-0000", "Big Time Rush", 30.00, "", 60, "DEZESSEIS_ANOS",
				"SUSPENSE", 1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testDescricaoNula() {
		sistema.cadastrarBluRaySerie("Gabriel", "(83) 9999-0000", "Big Time Rush", 30.00, "  ", 60, "DEZESSEIS_ANOS",
				"SUSPENSE", 1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testTemporadaZero() {
		sistema.cadastrarBluRaySerie("Gabriel", "(83) 9999-0000", "Big Time Rush", 30.00, " btr in paris ", 60,
				"DEZESSEIS_ANOS", "SUSPENSE", 0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testTemporadaNegativa() {
		sistema.cadastrarBluRaySerie("Gabriel", "(83) 9999-0000", "Big Time Rush", 30.00, " btr in paris ", 60,
				"DEZESSEIS_ANOS", "SUSPENSE", -1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testVerificaPecaVazia() {
		sistema.adicionarPecaPerdida("Gabriel", "(83) 9999-0000", "Jogo da Vida", "");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testVerificaPecaNula() {
		sistema.adicionarPecaPerdida("Gabriel", "(83) 9999-0000", "Jogo da Vida", "  ");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testDataEmprestimoVazia() {
		sistema.registrarEmprestimo("Gabriel", "(83) 9999-0000", "Thiago", "(83) 8899-0000", "Natiruts em Remigio", "",
				1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testDataEmprestimoNula() {
		sistema.registrarEmprestimo("Gabriel", "(83) 9999-0000", "Thiago", "(83) 8899-0000", "Natiruts em Remigio",
				"  ", 1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testPeriodoZero() {
		sistema.registrarEmprestimo("Gabriel", "(83) 9999-0000", "Thiago", "(83) 8899-0000", "Natiruts em Remigio",
				"10/08/2017", 0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testPeriodoNegativo() {
		sistema.registrarEmprestimo("Gabriel", "(83) 9999-0000", "Thiago", "(83) 8899-0000", "Natiruts em Remigio",
				"10/08/2017", -1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testDataDevolucaoVazia() throws ParseException {
		sistema.devolverItem("Gabriel", "(83) 9999-0000", "Thiago", "(83) 8899-0000", "Natiruts em Remigio",
				"10/08/2017", "");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testDataDevolucaoNula() throws ParseException {
		sistema.devolverItem("Gabriel", "(83) 9999-0000", "Thiago", "(83) 8899-0000", "Natiruts em Remigio",
				"10/08/2017", "  ");
	}
	
	@Test
	public void testAdicionarPecaPerdida(){
		sistema.cadastrarUsuario("Gabriel", "(83) 9999-0000", "gabriel@ccc.ufcg.edu.br");
		sistema.cadastrarJogoTabuleiro("Gabriel", "(83) 9999-0000", "Xadrez", 70.00);
		
		assertEquals("JOGO DE TABULEIRO: Xadrez, R$ 70.0, Nao emprestado, COMPLETO", sistema.pesquisarDetalhesItem("Gabriel", "(83) 9999-0000", "Xadrez"));
		sistema.adicionarPecaPerdida("Gabriel", "(83) 9999-0000", "Xadrez", "Torre");
		assertEquals("JOGO DE TABULEIRO: Xadrez, R$ 70.0, Nao emprestado, COM PECAS PERDIDAS", sistema.pesquisarDetalhesItem("Gabriel", "(83) 9999-0000", "Xadrez"));
	}
	
	@Test
	public void testListarCaloteiros(){
		sistema.cadastrarUsuario("gabriel", "9999-7777", "gabriel@ccc.ufcg.edu.br");
		sistema.cadastrarEletronico("gabriel", "9999-7777", "GTA V", 150.00, "PS4");
		sistema.cadastrarEletronico("gabriel", "9999-7777", "GIJoe", 150.00, "PS4");
		sistema.cadastrarUsuario("thiago", "8888-9999", "thiago@ccc.ufcg.edu.br");
		sistema.cadastrarUsuario("marcelo", "9999-8888", "marcelo@ccc.ufcg.edu.br");
		sistema.registrarEmprestimo("gabriel", "9999-7777", "thiago", "8888-9999", "GTA V", "21/08/2017", 3);
		sistema.registrarEmprestimo("gabriel", "9999-7777", "marcelo", "9999-8888", "GIJoe", "21/08/2017", 3);
		sistema.devolverItem("gabriel", "9999-7777", "thiago", "8888-9999", "GTA V", "21/08/2017", "30/08/2017");
		sistema.devolverItem("gabriel", "9999-7777", "marcelo", "9999-8888", "GIJoe", "21/08/2017", "30/08/2017");
		
		assertEquals("Lista de usuarios com reputacao negativa: marcelo, marcelo@ccc.ufcg.edu.br, 9999-8888|thiago, thiago@ccc.ufcg.edu.br, 8888-9999|", sistema.listarCaloteiros());
	}
	
	@Test
	public void testListarEmprestimosItem(){
		sistema.cadastrarUsuario("gabriel", "9999-7777", "gabriel@ccc.ufcg.edu.br");
		sistema.cadastrarEletronico("gabriel", "9999-7777", "GIJoe", 150.00, "PS4");
		sistema.cadastrarUsuario("thiago", "8888-9999", "thiago@ccc.ufcg.edu.br");
		sistema.cadastrarUsuario("marcelo", "9999-8888", "marcelo@ccc.ufcg.edu.br");
		
		sistema.registrarEmprestimo("gabriel", "9999-7777", "thiago", "8888-9999", "GIJoe", "14/07/2017", 3);
		sistema.devolverItem("gabriel", "9999-7777", "thiago", "8888-9999", "GIJoe", "14/07/2017", "20/07/2017");
		sistema.registrarEmprestimo("gabriel", "9999-7777", "marcelo", "9999-8888", "GIJoe", "21/08/2017", 3);
		
		assertEquals("Emprestimos associados ao item: EMPRESTIMO - De: gabriel, Para: thiago, GIJoe, 14/07/2017, 3 dias, ENTREGA: 20/07/2017|"
				+ "EMPRESTIMO - De: gabriel, Para: marcelo, GIJoe, 21/08/2017, 3 dias, ENTREGA: Emprestimo em andamento|", sistema.listarEmprestimosItem("GIJoe"));
	}
	
	@Test
	public void testListarEmprestimosUsuarioEmprestando(){
		sistema.cadastrarUsuario("gabriel", "9999-7777", "gabriel@ccc.ufcg.edu.br");
		sistema.cadastrarUsuario("thiago", "8888-9999", "thiago@ccc.ufcg.edu.br");
		sistema.cadastrarEletronico("gabriel", "9999-7777", "GIJoe", 150.00, "PS4");
		sistema.cadastrarEletronico("gabriel", "9999-7777", "GTA V", 150.00, "PS4");
		sistema.registrarEmprestimo("gabriel", "9999-7777", "thiago", "8888-9999", "GIJoe", "14/07/2017", 5);
		sistema.registrarEmprestimo("gabriel", "9999-7777", "thiago", "8888-9999", "GTA V", "20/07/2017", 3);
		
		assertEquals("Emprestimos: EMPRESTIMO - De: gabriel, Para: thiago, GIJoe, 14/07/2017, 5 dias, ENTREGA: Emprestimo em andamento|"
				+ "EMPRESTIMO - De: gabriel, Para: thiago, GTA V, 20/07/2017, 3 dias, ENTREGA: Emprestimo em andamento|",
				sistema.listarEmprestimosUsuarioEmprestando("gabriel", "9999-7777"));
	}
	
	@Test
	public void testListarEmprestimosUsuarioPegandoEmprestado(){
		sistema.cadastrarUsuario("gabriel", "9999-7777", "gabriel@ccc.ufcg.edu.br");
		sistema.cadastrarUsuario("thiago", "8888-9999", "thiago@ccc.ufcg.edu.br");
		sistema.cadastrarEletronico("thiago", "8888-9999", "GIJoe", 150.00, "PS4");
		assertEquals("Nenhum item pego emprestado", sistema.listarEmprestimosUsuarioPegandoEmprestado("gabriel", "9999-7777"));
		sistema.registrarEmprestimo("thiago", "8888-9999","gabriel", "9999-7777", "GIJoe", "14/07/2017", 5);
		assertEquals("Emprestimos pegos: EMPRESTIMO - De: thiago, Para: gabriel, GIJoe, 14/07/2017, 5 dias, ENTREGA: Emprestimo em andamento|",
				sistema.listarEmprestimosUsuarioPegandoEmprestado("gabriel", "9999-7777"));
	}
	
	@Test
	public void testListarItensEmprestados(){
		sistema.cadastrarUsuario("gabriel", "9999-7777", "gabriel@ccc.ufcg.edu.br");
		sistema.cadastrarUsuario("thiago", "8888-9999", "thiago@ccc.ufcg.edu.br");
		sistema.cadastrarEletronico("gabriel", "9999-7777", "GTA V", 150.00, "PS4");
		sistema.registrarEmprestimo("gabriel", "9999-7777", "thiago", "8888-9999", "GTA V", "14/07/2017", 5);
		
		assertEquals("Dono do item: gabriel, Nome do item emprestado: GTA V|", sistema.listarItensEmprestados());
	}
	
	@Test
	public void testListarItensNaoEmprestados(){
		sistema.cadastrarUsuario("gabriel", "9999-7777", "gabriel@ccc.ufcg.edu.br");
		sistema.cadastrarUsuario("thiago", "8888-9999", "thiago@ccc.ufcg.edu.br");
		sistema.cadastrarEletronico("thiago", "8888-9999", "GIJoe", 140.00, "PS4");
		sistema.cadastrarEletronico("thiago", "8888-9999", "GTA V", 150.00, "PS4");
		
		assertEquals("JOGO ELETRONICO: GIJoe, R$ 140.0, Nao emprestado, PS4|"
				+ "JOGO ELETRONICO: GTA V, R$ 150.0, Nao emprestado, PS4|", sistema.listarItensNaoEmprestados());
	}
	
	@Test
	public void testListarItensOrdenadosPorNome(){
		sistema.cadastrarUsuario("thiago", "8888-9999", "thiago@ccc.ufcg.edu.br");
		sistema.cadastrarEletronico("thiago", "8888-9999", "GTA V", 150.00, "PS4");
		sistema.cadastrarEletronico("thiago", "8888-9999", "GIJoe", 140.00, "PS4");
		
		assertEquals("JOGO ELETRONICO: GIJoe, R$ 140.0, Nao emprestado, PS4|JOGO ELETRONICO: GTA V, R$ 150.0, Nao emprestado, PS4|", sistema.listarItensOrdenadosPorNome());
	}
	
	@Test
	public void testListarItensOrdenadosPorValor(){
		
		sistema.cadastrarUsuario("thiago", "8888-9999", "thiago@ccc.ufcg.edu.br");
		sistema.cadastrarEletronico("thiago", "8888-9999", "GIJoe", 150.00, "PS4");
		sistema.cadastrarEletronico("thiago", "8888-9999", "GTA V", 200.00, "PS4");
		sistema.cadastrarEletronico("thiago", "8888-9999", "ARGUS", 99.99, "PS4");
		
		assertEquals("JOGO ELETRONICO: ARGUS, R$ 99.99, Nao emprestado, PS4|JOGO ELETRONICO: GIJoe, R$ 150.0, Nao emprestado, PS4|"
				+ "JOGO ELETRONICO: GTA V, R$ 200.0, Nao emprestado, PS4|", sistema.listarItensOrdenadosPorValor());
	}
	
	
	@Test
	public void testListarTop10Itens(){
		sistema.cadastrarUsuario("gabriel", "9999-7777", "gabriel@ccc.ufcg.edu.br");
		sistema.cadastrarUsuario("thiago", "8888-9999", "thiago@ccc.ufcg.edu.br");
		
		sistema.cadastrarEletronico("thiago", "8888-9999", "GIJoe", 150.00, "PS4");
		sistema.cadastrarBluRayFilme("gabriel", "9999-7777", "300", 42.50, 120, "LUTA", "DEZOITO_ANOS", 2014);
		
		sistema.registrarEmprestimo("gabriel", "9999-7777", "thiago", "8888-9999", "300", "21/08/2017", 4);
		sistema.devolverItem("gabriel", "9999-7777", "thiago", "8888-9999", "300", "21/08/2017", "25/08/2017");
		sistema.registrarEmprestimo("gabriel", "9999-7777", "thiago", "8888-9999", "300", "28/08/2017", 4);
		sistema.devolverItem("gabriel", "9999-7777", "thiago", "8888-9999", "300", "21/08/2017", "01/09/2017");
		
		sistema.registrarEmprestimo("thiago", "8888-9999", "gabriel", "9999-7777", "GIJoe", "28/08/2017", 4);
		sistema.devolverItem("thiago", "8888-9999", "gabriel", "9999-7777", "GIJoe", "28/08/2017", "01/09/2017");
		
		
		assertEquals("1) 2 emprestimos - FILME: 300, R$ 42.5, Nao emprestado, 120 min, DEZOITO_ANOS, OUTRO, 2014"
				+ "|2) 1 emprestimos - JOGO ELETRONICO: GIJoe, R$ 150.0, Nao emprestado, PS4|", sistema.listarTop10Itens());
	}
	
	
	@Test
	public void testListarTop10MelhoresUsuarios(){
		
		sistema.cadastrarUsuario("gabriel", "9999-7777", "gabriel@ccc.ufcg.edu.br");
		sistema.cadastrarUsuario("thiago", "8888-9999", "thiago@ccc.ufcg.edu.br");
		sistema.cadastrarEletronico("gabriel", "9999-7777", "GTA V", 150.00, "PS4");
		sistema.cadastrarEletronico("gabriel", "9999-7777", "PES 2017", 350.00, "PS4");
		sistema.cadastrarEletronico("thiago", "8888-9999", "GIJoe", 140.00, "PS4");

		assertEquals("1: gabriel - Reputacao: 25,00|2: thiago - Reputacao: 7,00|", sistema.listarTop10MelhoresUsuarios());
		
	}
	
	
	@Test
	public void testListarTop10PioresUsuarios(){
		sistema.cadastrarUsuario("gabriel", "9999-7777", "gabriel@ccc.ufcg.edu.br");
		sistema.cadastrarUsuario("thiago", "8888-9999", "thiago@ccc.ufcg.edu.br");
		sistema.cadastrarUsuario("marcelo", "9999-8888", "marcelo@ccc.ufcg.edu.br");
		
		sistema.cadastrarEletronico("gabriel", "9999-7777", "GTA V", 150.00, "PS4");
		sistema.cadastrarEletronico("gabriel", "9999-7777", "PES 2017", 350.00, "PS4");
		sistema.cadastrarEletronico("gabriel", "9999-7777", "GIJoe", 140.00, "PS4");
		
		sistema.registrarEmprestimo("gabriel", "9999-7777", "thiago", "8888-9999", "GTA V", "21/08/2017", 3);
		sistema.devolverItem("gabriel", "9999-7777", "thiago", "8888-9999", "GTA V", "21/08/2017", "28/08/2017");
		
		assertEquals("1: thiago - Reputacao: -6,00|2: marcelo - Reputacao: 0,00|3: gabriel - Reputacao: 47,00|", sistema.listarTop10PioresUsuarios());
	}
	
}
