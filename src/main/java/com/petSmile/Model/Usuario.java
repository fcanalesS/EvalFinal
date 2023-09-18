package com.petSmile.Model;

public class Usuario {
	public int id;
	public String nombre;
	public String password;
	
	
	
	public Usuario () {}
	
	public int getId() {
		return id;
	}
	public Usuario(int id, String nombre, String password) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.password = password;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	
	
}
