package br.univel;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import br.univel.banco.ConexaoBanco;

public class CadClientes {

	public void cadastro (String nome, String cidade, String estado, String telefone) throws SQLException, IOException{
		PreparedStatement ps;
	    ResultSet resultado;
	    ConexaoBanco cb = new ConexaoBanco();
	    Connection con = cb.abrirConexao();
		Cliente cl = new Cliente();
        List<Cliente> lista = new LinkedList<Cliente>();
        ps = cb.getSqlSelectAll(con, cl);
        resultado = ps.executeQuery();
		
        while (resultado.next()) {
        
            lista.add(new Cliente(resultado.getInt("ID"), resultado.getString("nome"), resultado.getString("cidade"),
                    resultado.getString("estado"), resultado.getString("telefone")));
        }
        
        int id = lista.size()+1;		
				
		Cliente c = new Cliente(id, nome , cidade, estado, telefone);
		cb.getSqlInsert(con, c);
	}
}
