package br.univel;

import java.math.BigDecimal;

public class Produto {
	public Produto(int id, String descricao, BigDecimal valor) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.valor = valor;
	}
	
	
	int id;
	String descricao;
	BigDecimal valor;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
}
