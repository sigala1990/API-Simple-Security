package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Usuario;

public interface IUsuarioService {
	// Metodos del CRUD
	public List<Usuario> listarUsuario(); // Listar All gcon_tb_usuarioes

	public Usuario guardarUsuario(Usuario usuario); // Guarda una gcon_tb_usuario  CREATE

	public Usuario usuarioXID(int id); // Leer datos de una gcon_tb_usuarioes READ

	public Usuario actualizarUsuario(Usuario usuario); // Actualiza datos de una gcon_tb_usuarioes UPDATE

	public void eliminarUsuario(int id);// Elimina el gcon_tb_usuario DELETE
}
