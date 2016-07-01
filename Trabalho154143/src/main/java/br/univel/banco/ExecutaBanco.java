package br.univel.banco;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.univel.Cliente;
import br.univel.Produto;

public class ExecutaBanco {

	public List<Produto> listarTodosProdutos(){
		
		StringBuilder sb = new StringBuilder();
		ConexaoBanco s = new ConexaoBanco();
		Connection con = null;
		List<Produto> ListProduto = new ArrayList<Produto>();
		List<String> lista = new ArrayList<String>();
		Cliente c = new Cliente(0, null, null, null, null);
		try {
			con = s.abrirConexao();
			ResultSet result = null;
			PreparedStatement psListar = s.getSqlSelectAll(con, c);
		
			try {

				result = psListar.executeQuery();
				while (result.next()) {
					int id = result.getInt(1);
					String descricao = result.getString("descricao");
					BigDecimal preco = result.getBigDecimal(1);
					ListProduto.add(new Produto(id,descricao, preco));
				}
			}finally{
				if (psListar != null) psListar.close();
				if (result != null) result.close();
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ListProduto;
	}
	public List<Cliente> listarTodosClientes() {
		StringBuilder sb = new StringBuilder();
		ConexaoBanco s = new ConexaoBanco();
		Connection con = null;
		List<Cliente> ListCliente = new ArrayList<Cliente>();
		List<String> lista = new ArrayList<String>();
		Cliente c = new Cliente(0, null, null, null, null);
		try {
			con = s.abrirConexao();
			ResultSet result = null;
			PreparedStatement psListar = s.getSqlSelectAll(con, c);
		
			try {

				result = psListar.executeQuery();
				while (result.next()) {
					int id = result.getInt(1);
					String nome = result.getString(2);
					String cidade = result.getString(3);
					String estado = result.getString(4);
					String telefone = result.getString(5);
					ListCliente.add(new Cliente(id,nome,cidade,estado,telefone));
				}
			}finally{
				if (psListar != null) psListar.close();
				if (result != null) result.close();
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ListCliente;
	}

}
