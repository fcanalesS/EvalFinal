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
import com.petSmile.DAO.DueñoDAO;
import com.petSmile.DAO.UsuarioDAO;
import com.petSmile.Model.Dueño;
import com.petSmile.Model.Usuario;

public class ExisteDueñoNoExisteTest {
	public ExisteDueñoNoExisteTest() {}
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
	public void testNoExisteDueño() throws SQLException {
		DueñoDAO dueñoDAO = new DueñoDAO();
		Dueño dueño = new Dueño();
		
		dueño = dueñoDAO.obtenerDueño("1-1119");
		
		assertEquals("El dueño no existe en la base de datos. . .", dueño.getRut(), null );
		System.out.println("El dueño no existe en la base de datos...");
	}
}
