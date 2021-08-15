package br.com.mariah.mudi.controller;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.mariah.mudi.model.Pedido;
import br.com.mariah.mudi.repository.PedidoRepository;

@Controller
public class HomeController {
	@Autowired
	private PedidoRepository pedidoRepository;

	@GetMapping("/home")
	public String home(Model model) {
		model.addAttribute("pedidos", this.pedidoRepository.findAll());
		return "home";
	}
}
