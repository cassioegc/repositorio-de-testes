package lp2.projetofinal.suitetest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import lp2.projetofinal.testes.BluRayFilmeTeste;
import lp2.projetofinal.testes.BluRaySerieTest;
import lp2.projetofinal.testes.BluRayShowTeste;
import lp2.projetofinal.testes.CartaoBomAmigoTeste;
import lp2.projetofinal.testes.CartaoCaloteiroTeste;
import lp2.projetofinal.testes.CartaoFreeRyderTeste;
import lp2.projetofinal.testes.CartaoNoobTeste;
import lp2.projetofinal.testes.ChaveNomeTelefoneTeste;
import lp2.projetofinal.testes.ControllerEmprestimosTeste;
import lp2.projetofinal.testes.ControllerItensTeste;
import lp2.projetofinal.testes.ControllerUsuarioTeste;
import lp2.projetofinal.testes.EmprestimoTeste;
import lp2.projetofinal.testes.EpisodioSerieTeste;
import lp2.projetofinal.testes.FakeBluRayTeste;
import lp2.projetofinal.testes.FakeItemTeste;
import lp2.projetofinal.testes.JogoEletronicoTeste;
import lp2.projetofinal.testes.JogoTabuleiroTeste;
import lp2.projetofinal.testes.SistemaTeste;
import lp2.projetofinal.testes.UsuarioTest;

@RunWith(Suite.class)

@Suite.SuiteClasses({
	
   SistemaTeste.class,
	
   ControllerUsuarioTeste.class,
   UsuarioTest.class,
   ChaveNomeTelefoneTeste.class,
   CartaoFreeRyderTeste.class,
   CartaoNoobTeste.class,
   CartaoBomAmigoTeste.class,
   CartaoCaloteiroTeste.class,
   
   ControllerItensTeste.class,
   FakeItemTeste.class,
   FakeBluRayTeste.class,
   JogoEletronicoTeste.class,
   BluRayFilmeTeste.class,
   BluRayShowTeste.class,
   BluRaySerieTest.class,
   JogoTabuleiroTeste.class,
   EpisodioSerieTeste.class,
   
   ControllerEmprestimosTeste.class,
   EmprestimoTeste.class
   
})

public class TestSuite {   
}  
