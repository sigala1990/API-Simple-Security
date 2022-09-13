package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DAO.IProvinciaDAO;
import com.example.demo.dto.Provincia;

@Service
public class ProvinciaServiceImpl implements IProvinciaService {
	
	@Autowired
	IProvinciaDAO iProvinciaDAO;
	
	public List<Provincia> listarPersona() {
		// TODO Auto-generated method stub
		return iProvinciaDAO.findAll();
	}
	
	public List<Provincia>  listProvinciasEnUs(){
		return iProvinciaDAO.totesLesProvinciesFetesServirPerPersonas();
	}
	
	public List<String> listNomProvinciasEnUs(){
		return iProvinciaDAO.nomDeTotesLesProvinciesFetesServirPerPersonas();
	}
	
}
