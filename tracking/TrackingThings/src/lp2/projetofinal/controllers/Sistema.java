package lp2.projetofinal.controllers;

import lp2.projetofinal.persistencia.Persistencia;

/**
 * Classe responsavel por ser o Controller Principal, delega responsabilidades para ControllerUsuario, ControllerItens e ControllerEmprestimos. Chama a classe Checks para validar os parametros passados em cada metodo.
 * 
 * Laboratorio de Programacao 2 - Projeto Final Parte 01
 * 
 * @author Thiago Santos de Moura - 116210967
 * @author Gabriel Almeida Azevedo - 116210009
 * @author Marcelo Gabriel dos Santos Queiroz Vitorino - 116211290
 */

import lp2.projetofinal.util.Checks;

public class Sistema {

	private ControllerUsuario controllerUsuario;
	private ControllerItens controllerItens;
	private ControllerEmprestimos controllerEmprestimos;

	public Sistema() {
		controllerUsuario = new ControllerUsuario();
		controllerItens = new ControllerItens();
		controllerEmprestimos = new ControllerEmprestimos();
	}
	
	public void inicializar() {
		controllerEmprestimos.carregaListaEmprestimos();
		controllerUsuario.carregaMapaUsuarios();
	}

	/**
	 * Metodo responsavel por delegar a acao de cadastrar um novo usuario para o
	 * controller de usuarios. Validando antes os paramentros passados.
	 * 
	 * @param nome
	 *            Nome do novo usuario.
	 * @param telefone
	 *            Telefone do novo usuario.
	 * @param email
	 *            Email do novo usuario.
	 */
	public void cadastrarUsuario(String nome, String telefone, String email) {

		verificacaoPadraoUsuario(nome, telefone);
		Checks.verificaEmailVazioNulo(email);

		controllerUsuario.cadastrarUsuario(nome, telefone, email);

	}

	/**
	 * Metodo responsavel por delegar ao controller de usuarios o retorno da
	 * informacao solicitada. Validando antes os paramentros passados.
	 * 
	 * @param nome
	 *            Nome do usuario escolhido.
	 * @param telefone
	 *            Telefone do usuario escolhido.
	 * @param atributo
	 *            Atributo escolhido para ser retornado escolhido.
	 * 
	 * @return Retorna uma string com essa informacao.
	 */
	public String getInfoUsuario(String nome, String telefone, String atributo) {

		verificacaoPadraoUsuario(nome, telefone);
		Checks.verificaAtributolVazioNulo(atributo);

		return controllerUsuario.getInfoUsuario(nome, telefone, atributo);
	}

	/**
	 * Metodo responsavel por delegar ao controller de usuarios a remocao do
	 * usuario escolhido. Validando antes os paramentros passados.
	 * 
	 * @param nome
	 *            Nome do usuario escolhido.
	 * @param telefone
	 *            Telefone do usuario escolhido.
	 */
	public void removerUsuario(String nome, String telefone) {

		verificacaoPadraoUsuario(nome, telefone);

		controllerUsuario.removerUsuario(nome, telefone);
	}

	/**
	 * Metodo responsavel por delegar ao controller de usuarios a atualizacao do
	 * usuario escolhido. Validando antes os paramentros passados.
	 * 
	 * @param nome
	 *            Nome do usuario escolhido.
	 * @param telefone
	 *            Telefone do usuario escolhido.
	 * @param atributo
	 *            Atributo escolhido para ser retornado escolhido.
	 * @param valor
	 *            Novo valor do atributo escolhido.
	 * 
	 */
	public void atualizarUsuario(String nome, String telefone, String atributo, String valor) {

		verificacaoPadraoUsuario(nome, telefone);
		Checks.verificaAtributolVazioNulo(atributo);
		Checks.verificaValorVazioNulo(valor);

		controllerUsuario.atualizarUsuario(nome, telefone, atributo, valor);

	}

	/**
	 * Metodo responsavel por encapsular a verificacao padrao de paramentros que
	 * identificam um usuario no sistema.
	 * 
	 * @param nome
	 *            Nome do usuario escolhido.
	 * @param telefone
	 *            Telefone do usuario escolhido.
	 */
	private void verificacaoPadraoUsuario(String nome, String telefone) {
		Checks.verificaNomeVazioNulo(nome);
		Checks.verificaTelefoneVazioNulo(telefone);
	}

