package br.com.edu.ifce.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.edu.ifce.domain.Turma;

@Repository
public class TurmaDaoImpl extends AbstractDao<Turma, Long> implements TurmaDao{

	@Override
	public List<Turma> findByNome(String nome) {
		TypedQuery<Turma> query = getEntityManager()
				.createQuery("select t from Turma t where t.nome like :nome", Turma.class);
		query.setParameter("nome", nome);
		return query.getResultList();
	}

	@Override
	public List<Turma> findByProfessorId(Long id) {
		return createQuery("select t from Turma t where t.professor.id = ?1", id);
	}
	
}
