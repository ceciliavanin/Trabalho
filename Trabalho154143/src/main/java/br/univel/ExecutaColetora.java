package br.univel;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class ExecutaColetora {

	public static void main(String[] args) {
		
	ClasseColetora c = new ClasseColetora();
	List<String> lista = c.lerArquivo();

	List<Produto> listaProduto = c.getProduto(lista);

	NumberFormat formatUS = NumberFormat.getCurrencyInstance(new Locale("en", "US"));
	NumberFormat formatBR = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

	BigDecimal cotacao = new BigDecimal(3.47);

	listaProduto.forEach(e -> {	

		System.out.println("Id: " + e.getId());
		System.out.println("Descrição: " + e.getDescricao());
		System.out.println("Preço Dólar: " + formatUS.format(e.getValor()));
		System.out.println("Preço Real: " + formatBR.format(e.getValor().multiply(cotacao)));
	});

	}
}



