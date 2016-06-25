package br.univel;

import java.io.File;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class ExecutaColetora{
	
	public static void main(String[] args) {
		new ExecutaColetora().lerProduto();
		new ExecutaColetora().lerCliente();
		new ExecutaColetora().executaSerializable();
	}
	
	public void executaSerializable(){
		Produto p = new Produto();
		File file = new File("arq.dat");
		
		SerIMP<Produto> ser = new SerIMP<Produto>(){};
		
		try{
			ser.gravar(p, file);
			
			Produto pLido = ser.ler(file);
			
			System.out.println(pLido.getId());
			System.out.println(pLido.getDescricao());
			System.out.println(pLido.getValor());
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	private void lerCliente() {
		ClasseColetora c = new ClasseColetora();
		List<String> lista = c.lerArquivo("listaCliente.txt");
		List<Cliente> listaProduto = c.getCliente(lista);
		listaProduto.forEach(e -> {	

			System.out.println("Id: " + e.getId());
			System.out.println("Nome: " + e.getNome());
			System.out.println("Cidade: " + e.getCidade());
			System.out.println("Estado: " + e.getEstado());
			System.out.println("Telefone: " + e.getTelefone());
			
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
			System.out.println("Descrição: " + e.getDescricao());
			System.out.println("Preço Dólar: " + formatUS.format(e.getValor()));
			System.out.println("Preço Real: " + formatBR.format(e.getValor().multiply(cotacao)));
			
			
		});
	
	}
}



