package br.univel;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class RealizaVenda {

	public void venda(){
		Produto p = new Produto();
		Cliente c = new Cliente();
		Venda v = new Venda();
		List<Produto> lista = new ArrayList<>();
		
		int id = p.getId();
		String nome = p.getDescricao();
		BigDecimal valor = p.getValor();
		
		Produto p1 = new Produto(id,nome, valor);
		lista.add(p1);
		v.setValortotal(somavenda(lista));
		BigDecimal valorRecebido = null;;
		v.setValortroco(troco(valorRecebido ,v.getValortotal()));
	}
			
	public static BigDecimal troco(BigDecimal valorRecebido, BigDecimal valortotal) {
		BigDecimal valorTroco = null;
		valorTroco = (valorRecebido.subtract(valortotal));
		return valorTroco;
	}

	public BigDecimal somavenda(List<Produto> lista){
	
		BigDecimal valor = null;
		for (Produto l: lista){
			valor = (l.getValor().add(valor));
		}
		return valor;
				
	
	}
	
}

