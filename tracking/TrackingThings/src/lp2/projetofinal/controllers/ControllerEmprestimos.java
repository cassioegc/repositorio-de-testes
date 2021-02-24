package lp2.projetofinal.controllers;

/**
 * Classe responsavel por controlar todos os objetos Emprestimo registrados no sistema.
 * 
 * Laboratorio de Programacao 2 - Projeto Final Parte 01
 * 
 * @author Thiago Santos de Moura - 116210967
 * @author Gabriel Almeida Azevedo - 116210009
 * @author Marcelo Gabriel dos Santos Queiroz Vitorino - 116211290
 */

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import lp2.projetofinal.entidades.Emprestimo;
import lp2.projetofinal.entidades.Item;
import lp2.projetofinal.entidades.Usuario;
import lp2.projetofinal.enums.EstadoItem;
import lp2.projetofinal.orders.OrdenaItemEmprestadoAlfabetico;
import lp2.projetofinal.persistencia.Persistencia;
import lp2.projetofinal.util.Exceptions;

public class ControllerEmprestimos {

	private List<Emprestimo> emprestimos;

	/**
	 * Construtor de ControllerEmprestimos;
	 */
	public ControllerEmprestimos() {
		this.emprestimos = new ArrayList<Emprestimo>();
	}

	/**
	 * Metodo responsavel por carregar a lista de emprestimos, caso exista na
	 * persistencia.
	 */
	public void carregaListaEmprestimos() {

		if (!(Persistencia.carregaEmprestimos() == null))
			this.emprestimos = Persistencia.carregaEmprestimos();
	}

	/**
	 * Metodo responsavel por salvar a lista de emprestimos na persistencia.
	 */
	public void salvarListaEmprestimos() {
		Persistencia.salvarEmprestimos(this.emprestimos);
	}

	/**
	 * Metodo responsavel por cadastrar um novo Emprestimo no sistema. Veficando
	 * antes a disponibilidade do item escolhido e solicitando a alteração do
	 * seu estado após registro realizado.
	 * 
	 * @param donoItem
	 *            Objeto do tipo Usuario resgatado pelo controlador de usuarios
	 *            e dono do item que será emprestado.
	 * @param requerenteItem
	 *            Objeto do tipo Usuario resgatado pelo controlador de usuarios
	 *            e requerente do item.
	 * @param item
	 *            Objeto do tipo Item, resgatado pelo contralador de itens.
	 * @param dataEmprestimo
	 *            Dado da solicitação do emprestimo, passada como string.
	 * @param periodo
	 *            Periodo de duração do emprestimo.
	 */
	public void registrarEmprestimo(Usuario donoItem, Usuario requerenteItem, Item item, String dataEmprestimo,
			int periodo) {

		if (item.getEstado().equals(EstadoItem.EMPRESTADO.getEstado()))
			Exceptions.itemEmprestadoNoMomento();

		Emprestimo emprestimo = new Emprestimo(donoItem, requerenteItem, item, dataEmprestimo, periodo);

		this.emprestimos.add(emprestimo);
		item.atualizaNumeroEmprestimos();
		item.itemEmprestado();
	}

	/**
	 * Metodo responsavel realizar a devolução do item que foi emprestado,
	 * identifando antes o objeto do tipo Emprestimo na lista de emprestimos e
	 * apos a devolucao, retorna o total de dias percorridos.
	 * 
	 * @param donoItem
	 *            Objeto do tipo Usuario resgatado pelo controlador de usuarios
	 *            e dono do item que foi emprestado.
	 * @param requerenteItem
	 *            Objeto do tipo Usuario resgatado pelo controlador de usuarios
	 *            e requerente do item que foi emprestado.
	 * @param item
	 *            Objeto do tipo Item, resgatado pelo contralador de itens.
	 * @param dataEmprestimo
	 *            Dado da solicitação do emprestimo, passada como string.
	 * @param dataDevolucao
	 *            Data da entrega do item.
	 * 
	 * @return Retorna um int com a quantidade de dias percorridos.
	 */
	public int devolverItem(Usuario donoItem, Usuario requerenteItem, Item item, String dataEmprestimo,
			String dataDevolucao) {

		Emprestimo emprestimo = identificaEmprestimo(donoItem, requerenteItem, dataEmprestimo);

		emprestimo.setDataDevolucao(dataDevolucao);
		item.itemDevolvido();

		return calcularDiasAtraso(dataEmprestimo, dataDevolucao, emprestimo.getNumeroDias());

	}

	/**
	 * Metodo responsavel por identificar um Emprestimo na lista de emprestimo.
	 * Para isso ele instancia uma referencia de desse objeto emprestimo para
	 * que seja possivel encontrar o igual na lista.
	 * 
	 * @param donoItem
	 *            Objeto do tipo Usuario resgatado pelo controlador de usuarios
	 *            e dono do item que foi emprestado.
	 * @param requerenteItem
	 *            Objeto do tipo Usuario resgatado pelo controlador de usuarios
	 *            e requerente do item que foi emprestado.
	 * @param dataEmprestimo
	 *            Dado da solicitação do emprestimo, passada como string.
	 * 
	 * @return Retorna um objeto do tipo Emprestimo, que encontra-se na lista de
	 *         emprestimos.
	 */
	public Emprestimo identificaEmprestimo(Usuario donoItem, Usuario requerenteItem, String dataEmprestimo) {

		Emprestimo emprestimo = new Emprestimo(donoItem, requerenteItem, dataEmprestimo);

		if (!this.emprestimos.contains(emprestimo))
			Exceptions.emprestimoNaoEncontrado();

		return this.emprestimos.get(this.emprestimos.indexOf(emprestimo));
	}

