package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Persona;

public interface IPersonaService {
	// Metodos del CRUD
	public List<Persona> listarPersona(); // Listar All gcon_tb_personaes

	public Persona guardarPersona(Persona persona); // Guarda una gcon_tb_persona  CREATE

	public Persona personaXID(int id); // Leer datos de una gcon_tb_personaes READ

	public Persona actualizarPersona(Persona persona); // Actualiza datos de una gcon_tb_personaes UPDATE

	public void eliminarPersona(int id);// Elimina el gcon_tb_persona DELETE
}
