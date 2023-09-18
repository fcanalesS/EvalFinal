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
import com.petSmile.DAO.OwnerDAO;
import com.petSmile.DAO.UsuarioDAO;
import com.petSmile.Model.Owner;
import com.petSmile.Model.Usuario;

public class ExisteDueñoTest {
	public ExisteDueñoTest() {}
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
	public void testExisteDueño() throws SQLException {
		OwnerDAO dueñoDAO = new OwnerDAO();
		Owner dueño = new Owner();
		
		dueño = dueñoDAO.obtenerDueño("1-9");
		
		assertEquals("El dueño existe en la base de datos. . .", dueño.getRut(), "1-9" );
		System.out.println("El dueño existe en la base de datos...");
	}
}
