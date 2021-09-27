package br.com.mariah.mudi.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.mariah.mudi.dto.RequisicaoNovoPedido;
import br.com.mariah.mudi.model.Pedido;
import br.com.mariah.mudi.model.User;
import br.com.mariah.mudi.repository.PedidoRepository;
import br.com.mariah.mudi.repository.UserRepository;

@Controller
@RequestMapping("pedido")
public class PedidoController {

	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private UserRepository userRepository;
	
	
	@GetMapping("formulario")
	public String formulario(RequisicaoNovoPedido requisicaoNovoPedido) {
		return "pedido/formulario";
	}
	
	@PostMapping("novo")
	public String novo( @Valid RequisicaoNovoPedido requisicaoNovoPedido, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "pedido/formulario";
		}
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		
		Pedido pedido = requisicaoNovoPedido.toPedido();
		User user = this.userRepository.findByUsername(username);
		pedido.setUser(user);
		
		this.pedidoRepository.save(pedido);
		return "redirect:/home";
	}
}