	/**
	 * Metodo responsavel por encapsular a verificacao padrao de paramentros que
	 * realizao o cadastro de um item no sistema.
	 * 
	 * @param nome
	 *            Nome do usuario escolhido.
	 * @param telefone
	 *            Telefone do usuario escolhido.
	 * @param nome
	 *            Item Nome do item escolhido.
	 * @param preco
	 *            Preco do item escolhido.
	 */
	private void verificacaoPadraoCadastroItem(String nome, String telefone, String nomeItem, double preco) {
		verificacaoPadraoUsuario(nome, telefone);
		Checks.verificaNomeItemVazioNulo(nomeItem);
		Checks.verificaPrecoZeroNegativo(preco);
	}

	/**
	 * Metodo responsavel por delegar ao controller de itens o cadastro de um
	 * novo item no conjunto de itens de um usuario passado, atraves de uma
	 * chamada polimorfica de parametros no metodo adicionarItem(). Validando
	 * antes os paramentros passados.
	 * 
	 * @param nome
	 *            Nome do novo item.
	 * @param telefone
	 *            Telefone do novo item.
	 * @param nomeItem
	 *            Item Nome do novo item.
	 * @param preco
	 *            Preco do novo item.
	 * @param plataforma
	 *            Plataforma do novo item.
	 */
	public void cadastrarEletronico(String nome, String telefone, String nomeItem, double preco, String plataforma) {

		verificacaoPadraoCadastroItem(nome, telefone, nomeItem, preco);
		Checks.verificaPlataformaVaziaNula(plataforma);

		controllerItens.adicionaItem(controllerUsuario.retornaUsuarioItens(nome, telefone), nomeItem, preco,
				plataforma);

		controllerUsuario.atualizaReputacao(nome, telefone, preco * 0.05, true);

	}

	/**
	 * Metodo responsavel por delegar ao controller de itens o cadastro de um
	 * novo item no conjunto de itens de um usuario passado, atraves de uma
	 * chamada polimorfica de parametros no metodo adicionarItem(). Validando
	 * antes os paramentros passados.
	 * 
	 * @param nome
	 *            Nome do novo item.
	 * @param telefone
	 *            Telefone do novo item.
	 * @param nomeItem
	 *            Item Nome do novo item.
	 * @param preco
	 *            Preco do novo item.
	 */
	public void cadastrarJogoTabuleiro(String nome, String telefone, String nomeItem, double preco) {

		verificacaoPadraoCadastroItem(nome, telefone, nomeItem, preco);

		controllerItens.adicionaItem(controllerUsuario.retornaUsuarioItens(nome, telefone), nomeItem, preco);

		controllerUsuario.atualizaReputacao(nome, telefone, preco * 0.05, true);
	}

	/**
	 * Metodo responsavel por delegar ao controller de itens o cadastro de um
	 * novo item no conjunto de itens de um usuario passado, atraves de uma
	 * chamada polimorfica de parametros no metodo adicionarItem(). Validando
	 * antes os paramentros passados.
	 * 
	 * @param nome
	 *            Nome do novo item.
	 * @param telefone
	 *            Telefone do novo item.
	 * @param nomeItem
	 *            Item Nome do novo item.
	 * @param preco
	 *            Preco do novo item.
	 * @param duracao
	 *            Duracao do novo item.
	 * @param genero
	 *            Genero do novo item.
	 * @param classificacao
	 *            Classificacao do novo item.
	 * @param anoLancamento
	 *            Ano de lancamento do novo item.
	 */
	public void cadastrarBluRayFilme(String nome, String telefone, String nomeItem, double preco, int duracao,
			String genero, String classificacao, int anoLancamento) {

		verificacaoPadraoCadastroItem(nome, telefone, nomeItem, preco);
		Checks.verificaDuracaoZeroNegativa(duracao);
		Checks.verificaGeneroVazioNulo(genero);
		Checks.verificaClassificacaoVaziaNula(classificacao);
		Checks.verificaAnoLancamentoZeroNegativo(anoLancamento);

		controllerItens.adicionaItem(controllerUsuario.retornaUsuarioItens(nome, telefone), nomeItem, preco, duracao,
				genero, classificacao, anoLancamento);

		controllerUsuario.atualizaReputacao(nome, telefone, preco * 0.05, true);
	}

