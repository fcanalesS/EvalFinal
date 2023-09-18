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
import com.petSmile.DAO.MascotaDAO;
import com.petSmile.Model.Agenda;
import com.petSmile.Model.Owner;
import com.petSmile.Model.Mascota;

/**
 * Servlet implementation class DashboardController
 */
public class DashboardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DashboardController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
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
				
		String opcion = request.getParameter("opcion");
		
		System.out.println("opt");
		System.out.println(opcion);
		
		if (opcion.equals("ingresarOwner" )) {
			RequestDispatcher requestDispatcher = (RequestDispatcher) request.getRequestDispatcher("/views/ingresarOwner.jsp");
			requestDispatcher.forward(request, response);
		}else if (opcion.equals("ingresarMascota")) {
			OwnerDAO ownerDAO = new OwnerDAO();
			List<Owner> listaOwner = new ArrayList<Owner>();
			try {
				listaOwner = ownerDAO.obtenerDueñoTodos();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("imprime lista de owners");
			System.out.println(listaOwner.toString());
			request.setAttribute("listaOwner", listaOwner);
			RequestDispatcher requestDispatcher = (RequestDispatcher) request.getRequestDispatcher("/views/ingresarMascota.jsp");
			requestDispatcher.forward(request, response);
		}else if (opcion.equals("ingresarAgenda")) {
			OwnerDAO ownerDAO = new OwnerDAO();
			MascotaDAO mascotaDAO = new MascotaDAO();
			List<Mascota> listaMascota = new ArrayList<Mascota>();
			List<Owner> listaOwner = new ArrayList<Owner>();
			try {
				listaOwner = ownerDAO.obtenerDueñoTodos();
				listaMascota = mascotaDAO.obtenerMascotaTodos();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			request.setAttribute("listaOwner", listaOwner);
			request.setAttribute("listaMascota", listaMascota);
			
				
			
			RequestDispatcher requestDispatcher = (RequestDispatcher) request.getRequestDispatcher("/views/ingresarAgenda.jsp");
			requestDispatcher.forward(request, response);
		}
		
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

