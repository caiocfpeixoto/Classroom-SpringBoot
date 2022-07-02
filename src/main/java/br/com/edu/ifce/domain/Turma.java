package br.com.edu.ifce.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name= "tabela_turma")
public class Turma extends AbstractEntity<Long>{
	
	@Column(name="nome", nullable = false, unique = true, length = 60)
	private String nome;
	
	@Column(name="codigo", nullable = false, unique = true, length = 7)
	private String codigo;
	
	@ManyToOne
	@JoinColumn(name="id_professor_fk")
	private Professor professor;
	
	@ManyToMany
	@JoinTable(
	        name = "turma_aluno",
	        joinColumns = @JoinColumn(name= "id_turma_fk"),
	        inverseJoinColumns = @JoinColumn(name="id_aluno_fk")
	    )
	private List<Aluno> aluno;
	
	@OneToMany
	@JoinColumn(name="id_conteudo_fk")
	private List<Conteudo> conteudo;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public Professor getProfessor() {
		return professor;
	}
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	public List<Aluno> getAluno() {
		return aluno;
	}
	public void setAluno(List<Aluno> aluno) {
		this.aluno = aluno;
	}
	public List<Conteudo> getConteudo() {
		return conteudo;
	}
	public void setConteudo(List<Conteudo> conteudo) {
		this.conteudo = conteudo;
	}
}
