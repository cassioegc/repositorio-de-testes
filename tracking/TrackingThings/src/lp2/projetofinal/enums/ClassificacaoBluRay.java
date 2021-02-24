/**
* Representacao da classificacao para um BluRay
* 
* @author ................
*/

package lp2.projetofinal.enums;

public enum ClassificacaoBluRay {
	LIVRE("LIVRE"), DEZ_ANOS("DEZ_ANOS"), DOZE_ANOS("DOZE_ANOS"), QUATORZE_ANOS("QUATORZE_ANOS"), DEZESSEIS_ANOS(
			"DEZESSEIS_ANOS"), DEZOITO_ANOS("DEZOITO_ANOS");

	private String classificacao;

	/**
	 *
	 * @param novaClassificacao
	 *            A descricao do estado.
	 * 
	 */
	private ClassificacaoBluRay(String novaClassificacao) {
		this.classificacao = novaClassificacao;
	}

	/**
	 * Recupera a classificacao do BluRay.
	 *
	 * @return A classificacao do BluRay.
	 */
	public String getClassificacao() {
		return this.classificacao;
	}

	public static ClassificacaoBluRay indentificaClassificacao(String classificacao) {

		switch (classificacao) {

		case "LIVRE":
			return ClassificacaoBluRay.LIVRE;
		case "DEZ_ANOS":
			return ClassificacaoBluRay.DEZ_ANOS;
		case "DOZE_ANOS":
			return ClassificacaoBluRay.DOZE_ANOS;
		case "QUATORZE_ANOS":
			return ClassificacaoBluRay.QUATORZE_ANOS;
		case "DEZESSEIS_ANOS":
			return ClassificacaoBluRay.DEZESSEIS_ANOS;
		case "DEZOITO_ANOS":
			return ClassificacaoBluRay.DEZOITO_ANOS;

		}
		return null;
	}

}
