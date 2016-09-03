package br.com.boxsystemV1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.boxsystemV1.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

	@Query(value="select u from Usuario u where u.login=:plogin")
	public Usuario buscarLogin(@Param("plogin") String login);
	
}
