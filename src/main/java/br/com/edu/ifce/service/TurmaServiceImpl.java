package br.com.edu.ifce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.edu.ifce.dao.TurmaDao;
import br.com.edu.ifce.domain.Turma;

@Service
@Transactional(readOnly = false)
public class TurmaServiceImpl implements TurmaService{

	@Autowired
	private TurmaDao dao;
	
	@Override
	public void salvar(Turma turma) {
		dao.save(turma);
	}

	@Override
	public void editar(Turma turma) {
		dao.update(turma);
	}

	@Override
	public void excluir(Long id) {
		dao.delete(id);
	}

	@Override @Transactional(readOnly = true)
	public Turma buscarPorId(Long id) {
		
		return dao.findById(id);
	}

	@Override @Transactional(readOnly = true)
	public List<Turma> buscarTodos() {

		return dao.findAll();
	}

	@Override
	public boolean turmaTemAlunos(Long id) {
		if (buscarPorId(id).getAluno().isEmpty()) {
			return false;
		}
		return true;
	}

}
