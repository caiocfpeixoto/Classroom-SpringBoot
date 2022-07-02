package br.com.edu.ifce.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.edu.ifce.domain.Aluno;
import br.com.edu.ifce.domain.Turma;
import br.com.edu.ifce.service.AlunoService;
import br.com.edu.ifce.service.TurmaService;


@Controller
@RequestMapping("/alunos")
public class AlunoController {
	
	@Autowired
	private AlunoService service;
	
	@Autowired
	private TurmaService turmaService;
	
	@GetMapping("/cadastrar")
	public String cadastrar(Aluno aluno) {
		return "/aluno/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("alunos", service.buscarTodos());
		return "aluno/lista";
	}
	
	@PostMapping("/salvar")
	public String salvar(Aluno aluno, RedirectAttributes attr) {
		service.salvar(aluno);
		attr.addFlashAttribute("success", "Aluno inserido com sucesso.");
		return "redirect:/alunos/cadastrar";
	}
	
	@ModelAttribute("turmas")
	public List<Turma> getTurmas(){
		return turmaService.buscarTodos();
	}
}
