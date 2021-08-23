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
@RequestMapping("/home")
public class HomeController {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	@GetMapping
	public String home(Model model, Principal principal) {
		model.addAttribute("pedidos", this.pedidoRepository.findAllByUsuario(principal.getName()));
		return "home";
	}
	
	@GetMapping("/{status}")
	public String porStatus(@PathVariable("status")String status, Model model) {
		model.addAttribute("pedidos", this.pedidoRepository.findByStatus(StatusPedido.valueOf(status.toUpperCase())));
		model.addAttribute("status",status);
		return "home";
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public String onError() {
		return "redirect:/home";
	}
}
