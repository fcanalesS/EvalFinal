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
import com.petSmile.DAO.AgendaDAO;
import com.petSmile.DAO.UsuarioDAO;
import com.petSmile.Model.Agenda;
import com.petSmile.Model.Usuario;

public class ExisteAgendaTest {
	public ExisteAgendaTest() {}
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
	public void testExisteAgenda() throws SQLException {
		AgendaDAO agendaDAO = new AgendaDAO();
		Agenda agenda = new Agenda();
		
		agenda = agendaDAO.obtenerAgendaUnica(16);
		
		assertEquals("La agenda existe en la base de datos. . .", agenda.getId(), 16 );
		System.out.println("La agenda existe en la base de datos...");
	}
}
