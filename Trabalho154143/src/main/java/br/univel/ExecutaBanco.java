package br.univel;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.univel.banco.ConexaoBanco;

public class ExecutaBanco {

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
					String nome = result.getString("nome");
					String cidade = result.getString("cidade");
					String estado = result.getString("estado");
					String telefone = result.getString("telefone");
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (List<Cliente>) ListCliente;
	}

}
