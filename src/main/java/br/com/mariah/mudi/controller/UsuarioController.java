package br.com.mariah.mudi.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.mariah.mudi.model.StatusPedido;
import br.com.mariah.mudi.repository.PedidoRepository;

@Controller
@RequestMapping("usuario")
public class UsuarioController {
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@GetMapping("pedido")
	public String home(Model model, Principal principal) {
		model.addAttribute("pedidos", this.pedidoRepository.findAllByUsuario(principal.getName()));
		return "usuario/home";
	}
	
	@GetMapping("pedido/{status}")
	public String porStatus(@PathVariable("status")String status, Model model,Principal principal) {
		model.addAttribute("pedidos", this.pedidoRepository.findByStatusEUsuario(StatusPedido.valueOf(status.toUpperCase()), principal.getName()));
		model.addAttribute("status",status);
		return "usuario/home";
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public String onError() {
		return "redirect:/usuario/home";
	} 
}
