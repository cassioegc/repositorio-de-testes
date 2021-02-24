package lp2.projetofinal.controllers;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Classe responsavel por controlar todos os objetos Usuario cadastrados no sistema.
 * 
 * Laboratorio de Programacao 2 - Projeto Final Parte 01
 * 
 * @author Thiago Santos de Moura - 116210967
 * @author Gabriel Almeida Azevedo - 116210009
 * @author Marcelo Gabriel dos Santos Queiroz Vitorino - 116211290
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import lp2.projetofinal.entidades.ChaveNomeTelefone;
import lp2.projetofinal.entidades.Item;
import lp2.projetofinal.entidades.Usuario;
import lp2.projetofinal.orders.OrdenaUsuarioReputacaoCrescente;
import lp2.projetofinal.orders.OrdenaUsuarioReputacaoDecrescente;
import lp2.projetofinal.persistencia.Persistencia;
import lp2.projetofinal.util.Exceptions;

public class ControllerUsuario {

	private Map<ChaveNomeTelefone, Usuario> usuarios;

	/**
	 * Construtor de ControllerUsuario;
	 */
	public ControllerUsuario() {
		this.usuarios = new HashMap<ChaveNomeTelefone, Usuario>();
	}

	/**
	 * Metodo responsavel por carregar o mapa de usuarios, caso exista na
	 * persistencia.
	 */
	public void carregaMapaUsuarios() {

		if (!(Persistencia.carregaUsuarios() == null))
			this.usuarios = Persistencia.carregaUsuarios();
	}

	/**
	 * Metodo responsavel por salvar o mapa de usuarios na persistencia.
	 */
	public void salvarMapaUsuarios() {
		Persistencia.salvarUsuarios(this.usuarios);
	}

	/**
	 * Metodo responsavel por cadastrar um novo usuario no sistema. Criando
	 * antes uma chave para ele e verificando antes sua existencia no mapa. E
	 * por fim, setando o seu cartao FreeRyder.
	 * 
	 * @param nome
	 *            Nome do usuario.
	 * @param telefone
	 *            Telefone do usuario.
	 * @param email
	 *            E-mail do usuario.
	 */
	public void cadastrarUsuario(String nome, String telefone, String email) {

		ChaveNomeTelefone chave = new ChaveNomeTelefone(nome, telefone);

		if (usuarios.containsKey(chave))
			Exceptions.usuarioJaCadastradoException();

		Usuario usuario = new Usuario(nome, email, telefone);

		this.usuarios.put(chave, usuario);
	}

	/**
	 * Metodo responsavel por recuperar uma informacao do usuario escolhido.
	 * Verificando antes sua existencia no mapa.
	 *
	 * @param nome
	 *            Nome do usuario.
	 * @param telefone
	 *            Telefone do usuario.
	 * @param atributo
	 *            Atributo escolhido para ser retornado.
	 * 
	 * @return Retorna uma string com o atributo escolhido.
	 */
	public String getInfoUsuario(String nome, String telefone, String atributo) {

		ChaveNomeTelefone chave = new ChaveNomeTelefone(nome, telefone);

		verificaExistenciaChaveMapa(chave);

		Usuario usuario = this.usuarios.get(chave);

		if (atributo.equals("Email"))
			return usuario.getEmail();
		else if (atributo.equals("Nome"))
			return usuario.getNome();
		else if (atributo.equals("Telefone"))
			return usuario.getTelefone();
		else if (atributo.equals("Reputacao"))
			return "" + usuario.getReputacao();
		else if (atributo.equals("Cartao"))
			return usuario.getCartao().getNomeCartao();
		else
			Exceptions.atributoInvalidoException();

		return null;

	}

	/**
	 * Metodo responsavel por verificar a existencia de um usuario no mapa de
	 * usuarios. Amplamente utilizado nos metodos desse classe.
	 * 
	 * @param chave
	 *            Chave do usuario que sera verificado.
	 */
	private void verificaExistenciaChaveMapa(ChaveNomeTelefone chave) {

		if (!this.usuarios.containsKey(chave))
			Exceptions.usuarioInvalidoException();
	}

