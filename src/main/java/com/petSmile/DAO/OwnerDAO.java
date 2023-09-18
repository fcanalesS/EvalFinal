package com.petSmile.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.petSmile.Conexion.Conexion;
import com.petSmile.Model.Owner;

public class OwnerDAO {
	private Connection connection;
	private PreparedStatement statement;
	private boolean estadoOperacion;
	
	public boolean insertarOwner ( Owner owner) throws SQLException {
		try {
			ResultSet resultSet = null;
			
			String sql = null;
			estadoOperacion = false;
			connection = obtenerConexion();
			
			connection.setAutoCommit(false);
			
			sql = "INSERT INTO dueño (rut, nombre, apellido, direccion, correo, telefono, nombreMascota) values (?,?,?,?,?,?,?)";
			statement=connection.prepareStatement(sql);
			statement.setString(1, owner.getRut());
			statement.setString(2, owner.getNombre());
			statement.setString(3, owner.getApellido());
			statement.setString(4, owner.getDireccion());
			statement.setString(5, owner.getCorreo());
			statement.setString(6, owner.getTelefono());
			statement.setString(7, "");
			
			estadoOperacion = statement.executeUpdate() > 0;
			connection.commit();
			statement.close();
			
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.getMessage();
			connection.rollback();
			statement.close();
			// TODO Auto-generated catch block
			return false;
		}
	}
	
	public Owner obtenerOwner (String rut) throws SQLException {
		ResultSet resultSet = null;
		Owner owner = new Owner();
		
		String sql = null;
		estadoOperacion = false;
		connection = obtenerConexion();
		
		sql = "SELECT * FROM dueño where Rut = ?";
		statement=connection.prepareStatement(sql);
		statement.setString(1, rut);
		
		resultSet = statement.executeQuery();
		
		if (resultSet.next()) {
			owner.setRut(resultSet.getString(1));
			owner.setNombre(resultSet.getString(2));
			owner.setApellido(resultSet.getString(3));
			owner.setDireccion(resultSet.getString(4));
			owner.setCorreo(resultSet.getString(5));
			owner.setTelefono(resultSet.getString(6));
			owner.setNombreMascota(resultSet.getString(7));
		}
		
		return owner;
	}
	
	public List<Owner> obtenerOwnerTodos () throws SQLException {
		ResultSet resultSet = null;		
		String sql = null;
		estadoOperacion = false;
		connection = obtenerConexion();
		
		sql = "SELECT * FROM dueño";
		statement=connection.prepareStatement(sql);
		
		
		resultSet = statement.executeQuery();
		
		List<Owner> lista = new ArrayList<Owner>();
		while (resultSet.next()) {
			Owner owner = new Owner();
			owner.setRut(resultSet.getString(1));
			owner.setNombre(resultSet.getString(2));
			owner.setApellido(resultSet.getString(3));
			owner.setDireccion(resultSet.getString(4));
			owner.setCorreo(resultSet.getString(5));
			owner.setTelefono(resultSet.getString(6));
			owner.setNombreMascota(resultSet.getString(7));
			lista.add(owner);
		}
		
		return lista;
	}
	
	private Connection obtenerConexion () throws SQLException {
		return Conexion.getConnection();
	}
}
