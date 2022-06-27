package br.com.edu.ifce.service;

import java.util.List;

import br.com.edu.ifce.domain.Professor;

public interface ProfessorService {

	void salvar(Professor professor);
	
	void editar(Professor professor);
	
	void excluir(Long id);
	
	Professor buscarPorId(Long id);
	
	List<Professor> buscarTodos();
}
