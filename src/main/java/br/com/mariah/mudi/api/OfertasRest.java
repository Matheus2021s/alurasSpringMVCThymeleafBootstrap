package br.com.mariah.mudi.api;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mariah.mudi.dto.RequisicaoDeNovaOferta;
import br.com.mariah.mudi.model.Oferta;
import br.com.mariah.mudi.model.Pedido;
import br.com.mariah.mudi.repository.PedidoRepository;

@RestController
@RequestMapping("/api/ofertas")
public class OfertasRest {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	@PostMapping
	public Oferta criaOferta(  @RequestBody @Valid RequisicaoDeNovaOferta requisicaoDeNovaOferta) {
		Optional<Pedido> pedidoBuscado = this.pedidoRepository.findById(requisicaoDeNovaOferta.getPedidoId());
		if(!pedidoBuscado.isPresent()) {
			return null;
		}
		Pedido pedido = pedidoBuscado.get();
		Oferta oferta =  requisicaoDeNovaOferta.toOferta();
		oferta.setPedido(pedido);
		pedido.getOfertas().add(oferta);
		this.pedidoRepository.save(pedido);
		return oferta;
	}
}
