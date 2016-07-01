package br.univel;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import br.univel.banco.ConexaoBanco;

public class CadProdutos  {

	public void cadastro(String descricao, BigDecimal preco) throws IOException, SQLException{
	PreparedStatement ps;
    ResultSet resultado;
    ConexaoBanco cb = new ConexaoBanco();
    Connection con = cb.abrirConexao();
	Produto prt = new Produto();
    List<Produto> lista = new LinkedList<Produto>();
    ps = cb.getSqlSelectAll(con, prt);
    resultado = ps.executeQuery();
	
    while (resultado.next()) {
    
        lista.add(new Produto(resultado.getInt("ID"), resultado.getString("descricao"), resultado.getBigDecimal("valor")));
    }
    
    int id = lista.size()+1;		
			
	Produto c = new Produto(id, descricao , preco);
	cb.getSqlInsert(con, c);
	
	}
}
