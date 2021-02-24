package lp2.projetofinal.testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import lp2.projetofinal.controllers.ControllerUsuario;
import lp2.projetofinal.entidades.Usuario;

public class ControllerUsuarioTeste {

	private ControllerUsuario controllerUsuario;

	@Before
	public void criaControllerUsuario() {
		controllerUsuario = new ControllerUsuario();
		controllerUsuario.cadastrarUsuario("Thiago", "(83) 9898-0000", "thiago@ccc.ufcg.edu.br");
	}

	@Test
	public void testGetInfoUsuario() {
		assertEquals("thiago@ccc.ufcg.edu.br", controllerUsuario.getInfoUsuario("Thiago", "(83) 9898-0000", "Email"));
		assertEquals("(83) 9898-0000", controllerUsuario.getInfoUsuario("Thiago", "(83) 9898-0000", "Telefone"));
		assertEquals("Thiago", controllerUsuario.getInfoUsuario("Thiago", "(83) 9898-0000", "Nome"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testGetInfoUsuarioATRIBUTOINVALIDO() {
		controllerUsuario.getInfoUsuario("Gabriel", "(83) 9999-0000", "email");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testGetInfoUsuarioUSUARIONAOEXISTENTE() {
		controllerUsuario.getInfoUsuario("Gabriel", "(83) 9999-0000", "Email");
	}

	@Test
	public void testCadastrarUsuario() {
		controllerUsuario.cadastrarUsuario("Gabriel", "(83) 9999-0000", "gabriel@ccc.ufcg.edu.br");
		assertEquals("gabriel@ccc.ufcg.edu.br", controllerUsuario.getInfoUsuario("Gabriel", "(83) 9999-0000", "Email"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCadastrarUsuarioUSUARIOJAEXISTENTE() {
		controllerUsuario.cadastrarUsuario("Thiago", "(83) 9898-0000", "thiago@ccc.ufcg.edu.br");
	}

	@Test
	public void testAtualizarUsuario() {
		controllerUsuario.atualizarUsuario("Thiago", "(83) 9898-0000", "Email", "thiagoSantos@ccc.ufcg.edu.br");
		assertEquals("thiagoSantos@ccc.ufcg.edu.br",
				controllerUsuario.getInfoUsuario("Thiago", "(83) 9898-0000", "Email"));
		controllerUsuario.atualizarUsuario("Thiago", "(83) 9898-0000", "Telefone", "(84) 9898-0000");
		assertEquals("(84) 9898-0000", controllerUsuario.getInfoUsuario("Thiago", "(84) 9898-0000", "Telefone"));
		controllerUsuario.atualizarUsuario("Thiago", "(84) 9898-0000", "Nome", "Marcelo");
		assertEquals("Marcelo", controllerUsuario.getInfoUsuario("Marcelo", "(84) 9898-0000", "Nome"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAtualizarUsuarioUSUARIOINVALIDO() {
		controllerUsuario.atualizarUsuario("Joao", "(83) 9999-9999", "Telefone", "(83) 9999-8888");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAtualizarUsuarioATRIBUTOINVALIDO() {
		controllerUsuario.atualizarUsuario("Thiago", "(83) 9898-0000", "email", "thiagoSantos@ccc.ufcg.edu.br");
	}

	@Test
	public void testIdentificaUsuario() {
		Usuario usuario = new Usuario("Thiago", "thiago@ccc.ufcg.edu.br", "(83) 9898-0000");
		assertEquals(usuario, controllerUsuario.identificaUsuario("Thiago", "(83) 9898-0000"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testRemoverUsuarioEIdentificaUsuarioUSUARIOINVALIDO() {
		controllerUsuario.removerUsuario("Thiago", "(83) 9898-0000");
		controllerUsuario.identificaUsuario("Thiago", "(83) 9898-0000");
	}
	
	@Test
	public void testAtualizaReputacao() {
		controllerUsuario.cadastrarUsuario("Marcelo", "(83) 9898-0000", "marcelo@ccc.ufcg.edu.br");
		
		assertEquals(0.0, controllerUsuario.identificaUsuario("Marcelo", "(83) 9898-0000").getReputacao(),0.01);
	
		controllerUsuario.atualizaReputacao("Marcelo", "(83) 9898-0000", 100, true);
		
		assertEquals(100, controllerUsuario.identificaUsuario("Marcelo", "(83) 9898-0000").getReputacao(),0.01);
		
		controllerUsuario.atualizaReputacao("Marcelo", "(83) 9898-0000", 101, false);
		
		assertEquals(-1, controllerUsuario.identificaUsuario("Marcelo", "(83) 9898-0000").getReputacao(),0.01);
	}
	
	@Test
	public void testAtualizaCartaoFidelidade() {
		controllerUsuario.cadastrarUsuario("MarceloG", "(83) 9898-00000", "marcelo@ccc.ufcg.edu.br");
		
		assertEquals("FreeRyder", controllerUsuario.identificaUsuario("MarceloG", "(83) 9898-00000").getCartao().getNomeCartao());
		
		controllerUsuario.atualizaReputacao("MarceloG", "(83) 9898-00000", 101, true);
		
		assertEquals("BomAmigo", controllerUsuario.identificaUsuario("MarceloG", "(83) 9898-00000").getCartao().getNomeCartao());
		
		controllerUsuario.atualizaReputacao("MarceloG", "(83) 9898-00000", 102, false);

		assertEquals("Caloteiro", controllerUsuario.identificaUsuario("MarceloG", "(83) 9898-00000").getCartao().getNomeCartao());
		
	
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testVerificaFidelidadeUsuarioNAOPODEPEGARITEMEMPRESTADO() {
		controllerUsuario.cadastrarUsuario("Thiago", "(83) 9898-0000", "thiago@ccc.ufcg.edu.br");

		controllerUsuario.atualizaReputacao("Thiago", "(83) 9898-0000", -1000000, false);

		controllerUsuario.verificaFidelidadeUsuario("Thiago", "(83) 9898-0000");
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testVerificaDisponibilidaDeUsuarioNAOPODEPEGARITEMEMNESSEPERIODO() {
		controllerUsuario.cadastrarUsuario("ThiagoA", "(83) 9898-0000", "thiago@ccc.ufcg.edu.br");

		controllerUsuario.atualizaReputacao("ThiagoA", "(83) 9898-0000", 10,true);
		
		assertEquals("FreeRyder", controllerUsuario.identificaUsuario("ThiagoA", "(83) 9898-0000").getCartao().getNomeCartao());
		
		controllerUsuario.verificadisponibilidadeUsuario("Thiago", "(83) 9898-0000",6);
	}
	
	@Test
	public void testListarCaloteiros() {
		controllerUsuario.cadastrarUsuario("Marcelo", "(83) 9898-0000", "marcelo@ccc.ufcg.edu.br");
	
		controllerUsuario.atualizaReputacao("Marcelo", "(83) 9898-0000", 100, false);
		
		controllerUsuario.cadastrarUsuario("Marcelle", "(83) 9898-0001", "marcelle@ccc.ufcg.edu.br");
		
		
		controllerUsuario.atualizaReputacao("Marcelle", "(83) 9898-0001", 101, false);
		
		assertEquals("Lista de usuarios com reputacao negativa: Marcelle, marcelle@ccc.ufcg.edu.br, (83) 9898-0001|Marcelo, marcelo@ccc.ufcg.edu.br, (83) 9898-0000|", controllerUsuario.listarCaloteiros());
	}
	
	@Test
	public void testListarTop10PioresUsuarios() {
		controllerUsuario.cadastrarUsuario("MarceloGA", "(83) 9898-0000", "marcelo@ccc.ufcg.edu.br");
	
		controllerUsuario.atualizaReputacao("MarceloGA", "(83) 9898-0000", 100, true);
		
		controllerUsuario.cadastrarUsuario("Marcelle", "(83) 9898-0001", "marcelle@ccc.ufcg.edu.br");
		
		controllerUsuario.atualizaReputacao("Marcelle", "(83) 9898-0001", 101, true);
		
		assertEquals("1: Thiago - Reputacao: 0,00|2: MarceloGA - Reputacao: 100,00|3: Marcelle - Reputacao: 101,00|", controllerUsuario.listarTop10PioresUsuarios());
	} 
}
