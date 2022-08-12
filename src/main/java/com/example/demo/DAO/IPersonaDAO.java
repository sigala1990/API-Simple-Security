package com.example.demo.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dto.Persona;

public interface IPersonaDAO extends JpaRepository<Persona,Integer> {
	
}
