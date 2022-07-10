package br.com.edu.ifce.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;


import br.com.edu.ifce.domain.Professor;

@Repository
public class ProfessorDaoImpl extends AbstractDao<Professor, Long> implements ProfessorDao{

	@Override
	public List<Professor> findByNome(String nome) {
		TypedQuery<Professor> query = getEntityManager()
				.createQuery("select p from Professor p where p.nome like :nome", Professor.class);
		query.setParameter("nome", nome);
		return query.getResultList();
	}
	
}
