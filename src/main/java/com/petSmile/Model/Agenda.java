	package com.petSmile.Model;

import java.time.LocalTime;
import java.util.Date;

public class Agenda {
	public int id;
	public int idMascota;
	public String rutOwner;
	public String nombreMascota;
	public String hora;
	public String fecha;
	public Agenda () {}
	@Override
	public String toString() {
		return "Agenda [id=" + id + ", idMascota=" + idMascota + ", rutOwner=" + rutOwner + ", nombreMascota="
				+ nombreMascota + ", hora=" + hora + ", fecha=" + fecha + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdMascota() {
		return idMascota;
	}
	public void setIdMascota(int idMascota) {
		this.idMascota = idMascota;
	}
	public String getRutOwner() {
		return rutOwner;
	}
	public void setRutOwner(String rutOwner) {
		this.rutOwner = rutOwner;
	}
	public String getNombreMascota() {
		return nombreMascota;
	}
	public void setNombreMascota(String nombreMascota) {
		this.nombreMascota = nombreMascota;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public Agenda(int id, int idMascota, String rutOwner, String nombreMascota, String hora, String fecha) {
		super();
		this.id = id;
		this.idMascota = idMascota;
		this.rutOwner = rutOwner;
		this.nombreMascota = nombreMascota;
		this.hora = hora;
		this.fecha = fecha;
	};
	
	
	
	
}
