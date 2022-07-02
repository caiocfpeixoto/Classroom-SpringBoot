package br.com.edu.ifce.domain;


import java.util.List;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name= "tabela_aluno")
public class Aluno extends AbstractEntity<Long>{
	
	@Column(name="nome", nullable = false, unique = true, length = 60)
	private String nome;
	
	@Column(name="email_institucional", nullable = false, unique = true, length = 60)
	private String email_institucional;
	
	@ManyToMany(mappedBy = "aluno")
	private List<Turma> turma;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail_institucional() {
		return email_institucional;
	}
	public void setEmail_institucional(String email_institucional) {
		this.email_institucional = email_institucional;
	}
	public List<Turma> getTurma() {
		return turma;
	}
	public void setTurma(List<Turma> turma) {
		this.turma = turma;
	}

}