	/**
	 * Metodo responsavel remover um usuario da lista de usuarios, verificando
	 * antes sua existencia no mapa de usuarios.
	 * 
	 * @param nome
	 *            Nome do usuario.
	 * @param telefone
	 *            Telefone do usuario.
	 */
	public void removerUsuario(String nome, String telefone) {

		ChaveNomeTelefone chave = new ChaveNomeTelefone(nome, telefone);

		verificaExistenciaChaveMapa(chave);

		this.usuarios.remove(chave);

	}

	/**
	 * Metodo responsavel por atualizar uma informacao em um usuario.
	 * Verificando antes sua existencia no mapa de usuarios e a existencia do
	 * atributo escolhido.
	 * 
	 * @param nome
	 *            Nome do usuario.
	 * @param telefone
	 *            Telefone do usuario.
	 * @param atributo
	 *            Atributo escolhido para ser retornado.
	 * @param valor
	 *            Novo valor do atributo escolhido.
	 */
	public void atualizarUsuario(String nome, String telefone, String atributo, String valor) {

		ChaveNomeTelefone chave = new ChaveNomeTelefone(nome, telefone);

		verificaExistenciaChaveMapa(chave);

		Usuario usuario = identificaUsuario(nome, telefone);

		if (atributo.equals("Email"))
			usuario.setEmail(valor);

		else if (atributo.equals("Telefone")) {
			usuario.setTelefone(valor);
			ChaveNomeTelefone newChave = new ChaveNomeTelefone(nome, valor);
			this.usuarios.put(newChave, usuario);
			this.usuarios.remove(chave);

		} else if (atributo.equals("Nome")) {
			usuario.setNome(valor);
			ChaveNomeTelefone newChave = new ChaveNomeTelefone(valor, telefone);
			this.usuarios.put(newChave, usuario);
			this.usuarios.remove(chave);

		} else
			Exceptions.atributoInvalidoException();

	}

	/**
	 * Metodo responsavel por identificar um usuario no mapa de usuarios e
	 * retornar o mesmo.
	 * 
	 * @param nome
	 *            Nome do usuario.
	 * @param telefone
	 *            Telefone do usuario.
	 * 
	 * @return Retorna um objeto do tipo usuario, que encontra-se no mapa de
	 *         usuarios.
	 */
	public Usuario identificaUsuario(String nome, String telefone) {

		ChaveNomeTelefone chave = new ChaveNomeTelefone(nome, telefone);

		verificaExistenciaChaveMapa(chave);

		return usuarios.get(chave);
	}

	/**
	 * Metodo responsavel por retornar o conjunto de itens do usuario escolhido
	 * para que ela possa ser processada no controllador de itens.
	 * 
	 * @param nome
	 *            Nome do usuario.
	 * @param telefone
	 *            Telefone do usuario.
	 * 
	 * @return Retorna um Set com esse conjunto.
	 */
	public Set<Item> retornaUsuarioItens(String nome, String telefone) {

		Usuario usuario = identificaUsuario(nome, telefone);

		return usuario.retornaSeusItens();

	}

	/**
	 * Metodo responsavel identificar o usuario e solicitar ao mesmo a
	 * atualizacao na reputacao. Apontando se ela eh positiva ou negativa, a
	 * partir do boolean que eh passado.
	 * 
	 * @param nome
	 *            Nome do usuario.
	 * @param telefone
	 *            Telefone do usuario.
	 * @param valor
	 *            Valor da modificacao na reputacao.
	 * @param acresce
	 *            Indicador de acrescimo ou decrescimo na reputacao.
	 */
	public void atualizaReputacao(String nome, String telefone, double valor, boolean acresce) {

		Usuario usuario = identificaUsuario(nome, telefone);

		usuario.atualizaReputacao(valor, acresce);

	}

	/**
	 * Metodo responsavel por retornar os itens de todos os usuarios cadastrados
	 * no sistema.
	 * 
	 * @return Retorna um set com esses valores.
	 */
	public Set<Item> todosUsuariosItens() {
		Set<Item> listaTodosItens = new HashSet<Item>();

		for (Usuario usuario : this.usuarios.values()) {
			listaTodosItens.addAll(usuario.retornaSeusItens());
		}
		return listaTodosItens;
	}

