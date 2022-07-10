package br.com.edu.ifce.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.edu.ifce.domain.Aluno;

@Repository
public class AlunoDaoImpl extends AbstractDao<Aluno, Long> implements AlunoDao{

	@Override
	public List<Aluno> findByNome(String nome) {
		
		TypedQuery<Aluno> query = getEntityManager()
				.createQuery("select a from Aluno a where a.nome like :nome", Aluno.class);
		query.setParameter("nome", nome);
		return query.getResultList();
	}

	@Override
	public List<Aluno> findByTurmaId(Long id) {
		return createQuery("select a from Aluno a where a.turma.id = ?1", id);
	}

}
