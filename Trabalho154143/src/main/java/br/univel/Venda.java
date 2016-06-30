package br.univel;

import java.math.BigDecimal;
import java.util.Date;

public class Venda {
	int id;
	Date data ;
	int qnt;
	BigDecimal valortotal;
	BigDecimal valortroco;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public int getQnt() {
		return qnt;
	}
	public void setQnt(int qnt) {
		this.qnt = qnt;
	}
	public BigDecimal getValortotal() {
		return valortotal;
	}
	public void setValortotal(BigDecimal valortotal) {
		this.valortotal = valortotal;
	}
	public BigDecimal getValortroco() {
		return valortroco;
	}
	public void setValortroco(BigDecimal valortroco) {
		this.valortroco = valortroco;
	}
	public Venda(int id, Date data, int qnt, BigDecimal valortotal, BigDecimal valortroco) {
		super();
		this.id = id;
		this.data = data;
		this.qnt = qnt;
		this.valortotal = valortotal;
		this.valortroco = valortroco;
	}
	public Venda() {
		
	}

	

}
