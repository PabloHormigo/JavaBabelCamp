package es.curso.controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.curso.modelo.negocio.GestorVideojuego;
import es.curso.modelo.entidad.*;

/**
 * Servlet implementation class PrimerServlet
 */
@WebServlet("/PrimerServlet")
public class PrimerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PrimerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GestorVideojuego gv = new GestorVideojuego();
		String user = request.getParameter("user");
		String pwd = request.getParameter("pwd");
		
		if(user.equals("user") && pwd.equals("1234")) {
			List<Videojuego> listaVideojuegos = gv.listar();
			System.out.println(listaVideojuegos);
			request.setAttribute("lista", listaVideojuegos);
			request.getRequestDispatcher("listadoVideojuegos.jsp").forward(request, response);
		}
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
