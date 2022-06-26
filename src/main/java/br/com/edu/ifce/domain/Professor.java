package br.com.edu.ifce.domain;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@SuppressWarnings("serial")
@Entity
@Table(name="tabela_professor")
public class Professor extends AbstractEntity<Long>{
	
	@Column(name="nome", nullable = false, unique = true, length = 60)
	private String professor_nome;
	
	@Column(name="email_professor")
	private String email;
	
	@OneToMany(mappedBy = "professor")
	private Collection<Turma> turma = new ArrayList<Turma>();
	
	
	public String getProfessor_nome() {
		return professor_nome;
	}
	public void setProfessor_nome(String professor_nome) {
		this.professor_nome = professor_nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Collection<Turma> getTurma() {
		return turma;
	}
	public void setTurma(Collection<Turma> turma) {
		this.turma = turma;
	}
	
}
