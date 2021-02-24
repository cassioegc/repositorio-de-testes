package lp2.projetofinal.testes;

import lp2.projetofinal.entidades.BluRay;

/**
 * Classe FakeBluRay, extende de BluRay e serve somente para poder gerar casos de teste para a classe BluRay.
 */

public class FakeBluRay extends BluRay{

	private static final long serialVersionUID = 1L;

	public FakeBluRay(String nome, double preco, int duracao, String classificacao) {
		super(nome, preco, duracao, classificacao);
	}

}
