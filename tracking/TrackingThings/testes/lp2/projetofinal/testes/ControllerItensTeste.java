package lp2.projetofinal.testes;

/**
 * Classe responsavel por conter testes para metodos de um objeto do tipo ControllerItens,
 * (controller que possui uma colecao de itens adicionados pelos usuarios do Traking Things).
 * 
 * Laboratorio de Programacao 2 - Projeto Final Parte 01
 * 
 * @author Thiago Santos de Moura - 116210967
 * @author Gabriel Almeida Azevedo - 116210009
 * @author Marcelo Gabriel dos Santos Queiroz Vitorino - 116211290
 */
import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import lp2.projetofinal.controllers.ControllerItens;
import lp2.projetofinal.entidades.Item;
import lp2.projetofinal.entidades.JogoEletronico;
import lp2.projetofinal.entidades.JogoTabuleiro;

public class ControllerItensTeste {

	private ControllerItens controllerItens;
	private Set<Item> listaItens;
	
	@Before
	public void criaControllerItensEUsuarios(){
		controllerItens = new ControllerItens();
		listaItens = new HashSet<>();
	}
	
	@Test
	public void testConstrutorControllerItens() {
		assertEquals("", controllerItens.listarItensOrdenadosPorNome(listaItens));
	}

	@Test
	public void testAdicionaItemSetStringDoubleString() {
		controllerItens.adicionaItem(listaItens, "PES 2017", 145.00, "PS4");
		assertEquals("JOGO ELETRONICO: PES 2017, R$ 145.0, Nao emprestado, PS4|", controllerItens.listarItensOrdenadosPorNome(listaItens));
	}

	@Test
	public void testAdicionaItemSetStringDouble() {
		controllerItens.adicionaItem(listaItens, "WAR", 200.00);
		assertEquals("JOGO DE TABULEIRO: WAR, R$ 200.0, Nao emprestado, COMPLETO|", controllerItens.listarItensOrdenadosPorNome(listaItens));
	}

	@Test
	public void testAdicionaItemSetStringDoubleIntStringStringInt() {
		controllerItens.adicionaItem(listaItens, "Velozes e Furiosos 7", 39.99, 123, "ACAO", "DEZESSEIS_ANOS", 2017);
		assertEquals("FILME: Velozes e Furiosos 7, R$ 39.99, Nao emprestado, 123 min, DEZESSEIS_ANOS, ACAO, 2017|", controllerItens.listarItensOrdenadosPorNome(listaItens));
	}

	@Test
	public void testAdicionaItemSetStringDoubleIntIntStringString() {
		controllerItens.adicionaItem(listaItens, "Os Anjos Cantam", 25.90, 110, 12, "Jorge e Matheus", "LIVRE");
		assertEquals("SHOW: Os Anjos Cantam, R$ 25.9, Nao emprestado, 110 min, LIVRE, Jorge e Matheus, 12 faixas|", controllerItens.listarItensOrdenadosPorNome(listaItens));
	}

	@Test
	public void testAdicionaItemSetStringDoubleStringIntStringStringInt() {
		controllerItens.adicionaItem(listaItens, "Big Time Rush", 30.00,"BTR in Paris", 60,"DEZESSEIS_ANOS","MUSICAL", 1);
		assertEquals("SERIE: Big Time Rush, R$ 30.0, Nao emprestado, 60 min, DEZESSEIS_ANOS, MUSICAL, Temporada 1|", controllerItens.listarItensOrdenadosPorNome(listaItens));
	}

	@Test
	public void testCadastrarPecaPerdidaNoTabuleiro() {
		controllerItens.adicionaItem(listaItens, "WAR", 200.00);
		assertEquals("JOGO DE TABULEIRO: WAR, R$ 200.0, Nao emprestado, COMPLETO|", controllerItens.listarItensOrdenadosPorNome(listaItens));
		controllerItens.cadastrarPecaPerdidaNoTabuleiro(listaItens, "WAR", "Dado Amarelo");
		assertEquals("JOGO DE TABULEIRO: WAR, R$ 200.0, Nao emprestado, COM PECAS PERDIDAS|", controllerItens.listarItensOrdenadosPorNome(listaItens));
	}

	@Test
	public void testAtualizarItem() {
		controllerItens.adicionaItem(listaItens, "WAR", 200.00);
		assertEquals("JOGO DE TABULEIRO: WAR, R$ 200.0, Nao emprestado, COMPLETO|", controllerItens.listarItensOrdenadosPorNome(listaItens));
		controllerItens.atualizarItem(listaItens, "WAR", "Nome", "WAR - IMPERIO ROMANO");
		assertEquals("JOGO DE TABULEIRO: WAR - IMPERIO ROMANO, R$ 200.0, Nao emprestado, COMPLETO|", controllerItens.listarItensOrdenadosPorNome(listaItens));
		controllerItens.atualizarItem(listaItens, "WAR - IMPERIO ROMANO", "Preco", "220.00");
		assertEquals("JOGO DE TABULEIRO: WAR - IMPERIO ROMANO, R$ 220.0, Nao emprestado, COMPLETO|", controllerItens.listarItensOrdenadosPorNome(listaItens));
	}

