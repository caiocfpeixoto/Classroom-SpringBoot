package br.com.edu.ifce.dao;

import java.util.List;

import br.com.edu.ifce.domain.Turma;

public interface TurmaDao {
	
	void save(Turma turma);
	
	void update(Turma turma);
	
	void delete(Long id);
	
	Turma findById(Long id);
	
	List<Turma> findAll();

	List<Turma> findByNome(String nome);

	List<Turma> findByProfessorId(Long id);
}
