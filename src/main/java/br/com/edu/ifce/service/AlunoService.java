package br.com.edu.ifce.service;

import java.util.List;

import br.com.edu.ifce.domain.Aluno;

public interface AlunoService {

	void salvar(Aluno aluno);
	
	void editar(Aluno aluno);
	
	void excluir(Long id);
	
	Aluno buscarPorId(Long id);
	
	List<Aluno> buscarTodos();
}
