package br.univel;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.*;

public class GravaXmlTest {

	
	@Test
	public void	testExportacaoLista() throws IOException{
			
		assertTrue(new GravaXml().gravaXml(Produto.class));
		
	}

}
