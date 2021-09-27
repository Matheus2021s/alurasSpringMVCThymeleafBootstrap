package br.com.mariah.mudi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.mariah.mudi.repository.PedidoRepository;

@Controller
@RequestMapping("/oferta")
public class OfertaController {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@GetMapping
	public String getFormularioParaOfertas() {
		return "oferta/home";
	}
}
