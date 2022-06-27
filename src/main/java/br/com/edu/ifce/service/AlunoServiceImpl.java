package br.com.edu.ifce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.edu.ifce.dao.AlunoDao;
import br.com.edu.ifce.domain.Aluno;

@Service
@Transactional(readOnly = false)
public class AlunoServiceImpl implements AlunoService{

	@Autowired
	private AlunoDao dao;
	
	@Override
	public void salvar(Aluno aluno) {
		dao.save(aluno);
	}

	@Override
	public void editar(Aluno aluno) {
		dao.update(aluno);
	}

	@Override
	public void excluir(Long id) {
		dao.delete(id);
	}

	@Override @Transactional(readOnly = true)
	public Aluno buscarPorId(Long id) {

		return dao.findById(id);
	}

	@Override @Transactional(readOnly = true)
	public List<Aluno> buscarTodos() {
	
		return dao.findAll();
	}

}
