package br.com.boxsystemV1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.boxsystemV1.model.Uf;

@Repository
public interface UfRepository extends JpaRepository<Uf, Integer>{

}
