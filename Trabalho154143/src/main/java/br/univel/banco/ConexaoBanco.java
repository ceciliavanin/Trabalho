package br.univel.banco;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
public class ConexaoBanco {

		public static Properties getProp() throws IOException {
			Properties props = new Properties();
			FileInputStream file = new FileInputStream(
					"properties/banco.properties");
			props.load(file);
			return props;

		}

		public Connection abrirConexao() throws IOException {
			String login; 
			String url; 
			String password; 
			System.out.println("************Teste de leitura do arquivo de propriedades************");
			
			Properties prop = getProp();
			
			login = prop.getProperty("prop.server.login");
			url = prop.getProperty("prop.server.url");
			password = prop.getProperty("prop.server.password");
			
		
			try {
				Class.forName("org.h2.Driver");
				Connection con = DriverManager.getConnection(url, login, password);
				return con;
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				return null;
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
				
		}
		public static void main(String[] args) throws IOException {
			new ConexaoBanco().abrirConexao();
		}
}
