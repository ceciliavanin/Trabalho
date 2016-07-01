package br.univel.banco;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import br.univel.Cliente;
import br.univel.banco.Coluna;
import br.univel.banco.Tabela;

public class ConexaoBanco {

	private Connection con;

	public static Properties getProp() throws IOException {
		Properties props = new Properties();
		FileInputStream file = new FileInputStream("properties/banco.properties");
		props.load(file);
		return props;

	}

	public Connection abrirConexao() throws IOException {
		String url;
		String user;
		String password;

		Properties prop = getProp();

		url = prop.getProperty("prop.server.url");
		user = prop.getProperty("prop.server.user");
		password = prop.getProperty("prop.server.password");

		try {
			Class.forName("org.h2.Driver");
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public String getCreateTable(Object obj) throws SQLException {
		Class<? extends Object> cl = obj.getClass();
		try {

			StringBuilder sb = new StringBuilder();

			{
				String nomeTabela;
				if (cl.isAnnotationPresent(Tabela.class)) {

					Tabela anotacaoTabela = cl.getAnnotation(Tabela.class);
					nomeTabela = anotacaoTabela.value();

				} else {
					nomeTabela = cl.getSimpleName();

				}
				sb.append("CREATE TABLE ").append(nomeTabela).append(" (");
			}

			Field[] atributos = cl.getDeclaredFields();

			{
				for (int i = 0; i < atributos.length; i++) {

					Field field = atributos[i];

					String nomeColuna;
					String tipoColuna = null;
					int tamanhoColuna;
					Coluna anotacaoColuna = null;
					if (field.isAnnotationPresent(Coluna.class)) {
						anotacaoColuna = field.getAnnotation(Coluna.class);

						if (anotacaoColuna.nome().isEmpty()) {
							nomeColuna = field.getName().toUpperCase();
						} else {
							nomeColuna = anotacaoColuna.nome();
						}

					} else {
						nomeColuna = field.getName();
					}

					Class<?> tipoParametro = field.getType();

					if (tipoParametro.equals(String.class)) {
						tamanhoColuna = anotacaoColuna.tamanho();
						tipoColuna = "VARCHAR(" + tamanhoColuna + ")";

					} else if (tipoParametro.equals(int.class)) {
						tipoColuna = "INT";

					} else {
						tipoColuna = "DESCONHECIDO";
					}

					if (i > 0) {
						sb.append(",");
					}

					sb.append("\n\t").append(nomeColuna).append(' ').append(tipoColuna);
				}
			}

			{

				sb.append(",\n\tPRIMARY KEY( ");

				for (int i = 0, achou = 0; i < atributos.length; i++) {

					Field field = atributos[i];
					if (field.isAnnotationPresent(Coluna.class)) {

						Coluna anotacaoColuna = field.getAnnotation(Coluna.class);

						if (anotacaoColuna.pk()) {

							if (achou > 0) {
								sb.append(", ");
							}

							if (anotacaoColuna.nome().isEmpty()) {
								sb.append(field.getName().toUpperCase());
							} else {
								sb.append(anotacaoColuna.nome());
							}

							achou++;
						}

					}
				}

				sb.append(" )");
			}

			sb.append("\n);");
			return sb.toString();

		} catch (SecurityException e) {
			throw new RuntimeException(e);

		}

	}

	public PreparedStatement getSqlInsert(Connection con, Object obj) {

		Class<? extends Object> cl = obj.getClass();

		StringBuilder sb = new StringBuilder();

		{
			String nomeTabela;
			if (cl.isAnnotationPresent(Tabela.class)) {

				Tabela anotacaoTabela = cl.getAnnotation(Tabela.class);
				nomeTabela = anotacaoTabela.value();

			} else {
				nomeTabela = cl.getSimpleName().toUpperCase();

			}
			sb.append("INSERT INTO ").append(nomeTabela).append(" (");
		}

		Field[] atributos = cl.getDeclaredFields();

		{
			for (int i = 0; i < atributos.length; i++) {

				Field field = atributos[i];

				String nomeColuna;

				if (field.isAnnotationPresent(Coluna.class)) {
					Coluna anotacaoColuna = field.getAnnotation(Coluna.class);

					if (anotacaoColuna.nome().isEmpty()) {
						nomeColuna = field.getName();
					} else {
						nomeColuna = anotacaoColuna.nome();
					}

				} else {
					nomeColuna = field.getName();
				}

				if (i > 0) {
					sb.append(", ");
				}

				sb.append(nomeColuna);
			}
		}

		sb.append(") VALUES (");

		for (int i = 0; i < atributos.length; i++) {
			if (i > 0) {
				sb.append(", ");
			}
			sb.append('?');
		}
		sb.append(')');

		String strSql = sb.toString();

		try {
			PreparedStatement ps = con.prepareStatement(strSql);

			for (int i = 0; i < atributos.length; i++) {

				Field field = atributos[i];

				field.setAccessible(true);

				if (field.getType().equals(int.class)) {
					ps.setInt(i + 1, field.getInt(obj));

				} else if (field.getType().equals(String.class)) {
					ps.setString(i + 1, String.valueOf(field.get(obj)));

				} else if (field.getType().isEnum()) {
					Object valor = field.get(obj);
					Method m = valor.getClass().getMethod("ordinal");
					ps.setInt(i + 1, (Integer) m.invoke(valor, null));

				} else {
					throw new RuntimeException("Tipo não suportado, falta implementar.");

				}
			}
			return ps;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;

		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return null;

		} catch (IllegalAccessException e) {
			e.printStackTrace();
			return null;

		} catch (NoSuchMethodException e) {
			e.printStackTrace();
			return null;
		} catch (SecurityException e) {
			e.printStackTrace();
			return null;

		} catch (InvocationTargetException e) {
			e.printStackTrace();
			return null;

		}

	}

	public PreparedStatement getSqlSelectAll(Connection con, Object obj) {
		Class<?> cl = obj.getClass();
		StringBuilder sb = new StringBuilder();
		String nomeTabela;
		if (cl.isAnnotationPresent(Tabela.class)) {

			Tabela anotacaoTabela = cl.getAnnotation(Tabela.class);
			nomeTabela = anotacaoTabela.value();

		} else {
			nomeTabela = cl.getSimpleName().toUpperCase();

		}
		sb.append("SELECT * FROM ").append(nomeTabela);
		String strSql = sb.toString();
		PreparedStatement ps = null;

		try {
			ps = con.prepareStatement(strSql);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}

		return ps;
	}

	
	public ConexaoBanco() {
		
	}
}
