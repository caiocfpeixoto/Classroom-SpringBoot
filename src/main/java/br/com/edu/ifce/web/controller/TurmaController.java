package br.com.edu.ifce.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.edu.ifce.domain.Professor;
import br.com.edu.ifce.domain.Turma;
import br.com.edu.ifce.service.ProfessorService;
import br.com.edu.ifce.service.TurmaService;

@Controller
@RequestMapping("/turmas")
public class TurmaController {
	
	@Autowired
	private TurmaService turmaService;
	
	@Autowired
	private ProfessorService professorService;
	
	@GetMapping("/cadastrar")
	public String cadastrar(Turma turma) {
		return "/turma/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("turmas", turmaService.buscarTodos());
		return "/turma/lista";
	}
	
	@PostMapping("/salvar")
	public String salvar(Turma turma, RedirectAttributes attr) {
		turmaService.salvar(turma);
		attr.addAttribute("sucess", "Turma inserida com sucesso.");
		return "redirect:/turmas/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("turma", turmaService.buscarPorId(id));
		return "/turma/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(Turma turma, RedirectAttributes attr) {
		turmaService.editar(turma);
		attr.addFlashAttribute("sucess", "Registro atualizado com sucesso.");
		return "redirect:/turmas/cadastrar";
	}
	
	@ModelAttribute("professores")
	public List<Professor> listaDeProfessores(){
		return professorService.buscarTodos();
	}
	
	
}
