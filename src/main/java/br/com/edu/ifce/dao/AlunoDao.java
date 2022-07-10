package br.com.edu.ifce.dao;

import java.util.List;

import br.com.edu.ifce.domain.Aluno;

public interface AlunoDao {
	
void save(Aluno aluno);
	
	void update(Aluno aluno);
	
	void delete(Long id);
	
	Aluno findById(Long id);
	
	List<Aluno> findAll();

	List<Aluno> findByNome(String nome);

	List<Aluno> findByTurmaId(Long id);
}
