package br.com.edu.ifce.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@SuppressWarnings("serial")
@Entity
@Table(name="tabela_professor")
public class Professor extends AbstractEntity<Long>{
	
	@Column(name="nome", nullable = false, unique = true, length = 60)
	private String nome;
	
	@Column(name="email", nullable = false, unique = true, length = 60)
	private String email;
	
	@OneToMany(mappedBy = "professor")
	private List<Turma> turma;
	
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
	public List<Turma> getTurma() {
		return turma;
	}
	public void setTurma(List<Turma> turma) {
		this.turma = turma;
	}
	
}
