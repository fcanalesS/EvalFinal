package com.petSmile.Model;

public class Mascota {
	public int idMascota;
	public String RutOwner;
	public String tipoMascota;
	public int edad;
	public String nombreMascota;
	
	public Mascota () {}

	public Mascota(int idMascota, String rutDueño, String tipoMascota, int edad, String nombreMascota) {
		super();
		this.idMascota = idMascota;
		RutOwner = rutDueño;
		this.tipoMascota = tipoMascota;
		this.edad = edad;
		this.nombreMascota = nombreMascota;
	}

	public int getIdMascota() {
		return idMascota;
	}

	public void setIdMascota(int idMascota) {
		this.idMascota = idMascota;
	}

	public String getRutOwner() {
		return RutOwner;
	}

	public void setRutOwner(String rutDueño) {
		RutOwner = rutDueño;
	}

	public String getTipoMascota() {
		return tipoMascota;
	}

	public void setTipoMascota(String tipoMascota) {
		this.tipoMascota = tipoMascota;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getNombreMascota() {
		return nombreMascota;
	}

	public void setNombreMascota(String nombreMascota) {
		this.nombreMascota = nombreMascota;
	}

	@Override
	public String toString() {
		return "Mascota [idMascota=" + idMascota + ", RutDueño=" + RutOwner + ", tipoMascota=" + tipoMascota + ", edad="
				+ edad + ", nombreMascota=" + nombreMascota + "]";
	}
	
	
}
