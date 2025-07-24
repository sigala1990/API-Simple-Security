package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Persona;
import com.example.demo.service.PersonaServiceImpl;

@RestController
@RequestMapping("/api")
public class PersonaController {
	@Autowired
	PersonaServiceImpl personaServiceImpl;
	
	@GetMapping("/persona")
	@PreAuthorize("hasAnyAuthority('ADMIN','USER')")
	public List<Persona> listarPersona(){
		return personaServiceImpl.listarPersona();
	}
	
	
	@PostMapping("/persona")
	@PreAuthorize("hasAnyAuthority('ADMIN','USER')")
	public Persona salvarPersona(@RequestBody Persona persona) {
		
		return personaServiceImpl.guardarPersona(persona);
	}
	
	
	@GetMapping("/persona/{id}")
	@PreAuthorize("hasAnyAuthority('ADMIN','USER')")
	public Persona personaXID(@PathVariable(name="id") Integer id) {
		
		Persona Persona_xid= new Persona();
		
		Persona_xid=personaServiceImpl.personaXID(id);
				
		return Persona_xid;
	}
	
	@PutMapping("/persona/{id}")
	@PreAuthorize("hasAnyAuthority('ADMIN','USER')")
	public Persona actualizarPersona(@PathVariable(name="id")Integer id,@RequestBody Persona persona) {
		
		Persona Persona_seleccionado= new Persona();
		Persona Persona_actualizado= new Persona();
		
		Persona_seleccionado= personaServiceImpl.personaXID(id);
		
		
		//Persona_seleccionado.setCreat_per(persona.getCreat_per());
		Persona_seleccionado.setNombre(persona.getNombre());
		Persona_seleccionado.setApellido(persona.getApellido());
		Persona_seleccionado.setDireccion(persona.getDireccion());
		Persona_seleccionado.setFecha_nacimiento(persona.getFecha_nacimiento());
		Persona_seleccionado.setFecha_creacion_registro(persona.getFecha_creacion_registro());
		
				
		Persona_actualizado = personaServiceImpl.actualizarPersona(Persona_seleccionado);
				
		return Persona_actualizado;
	}
	
	@DeleteMapping("/persona/{id}")
	@PreAuthorize("hasAnyAuthority('ADMIN')")
	//@PreAuthorize("hasAnyAuthority('ADMIN','USER')")
	public void eleiminarPersona(@PathVariable(name="id")Integer id) {
		personaServiceImpl.eliminarPersona(id);
	}

}