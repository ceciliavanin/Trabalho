package br.univel.model;

import java.text.NumberFormat;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.univel.Produto;

public class ProdutoModel extends AbstractTableModel{

	private List<Produto> lista;  
	private NumberFormat format = NumberFormat.getInstance();
	
	public ProdutoModel(List<Produto> lista){
		this.lista = lista;
	}
	
	public int getColumnCount(){
		return 3;
	}
	

	public int getRowCount(){
		return lista.size();
	}
	

	public String getColumnName(int col){
		
		switch(col){
		
			case 0:
				return "Código";
			case 1:
				return "Descrição";
			case 2:
				return "Preço";
				
		}
		
		return null;
	}
	

	public Object getValueAt(int row, int col){
		
		Produto p = lista.get(row);
		
		switch(col){
		
			case 0:
				return p.getId();
			case 1:
				return p.getDescricao();
			case 2:
				return p.getValor();
				
		}
		
		return null;
		
	}
	
	public Produto getProdutoNaLinha(int index){
		return lista.get(index);
	}
	
	public void removerProduto(Produto p){
		int idx = this.lista.indexOf(p);
		this.lista.remove(p);
		super.fireTableRowsDeleted(idx, idx);
	}
	
	public void adicionarProduto(Produto p){
		this.lista.add(p);
		super.fireTableRowsInserted(lista.size() - 1, lista.size() - 1);
	}
	
}
