package br.univel;

import static org.junit.Assert.*;

import org.junit.Test;

public class ClasseColetoraTest {

	@Test
	public void testConexao(){
		
		assertTrue(new ClasseColetora().VerificarArquivo("listaProduto.txt"));
		
	}
	
	
	@Test
	public void testConexaoFalha(){
		
		assertTrue(new ClasseColetora().VerificarArquivo("Cliente.xml"));
		
	}
	
	@Test
	public void testConexaoFalhaComFalse(){
		
		assertFalse(new ClasseColetora().VerificarArquivo("Produtos.xml"));
		
	}
	
}
