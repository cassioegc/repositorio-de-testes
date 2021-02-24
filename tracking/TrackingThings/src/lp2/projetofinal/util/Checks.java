package lp2.projetofinal.util;

/**
 * Classe responsavel por encapsular os metodos relacionados a validacoes no
 * projeto.
 * 
 * Laboratorio de Programacao 2 - Projeto Final Parte 01
 * 
 * @author Thiago Santos de Moura - 116210967
 * @author Gabriel Almeida Azevedo - 116210009
 * @author Marcelo Gabriel dos Santos Queiroz Vitorino - 116211290
 */

public class Checks {

	/**
	 * Metodo responsavel por validar o atributo nome. Lanca excessao em caso de
	 * irregularidade.
	 * 
	 * @param nome
	 *            = string com o nome do usuario.
	 */
	public static void verificaNomeVazioNulo(String nome) {
		if (nome.trim().isEmpty())
			throw new IllegalArgumentException("Nome usuario nao pode ser vazio ou nulo");
	}

	/**
	 * Metodo responsavel por validar o atributo telefone. Lanca excessao em
	 * caso de irregularidade.
	 * 
	 * @param telefone
	 *            = string com o telefone do usuario.
	 */
	public static void verificaTelefoneVazioNulo(String telefone) {
		if (telefone.trim().isEmpty())
			throw new IllegalArgumentException("Telefone nao pode ser vazio ou nulo");
	}

	/**
	 * Metodo responsavel por validar o atributo email. Lanca excessao em caso
	 * de irregularidade.
	 * 
	 * @param email
	 *            = string com o email do usuario.
	 */
	public static void verificaEmailVazioNulo(String email) {
		if (email.trim().isEmpty())
			throw new IllegalArgumentException("Email nao pode ser vazio ou nulo");
	}

	/**
	 * Metodo responsavel por validar o atributo ATRIBUTO(atributo representa
	 * qual atributo do objeto o usuario deseja consutar ou mudar). Lanca
	 * excessao em caso de irregularidade.
	 * 
	 * @param atributo
	 *            = string com o atributo em questao.
	 */
	public static void verificaAtributolVazioNulo(String atributo) {
		if (atributo.trim().isEmpty())
			throw new IllegalArgumentException("Atributo nao pode ser vazio ou nulo");
	}

	/**
	 * Metodo responsavel por validar o atributo valor. Lanca excessao em caso
	 * de irregularidade.
	 * 
	 * @param valor
	 *            = string com o valor dos itens.
	 */
	public static void verificaValorVazioNulo(String valor) {
		if (valor.trim().isEmpty())
			throw new IllegalArgumentException("Valor nao pode ser vazio ou nulo");
	}

	/**
	 * Metodo responsavel por validar o atributo preco. Lanca excessao em caso
	 * de irregularidade.
	 * 
	 * @param preco
	 *            = double com o preco do item.
	 */
	public static void verificaPrecoZeroNegativo(double preco) {
		if (preco <= 0)
			throw new IllegalArgumentException("Preco invalido");
	}

	/**
	 * Metodo responsavel por validar o atributo nomeItem. Lanca excessao em
	 * caso de irregularidade.
	 * 
	 * @param nomeItem
	 *            = String com o nome do item.
	 */
	public static void verificaNomeItemVazioNulo(String nomeItem) {
		if (nomeItem.trim().isEmpty())
			throw new IllegalArgumentException("Nome item nao pode ser vazio ou nulo");
	}

	/**
	 * Metodo responsavel por validar o atributo plataforma. Lanca excessao em
	 * caso de irregularidade.
	 * 
	 * @param plataforma
	 *            = String com o nome da plataforma.
	 */
	public static void verificaPlataformaVaziaNula(String plataforma) {
		if (plataforma.trim().isEmpty())
			throw new IllegalArgumentException("Plataforma nao pode ser vazia ou nula");
	}

	/**
	 * Metodo responsavel por validar o atributo duracao. Lanca excessao em caso
	 * de irregularidade.
	 * 
	 * @param duracao
	 *            = int com o tempo em minutos do show ou da serie ou do
	 *            episodio.
	 */
	public static void verificaDuracaoZeroNegativa(int duracao) {
		if (duracao <= 0)
			throw new IllegalArgumentException("Duracao invalida");
	}

