package model;

import java.util.Calendar;

import javax.persistence.*;

@Entity
public class Tarefa {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) // se o strategy ele cria a sequencia como uma tabela
	private Long id;
	private String descricao;
	private boolean finalizado;
	@Temporal(TemporalType.DATE)
	@Column(name="data_finalizacao", nullable = true)
	private Calendar dataFinalizacao;
	  
	  
//	obrigatório para JPA
	public Tarefa(){}
	  
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public boolean isFinalizado() {
		return finalizado;
	}
	public void setFinalizado(boolean finalizado) {
		this.finalizado = finalizado;
	}
	public Calendar getDataFinalizacao() {
		return dataFinalizacao;
	}
	public void setDataFinalizacao(Calendar dataFinalizacao) {
		this.dataFinalizacao = dataFinalizacao;
	}
	
}
