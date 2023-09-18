package com.petSmile.Test;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;

import org.apache.commons.dbcp.BasicDataSource;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

import com.petSmile.Conexion.Conexion;
import com.petSmile.DAO.UsuarioDAO;
import com.petSmile.Model.Usuario;

public class UsuarioIncorrectoTest {
	public UsuarioIncorrectoTest() {}
	Connection connection;
	private static BasicDataSource dataSource = null;
	
	@BeforeClass
	public static void setUpClass() {}
	
	@AfterClass
	public static void tearDownClass() {}
	
	@Before
	public void setUp() {}
	
	@After
	public void tearDown() {}
	
	@Test
	public void testUsuario() throws SQLException {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = new Usuario();
		
		usuario = usuarioDAO.obtenerUsuario("test11", "test1231");
		
		assertEquals("El usuario no existe en la base de datos. . .", usuario.getNombre(), null );
		System.out.println("El usuario no existe en la base de datos...");
	}
}
