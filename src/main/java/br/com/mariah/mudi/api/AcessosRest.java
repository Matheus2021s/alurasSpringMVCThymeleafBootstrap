package br.com.mariah.mudi.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mariah.mudi.interceptor.InterceptadorDeAcessos;
import br.com.mariah.mudi.interceptor.InterceptadorDeAcessos.Acesso;

@RestController
@RequestMapping("acessos")
public class AcessosRest {

	@GetMapping
	public List<Acesso> getAcessos(){
		return InterceptadorDeAcessos.acessos;
	}
}
