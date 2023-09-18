package com.petSmile.Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.petSmile.DAO.AgendaDAO;
import com.petSmile.Model.Agenda;

/**
 * Servlet implementation class AgendaController
 */
public class AgendaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgendaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		AgendaDAO agendaDAO = new AgendaDAO();
		Agenda agenda = new Agenda();
		
		agenda.setRutOwner(request.getParameter("rut"));
		agenda.setNombreMascota(request.getParameter("nombreMascota"));
		agenda.setHora(request.getParameter("hora"));
		agenda.setFecha(request.getParameter("fecha"));
		agenda.setIdMascota(Integer.parseInt(request.getParameter("mascota")));
		
		
		System.out.println("Imprime agenda");
		System.out.println(agenda.toString());
		
		
		boolean estado = false;
		
		try {
			estado = agendaDAO.insertarAgenda(agenda);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		System.out.println(estado);
		
		if (estado == true) {
			List<Agenda> lista = new ArrayList<Agenda>();
			AgendaDAO dao = new AgendaDAO();
			
			try {
				lista = dao.obtenerAgendaTodas();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("AGENDAS");
			System.out.println(lista.toString());
			request.setAttribute("lista", lista);
			
			RequestDispatcher requestDispatcher = (RequestDispatcher) request.getRequestDispatcher("/views/dashboard.jsp");
			requestDispatcher.forward(request, response);
		}else {
			RequestDispatcher requestDispatcher = (RequestDispatcher) request.getRequestDispatcher("/views/dashboard.jsp");
			requestDispatcher.forward(request, response);
		}
		
		
		doGet(request, response);
	}

}
