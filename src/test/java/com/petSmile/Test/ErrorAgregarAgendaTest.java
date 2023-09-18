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
import com.petSmile.DAO.DueñoDAO;
import com.petSmile.DAO.UsuarioDAO;
import com.petSmile.Model.Agenda;
import com.petSmile.Model.Dueño;
import com.petSmile.Model.Usuario;

public class ErrorAgregarAgendaTest {
	public ErrorAgregarAgendaTest() {}
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
	public void testErrorAgregarAgenda() throws SQLException {
		AgendaDAO agendaDAO = new AgendaDAO();
		Agenda agenda = new Agenda(0, 2, "1-909", "Mascota Test", "09.12", "2022-04-27");
		
		boolean estado = agendaDAO.insertarAgenda(agenda); 
		
		assertEquals("No se pudo agregar la agenda en la base de datos. . .", estado, false );
		System.out.println("No se pudo agregar la agenda en la base de datos. . .");
	}
}
