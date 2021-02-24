package lp2.projetofinal.enums;

public enum EstadoItem {

	NAO_EMPRESTADO("Nao emprestado"), EMPRESTADO("Emprestado");

	private String estado;

	public String getEstado() {
		return this.estado;
	}

	private EstadoItem(String estado) {
		this.estado = estado;
	}
	
	

}