	/**
	 * Metodo responsavel verificar a fidelidade de um usuario, lancando uma
	 * excecao quando o mesmo nao tiver essa permissao.
	 * 
	 * @param nomeRequerente
	 *            Nome do usuario que sera analisado.
	 * @param telefoneRequerente
	 *            Telefone do usuario que sera analisado.
	 */
	public void verificaFidelidadeUsuario(String nomeRequerente, String telefoneRequerente) {

		Usuario usuario = identificaUsuario(nomeRequerente, telefoneRequerente);

		if (!usuario.getCartao().permisaoPegarEmprestado())
			Exceptions.usuarioNaoPodePegarItemException();
	}

	/**
	 * Metodo responsavel por verificar a disponibilidade de um usuario pegar um
	 * item pela quantidade de dias indicada.
	 * 
	 * @param nomeRequerente
	 *            Nome do usuario.
	 * @param telefoneRequerente
	 *            Telefone do usuario.
	 * @param periodo
	 *            Periodo de dias solicitado.
	 */
	public void verificadisponibilidadeUsuario(String nomeRequerente, String telefoneRequerente, int periodo) {

		Usuario usuario = identificaUsuario(nomeRequerente, telefoneRequerente);

		if (usuario.getCartao().prazoEmprestimo() < periodo)
			Exceptions.usuarioImpossibilitadoDePegarItemNessePeriodoException();

	}

	/**
	 * Metodo responsavel por listar os caloteiros do sistema, ou seja aqueles
	 * que tem a reputacao menor que zero.
	 * 
	 * @return Retorna uma string com essa listagem.
	 */
	public String listarCaloteiros() {
		String stringCaloteiros = "Lista de usuarios com reputacao negativa: ";

		List<Usuario> caloteiros = new ArrayList<Usuario>();

		for (Usuario usuario : this.usuarios.values()) {
			if (usuario.getReputacao() < 0.0) {
				caloteiros.add(usuario);
			}
		}
		Collections.sort(caloteiros);

		for (Usuario usuario : caloteiros) {
			stringCaloteiros += usuario.toString() + "|";
		}
		return stringCaloteiros;
	}

	/**
	 * Metodo responsavel por listar os dez melhores usuarios cadastrados no
	 * sistema, ou seja, aqueles que tem as melhores reputacoes.
	 * 
	 * @return Retorna uma string com essa listagem.
	 */
	public String listarTop10MelhoresUsuarios() {
		String stringTop10MelhoresUsuarios = "";

		List<Usuario> top10MelhoresUsuarios = new ArrayList<Usuario>(this.usuarios.values());

		Collections.sort(top10MelhoresUsuarios, new OrdenaUsuarioReputacaoDecrescente());

		int posicaoTop10 = 1;

		for (Usuario usuario : top10MelhoresUsuarios) {
			if (posicaoTop10 == 11) {
				break;
			}
			stringTop10MelhoresUsuarios += posicaoTop10 + ": " + usuario.getNome() + " - Reputacao: "
					+ String.format("%.2f", usuario.getReputacao()) + "|";

			posicaoTop10++;
		}
		return stringTop10MelhoresUsuarios;

	}

	/**
	 * Metodo responsvel por listar os dez piores usuarios cadastrados no
	 * sistema, ou seja, aqueles que tem as piores reputacoes.
	 * 
	 * @return Retorna uma string com essa listagem.
	 */
	public String listarTop10PioresUsuarios() {
		String stringTop10PioresUsuarios = "";

		List<Usuario> top10PioresUsuarios = new ArrayList<Usuario>(this.usuarios.values());

		Collections.sort(top10PioresUsuarios, new OrdenaUsuarioReputacaoCrescente());

		int posicaoTop10 = 1;

		for (Usuario usuario : top10PioresUsuarios) {
			if (posicaoTop10 == 11) {
				break;
			}
			stringTop10PioresUsuarios += posicaoTop10 + ": " + usuario.getNome() + " - Reputacao: "
					+ String.format("%.2f", usuario.getReputacao()) + "|";

			posicaoTop10++;
		}
		return stringTop10PioresUsuarios;
	}
}