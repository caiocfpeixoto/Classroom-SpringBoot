package br.com.edu.ifce.domain;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name= "tabela_aluno")
public class Aluno extends AbstractEntity<Long>{
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="email_institucional")
	private String email_institucional;
	
	@ManyToMany(mappedBy = "aluno")
	private Collection<Turma> turma = new ArrayList<Turma>();
	
	
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
	public Collection<Turma> getTurma() {
		return turma;
	}
	public void setTurma(Collection<Turma> turma) {
		this.turma = turma;
	}
	
}
