package br.univel;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import br.univel.banco.Coluna;
import br.univel.banco.Tabela;

@Tabela ("CLIENTES")
@XmlRootElement
public class Cliente implements Serializable{
	/**
	 * 
	 */
	@Coluna (nome = "ID", pk=true)
	int id;
	
	@Coluna (nome="nome", tamanho=50)
	String nome;

	@Coluna (nome="cidade", tamanho=30)
	String cidade;
	
	@Coluna (nome="estado", tamanho=30)
	String estado;
	
	@Coluna (nome="telefone", tamanho=15)
	String telefone;
	
	public Cliente() {

	}
	public Cliente(int id, String nome,  String cidade, String estado, String telefone) {
		super();
		this.id = id;
		this.nome = nome;
		this.cidade = cidade;
		this.estado = estado;
		this.telefone = telefone;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
}