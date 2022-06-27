package br.com.edu.ifce.domain;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
public class Conteudo extends AbstractEntity<Long>{
	
	@Column(nullable = false)
	private String titulo;
	
	@Column(nullable = false)
	private String descricao;

	@ManyToOne
	@JoinColumn(name="id_turma_fk")
	private Turma turma;
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
