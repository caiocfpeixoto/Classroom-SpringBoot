package br.com.edu.ifce.domain;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@SuppressWarnings("serial")
@Entity
@Table(name= "tabela_aluno")
public class Aluno extends AbstractEntity<Long>{
	
	@NotBlank(message = "Informe um nome.")
	@Size(min=3,max= 60,message = "O nome do aluno deve ter entre {min} e {max} caracteres.")
	@Column(name="nome", nullable = false, unique = true, length = 60)
	private String nome;
	
	@NotBlank(message = "Informe um email.")
	@Size(min=5,max= 60,message = "O email do aluno deve ter entre {min} e {max} caracteres.")
	@Column(name="email_institucional", nullable = false, unique = true, length = 60)
	private String email_institucional;
	
	@NotNull(message = "Selecione a turma relativo ao aluno.")
	@ManyToOne
	@JoinColumn(name="turma_id_fk")
	private Turma turma;
	
	
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
	public Turma getTurma() {
		return turma;
	}
	public void setTurma(Turma turma) {
		this.turma = turma;
	}
}
