package com.example.demo.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.dto.Provincia;

public interface IProvinciaDAO extends JpaRepository<Provincia, Integer>{
	

	@Query(value = "select * from provincia as pr inner join persona as pe on pe.id = pr.id",nativeQuery = true)
	List<Provincia>totesLesProvinciesFetesServirPerPersonas();
	
	@Query(value = "select  pr.nombre  from provincia as pr inner join persona as pe on pe.id = pr.id",nativeQuery = true)
	List<String>nomDeTotesLesProvinciesFetesServirPerPersonas();
	
}
