package br.univel.banco;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.sql.SQLException;
import org.junit.Test;
import br.univel.banco.ConexaoBanco;

public class ConexaoBancoTest {

	@Test
	public void testConexao() throws SQLException, ClassNotFoundException, IOException{
		ConexaoBanco c = new ConexaoBanco(); 
		c.abrirConexao();
		if (!(c == null)){
			assertTrue(true);
		}
		
	
	}
	
}
