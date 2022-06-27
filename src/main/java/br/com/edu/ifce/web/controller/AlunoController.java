package br.com.edu.ifce.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.edu.ifce.domain.Aluno;
import br.com.edu.ifce.service.AlunoService;


@Controller
@RequestMapping("/alunos")
public class AlunoController {
	
	@Autowired
	private AlunoService service;
	
	@GetMapping("/cadastrar")
	public String cadastrar(Aluno aluno) {
		return "/aluno/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("alunos", service.buscarTodos());
		return "/aluno/lista";
	}
	
	@PostMapping("/salvar")
	public String salvar(Aluno aluno) {
		service.salvar(aluno);
		return "redirect:/alunos/cadastrar";
	}
}
