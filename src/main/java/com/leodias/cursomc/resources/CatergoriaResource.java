package com.leodias.cursomc.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/categorias")
public class CatergoriaResource {
	
	@RequestMapping(method = RequestMethod.GET)
	public String Listar() {
		return "REST está funcionando!";
	}

}