	@Test
	public void testRemoverItem() {
		controllerItens.adicionaItem(listaItens, "WAR", 200.00);
		assertEquals("JOGO DE TABULEIRO: WAR, R$ 200.0, Nao emprestado, COMPLETO|", controllerItens.listarItensOrdenadosPorNome(listaItens));
		controllerItens.removerItem(listaItens, "WAR");
		assertEquals("", controllerItens.listarItensOrdenadosPorNome(listaItens));
	}

	@Test
	public void testGetInfoItem() {
		controllerItens.adicionaItem(listaItens, "Big Time Rush", 30.00,"BTR in Paris", 60,"DEZESSEIS_ANOS","MUSICAL", 1);
		assertEquals("Big Time Rush", controllerItens.getInfoItem(listaItens, "Big Time Rush", "Nome"));
		assertEquals("30.0", controllerItens.getInfoItem(listaItens, "Big Time Rush", "Preco"));

	}

	@Test
	public void testGetDetalhesItem() {
		controllerItens.adicionaItem(listaItens, "WAR", 200.00);
		controllerItens.adicionaItem(listaItens, "Os Anjos Cantam", 25.90, 110, 12, "Jorge e Matheus", "LIVRE");
		assertEquals("JOGO DE TABULEIRO: WAR, R$ 200.0, Nao emprestado, COMPLETO", controllerItens.getDetalhesItem(listaItens, "WAR"));
		assertEquals("SHOW: Os Anjos Cantam, R$ 25.9, Nao emprestado, 110 min, LIVRE, Jorge e Matheus, 12 faixas", controllerItens.getDetalhesItem(listaItens, "Os Anjos Cantam"));
	}

	@Test
	public void testListarItensOrdenadosPorNome() {
		controllerItens.adicionaItem(listaItens, "PES 2017", 145.00, "PS4");
		controllerItens.adicionaItem(listaItens, "WAR", 200.00);
		controllerItens.adicionaItem(listaItens, "Velozes e Furiosos 7", 39.99, 123, "ACAO", "DEZESSEIS_ANOS", 2017);
		controllerItens.adicionaItem(listaItens, "Os Anjos Cantam", 25.90, 110, 12, "Jorge e Matheus", "LIVRE");
		controllerItens.adicionaItem(listaItens, "Big Time Rush", 30.00,"BTR in Paris", 60,"DEZESSEIS_ANOS","MUSICAL", 1);
		assertEquals("SERIE: Big Time Rush, R$ 30.0, Nao emprestado, 60 min, DEZESSEIS_ANOS, MUSICAL, Temporada 1|SHOW: Os Anjos Cantam, R$ 25.9, Nao emprestado, 110 min, LIVRE, Jorge e Matheus, 12 faixas|"
				+ "JOGO ELETRONICO: PES 2017, R$ 145.0, Nao emprestado, PS4|FILME: Velozes e Furiosos 7, R$ 39.99, Nao emprestado, 123 min, DEZESSEIS_ANOS, ACAO, 2017|"
				+ "JOGO DE TABULEIRO: WAR, R$ 200.0, Nao emprestado, COMPLETO|" ,controllerItens.listarItensOrdenadosPorNome(listaItens));
	}

	@Test
	public void testListarItensOrdenadosPorValor() {
		controllerItens.adicionaItem(listaItens, "PES 2017", 145.00, "PS4");
		controllerItens.adicionaItem(listaItens, "WAR", 200.00);
		controllerItens.adicionaItem(listaItens, "Velozes e Furiosos 7", 39.99, 123, "ACAO", "DEZESSEIS_ANOS", 2017);
		controllerItens.adicionaItem(listaItens, "Os Anjos Cantam", 25.90, 110, 12, "Jorge e Matheus", "LIVRE");
		controllerItens.adicionaItem(listaItens, "Big Time Rush", 30.00,"BTR in Paris", 60,"DEZESSEIS_ANOS","MUSICAL", 1);
		assertEquals("SHOW: Os Anjos Cantam, R$ 25.9, Nao emprestado, 110 min, LIVRE, Jorge e Matheus, 12 faixas|SERIE: Big Time Rush, R$ 30.0, Nao emprestado, 60 min, DEZESSEIS_ANOS, MUSICAL, Temporada 1|"
				+ "FILME: Velozes e Furiosos 7, R$ 39.99, Nao emprestado, 123 min, DEZESSEIS_ANOS, ACAO, 2017|JOGO ELETRONICO: PES 2017, R$ 145.0, Nao emprestado, PS4|"
				+ "JOGO DE TABULEIRO: WAR, R$ 200.0, Nao emprestado, COMPLETO|", controllerItens.listarItensOrdenadosPorValor(listaItens));
	}

	@Test
	public void testIdentificaItemUsuario() {
		JogoEletronico Pes = new JogoEletronico("PES 2017", 145.00, "PS4");
		JogoTabuleiro WAR = new JogoTabuleiro("WAR", 200.00);
		controllerItens.adicionaItem(listaItens, "PES 2017", 145.00, "PS4");
		controllerItens.adicionaItem(listaItens, "WAR", 200.00);
		assertEquals(Pes, controllerItens.identificaItem(listaItens, "PES 2017"));
		assertEquals(WAR, controllerItens.identificaItem(listaItens, "WAR"));
	}
	
}