	/**
	 * Metodo responsavel por delegar ao controller de itens o cadastro de um
	 * novo item no conjunto de itens de um usuario passado, atraves de uma
	 * chamada polimorfica de parametros no metodo adicionarItem(). Validando
	 * antes os paramentros passados.
	 * 
	 * @param nome
	 *            Nome do novo item.
	 * @param telefone
	 *            Telefone do novo item.
	 * @param nomeItem
	 *            Item Nome do novo item.
	 * @param preco
	 *            Preco do novo item.
	 * @param duracao
	 *            Duracao do novo item.
	 * @param numeroFaixas
	 *            Numero de faixas do novo item.
	 * @param artista
	 *            Artista do novo item.
	 * @param classificacao
	 *            Classificacao do novo item.
	 */
	public void cadastrarBluRayShow(String nome, String telefone, String nomeItem, double preco, int duracao,
			int numeroFaixas, String artista, String classificacao) {

		verificacaoPadraoCadastroItem(nome, telefone, nomeItem, preco);
		Checks.verificaDuracaoZeroNegativa(duracao);
		Checks.verificaNumeroFaixasZeroNegativo(numeroFaixas);
		Checks.verificaArtistaVazioNulo(artista);
		Checks.verificaClassificacaoVaziaNula(classificacao);

		controllerItens.adicionaItem(controllerUsuario.retornaUsuarioItens(nome, telefone), nomeItem, preco, duracao,
				numeroFaixas, artista, classificacao);

		controllerUsuario.atualizaReputacao(nome, telefone, preco * 0.05, true);
	}

	/**
	 * Metodo responsavel por delegar ao controller de itens o cadastro de um
	 * novo item no conjunto de itens de um usuario passado, atraves de uma
	 * chamada polimorfica de parametros no metodo adicionarItem(). Validando
	 * antes os paramentros passados.
	 * 
	 * @param nome
	 *            Nome do novo item.
	 * @param telefone
	 *            Telefone do novo item.
	 * @param nomeItem
	 *            Item Nome do novo item.
	 * @param preco
	 *            Preco do novo item.
	 * @param descricao
	 *            Descricao do novo item.
	 * @param duracao
	 *            Duracao do novo item.
	 * @param genero
	 *            Genero do novo item.
	 * @param classificacao
	 *            Classificacao do novo item.
	 * @param temporada
	 *            Temporada do novo item.
	 */
	public void cadastrarBluRaySerie(String nome, String telefone, String nomeItem, double preco, String descricao,
			int duracao, String classificacao, String genero, int temporada) {

		verificacaoPadraoCadastroItem(nome, telefone, nomeItem, preco);
		Checks.verificaDuracaoZeroNegativa(duracao);
		Checks.verificaClassificacaoVaziaNula(classificacao);
		Checks.verificaGeneroVazioNulo(genero);
		Checks.verificaDescricaoVaziaNula(descricao);
		Checks.verificaTemporadaZeroNegativa(temporada);

		controllerItens.adicionaItem(controllerUsuario.retornaUsuarioItens(nome, telefone), nomeItem, preco, descricao,
				duracao, classificacao, genero, temporada);

		controllerUsuario.atualizaReputacao(nome, telefone, preco * 0.05, true);
	}

	/**
	 * Metodo responsavel por adicionar um bluray a um bluray serie escolhido.
	 * Validando antes as informacoes passadas.
	 * 
	 * @param nome
	 *            Nome do dono do item.
	 * @param telefone
	 *            Telefone do dono do item.
	 * @param BlurayTemporada
	 *            Nome do bluray serie escolhido.
	 * @param duracao
	 *            Duracao do item bluray que sera adicionado.
	 */
	public void adicionarBluRay(String nome, String telefone, String BlurayTemporada, int duracao) {

		verificacaoPadraoUsuario(nome, telefone);
		Checks.verificaNomeItemVazioNulo(BlurayTemporada);
		Checks.verificaDuracaoZeroNegativa(duracao);

		controllerItens.adicionarBluRayEpisodio(controllerUsuario.retornaUsuarioItens(nome, telefone), BlurayTemporada,
				duracao);

	}

	/**
	 * Método responsável por delegar ao controller de itens a adicao de uma
	 * peca perdida a um jogo de tabuleiro. Validando antes as informações
	 * passadas.
	 * 
	 * @param nome
	 *            Nome do dono do item.
	 * @param telefone
	 *            Telefone do dono do item.
	 * @param nomeItem
	 *            Nome do jogo de Tabuleiro.
	 * @param nomePeca
	 *            Nome da peca perdida.
	 */
	public void adicionarPecaPerdida(String nome, String telefone, String nomeItem, String nomePeca) {

		verificacaoPadraoUsuario(nome, telefone);
		Checks.verificaNomeItemVazioNulo(nomeItem);
		Checks.verificaPecaVaziaNula(nomePeca);

		controllerItens.cadastrarPecaPerdidaNoTabuleiro(controllerUsuario.retornaUsuarioItens(nome, telefone), nomeItem,
				nomePeca);
	}

