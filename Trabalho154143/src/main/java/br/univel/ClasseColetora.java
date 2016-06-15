package br.univel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
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
		
		Pattern p = Pattern.compile("[0-9]=.*");
		
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
	 
	public Produto getProduto(String str){
		
		try {
			int id = Integer.parseInt(str.substring(0, str.indexOf(' ')));
			String descricao = str.substring(str.indexOf(' ')+1, str.lastIndexOf(' '));
			BigDecimal preco = new BigDecimal(formato.parse(str.substring(0,str.lastIndexOf(' '))).doubleValue());
			Produto produto = new Produto(id, descricao, preco);
			return produto;
		} catch (ParseException e) {
			
			e.printStackTrace();
			return null;
		}
	}
	
	public List<String> lerArquivo() {
		ArrayList<String> lista = new ArrayList<>();

		try (FileReader fr = new FileReader(new File("lista.txt"));
				BufferedReader br = new BufferedReader(fr)) {

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

}
