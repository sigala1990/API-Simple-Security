package com.example.demo.dto;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="persona")
public class Persona {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="apellido")
	private String apellido;
	
	@Column(name="direccion")
	private String direccion;
	
	@Column(name="fecha_nacimiento")
	private Date fecha_nacimiento;
	
	@Column(name="fecha_creacion_registro")
	private Date fecha_creacion_registro;
	
	@ManyToOne
	@JoinColumn(name="fk_usuario")
	private Usuario id_usuario;

	public Persona() {
	}

	public Persona(int id, String nombre, String apellido, String direccion, Date fecha_nacimiento,
			Date fecha_creacion_registro, Usuario id_usuario) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.fecha_nacimiento = fecha_nacimiento;
		this.fecha_creacion_registro = fecha_creacion_registro;
		this.id_usuario = id_usuario;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public Date getFecha_creacion_registro() {
		return fecha_creacion_registro;
	}

	public void setFecha_creacion_registro(Date fecha_creacion_registro) {
		this.fecha_creacion_registro = fecha_creacion_registro;
	}

	public Usuario getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Usuario id_usuario) {
		this.id_usuario = id_usuario;
	}
	
	
	
}
