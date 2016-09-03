package br.com.boxsystemV1.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(generator = "TableIdGen")
	@GenericGenerator(name = "TableIdGen",
		strategy = "org.hibernate.id.enhanced.TableGenerator",
		parameters = {
				@Parameter(name = "table_name", value = "enhanced_hibernate_sequences"),
	            @Parameter(name = "value_column_name", value = "NEXTVALUE"),
	            @Parameter(name = "segment_column_name", value = "ID"),
	            @Parameter(name = "segment_value", value = "id_usuario"),
	            @Parameter(name = "increment_size", value = "1"),
	            @Parameter(name = "optimizer", value = "org.mca.PooledIdOptimizer")
	})
	private Integer id;
	private String login;
	private String senha;
	private String nome;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
	
}
