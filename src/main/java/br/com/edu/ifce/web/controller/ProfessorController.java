package br.com.edu.ifce.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.edu.ifce.domain.Professor;
import br.com.edu.ifce.service.ProfessorService;

@Controller
@RequestMapping("/professores")
public class ProfessorController {
	
	@Autowired
	private ProfessorService service;
	
	@GetMapping("/cadastrar")
	public String cadastrar(Professor professor) {
		return "/professor/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("professores", service.buscarTodos());
		return "/professor/lista";
	}
	
	@PostMapping("/salvar")
	public String salvar(Professor professor) {
		service.salvar(professor);
		return "redirect:/professores/cadastrar";
	}
}
