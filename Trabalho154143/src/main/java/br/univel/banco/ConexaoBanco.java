package br.univel.banco;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
public class ConexaoBanco {

		public static Properties getProp() throws IOException {
			Properties props = new Properties();
			FileInputStream file = new FileInputStream(
					"./properties/dados.properties");
			props.load(file);
			return props;

		}

		public static void  main(String args[]) throws IOException {
			String login; 
			String url; 
			String password; //Variável que guardará o password do usúario.
			System.out.println("************Teste de leitura do arquivo de propriedades************");
			
			Properties prop = getProp();
			
			login = prop.getProperty("prop.server.login");
			url = prop.getProperty("prop.server.url");
			password = prop.getProperty("prop.server.password");
			
			System.out.println("Login = " + login);
			System.out.println("Host = " + url);
			System.out.println("Password = " + password);
		}
	
}
