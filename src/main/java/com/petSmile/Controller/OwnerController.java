package com.petSmile.Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.petSmile.DAO.AgendaDAO;
import com.petSmile.DAO.OwnerDAO;
import com.petSmile.Model.Agenda;
import com.petSmile.Model.Owner;

/**
 * Servlet implementation class OwnerController
 */
public class OwnerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OwnerController() {
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
		OwnerDAO dao = new OwnerDAO();
		Owner d = new Owner();
		
		d.setRut(request.getParameter("rut"));
		d.setNombre(request.getParameter("nombre"));
		d.setApellido(request.getParameter("apellido"));
		d.setDireccion(request.getParameter("direccion"));
		d.setCorreo(request.getParameter("correo"));
		d.setTelefono(request.getParameter("telefono"));
		
		System.out.println("imprime owner");
		System.out.println(d.toString());
		
		boolean estado = false;
		
		try {
			estado = dao.insertarDueño(d);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.getMessage();
			e.printStackTrace();
		}
		
		
		List<Agenda> lista = new ArrayList<Agenda>();
		AgendaDAO agenda = new AgendaDAO();
		
		try {
			lista = agenda.obtenerAgendaTodas();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("AGENDAS");
		System.out.println(lista.toString());
		request.setAttribute("lista", lista);
		
		
		if (estado == true) {
			RequestDispatcher requestDispatcher = (RequestDispatcher) request.getRequestDispatcher("/views/dashboard.jsp");
			requestDispatcher.forward(request, response);
		}else {
			doGet(request, response);
		}
		
		
		
	}

}
