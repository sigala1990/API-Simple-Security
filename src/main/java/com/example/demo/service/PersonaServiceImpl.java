package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DAO.IPersonaDAO;
import com.example.demo.dto.Persona;

@Service
public class PersonaServiceImpl implements IPersonaService{

	@Autowired
	IPersonaDAO iUsuariDAO;
	
	@Override
	public List<Persona> listarPersona() {
		// TODO Auto-generated method stub
		return iUsuariDAO.findAll();
	}

	@Override
	public Persona guardarPersona(Persona usuari) {
		// TODO Auto-generated method stub
		return iUsuariDAO.save(usuari);
	}

	@Override
	public Persona personaXID(int id) {
		// TODO Auto-generated method stub
		return iUsuariDAO.findById(id).get();
	}

	@Override
	public Persona actualizarPersona(Persona usuari) {
		// TODO Auto-generated method stub
		return iUsuariDAO.save(usuari);
	}

	@Override
	public void eliminarPersona(int id) {
		// TODO Auto-generated method stubç
		iUsuariDAO.deleteById(id);
		
	}

}
