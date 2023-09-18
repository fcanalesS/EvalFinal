package com.petSmile.Model;

public class Mascota {
	public int idMascota;
	public String RutDueño;
	public String tipoMascota;
	public int edad;
	public String nombreMascota;
	
	public Mascota () {}

	public Mascota(int idMascota, String rutDueño, String tipoMascota, int edad, String nombreMascota) {
		super();
		this.idMascota = idMascota;
		RutDueño = rutDueño;
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
		return RutDueño;
	}

	public void setRutOwner(String rutDueño) {
		RutDueño = rutDueño;
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
		return "Mascota [idMascota=" + idMascota + ", RutDueño=" + RutDueño + ", tipoMascota=" + tipoMascota + ", edad="
				+ edad + ", nombreMascota=" + nombreMascota + "]";
	}
	
	
}
