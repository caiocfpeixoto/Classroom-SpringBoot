package br.com.edu.ifce.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@SuppressWarnings("serial")
@Entity
@Table(name="tabela_professor")
public class Professor extends AbstractEntity<Long>{
	
	@NotBlank(message = "Informe um nome.")
	@Size(min=3,max= 60,message = "O nome do professor deve ter entre {min} e {max} caracteres.")
	@Column(name="nome", nullable = false, unique = true, length = 60)
	private String nome;
	
	@NotBlank(message = "Informe um email.")
	@Size(min=5,max= 60,message = "O email do professor deve ter entre {min} e {max} caracteres.")
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
