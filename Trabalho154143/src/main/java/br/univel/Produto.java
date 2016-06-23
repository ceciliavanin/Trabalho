package br.univel;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class Produto implements Serializable{
	public Produto(){

	}
	public Produto(int id, String descricao, BigDecimal valor) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.valor = valor;
	}
		
	int id;
	String descricao;
	BigDecimal valor;
	List<Produto> lp;
	public List<Produto> getLp() {
		return lp;
	}
	public void setLp(List<Produto> lp) {
		this.lp = lp;
	}
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
