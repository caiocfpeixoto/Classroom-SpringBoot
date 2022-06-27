package br.com.edu.ifce.service;

import java.util.List;

import br.com.edu.ifce.domain.Turma;

public interface TurmaService {
	
	void salvar(Turma turma);
	
	void editar(Turma turma);
	
	void excluir(Long id);
	
	Turma buscarPorId(Long id);
	
	List<Turma> buscarTodos();
}
