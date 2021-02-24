package lp2.projetofinal.testes;

/**
 * Classe responsavel por conter testes para metodos de um objeto do EpisodioSerie(objeto que compoe BluRaySerie).
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

import lp2.projetofinal.entidades.EpisodioSerie;

public class EpisodioSerieTeste {

	private EpisodioSerie episodio1;
	private EpisodioSerie episodio2;
	
	@Before
	public void criaEpisodioSerie(){
		episodio1 = new EpisodioSerie(45);
		episodio2 = new EpisodioSerie(43);
	}
	@Test
	public void testConstrutorEpisodioSerie() {
		assertEquals(45, episodio1.getDuracao());
		assertEquals(43, episodio2.getDuracao());
	}

}
