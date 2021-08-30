package br.ufg.inf.fs.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.ufg.inf.fs.entities.Hospedagem;

public interface HospedagemRepository extends JpaRepository<Hospedagem, Integer>{

	@Query("SELECT h FROM Hospedagem h WHERE h.idHospede = id")
	public List<Hospedagem> findByIdHospede(@Param("id") Integer id);
	
}