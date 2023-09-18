package com.petSmile.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.petSmile.Conexion.Conexion;
import com.petSmile.Model.Mascota;

public class MascotaDAO {
	private Connection connection;
	private PreparedStatement statement;
	private boolean estadoOperacion;
	
	private Connection obtenerConexion () throws SQLException {
		return Conexion.getConnection();
	}
	
	public boolean insertarMascota ( Mascota mascota) throws SQLException {
		try {
			ResultSet resultSet = null;
			
			String sql = null;
			estadoOperacion = false;
			connection = obtenerConexion();
			
			connection.setAutoCommit(false);
			
			sql = "INSERT INTO mascota (rutDueño, tipoMascota, edad, nombreMascota) values (?,?,?,?)";
			statement=connection.prepareStatement(sql);
			statement.setString(1, mascota.getRutDueño());
			statement.setString(2, mascota.getTipoMascota());
			statement.setInt(3, mascota.getEdad());
			statement.setString(4, mascota.getNombreMascota());
			
			estadoOperacion = statement.executeUpdate() > 0;
			connection.commit();
			statement.close();
			
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			connection.rollback();
			statement.close();
			return false;
		}
	}
	
	public List<Mascota> obtenerMascota (String rut) throws SQLException {
		ResultSet resultSet = null;
		
		List<Mascota> mascotas = new ArrayList<Mascota>();
		
		String sql = null;
		estadoOperacion = false;
		connection = obtenerConexion();
		
		sql = "SELECT * FROM mascota where Rut = ?";
		statement=connection.prepareStatement(sql);
		statement.setString(1, rut);
		
		resultSet = statement.executeQuery();
		
		while (resultSet.next()) {
			Mascota mascota = new Mascota();
			mascota.setIdMascota(resultSet.getInt(1));
			mascota.setRutDueño(resultSet.getString(2));
			mascota.setTipoMascota(resultSet.getString(3));
			mascota.setEdad(resultSet.getInt(4));
			mascota.setNombreMascota(resultSet.getString(5));
			mascotas.add(mascota);
		}
		
		return mascotas;
	}
	
	public Mascota obtenerMascotaPorID (int idMascota) throws SQLException {
		try {
			ResultSet resultSet = null;
			
			Mascota mascotas = new Mascota();
			
			String sql = null;
			estadoOperacion = false;
			connection = obtenerConexion();
			
			sql = "SELECT * FROM mascota where idMascota = ?";
			statement=connection.prepareStatement(sql);
			statement.setInt(1, idMascota);
			
			resultSet = statement.executeQuery();
			Mascota mascota = new Mascota();
			if (resultSet.next()) {
				
				mascota.setIdMascota(resultSet.getInt(1));
				mascota.setRutDueño(resultSet.getString(2));
				mascota.setTipoMascota(resultSet.getString(3));
				mascota.setEdad(resultSet.getInt(4));
				mascota.setNombreMascota(resultSet.getString(5));
				
			}
			
			return mascotas;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return null;
		}
	}
	
	public List<Mascota> obtenerMascotaTodos () throws SQLException {
		ResultSet resultSet = null;
		
		List<Mascota> mascotas = new ArrayList<Mascota>();
		
		String sql = null;
		estadoOperacion = false;
		connection = obtenerConexion();
		
		sql = "SELECT * FROM mascota";
		statement=connection.prepareStatement(sql);
				
		resultSet = statement.executeQuery();
		
		while (resultSet.next()) {
			Mascota mascota = new Mascota();
			mascota.setIdMascota(resultSet.getInt(1));
			mascota.setRutDueño(resultSet.getString(2));
			mascota.setTipoMascota(resultSet.getString(3));
			mascota.setEdad(resultSet.getInt(4));
			mascota.setNombreMascota(resultSet.getString(5));
			mascotas.add(mascota);
		}
		
		return mascotas;
	}
	
}