	/**
	 * Metodo responsavel por validar o atributo genero. Lanca excessao em caso
	 * de irregularidade.
	 * 
	 * @param genero
	 *            = String com o nome do genero.
	 */
	public static void verificaGeneroVazioNulo(String genero) {
		if (genero.trim().isEmpty())
			throw new IllegalArgumentException("Genero nao pode ser vazio ou nulo");
	}

	/**
	 * Metodo responsavel por validar o atributo classificacao. Lanca excessao
	 * em caso de irregularidade.
	 * 
	 * @param classificacao
	 *            = String com o nome da classificacao.
	 */
	public static void verificaClassificacaoVaziaNula(String classificacao) {
		if (classificacao.trim().isEmpty())
			throw new IllegalArgumentException("Classificacao nao pode ser vazia ou nula");
	}

	/**
	 * Metodo responsavel por validar o atributo anoLancamento. Lanca excessao
	 * em caso de irregularidade.
	 * 
	 * @param anoLancamento
	 *            = int com o ano de lancamento.
	 */
	public static void verificaAnoLancamentoZeroNegativo(int anoLancamento) {
		if (anoLancamento <= 0)
			throw new IllegalArgumentException("Ano lancamento invalido");
	}

	/**
	 * Metodo responsavel por validar o atributo numFaixas. Lanca excessao em
	 * caso de irregularidade.
	 * 
	 * @param numFaixas
	 *            = int com a quantidade de faixas.
	 */
	public static void verificaNumeroFaixasZeroNegativo(int numFaixas) {
		if (numFaixas <= 0)
			throw new IllegalArgumentException("Numero faixas invalido");
	}

	/**
	 * Metodo responsavel por validar o atributo artista. Lanca excessao em caso
	 * de irregularidade.
	 * 
	 * @param artista
	 *            = String com o nome do artista.
	 */
	public static void verificaArtistaVazioNulo(String artista) {
		if (artista.trim().isEmpty())
			throw new IllegalArgumentException("Artista nao pode ser vazio ou nulo");
	}

	/**
	 * Metodo responsavel por validar o atributo temporada. Lanca excessao em
	 * caso de irregularidade.
	 * 
	 * @param temporada
	 *            = int com o numero da temporada.
	 */
	public static void verificaTemporadaZeroNegativa(int temporada) {
		if (temporada <= 0)
			throw new IllegalArgumentException("Temporada invalida");
	}

	/**
	 * Metodo responsavel por validar o atributo descricao. Lanca excessao em
	 * caso de irregularidade.
	 * 
	 * @param descricao
	 *            = String com a descricao da Serie.
	 */
	public static void verificaDescricaoVaziaNula(String descricao) {
		if (descricao.trim().isEmpty())
			throw new IllegalArgumentException("Descricao nao pode ser vazia ou nula");
	}

	/**
	 * Metodo responsavel por validar o atributo nomePeca. Lanca excessao em
	 * caso de irregularidade.
	 * 
	 * @param nomePeca
	 *            = String com o nome da peca.
	 */
	public static void verificaPecaVaziaNula(String nomePeca) {
		if (nomePeca.trim().isEmpty())
			throw new IllegalArgumentException("Peca nao pode ser vazia ou nula");
	}

	/**
	 * Metodo responsavel por validar o atributo dataEmprestimo. Lanca excessao
	 * em caso de irregularidade.
	 * 
	 * @param data
	 *            = String com a data do emprestimo.
	 */
	public static void verificaDataEmprestimoVaziaNula(String data) {
		if (data.trim().isEmpty())
			throw new IllegalArgumentException("Data nao pode ser vazia ou nula");
	}

	/**
	 * Metodo responsavel por validar o atributo dataDevolucao. Lanca excessao
	 * em caso de irregularidade.
	 * 
	 * @param data
	 *            = String com a data de devolucao.
	 */
	public static void verificaDataDevolucaoVaziaNula(String data) {
		if (data.trim().isEmpty())
			throw new IllegalArgumentException("Data devolucao nao pode ser vazia ou nula");
	}

	/**
	 * Metodo responsavel por validar o atributo periodo. Lanca excessao em caso
	 * de irregularidade.
	 * 
	 * @param periodo
	 *            = int com o tempo de emprestimo do item.
	 */
	public static void verificaPeriodoZeradoOuNegativo(int periodo) {
		if (periodo <= 0)
			throw new IllegalArgumentException("Periodo nao pode zero ou negativo");
	}

}
