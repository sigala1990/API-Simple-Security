package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.DAO.IUsuarioDAO;
import com.example.demo.dto.Usuario;
@Service
public class UsuarioServiceImpl implements IUsuarioService,UserDetailsService {

	@Autowired
	IUsuarioDAO iUsuariDAO;
	
	@Override
	public List<Usuario> listarUsuario() {
		// TODO Auto-generated method stub
		return iUsuariDAO.findAll();
	}

	@Override
	public Usuario guardarUsuario(Usuario usuari) {
		// TODO Auto-generated method stub
		return iUsuariDAO.save(usuari);
	}

	@Override
	public Usuario usuarioXID(int id) {
		// TODO Auto-generated method stub
		return iUsuariDAO.findById(id).get();
	}

	@Override
	public Usuario actualizarUsuario(Usuario usuari) {
		// TODO Auto-generated method stub
		return iUsuariDAO.save(usuari);
	}

	@Override
	public void eliminarUsuario(int id) {
		// TODO Auto-generated method stubç
		iUsuariDAO.deleteById(id);
		
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = iUsuariDAO.findByUsername(username);
		if (usuario == null) {
			throw new UsernameNotFoundException(username);
		}

		return new User(usuario.getUsername(), usuario.getPassword(), usuario.getAuthorities());
	}
}
