/**
* Representacao do genero para um BluRay
* 
* @author ................
*/

package lp2.projetofinal.enums;

public enum GeneroBluRay {
	 ACAO("ACAO"), ANIMACAO("ANIMACAO"), AVENTURA("AVENTURA"), COMEDIA("COMEDIA"), DOCUMENTARIO("DOCUMENTARIO"), DRAMA("DRAMA"),
	 EROTICO("EROTICO"), FAROESTE("FAROESTE"), FICCAO("FICCAO"), MUSICAL("MUSICAL"), POLICIAL("POLICIAL"), ROMANCE("ROMANCE"), 
	 SUSPENSE("SUSPENSE"), TERROR("TERROR"), OUTRO("OUTRO");
	
	
	private String genero;

	/**
	 *
	 * @param novoGenero
	 *            O genero do BluRay.
	 * 
	 */
	private GeneroBluRay(String novoGenero) {
		this.genero = novoGenero;
	}

	/**
	 * Recupera o genero do BluRay.
	 *
	 * @return O genero do BluRay.
	 */
	public String getGenero() {
		return this.genero;
	}
	
	public static GeneroBluRay indentificaGenero(String genero) {
			
			switch(genero){
				
				case "ACAO":
					return GeneroBluRay.ACAO;
				case "ANIMACAO":
					return GeneroBluRay.ANIMACAO;	
				case "AVENTURA":
					return GeneroBluRay.AVENTURA;
				case "COMEDIA":
					return GeneroBluRay.COMEDIA;
				case "DOCUMENTARIO":
					return GeneroBluRay.DOCUMENTARIO;
				case "DRAMA":
					return GeneroBluRay.DRAMA;
				case "EROTICO":
					return GeneroBluRay.EROTICO;
				case "FAROESTE":
					return GeneroBluRay.FAROESTE;
				case "FICCAO":
					return GeneroBluRay.FICCAO;
				case "MUSICAL":
					return GeneroBluRay.MUSICAL;
				case "POLICIAL":
					return GeneroBluRay.POLICIAL;
				case "ROMANCE":
					return GeneroBluRay.ROMANCE;
				case "SUSPENSE":
					return GeneroBluRay.SUSPENSE;
				case "TERROR":
					return GeneroBluRay.TERROR;
				case "OUTRO":
					return GeneroBluRay.OUTRO;
					
				}
			return GeneroBluRay.OUTRO; /// RETORNA OQ SE TUDO DER ERRADO?
		}

}
