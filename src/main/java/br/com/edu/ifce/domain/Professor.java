package br.com.edu.ifce.domain;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@SuppressWarnings("serial")
@Entity
@Table(name="tabela_professor")
public class Professor extends AbstractEntity<Long>{
	
	@Column(name="nome", nullable = false, unique = true, length = 60)
	private String nome;
	
	@Column(name="email")
	private String email;
	
	@OneToMany(mappedBy = "professor")
	private Collection<Turma> turma = new ArrayList<Turma>();
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
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
