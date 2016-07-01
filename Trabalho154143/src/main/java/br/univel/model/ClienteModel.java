package br.univel.model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.univel.Cliente;
import br.univel.Produto;

public class ClienteModel extends AbstractTableModel{

	private List<Cliente> lista;
	
	public ClienteModel(List<Cliente> lista){
		this.lista = lista;
	}
	
	@Override
	public int getColumnCount(){
		return 2;
	}
	
	@Override
	public int getRowCount(){
		return lista.size();
	}

	@Override
	public String getColumnName(int col){
		
		switch (col) {
			case 0:
				return "ID";
			case 1:
				return "NOME";
			default:
				return "erro";
				
		}
		
	}
	
	
	public Object getValueAt(int row, int col){
		
		Cliente c = lista.get(row);
		
		switch (col) {
			case 0:
				return c.getId();
			case 1:
				return c.getNome();
			case 6:
				return c.getCidade();
			case 7:
				return c.getEstado();
			case 9:
				return c.getTelefone();
			default:
				return "erro";
				
		}
		
	}
	
	public Cliente getClienteNaLinha(int index){
		return lista.get(index);
	}
	
	public void removerCliente(Cliente c){
		int idx = this.lista.indexOf(c);
		this.lista.remove(c);
		super.fireTableRowsDeleted(idx, idx);
	}
	
	public void adicionarCliente(Cliente c){
		this.lista.add(c);
		super.fireTableRowsInserted(lista.size() - 1, lista.size() - 1);
	}
	
}