	/**
	 * Metodo responsavel delegar a remoção de um item ao controller de itens.
	 * Verificando antes as informações passadas.
	 * 
	 * @param nome
	 *            Nome do dono do item.
	 * @param telefone
	 *            Telefone do dono do item.
	 * @param nomeItem
	 *            Nome do item que sera removido.
	 */
	public void removerItem(String nome, String telefone, String nomeItem) {

		verificacaoPadraoUsuario(nome, telefone);
		Checks.verificaNomeItemVazioNulo(nomeItem);

		controllerItens.removerItem(controllerUsuario.retornaUsuarioItens(nome, telefone), nomeItem);
	}

	/**
	 * Metodo responsavel delegar a atualização de um item ao controller de
	 * itens. Verificando antes as informações passadas.
	 * 
	 * @param nome
	 *            Nome do dono do item.
	 * @param telefone
	 *            Telefone do dono do item.
	 * @param nomeItem
	 *            Nome do item que sera removido.
	 * @param atributo
	 *            Atributo escolhido para ser atulizado.
	 * @param valor
	 *            Novo valor desse atributo.
	 */
	public void atualizarItem(String nome, String telefone, String nomeItem, String atributo, String valor) {

		verificacaoPadraoUsuario(nome, telefone);
		Checks.verificaNomeItemVazioNulo(nomeItem);
		Checks.verificaAtributolVazioNulo(atributo);
		Checks.verificaValorVazioNulo(valor);

		controllerItens.atualizarItem(controllerUsuario.retornaUsuarioItens(nome, telefone), nomeItem, atributo, valor);

	}

	/**
	 * Metodo responsavel por delegar a recuperacao de uma informacao de um item
	 * para o controller de itens. Validando antes as informacoes passadas.
	 * 
	 * @param nome
	 *            Nome do dono do item.
	 * @param telefone
	 *            Telefone do dono do item.
	 * @param nomeItem
	 *            Nome do item que sera removido.
	 * @param atributo
	 *            Atributo escolhido para ser recuperado.
	 * 
	 * @return Retorna uma string com esse valor.
	 */
	public String getInfoItem(String nome, String telefone, String nomeItem, String atributo) {

		verificacaoPadraoUsuario(nome, telefone);
		Checks.verificaNomeItemVazioNulo(nomeItem);
		Checks.verificaAtributolVazioNulo(atributo);

		return controllerItens.getInfoItem(controllerUsuario.retornaUsuarioItens(nome, telefone), nomeItem, atributo);
	}

	/**
	 * Metodo responsável por delegar a pesquisa por detalhes de um item para o
	 * controlador de itens. Validando antes as informacoes passadas.
	 * 
	 * @param nome
	 *            Nome do dono do item.
	 * @param telefone
	 *            Telefone do dono do item.
	 * @param nomeItem
	 *            Nome do item que sera removido.
	 * 
	 * @return Retorna uma string com a representação do item para o sistema.
	 */
	public String pesquisarDetalhesItem(String nome, String telefone, String nomeItem) {

		verificacaoPadraoUsuario(nome, telefone);
		Checks.verificaNomeItemVazioNulo(nomeItem);

		return controllerItens.getDetalhesItem(controllerUsuario.retornaUsuarioItens(nome, telefone), nomeItem);
	}

	/**
	 * Metodo responsavel por delegar a acao de listar os itens que ja foram
	 * cadastros idenpendente dos seus donos, de forma alfabetica.
	 * 
	 * @return Retorna uma string com essa listagem.
	 */
	public String listarItensOrdenadosPorNome() {
		return controllerItens.listarItensOrdenadosPorNome(controllerUsuario.todosUsuariosItens());

	}

	/**
	 * Metodo responsavel por delegar a acao de listar os itens que ja foram
	 * cadastros idenpendente dos seus donos, levando em consideracao seu preco.
	 * 
	 * @return Retorna uma string com essa listagem.
	 */
	public String listarItensOrdenadosPorValor() {
		return controllerItens.listarItensOrdenadosPorValor(controllerUsuario.todosUsuariosItens());
	}

