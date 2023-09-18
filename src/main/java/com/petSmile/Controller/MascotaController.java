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
import com.petSmile.DAO.MascotaDAO;
import com.petSmile.Model.Agenda;
import com.petSmile.Model.Mascota;

/**
 * Servlet implementation class MascotaController
 */
public class MascotaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MascotaController() {
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
		Mascota mascota = new Mascota();
		MascotaDAO mascotaDAO = new MascotaDAO();
		
		System.out.println(request.getParameter("rut"));
		System.out.println(request.getParameter("tipoMascota"));
		System.out.println(request.getParameter("edad"));
		System.out.println(request.getParameter("nombreMascota"));
		
		mascota.setRutOwner(request.getParameter("rut"));
		mascota.setTipoMascota(request.getParameter("tipoMascota"));
		mascota.setEdad(Integer.parseInt(request.getParameter("edad")));
		mascota.setNombreMascota(request.getParameter("nombreMascota"));
		
		boolean estado = false;
		
		try {
			estado = mascotaDAO.insertarMascota(mascota);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Ingreso de mascota");
		System.out.println(mascota.toString());
		
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
			RequestDispatcher requestDispatcher = (RequestDispatcher) request.getRequestDispatcher("/views/ingresarMascota.jsp");
			requestDispatcher.forward(request, response);
		}
		
		
		doGet(request, response);
	}

}
