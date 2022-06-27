package br.com.edu.ifce.dao;

import java.util.List;

import br.com.edu.ifce.domain.Professor;

public interface ProfessorDao {
	
	void save(Professor professor);
	
	void update(Professor professor);
	
	void delete(Long id);
	
	Professor findById(Long id);
	
	List<Professor> findAll();
}
