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
import com.petSmile.DAO.UsuarioDAO;
import com.petSmile.Model.Agenda;
import com.petSmile.Model.Usuario;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
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
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		UsuarioDAO user = new UsuarioDAO();
		
		request.setAttribute("mensaje", "mensaje de prueba");
		
		
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
		
		
		Usuario existeUsuario = new Usuario();
		try {
			existeUsuario = user.obtenerUsuario(username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		if (existeUsuario.getNombre() != null) {
			request.setAttribute("rut", existeUsuario);
			RequestDispatcher requestDispatcher = (RequestDispatcher) request.getRequestDispatcher("/views/dashboard.jsp");
			requestDispatcher.forward(request, response);
		}else {
			RequestDispatcher requestDispatcher = (RequestDispatcher) request.getRequestDispatcher("/index.jsp");
			requestDispatcher.forward(request, response);
		}
		//doGet(request, response);
	}

}