	/**
	 * Metodo responsavel por delegar o registro de um emprestimo de um item
	 * entre dois usuarios cadastros no sistema. Validando antes as informacoes
	 * passadas. Para isso ele solicita a identificacao dos usuarios
	 * relacionados nesse emprestimo, e identifca o item em questao. Todas essas
	 * informacoes sao passadas para o controller de emprestimos que realiza o
	 * registro.
	 * 
	 * @param nomeDono
	 *            Nome do dono do item.
	 * @param telefoneDono
	 *            Telefone do dono do item.
	 * @param nomeRequerente
	 *            Nome do requerente do item.
	 * @param telefoneRequerente
	 *            Telefone do requerente do item.
	 * @param nomeItem
	 *            Nome do item.
	 * @param dataEmprestimo
	 *            Data em que o emprestimo sera realizado.
	 * @param periodo
	 *            Periodo em que o item vai ficar com o requerente.
	 */
	public void registrarEmprestimo(String nomeDono, String telefoneDono, String nomeRequerente,
			String telefoneRequerente, String nomeItem, String dataEmprestimo, int periodo) {

		verificacaoPadraoUsuario(nomeDono, telefoneDono);
		verificacaoPadraoUsuario(nomeRequerente, telefoneRequerente);

		Checks.verificaNomeItemVazioNulo(nomeItem);
		Checks.verificaDataEmprestimoVaziaNula(dataEmprestimo);
		Checks.verificaPeriodoZeradoOuNegativo(periodo);

		controllerUsuario.verificaFidelidadeUsuario(nomeRequerente, telefoneRequerente);
		controllerUsuario.verificadisponibilidadeUsuario(nomeRequerente, telefoneRequerente, periodo);

		controllerEmprestimos.registrarEmprestimo(controllerUsuario.identificaUsuario(nomeDono, telefoneDono),
				controllerUsuario.identificaUsuario(nomeRequerente, telefoneRequerente),
				controllerItens.identificaItem(controllerUsuario.retornaUsuarioItens(nomeDono, telefoneDono), nomeItem),
				dataEmprestimo, periodo);

		controllerUsuario.atualizaReputacao(nomeDono, telefoneDono,
				controllerItens.identificaItem(controllerUsuario.retornaUsuarioItens(nomeDono, telefoneDono), nomeItem)
						.getPreco() * 0.1,
				true);

	}

	/**
	 * Metodo responsavel por delegar a devolucao de um item e o encerramento de
	 * um emprestimo, validando antes as informacoes passadas. Para isso ele
	 * solicita a identificacao dos usuarios relacionados nesse emprestimo, e
	 * identifca o item em questao. Todas essas informacoes sao passadas para o
	 * controller de emprestimos que realiza a devolucao do item. Por fim, os
	 * dias de atraso é retornada e a reputacao do usuario requerente eh
	 * atualizada.
	 * 
	 * @param nomeDono
	 *            Nome do dono do item.
	 * @param telefoneDono
	 *            Telefone do dono do item.
	 * @param nomeRequerente
	 *            Nome do requerente do item.
	 * @param telefoneRequerente
	 *            Telefone do requerente do item.
	 * @param nomeItem
	 *            Nome do item.
	 * @param dataEmprestimo
	 *            Data em que o emprestimo foi realizado.
	 * @param dataDevolucao
	 *            Data da devolucao do item.
	 */
	public void devolverItem(String nomeDono, String telefoneDono, String nomeRequerente, String telefoneRequerente,
			String nomeItem, String dataEmprestimo, String dataDevolucao) {

		verificacaoPadraoUsuario(nomeDono, telefoneDono);
		verificacaoPadraoUsuario(nomeRequerente, telefoneRequerente);

		Checks.verificaNomeItemVazioNulo(nomeItem);
		Checks.verificaDataEmprestimoVaziaNula(dataEmprestimo);
		Checks.verificaDataDevolucaoVaziaNula(dataDevolucao);

		int diasAtraso = controllerEmprestimos.devolverItem(controllerUsuario.identificaUsuario(nomeDono, telefoneDono),
				controllerUsuario.identificaUsuario(nomeRequerente, telefoneRequerente),
				controllerItens.identificaItem(controllerUsuario.retornaUsuarioItens(nomeDono, telefoneDono), nomeItem),
				dataEmprestimo, dataDevolucao);

		if (diasAtraso <= 0) {
			controllerUsuario
					.atualizaReputacao(nomeRequerente, telefoneRequerente,
							controllerItens.identificaItem(
									controllerUsuario.retornaUsuarioItens(nomeDono, telefoneDono), nomeItem).getPreco()
									* 0.05,
							true);
		} else {
			controllerUsuario
					.atualizaReputacao(nomeRequerente, telefoneRequerente,
							controllerItens.identificaItem(
									controllerUsuario.retornaUsuarioItens(nomeDono, telefoneDono), nomeItem).getPreco()
									* diasAtraso * 0.01,
							false);
		}
	}

