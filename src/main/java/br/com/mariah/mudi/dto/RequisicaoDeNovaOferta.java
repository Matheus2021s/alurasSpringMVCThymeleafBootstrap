package br.com.mariah.mudi.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import br.com.mariah.mudi.model.Oferta;

public class RequisicaoDeNovaOferta {

	
	private Long pedidoId;
	
	private String valor;
	
	private String dataEntrega;
	
	private String comentario;

	public Long getPedidoId() {
		return pedidoId;
	}

	public void setPedidoId(Long pedidoId) {
		this.pedidoId = pedidoId;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(String dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Oferta toOferta() {
		Oferta retorno = new Oferta();
		retorno.setId(getPedidoId());
		retorno.setComentario(getComentario());
		retorno.setValor(new BigDecimal(getValor()));
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		retorno.setDataDaEntrega(LocalDate.parse(getDataEntrega(), formatter) );
		return retorno;
	}
	
	
	
}
