package br.com.mariah.mudi.dto;

import javax.validation.constraints.NotBlank;

import br.com.mariah.mudi.model.Pedido;
import br.com.mariah.mudi.model.StatusPedido;

public class RequisicaoNovoPedido {

	@NotBlank
	private String nomeProduto;
	
	@NotBlank
	private String urlProduto;
	
	@NotBlank
	private String urlImagem;

	@NotBlank
	private String descricaoProduto;

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public String getUrlProduto() {
		return urlProduto;
	}

	public void setUrlProduto(String urlProduto) {
		this.urlProduto = urlProduto;
	}

	public String getUrlImagem() {
		return urlImagem;
	}

	public void setUrlImagem(String urlImagem) {
		this.urlImagem = urlImagem;
	}

	public String getDescricaoProduto() {
		return descricaoProduto;
	}

	public void setDescricaoProduto(String descricaoProduto) {
		this.descricaoProduto = descricaoProduto;
	}

	public Pedido toPedido() {
		Pedido pedido = new Pedido();
		pedido.setNomeProduto(getNomeProduto());
		pedido.setUrlProduto(getUrlProduto());
		pedido.setUrlImagem(getUrlImagem());
		pedido.setDescricao(getDescricaoProduto());
		pedido.setStatus(StatusPedido.AGUARDANDO);
		return pedido;
	}

}