	/**
	 * Metodo responsavel por listar os emprestimos em que o usuario eh o dono
	 * do item que esta sendo emprestado, em ordem alfabetica.
	 * 
	 * @param nome
	 *            Nome do usuario dono.
	 * @param telefone
	 *            Telefone do usuario dono.
	 * 
	 * @return Retorna uma string com essa listagem.
	 */
	public String listarEmprestimosUsuarioEmprestando(String nome, String telefone) {

		Checks.verificaNomeVazioNulo(nome);
		Checks.verificaTelefoneVazioNulo(telefone);

		return controllerEmprestimos
				.listarEmprestimosEmprestandoOrdenadosPorNomeItem(controllerUsuario.identificaUsuario(nome, telefone));

	}

	/**
	 * Metodo responsavel por listar os emprestimos em que o usuario eh o
	 * requerente do item que esta sendo emprestado, em ordem alfabetica.
	 * 
	 * @param nome
	 *            Nome do usuario requerente.
	 * @param telefone
	 *            Telefone do usuario requerente.
	 * 
	 * @return Retorna uma string com essa listagem.
	 */
	public String listarEmprestimosUsuarioPegandoEmprestado(String nome, String telefone) {

		Checks.verificaNomeVazioNulo(nome);
		Checks.verificaTelefoneVazioNulo(telefone);

		return controllerEmprestimos
				.listarEmprestimosRequerenteOrdenadosPorNomeItem(controllerUsuario.identificaUsuario(nome, telefone));

	}

	/**
	 * Metodo responsavel por listar os emprestimos em que o nome do item esta
	 * associado, em ordem alfabetica. Independe de serem o mesmo item.
	 * 
	 * @param nomeItem
	 *            Nome do item.
	 * 
	 * @return Retorna uma string com essa listagem.
	 */
	public String listarEmprestimosItem(String nomeItem) {

		Checks.verificaNomeItemVazioNulo(nomeItem);

		return controllerEmprestimos.listarEmprestimosItens(nomeItem);

	}

	/**
	 * Metodo responsavel por listar os itens que estao disponivel para
	 * emprestimos no sistema. Em ordem alfabetica.
	 * 
	 * @return Retorna uma string com essa listagem.
	 */
	public String listarItensNaoEmprestados() {

		return controllerItens.listarItensNaoEmprestados(controllerUsuario.todosUsuariosItens());
	}

	/**
	 * Metodo responsavel por listar os itens que nao estao disponivel para
	 * emprestimos no sistema. Em ordem alfabetica.
	 * 
	 * @return Retorna uma string com essa listagem.
	 */
	public String listarItensEmprestados() {

		return controllerEmprestimos.listarItensEmprestados();
	}

	/**
	 * Metodo responsavel por listar os 10 itens que mais foram emprestados no
	 * sistema. Em ordem alfabetica.
	 *
	 * @return Retorna uma string com essa listagem.
	 */
	public String listarTop10Itens() {

		return controllerItens.listarTop10Itens(controllerUsuario.todosUsuariosItens());
	}

	/**
	 * Metodo responsavel por listar os usuarios que possuem o cartao caloteiro
	 * no sistema. Em ordem alfabetica.
	 * 
	 * @return Retorna uma string com essa listagem.
	 */
	public String listarCaloteiros() {
		return controllerUsuario.listarCaloteiros();
	}

	/**
	 * Metodo responsavel por listar os 10 usuarios que possuem as maiores
	 * reputacoes no sistema. Em ordem alfabetica.
	 *
	 * @return Retorna uma string com essa listagem.
	 */
	public String listarTop10MelhoresUsuarios() {
		return controllerUsuario.listarTop10MelhoresUsuarios();
	}

	/**
	 * Metodo responsavel por listar os 10 usuarios que possuem as piores
	 * reputacoes no sistema. Em ordem alfabetica.
	 *
	 * @return Retorna uma string com essa listagem.
	 */
	public String listarTop10PioresUsuarios() {
		return controllerUsuario.listarTop10PioresUsuarios();
	}

	public void finalizar() {

		controllerEmprestimos.salvarListaEmprestimos();
		controllerUsuario.salvarMapaUsuarios();
		
	}

	public void resetarPersistencia() {
		Persistencia.resetar();
	}

}