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
		return "/aluno/lista";
	}
	
	@PostMapping("/salvar")
	public String salvar(@Valid Aluno aluno, BindingResult result, RedirectAttributes attr) {
		
		if(result.hasErrors()) {
			return "/aluno/cadastro";
		}
		
		service.salvar(aluno);
		attr.addFlashAttribute("success", "Aluno inserido com sucesso.");
		return "redirect:/alunos/cadastrar";
	}
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("aluno", service.buscarPorId(id));
		return "aluno/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(@Valid Aluno aluno, BindingResult result, RedirectAttributes attr) {

		if(result.hasErrors()) {
			return "/aluno/cadastro";
		}
		
		service.editar(aluno);
		attr.addFlashAttribute("success", "Registro atualizado com sucesso.");
		return "redirect:/alunos/cadastrar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
		service.excluir(id);
		attr.addFlashAttribute("success", "Aluno excluido com sucesso.");
		return "redirect:/alunos/listar";
	}
	
	@GetMapping("/buscar/nome")
	public String getPorNome(@RequestParam("nome") String nome, ModelMap model) {		
		model.addAttribute("alunos", service.buscarPorNome(nome));
		return "/aluno/lista";
	}
	
	@GetMapping("/buscar/turma")
	public String getPorCargo(@RequestParam("id") Long id, ModelMap model) {
		model.addAttribute("alunos", service.buscarPorTurma(id));
		return "/aluno/lista";
	}
	
	@ModelAttribute("turmas")
	public List<Turma> getTurmas(){
		return turmaService.buscarTodos();
	}
}
