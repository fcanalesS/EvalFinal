package com.petSmile.DAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.petSmile.Conexion.Conexion;
import com.petSmile.Model.Agenda;


public class AgendaDAO {
	private Connection connection;
	private PreparedStatement statement;
	private boolean estadoOperacion;
	
	private Connection obtenerConexion () throws SQLException {
		return Conexion.getConnection();
	}
	
	public boolean insertarAgenda ( Agenda agenda) throws SQLException {
		try {
			ResultSet resultSet = null;
			
			String sql = null;
			estadoOperacion = false;
			connection = obtenerConexion();
			connection.setAutoCommit(false);
			
			sql = "INSERT INTO agenda (idMascota, rutDueño, nombreMascota, hora, fecha) values (?,?,?,?,?)";
			statement=connection.prepareStatement(sql);
			statement.setInt(1, agenda.getIdMascota());
			statement.setString(2, agenda.getRutOwner());
			statement.setString(3, agenda.getNombreMascota());
			statement.setString(4, agenda.getHora());
			statement.setString(5, agenda.getFecha());
			
			estadoOperacion = statement.executeUpdate() > 0;
			connection.commit();
			statement.close();
			
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			connection.rollback();
			statement.close();
			return false;
		}
	}
	
	public Agenda obtenerAgendaUnica (int id) throws SQLException {
		ResultSet resultSet = null;
		
		Agenda agenda = new Agenda();
		
		String sql = null;
		estadoOperacion = false;
		connection = obtenerConexion();
		
		sql = "SELECT * FROM agenda where id = ?";
		statement=connection.prepareStatement(sql);
		statement.setInt(1, id);
		
		resultSet = statement.executeQuery();
		
		if (resultSet.next()) {
			agenda.setId(resultSet.getInt(1));
			agenda.setIdMascota(resultSet.getInt(2));
			agenda.setRutOwner(resultSet.getString(3));
			agenda.setNombreMascota(resultSet.getString(4));
			agenda.setHora(resultSet.getString(5));
			agenda.setFecha(resultSet.getString(6));
		}
		
		return agenda;
	}
	
	public List<Agenda> obtenerAgenda (String rut) throws SQLException {
		ResultSet resultSet = null;
		
		List<Agenda> agendas = null;
		
		String sql = null;
		estadoOperacion = false;
		connection = obtenerConexion();
		
		sql = "SELECT * FROM agenda where rutDueño = ?";
		statement=connection.prepareStatement(sql);
		statement.setString(1, rut);
		
		resultSet = statement.executeQuery();
		
		while (resultSet.next()) {
			Agenda agenda = new Agenda();
			agenda.setId(resultSet.getInt(1));
			agenda.setIdMascota(resultSet.getInt(2));
			agenda.setRutOwner(resultSet.getString(3));
			agenda.setNombreMascota(resultSet.getString(4));
			agenda.setHora(resultSet.getString(5));
			agenda.setFecha(resultSet.getString(6));
			agendas.add(agenda);
		}
		
		return agendas;
	}
	
	public List<Agenda> obtenerAgendaTodas () throws SQLException {
		ResultSet resultSet = null;
		
		List<Agenda> agendas = new ArrayList<Agenda>();
		
		String sql = null;
		estadoOperacion = false;
		connection = obtenerConexion();
		
		sql = "SELECT * FROM agenda";
		statement=connection.prepareStatement(sql);
		
		resultSet = statement.executeQuery();
		
		while (resultSet.next()) {
			Agenda agenda = new Agenda();
			agenda.setId(resultSet.getInt(1));
			agenda.setIdMascota(resultSet.getInt(2));
			agenda.setRutOwner(resultSet.getString(3));
			agenda.setNombreMascota(resultSet.getString(4));
			agenda.setHora(resultSet.getString(5));
			agenda.setFecha(resultSet.getString(6));
			agendas.add(agenda);
		}
		
		return agendas;
	}
}
