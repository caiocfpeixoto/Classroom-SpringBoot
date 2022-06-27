package br.com.edu.ifce.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/turmas")
public class TurmaController {
	
	@GetMapping("/cadastrar")
	public String cadastrar() {
		return "/turma/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar() {
		return "/turma/lista";
	}
	
}
