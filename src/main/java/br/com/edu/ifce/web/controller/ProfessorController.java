package br.com.edu.ifce.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	public String salvar(@Valid Professor professor, BindingResult result, RedirectAttributes attr) {
		
		if(result.hasErrors()) {
			return "/professor/cadastro";
		}
		
		service.salvar(professor);
		attr.addFlashAttribute("success", "Professor inserido com sucesso.");
		return "redirect:/professores/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("professor", service.buscarPorId(id));
		return "professor/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(@Valid Professor professor, BindingResult result, RedirectAttributes attr) {

		if(result.hasErrors()) {
			return "/professor/cadastro";
		}
		
		service.editar(professor);
		attr.addFlashAttribute("success", "Professor editado com sucesso.");
		return "redirect:/professores/cadastrar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		if(service.professorTemTurmas(id)) {
			model.addAttribute("fail", "Professor não removido. Possui Turma(s) vinculado(s).");
		}else {
			service.excluir(id);
			model.addAttribute("success", "Professor excluido com sucesso.");
		}
		
		return listar(model);
	}
	
	@GetMapping("/buscar/nome")
	public String getPorNome(@RequestParam("nome") String nome, ModelMap model) {		
		model.addAttribute("professores", service.buscarPorNome(nome));
		return "/professor/lista";
	}
}
