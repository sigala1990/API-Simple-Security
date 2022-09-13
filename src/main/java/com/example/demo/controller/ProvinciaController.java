package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Provincia;
import com.example.demo.service.ProvinciaServiceImpl;

@RestController
@RequestMapping("/api")
public class ProvinciaController {

	@Autowired
	ProvinciaServiceImpl provinciaServiceImpl;
	
	@GetMapping("/provincia")
	@PreAuthorize("hasAnyAuthority('ADMIN','USER')")
	public List<Provincia> listarPersona(){
		return provinciaServiceImpl.listarPersona();
	}
	
	@GetMapping("/provincia/utilitzades")
	@PreAuthorize("hasAnyAuthority('ADMIN','USER')")
	public List<Provincia> provinciaUtilitzades(){
		return provinciaServiceImpl.listProvinciasEnUs();
	}
	
	@GetMapping("/provincia/nom/utilitzades")
	@PreAuthorize("hasAnyAuthority('ADMIN','USER')")
	public List<String> provinciaNomUtilitzades(){
		return provinciaServiceImpl.listNomProvinciasEnUs();
	}
}
