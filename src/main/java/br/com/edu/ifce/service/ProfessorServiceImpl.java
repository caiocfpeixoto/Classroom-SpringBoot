package br.com.edu.ifce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.edu.ifce.dao.ProfessorDao;
import br.com.edu.ifce.domain.Professor;

@Service
public class ProfessorServiceImpl implements ProfessorService{
	
	@Autowired
	private ProfessorDao dao;
	
	@Override
	@Transactional(readOnly = false)
	public void salvar(Professor professor) {
		dao.save(professor);
	}

	@Override
	@Transactional(readOnly = false)
	public void editar(Professor professor) {
		dao.update(professor);
	}

	@Override
	@Transactional(readOnly = false)
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

	@Override
	public List<Professor> buscarPorNome(String nome) {
		return dao.findByNome(nome);
	}

}
