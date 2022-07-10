package br.com.edu.ifce.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@SuppressWarnings("serial")
@Entity
@Table(name= "tabela_turma")
public class Turma extends AbstractEntity<Long>{
	
	@NotBlank(message = "Informe um nome.")
	@Size(min=3,max= 60,message = "O nome da turma deve ter entre {min} e {max} caracteres.")
	@Column(name="nome", nullable = false, unique = true, length = 60)
	private String nome;
	
	@NotBlank(message = "Informe um código.")
	@Size(min=5,max= 60,message = "O código da turma deve ter entre {min} e {max} caracteres.")
	@Column(name="codigo", nullable = false, unique = true, length = 7)
	private String codigo;
	
	@NotNull(message = "Selecione o professor relativo a turma.")
	@ManyToOne
	@JoinColumn(name="id_professor_fk")
	private Professor professor;
	
	@OneToMany(mappedBy = "turma")
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
