package lp2.projetofinal.enums;

public enum PlataformaJogoEletronico {

	PC("PC"), MAC("MAC"), PS3("PS3"), PS4("PS4"), XBOX360("XBOX360"), XBOX_ONE("XBOX ONE"), NINTENDO_3DS(
			"NINTENDO 3DS"), OUTRO("OUTRO");

	private String plataforma;

	public String getPlataforma() {
		return this.plataforma;
	}

	private PlataformaJogoEletronico(String plataforma) {
		this.plataforma = plataforma;
	}
    // Pq static? - marcelo - PRA PODER CHAMAR SEM CRIAR UMA PLATAFORMA OBJETO.
	public static PlataformaJogoEletronico indentificaPlataforma(String plataforma) {
		
		switch(plataforma){
			
			case "PC":
				return PlataformaJogoEletronico.PC;
				// NAO PRECISA DO BREAK NE?
			case "MAC":
				return PlataformaJogoEletronico.MAC;
			case "PS3":
				return PlataformaJogoEletronico.PS3;	
			case "PS4":
				return PlataformaJogoEletronico.PS4;
			case "XBOX360":
				return PlataformaJogoEletronico.XBOX360;
			case "XBOX_ONE":
				return PlataformaJogoEletronico.XBOX_ONE;
			case "NINTENDO_3DS":
				return PlataformaJogoEletronico.NINTENDO_3DS;
			case "OUTRO":
				return PlataformaJogoEletronico.OUTRO;
				
			}
		return PlataformaJogoEletronico.OUTRO; /// RETORNA OQ SE TUDO DER ERRADO?
	}

}
