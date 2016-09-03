package br.com.boxsystemV1.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@SuppressWarnings("serial")
@Entity
public class Uf implements Serializable{

	@Id
	@GeneratedValue(generator = "TableIdGen")
	@GenericGenerator(name = "TableIdGen",
		strategy = "org.hibernate.id.enhanced.TableGenerator",
		parameters = {
				@Parameter(name = "table_name", value = "enhanced_hibernate_sequences"),
	            @Parameter(name = "value_column_name", value = "NEXTVALUE"),
	            @Parameter(name = "segment_column_name", value = "ID"),
	            @Parameter(name = "segment_value", value = "id_uf"),
	            @Parameter(name = "increment_size", value = "1"),
	            @Parameter(name = "optimizer", value = "org.mca.PooledIdOptimizer")
	})
	private Integer id;
	private String uf;
	private String nome;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((uf == null) ? 0 : uf.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Uf other = (Uf) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (uf == null) {
			if (other.uf != null)
				return false;
		} else if (!uf.equals(other.uf))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "UF [id=" + id + ", uf=" + uf + ", nome=" + nome + "]";
	}
	
	
}
