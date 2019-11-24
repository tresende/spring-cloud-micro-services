package br.com.thiagoresende.loja.dto;

public class EnderecoDTO {
	private String rua;
	private String estado;
	private int numero;

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	@Override
	public String toString() {
		return "Estado " + estado + ",  Rua " + rua + " " + numero;
	}

}
