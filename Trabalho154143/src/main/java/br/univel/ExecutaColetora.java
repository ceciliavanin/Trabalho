package br.univel;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class ExecutaColetora {

	
	
	public static void main(String[] args) {
		new ExecutaColetora().lerProduto();
		new ExecutaColetora().lerCliente();



	}

	private void lerCliente() {
		ClasseColetora c = new ClasseColetora();
		List<String> lista = c.lerArquivo("listaCliente.txt");
		List<Cliente> listaProduto = c.getCliente(lista);
		listaProduto.forEach(e -> {	

			System.out.println("Id: " + e.getId());
			System.out.println("Nome: " + e.getNome());
			System.out.println("Endere�o: "  + e.getEndereco());
			System.out.println("Numero" + e.getNumero());
			System.out.println("Complemento: " + e.getComplemento());
			System.out.println("Bairro: " + e.getBairro());
			System.out.println("Cidade: " + e.getCidade());
			System.out.println("Estado: " + e.getEstado());
			System.out.println("CEP: " + e.getCep());
			System.out.println("Telefone: " + e.getTelefone());
			System.out.println("Celular: " + e.getCelular());
			
		});
		
	}

	private void lerProduto() {
		ClasseColetora c = new ClasseColetora();
		List<String> lista = c.lerArquivo("listaProduto.txt");
		List<Produto> listaProduto = c.getProduto(lista);

		NumberFormat formatUS = NumberFormat.getCurrencyInstance(new Locale("en", "US"));
		NumberFormat formatBR = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

		BigDecimal cotacao = new BigDecimal(3.47);

		listaProduto.forEach(e -> {	

			System.out.println("Id: " + e.getId());
			System.out.println("Descri��o: " + e.getDescricao());
			System.out.println("Pre�o D�lar: " + formatUS.format(e.getValor()));
			System.out.println("Pre�o Real: " + formatBR.format(e.getValor().multiply(cotacao)));
		});
		
	}
}



