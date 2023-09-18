package com.petSmile.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.petSmile.Conexion.Conexion;
import com.petSmile.Model.Usuario;

public class UsuarioDAO {
	private Connection connection;
	private PreparedStatement statement;
	private boolean estadoOperacion;
	
	public Usuario obtenerUsuario (String usuario, String password) throws SQLException {
		ResultSet resultSet = null;
		Usuario user = new Usuario();
		
		String sql = null;
		estadoOperacion = false;
		connection = obtenerConexion();
		
		sql = "SELECT * FROM usuario WHERE nombreUsuario = ? AND password = ?";
		statement=connection.prepareStatement(sql);
		statement.setString(1, usuario);
		statement.setString(2, password);
		
		resultSet = statement.executeQuery();
		
		if (resultSet.next()) {
			user.setId(resultSet.getInt(1));
			user.setNombre(resultSet.getString(2));
			user.setPassword(resultSet.getString(3));
		}
		
		
		return user;
	}
	
	private Connection obtenerConexion () throws SQLException {
		return Conexion.getConnection();
	}
}
