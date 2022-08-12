package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DAO.IUsuarioDAO;
import com.example.demo.dto.Usuario;
import com.example.demo.service.UsuarioServiceImpl;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class UsuarioController {

	
	private IUsuarioDAO usuarioDAO;

	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public UsuarioController(IUsuarioDAO UsuarioDAO, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.usuarioDAO = UsuarioDAO;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
	
	@Autowired
	UsuarioServiceImpl usuarioServiceImpl;
	
	
	@GetMapping("/response-entity-builder-with-http-headers")
	public ResponseEntity<String> usingResponseEntityBuilderAndHttpHeaders() {
	    HttpHeaders responseHeaders = new HttpHeaders();
	    responseHeaders.set("Baeldung-Example-Header", 
	      "Value-ResponseEntityBuilderWithHttpHeaders");

	    return ResponseEntity.ok()
	      .headers(responseHeaders)
	      .body("Response with header using ResponseEntity");
	}
	
	@GetMapping("/usuario")
	@PreAuthorize("hasAnyAuthority('ADMIN','USER')")
	public List<Usuario> listarGcon_tb_usuarios(){
		return usuarioServiceImpl.listarUsuario();
	}
	

	@PostMapping("/usuarioo")
	public Usuario salvarGcon_tb_usuario(@RequestBody Usuario usuario) {
		usuario.setPassword(bCryptPasswordEncoder.encode(usuario.getPassword()));
		usuarioDAO.save(usuario);
		
		return usuario;
	}
	
	
	@GetMapping("/usuario/{id}")
	public Usuario gcon_tb_usuarioXID(@PathVariable(name="id") int id) {
		
		
		Usuario usuario_xid= new Usuario();
		
		usuario_xid=usuarioServiceImpl.usuarioXID(id);
		
				//System.out.println("Gcon_tb_usuario XID: "+Gcon_tb_usuario_xid);
		
		return usuario_xid;
	}
	
	@PutMapping("/usuario/{id}")
	public Usuario actualizarGcon_tb_usuario(@PathVariable(name="id")int id,@RequestBody Usuario usuario) {
		
		Usuario usuario_seleccionado= new Usuario();
		Usuario usuario_actualizado= new Usuario();
		
		usuario_seleccionado= usuarioServiceImpl.usuarioXID(id);
		
		usuario_seleccionado.setUsername(usuario.getUsername());
		usuario_seleccionado.setPassword(usuario.getPassword());
		usuario_seleccionado.setRoles(usuario.getRoles());
		
	
		usuario_actualizado = usuarioServiceImpl.actualizarUsuario(usuario_seleccionado);
		
		return usuario_actualizado;
	}
	
	@DeleteMapping("/usuario/{id}")
	public void eleiminarGcon_tb_usuario(@PathVariable(name="id")int id) {
		usuarioServiceImpl.eliminarUsuario(id);
	}
}

