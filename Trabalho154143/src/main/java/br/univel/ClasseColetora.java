
package br.univel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClasseColetora {

	private NumberFormat formato = NumberFormat.getInstance(new Locale("pt", "BR"));
	
	public List<Produto> getProduto(List<String> lista){
		List<Produto> listProduto = new ArrayList<>();
		
		Pattern p = Pattern.compile("[0-9]+.*");
		
		lista.forEach(e -> {
			
			if (!e.startsWith("------")){
				Matcher m = p.matcher(e);
				if(m.matches()){
					listProduto.add(getProduto(e));
				}
			}
		});
		return listProduto;
		
	} 
	 
	private Produto getProduto(String str) {
		int indexPrimeiroEspaco = str.indexOf(' ');
		String subStringCodigo = str.substring(0, indexPrimeiroEspaco);
		int id = Integer.parseInt(subStringCodigo);

		String strSemCodigo = str.substring(indexPrimeiroEspaco).trim();

		int indexDolar = strSemCodigo.indexOf("US$");

		String descricao = strSemCodigo.substring(0, indexDolar).trim();

		BigDecimal preco = null;
		String strPreco = null;

		try {
		
			strPreco = strSemCodigo.substring(indexDolar + 3).trim();
			preco = new BigDecimal(formato.parse(strPreco).doubleValue());
			preco.setScale(2, RoundingMode.HALF_EVEN);

		} catch (NumberFormatException | ParseException e) {

			System.out.println(strPreco);

			e.printStackTrace();
		}

		Produto p = new Produto(id, descricao, preco);
		return p;
	}
	
	public List<String> lerArquivo(String arq) {
		ArrayList<String> lista = new ArrayList<>();

		try (FileReader fr = new FileReader(new File(arq));
			 BufferedReader br = new BufferedReader(fr)) 
		{

			String linha = null;
			while ((linha = br.readLine()) != null) {
				lista.add(linha);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lista;
	}

	public List<Cliente> getCliente(List<String> lista) {
		List<Cliente> listaCl = new ArrayList<>();

		Pattern c = Pattern.compile("[0-9]+.*");

		lista.forEach(e -> {
			Matcher m = c.matcher(e);
			if (m.matches()) {
				listaCl.add(getCliente(e));
			}
		});

		return listaCl;
	}

	public Cliente getCliente(String str){
			
		String[] itens = str.split(",");
		int id = Integer.parseInt(itens[0]);
		String nome = itens[1];
		String cidade = itens[2];
		String estado = itens[3];
		String telefone = itens[4];

		Cliente c = new Cliente(id, nome, cidade, estado, telefone);

		return c;
	}
}
