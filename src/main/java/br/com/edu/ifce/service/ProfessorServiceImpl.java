package br.com.edu.ifce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.edu.ifce.dao.ProfessorDao;
import br.com.edu.ifce.domain.Professor;

@Service
@Transactional(readOnly = false)
public class ProfessorServiceImpl implements ProfessorService{
	
	@Autowired
	private ProfessorDao dao;
	
	@Override
	public void salvar(Professor professor) {
		dao.save(professor);
	}

	@Override
	public void editar(Professor professor) {
		dao.update(professor);
	}

	@Override
	public void excluir(Long id) {
		dao.delete(id);
	}

	@Override @Transactional(readOnly = true)
	public Professor buscarPorId(Long id) {

		return dao.findById(id);
	}

	@Override @Transactional(readOnly = true)
	public List<Professor> buscarTodos() {

		return dao.findAll();
	}

	@Override
	public boolean professorTemTurmas(Long id) {
		if(buscarPorId(id).getTurma().isEmpty()) {
			return false;
		}
		return true;
	}

}
