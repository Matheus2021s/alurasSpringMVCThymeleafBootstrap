package br.com.mariah.mudi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.mariah.mudi.dto.RequisicaoNovoPedido;
import br.com.mariah.mudi.model.Pedido;
import br.com.mariah.mudi.repository.PedidoRepository;

@Controller
@RequestMapping("pedido")
public class PedidoController {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	@GetMapping("formulario")
	public String formulario() {
		return "pedido/formulario";
	}
	
	@PostMapping("novo")
	public String novo(RequisicaoNovoPedido request) {
		
		Pedido pedido = request.toPedido();
		this.pedidoRepository.save(pedido);
		return "pedido/formulario";
	}
}
