package br.com.edu.ifce.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public String salvar(@Valid Turma turma,BindingResult result,RedirectAttributes attr) {
		
		if(result.hasErrors()) {
			return"/turma/cadastro";
		}
		
		turmaService.salvar(turma);
		attr.addFlashAttribute("success", "Turma inserida com sucesso.");
		return "redirect:/turmas/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("turma", turmaService.buscarPorId(id));
		return "turma/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(@Valid Turma turma,BindingResult result, RedirectAttributes attr) {
		
		if(result.hasErrors()) {
			return"/turma/cadastro";
		}
		
		turmaService.editar(turma);
		attr.addFlashAttribute("success", "Registro atualizado com sucesso.");
		return "redirect:/turmas/cadastrar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
		if (turmaService.turmaTemAlunos(id)) {
			attr.addFlashAttribute("fail", "Turma não excluida. Tem Aluno(s) vinculado(s).");
		} else {
			turmaService.excluir(id);
			attr.addFlashAttribute("success", "Turma excluida com sucesso.");
		}
		return "redirect:/turmas/listar";
	}
	
	@GetMapping("/buscar/nome")
	public String getPorNome(@RequestParam("nome") String nome, ModelMap model) {		
		model.addAttribute("turmas", turmaService.buscarPorNome(nome));
		return "/turma/lista";
	}
	
	@GetMapping("/buscar/professor")
	public String getPorProfessor(@RequestParam("id") Long id, ModelMap model) {
		model.addAttribute("turmas", turmaService.buscarPorProfessor(id));
		return "/turma/lista";
	}
	
	@ModelAttribute("professores")
	public List<Professor> listaDeProfessores(){
		return professorService.buscarTodos();
	}
	
	
}
