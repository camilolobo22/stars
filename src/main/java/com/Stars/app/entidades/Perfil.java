package com.Stars.app.entidades;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotEmpty;

@Document(collection="perfil")
public class Perfil {
	
	@Id
	private String id;

	@NotEmpty
	private String nombre;

	@NotEmpty
	private String apellido;

	@NotEmpty
	private String correoElectronico;

	@NotEmpty
	private String nombreUsuario;

	@NotEmpty
	private String contraseña;

	//CONSTRUCTOR
	public Perfil() {
	}
	
	

	//METODOS GET y SET
	
	public Perfil(@NotEmpty String nombre, @NotEmpty String apellido, @NotEmpty String correoElectronico,
			@NotEmpty String nombreUsuario, @NotEmpty String contraseña) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.correoElectronico = correoElectronico;
		this.nombreUsuario = nombreUsuario;
		this.contraseña = contraseña;
	}



	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}



	@Override
	public String toString() {
		return "Perfil [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", correoElectronico="
				+ correoElectronico + ", nombreUsuario=" + nombreUsuario + ", contraseña=" + contraseña + "]";
	}


	
	
}