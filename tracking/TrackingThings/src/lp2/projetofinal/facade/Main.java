package lp2.projetofinal.facade;

/**
 * Classe responsavel por rodar os testes do easyAccept.
 * 
 * Laboratorio de Programacao 2 - Projeto Final Parte 01
 * 
 * @author Thiago Santos de Moura - 116210967
 * @author Gabriel Almeida Azevedo - 116210009
 * @author Marcelo Gabriel dos Santos Queiroz Vitorino - 116211290
 */

import java.io.File;
import java.util.ArrayList;

import easyaccept.EasyAccept;

public class Main {

	public static void main(String[] args) throws Exception {
		
		ArrayList<String> testes = new ArrayList<>();
		testes.add("acceptance_test" + File.separator + "us1_test.txt");
		testes.add("acceptance_test" + File.separator + "us2_test.txt");
		testes.add("acceptance_test" + File.separator + "us3_test.txt");
		testes.add("acceptance_test" + File.separator + "us4_test.txt");
		testes.add("acceptance_test" + File.separator + "us5_test.txt");
		testes.add("acceptance_test" + File.separator + "us6_test.txt");
		testes.add("acceptance_test" + File.separator + "us7_test.txt");
		testes.add("acceptance_test" + File.separator + "us8_test.txt");
		
		//Rodar esse teste, limpará a persistência.
		//testes.add("acceptance_test/persistencia" + File.separator + "resetarPersistencia.txt");
		
		EasyAccept.executeEasyAcceptTests("lp2.projetofinal.facade.Facade", testes);
}
	
}