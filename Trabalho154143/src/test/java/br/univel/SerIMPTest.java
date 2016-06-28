package br.univel;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.Test;

public class SerIMPTest {

	
	@Test
	public void TestaArquivoGerado() throws FileNotFoundException{
		File f = new File("Cliente");
		new SerIMP().gravar(Cliente.class, f);
	}
	
}