	/**
	 * Metodo responsavel por listar os emprestimos em que o usuario eh o dono
	 * do item, em ordem alfabetica pelo nome do item.
	 * 
	 * @param usuario
	 *            Objeto usuario dono do item no emprestimo.
	 * 
	 * @return Retorna uma string com essa listagem.
	 */
	public String listarEmprestimosEmprestandoOrdenadosPorNomeItem(Usuario usuario) {

		List<Emprestimo> listaEmprestimos = retornaListaEmprestimos(usuario, true);

		if (listaEmprestimos.isEmpty())
			return "Nenhum item emprestado";

		Collections.sort(listaEmprestimos, new OrdenaItemEmprestadoAlfabetico());

		String stringEmprestimos = "Emprestimos: ";
		for (Emprestimo emprestimo : listaEmprestimos) {
			stringEmprestimos += emprestimo.toString() + "|";
		}

		return stringEmprestimos;
	}

	/**
	 * Metodo responsavel por listar os emprestimos em que o usuario eh o
	 * requerente do item, em ordem alfabetica pelo nome do item.
	 * 
	 * @param usuario
	 *            Objeto usuario requerente do item no emprestimo.
	 * 
	 * @return Retorna uma string com essa listagem.
	 */
	public String listarEmprestimosRequerenteOrdenadosPorNomeItem(Usuario usuario) {

		List<Emprestimo> listaEmprestimos = retornaListaEmprestimos(usuario, false);

		if (listaEmprestimos.isEmpty())
			return "Nenhum item pego emprestado";

		Collections.sort(listaEmprestimos, new OrdenaItemEmprestadoAlfabetico());

		String stringEmprestimos = "Emprestimos pegos: ";
		for (Emprestimo emprestimo : listaEmprestimos) {
			stringEmprestimos += emprestimo.toString() + "|";
		}

		return stringEmprestimos;
	}

	/**
	 * Metodo responsavel por retornar a lista com os emprestimos em que o
	 * usuario faz parte. No caso do booleano ser true, retorna os que ele eh o
	 * dono do item, e no caso de false, os que ele eh o requerente.
	 * 
	 * @param usuario
	 *            Usuario que sera comparado.
	 * 
	 * @param emprestando
	 *            Booleano com a escolha de referencia para usuario.
	 * 
	 * @return Retorna uma lista com esses emprestimos.
	 */
	private List<Emprestimo> retornaListaEmprestimos(Usuario usuario, boolean emprestando) {

		List<Emprestimo> listaEmprestimos = new ArrayList<Emprestimo>();

		for (Emprestimo emprestimo : this.emprestimos) {

			if (emprestando) {
				if (emprestimo.getDonoDoItem().equals(usuario))
					listaEmprestimos.add(emprestimo);
			} else {
				if (emprestimo.getUsuarioRequerente().equals(usuario))
					listaEmprestimos.add(emprestimo);
			}
		}
		return listaEmprestimos;
	}

	/**
	 * Metodo responsavel os emprestimos em que o item participou, idependente
	 * de serem o mesmo item no sistema ou do mesmo dono.
	 * 
	 * @param nomeItem
	 *            Nome do item.
	 * 
	 * @return Retorna uma string com a lista de emprestimos associados a esse
	 *         item.
	 */
	public String listarEmprestimosItens(String nomeItem) {

		String stringEmprestimos = "Emprestimos associados ao item: ";

		for (Emprestimo emprestimo : this.emprestimos) {
			if (emprestimo.getItem().getNome().equals(nomeItem)) {
				stringEmprestimos += emprestimo.toString() + "|";
			}
		}

		if (!stringEmprestimos.contains("|"))
			return "Nenhum emprestimos associados ao item";

		return stringEmprestimos;

	}

	/**
	 * Metodo responsavel por listar os itens que estão sendo emprestados no
	 * momento, em ordem alfabetica. Mas especificamente, o nome do dono do item
	 * e o nome dele.
	 * 
	 * @return Retorna uma string com essas listagem.
	 */
	public String listarItensEmprestados() {

		String stringItens = "";
		List<Emprestimo> listaEmprestimos = new ArrayList<Emprestimo>(emprestimos);
		Collections.sort(listaEmprestimos, new OrdenaItemEmprestadoAlfabetico());

		List<String> listaStrings = new ArrayList<String>();
		String item;

		for (Emprestimo emprestimo : listaEmprestimos) {
			if (emprestimo.getItem().getEstado().equals(EstadoItem.EMPRESTADO.getEstado())) {
				item = "Dono do item: " + emprestimo.getDonoDoItem().getNome() + ", Nome do item emprestado: "
						+ emprestimo.getItem().getNome() + "|";
				if (!listaStrings.contains(item)) {
					stringItens += item;
					listaStrings.add(item);
				}
			}
		}
		return stringItens;
	}

	/**
	 * Metodo responsavel por calcular e retornar os dias percorridos dentre a
	 * data de devolucao e data de emprestimo.
	 * 
	 * @param dataEmprestimo
	 *            String da data de emprestimo.
	 * @param dataDevolucao
	 *            String da data de devolucao.
	 * @param diasParaDevolucao
	 *            Periodo de dias acordado no empresimo.
	 * 
	 * @return Retorna um int com esse calculo.
	 */
	private int calcularDiasAtraso(String dataEmprestimo, String dataDevolucao, int diasParaDevolucao) {

		DateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
		try {

			Date dataEmprestimo1 = formatoData.parse(dataEmprestimo);
			Date dataDevolucao1 = formatoData.parse(dataDevolucao);

			int diasAtraso = (int) (((dataDevolucao1.getTime() - dataEmprestimo1.getTime()) / 86400000L)
					- diasParaDevolucao);

			return diasAtraso;
		} catch (ParseException e) {
		}
		return 0;
	}

}
