package lp2.projetofinal.controllers;

import lp2.projetofinal.util.Checks;

public class Sistema {

	private ControllerUsuario controllerUsuario;

	public Sistema() {
		controllerUsuario = new ControllerUsuario();
	}

	public void cadastrarUsuario(String nome, String telefone, String email) {

		Checks.verificaNomeVazioNulo(nome);
		Checks.verificaTelefoneVazioNulo(telefone);
		Checks.verificaEmailVazioNulo(email);

		controllerUsuario.cadastrarUsuario(nome, telefone, email);

	}

	public String getInfoUsuario(String nome, String telefone, String atributo) {

		Checks.verificaNomeVazioNulo(nome);
		Checks.verificaTelefoneVazioNulo(telefone);
		Checks.verificaAtributolVazioNulo(atributo);

		return controllerUsuario.getInfoUsuario(nome, telefone, atributo);
	}

	public void removerUsuario(String nome, String telefone) {

		Checks.verificaNomeVazioNulo(nome);
		Checks.verificaTelefoneVazioNulo(telefone);

		controllerUsuario.removerUsuario(nome, telefone);
	}

	public void atualizarUsuario(String nome, String telefone, String atributo, String valor) {

		Checks.verificaNomeVazioNulo(nome);
		Checks.verificaTelefoneVazioNulo(telefone);
		Checks.verificaAtributolVazioNulo(atributo);
		Checks.verificaValorVazioNulo(valor);

		controllerUsuario.atualizarUsuario(nome, telefone, atributo, valor);

	}

	public void cadastrarEletronico(String nome, String telefone, String nomeItem, double preco, String plataforma) {
		controllerUsuario.cadastrarEletronico(nome, telefone, nomeItem, preco, plataforma);
	}

	public void cadastrarJogoTabuleiro(String nome, String telefone, String nomeItem, double preco) {
		controllerUsuario.cadastrarJogoTabuleiro(nome, telefone, nomeItem, preco);
	}

	public void cadastrarBluRayFilme(String nome, String telefone, String nomeItem, double preco, int duracao,
			String genero, String classificacao, int anoLancamento) {
		controllerUsuario.cadastrarBluRayFilme(nome, telefone, nomeItem, preco, duracao, genero, classificacao,
				anoLancamento);
	}

	public void cadastrarBluRayShow(String nome, String telefone, String nomeItem, double preco, int duracao,
			int numeroFaixas, String artista, String classificacao) {
		controllerUsuario.cadastrarBluRayShow(nome, telefone, nomeItem, preco, duracao, numeroFaixas, artista,
				classificacao);
	}

	public void cadastrarBluRaySerie(String nome, String telefone, String nomeItem, double preco, String descricao,
			int duracao, String classificacao, String genero, int temporada) {
		controllerUsuario.cadastrarBluRaySerie(nome, telefone, nomeItem, preco, descricao, duracao, classificacao,
				genero, temporada);
	}

	public void adicionarBluRay(String nome, String telefone, String BlurayTemporada, int duracao) {
		controllerUsuario.adicionarBluRayEpisodio(nome, telefone, BlurayTemporada, duracao);
	}

	public void removerItem(String nome, String telefone, String nomeItem) {
		controllerUsuario.removerItem(nome, telefone, nomeItem);
	}

	public void finalizar() {

	}

	public String getInfoItem(String nome, String telefone, String nomeItem, String atributo) {
		
		return "Mudar"; //controllerUsuario.getInfoItem(nome, telefone, nomeItem, atributo);
	}
}
