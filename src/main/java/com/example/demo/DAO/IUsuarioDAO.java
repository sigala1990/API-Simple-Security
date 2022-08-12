package com.example.demo.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dto.Usuario;

public interface IUsuarioDAO extends JpaRepository<Usuario, Integer>{
	Usuario findByUsername(String username);
}
