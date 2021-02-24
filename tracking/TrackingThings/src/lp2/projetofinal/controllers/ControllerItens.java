package lp2.projetofinal.controllers;

/**
 * Classe responsavel por controlar todos os objetos Item cadastrados no sistema.
 * 
 * Laboratorio de Programacao 2 - Projeto Final Parte 01
 * 
 * @author Thiago Santos de Moura - 116210967
 * @author Gabriel Almeida Azevedo - 116210009
 * @author Marcelo Gabriel dos Santos Queiroz Vitorino - 116211290
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import lp2.projetofinal.entidades.BluRayFilme;
import lp2.projetofinal.entidades.BluRaySerie;
import lp2.projetofinal.entidades.BluRayShow;
import lp2.projetofinal.entidades.Item;
import lp2.projetofinal.entidades.JogoEletronico;
import lp2.projetofinal.entidades.JogoTabuleiro;
import lp2.projetofinal.enums.EstadoItem;
import lp2.projetofinal.orders.OrdenaItemNumeroEmprestimos;
import lp2.projetofinal.orders.OrdenaItemPeloPreco;
import lp2.projetofinal.util.Exceptions;

public class ControllerItens {

	/**
	 * Construtor de controllerItens.
	 */
	public ControllerItens() {
	}

	/**
	 * Metodo com polimorfismo parametrico. Ele tem responsabilidade de
	 * cadastrar um novo item no sistema. Mas especificamente um subtipo Jogo
	 * Eletronico.
	 * 
	 * @param listaItens
	 *            Conjunto de itens que pertecem ao usuario escolhido para o
	 *            cadastro.
	 * @param nomeItem
	 *            Nome do item que sera cadastrado.
	 * @param preco
	 *            Preco do item que sera cadastrado.
	 * @param plataforma
	 *            Plataforma do jogo que sera cadastrado.
	 */
	public void adicionaItem(Set<Item> listaItens, String nomeItem, double preco, String plataforma) {

		JogoEletronico jogoEletronico = new JogoEletronico(nomeItem, preco, plataforma);
		listaItens.add(jogoEletronico);
	}

	/**
	 * Metodo com polimorfismo parametrico. Ele tem responsabilidade de
	 * cadastrar um novo item no sistema. Mas especificamente um subtipo Jogo
	 * Tabuleiro.
	 * 
	 * @param listaItens
	 *            Conjunto de itens que pertecem ao usuario escolhido para o
	 *            cadastro.
	 * @param nomeItem
	 *            Nome do item que sera cadastrado.
	 * @param preco
	 *            Preco do item que sera cadastrado.
	 */
	public void adicionaItem(Set<Item> listaItens, String nomeItem, double preco) {

		JogoTabuleiro jogoTabuleiro = new JogoTabuleiro(nomeItem, preco);
		listaItens.add(jogoTabuleiro);

	}

	/**
	 * Metodo com polimorfismo parametrico. Ele tem responsabilidade de
	 * cadastrar um novo item no sistema. Mas especificamente um subtipo
	 * BlurayFilme.
	 * 
	 * @param listaItens
	 *            Conjunto de itens que pertecem ao usuario escolhido para o
	 *            cadastro.
	 * @param nomeItem
	 *            Nome do item que sera cadastrado.
	 * @param preco
	 *            Preco do item que sera cadastrado.
	 * @param duracao
	 *            Duracao do Bluray que sera cadastrado.
	 * @param genero
	 *            Genero do bluray que sera cadastrado.
	 * @param classificacao
	 *            Classificacao do bluray que sera cadastrado.
	 * @param anoLancamento
	 *            Ano do lancamento do bluray que sera cadastrado.
	 */
	public void adicionaItem(Set<Item> listaItens, String nomeItem, double preco, int duracao, String genero,
			String classificacao, int anoLancamento) {

		BluRayFilme bluRayFilme = new BluRayFilme(nomeItem, preco, duracao, genero, classificacao, anoLancamento);
		listaItens.add(bluRayFilme);
	}

	/**
	 * Metodo com polimorfismo parametrico. Ele tem responsabilidade de
	 * cadastrar um novo item no sistema. Mas especificamente um subtipo
	 * BlurayShow.
	 * 
	 * @param listaItens
	 *            Conjunto de itens que pertecem ao usuario escolhido para o
	 *            cadastro.
	 * @param nomeItem
	 *            Nome do item que sera cadastrado.
	 * @param preco
	 *            Preco do item que sera cadastrado.
	 * @param duracao
	 *            Duracao do Bluray que sera cadastrado.
	 * @param numeroFaixas
	 *            Numero de faixas do bluray show.
	 * @param artista
	 *            Artista do bluray show.
	 * @param classificacao
	 *            Classificacao do bluray que sera cadastrado.
	 */
	public void adicionaItem(Set<Item> listaItens, String nomeItem, double preco, int duracao, int numeroFaixas,
			String artista, String classificacao) {

		BluRayShow bluRayShow = new BluRayShow(nomeItem, preco, duracao, classificacao, artista, numeroFaixas);
		listaItens.add(bluRayShow);
	}

	/**
	 * Metodo com polimorfismo parametrico. Ele tem responsabilidade de
	 * cadastrar um novo item no sistema. Mas especificamente um subtipo
	 * BluraySerie.
	 * 
	 * @param listaItens
	 *            Conjunto de itens que pertecem ao usuario escolhido para o
	 *            cadastro.
	 * @param nomeItem
	 *            Nome do item que sera cadastrado.
	 * @param preco
	 *            Preco do item que sera cadastrado.
	 * @param duracao
	 *            Duracao do Bluray que sera cadastrado.
	 * @param genero
	 *            Genero do bluray que sera cadastrado.
	 * @param classificacao
	 *            Classificacao do bluray que sera cadastrado.
	 * @param temporada
	 *            Numero da temporada do bluray serie.
	 * 
	 * @param descricao
	 *            Descricao do bluray serie.
	 */
	public void adicionaItem(Set<Item> listaItens, String nomeItem, double preco, String descricao, int duracao,
			String classificacao, String genero, int temporada) {

		BluRaySerie bluRaySerie = new BluRaySerie(nomeItem, preco, descricao, duracao, classificacao, genero,
				temporada);

		listaItens.add(bluRaySerie);
	}

	/**
	 * Metodo responsavel por adicionar um bluray episodio ao bluray serie
	 * escolhido. Encontrando antes o item para o cadastro.
	 * 
	 * @param listaItens
	 *            Conjunto de itens que pertecem ao usuario escolhido para o
	 *            cadastro.
	 * @param nomeItem
	 *            Nome do bluray serie.
	 * @param duracao
	 *            Duracao do episodio.
	 */
	public void adicionarBluRayEpisodio(Set<Item> listaItens, String nomeItem, int duracao) {

		BluRaySerie bluraySerie = (BluRaySerie) identificaItem(listaItens, nomeItem);
		bluraySerie.adicionarBluRay(duracao);
	}

	/**
	 * Metodo responsavel por cadastrar uma peca perdida no tabuleiro escolhido.
	 * Encontrando antes o item para o cadastro.
	 * 
	 * @param listaItens
	 *            Conjunto de itens que pertecem ao usuario escolhido para o
	 *            cadastro.
	 * @param nomeItem
	 *            Nome do jogo de tabuleiro.
	 * @param nomePeca
	 *            Nome da peca perdida.
	 */
	public void cadastrarPecaPerdidaNoTabuleiro(Set<Item> listaItens, String nomeItem, String nomePeca) {

		JogoTabuleiro jogoTabuleiro = (JogoTabuleiro) identificaItem(listaItens, nomeItem);
		jogoTabuleiro.adicionarPecaPerdida(nomePeca);

	}

	/**
	 * Metodo responsavel por atualizar um item. Encontrando antes o item para a
	 * atualizacao.
	 * 
	 * @param listaItens
	 *            Conjunto de itens que pertecem ao usuario escolhido para a
	 *            atualizacao.
	 * @param nomeItem
	 *            Nome do item escolhido.
	 * @param atributo
	 *            Atributo que sera atualizado.
	 * @param valor
	 *            Novo valor desse atributo.
	 */
	public void atualizarItem(Set<Item> listaItens, String nomeItem, String atributo, String valor) {

		Item item = identificaItem(listaItens, nomeItem);
		item.atualizar(atributo, valor);

	}

	/**
	 * Metodo responsavel por remover um item do conjunto de itens de um
	 * usuario.
	 * 
	 * @param listaItens
	 *            Conjunto de itens que pertecem ao usuario escolhido para a
	 *            remocao.
	 * @param nomeItem
	 *            Nome do item.
	 */
	public void removerItem(Set<Item> listaItens, String nomeItem) {

		Item item = identificaItem(listaItens, nomeItem);
		listaItens.remove(item);
	}

	/**
	 * Metodo responsavel por retornar o valor do atributo escolhido,
	 * solicitando ao item que reconheca qual atributo eh ja que eles podem
	 * divergir de atributos.
	 * 
	 * @param listaItens
	 *            Conjunto de itens que pertecem ao usuario escolhido para a
	 *            recuperacao de informacao.
	 * @param nomeItem
	 *            Nome do item.
	 * @param atributo
	 *            Atributo escolhido para ser retornado.
	 * 
	 * @return Retorna uma string com o valor desse atributo.
	 */
	public String getInfoItem(Set<Item> listaItens, String nomeItem, String atributo) {

		Item item = identificaItem(listaItens, nomeItem);
		return item.getInfo(atributo);
	}

	/**
	 * Metodo responsavel por retornar todas as informacoes de um item a partir
	 * do toString dele.
	 * 
	 * @param listaItens
	 *            Conjunto de itens que pertecem ao usuario escolhido para a
	 *            recuperacao de informacao.
	 * @param nomeItem
	 *            Nome do item.
	 * 
	 * @return Retorna uma string do item.
	 */
	public String getDetalhesItem(Set<Item> listaItens, String nomeItem) {

		Item item = identificaItem(listaItens, nomeItem);
		return item.toString();
	}

	/**
	 * Metodo responsavel por listar todos os itens do sistema em ordem
	 * alfabetica.
	 * 
	 * @param listaTodosItens
	 *            Conjunto de itens que sera ordenado.
	 * 
	 * @return Retorna uma string com essa listagem.
	 */
	public String listarItensOrdenadosPorNome(Set<Item> listaTodosItens) {

		List<Item> listaItensOrdenada = new ArrayList<Item>(listaTodosItens);
		Collections.sort(listaItensOrdenada);

		String itensString = "";
		for (Item item : listaItensOrdenada) {
			itensString += item.toString() + "|";
		}
		return itensString;
	}

	/**
	 * Metodo responsavel por listar todos os itens do sistema levando em
	 * consideração o seu preco.
	 * 
	 * @param listaTodosItens
	 *            Conjunto de itens que sera ordenado.
	 * 
	 * @return Retorna uma string com essa listagem.
	 */
	public String listarItensOrdenadosPorValor(Set<Item> listaTodosItens) {

		List<Item> listaItensOrdenada = new ArrayList<Item>(listaTodosItens);
		Collections.sort(listaItensOrdenada, new OrdenaItemPeloPreco());

		String itensString = "";
		for (Item item : listaItensOrdenada) {
			itensString += item.toString() + "|";
		}
		return itensString;
	}

	/**
	 * Metodo responsavel por identificar e retornar um item no sistema.
	 * 
	 * @param listaItens
	 *            O conjunto de itens de um usuario.
	 * @param nomeItem
	 *            Nome do item.
	 * 
	 * @return Retorna um objeto do tipo item.
	 */
	public Item identificaItem(Set<Item> listaItens, String nomeItem) {

		for (Item item : listaItens) {
			if (item.getNome().equals(nomeItem))
				return item;
		}
		Exceptions.itemNaoEncontradoException();
		return null;
	}

	/**
	 * Metodo responsavel por listar os itens do sistema que nao estao sendo
	 * emprestados no momento. Levando em consideracao a ordem alfabetica.
	 * 
	 * @param listaTodosItens
	 *            Conjunto de todos os itens do sistema.
	 * 
	 * @return Retorna uma string com essa listagem.
	 */
	public String listarItensNaoEmprestados(Set<Item> listaTodosItens) {

		String stringItens = "";
		List<Item> listaItensOrdenada = new ArrayList<Item>(listaTodosItens);
		Collections.sort(listaItensOrdenada);

		for (Item item : listaItensOrdenada) {
			if (item.getEstado().equals(EstadoItem.NAO_EMPRESTADO.getEstado()))
				stringItens += item.toString() + "|";
		}
		return stringItens;
	}

	/**
	 * Metodo responsavel por listar os dez itens que foram mais emprestados no
	 * sistema.
	 * 
	 * @param listaTodosItens
	 *            Conjunto de todos os itens do sistema.
	 * 
	 * @return Retorna uma string com essa listagem.
	 */
	public String listarTop10Itens(Set<Item> listaTodosItens) {
		List<Item> listaItensOrdenada = new ArrayList<Item>(listaTodosItens);
		Collections.sort(listaItensOrdenada, new OrdenaItemNumeroEmprestimos());

		String top10ItensString = "";
		int numeroItens = 1;
		for (Item item : listaItensOrdenada) {
			if (numeroItens == 11) {
				break;
			}
			if (item.getNumeroEmprestimos() != 0) {
				top10ItensString += numeroItens + ") " + item.getNumeroEmprestimos() + " emprestimos - "
						+ item.toString() + "|";
				numeroItens++;
			}
		}
		return top10ItensString;
	}

}
