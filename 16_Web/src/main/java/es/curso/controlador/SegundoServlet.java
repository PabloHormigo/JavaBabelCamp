package es.curso.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.curso.modelo.entidad.Pelicula;
import es.curso.modelo.negocio.GestorPelicula;


public class SegundoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GestorPelicula gp = new GestorPelicula();
		
		String id = request.getParameter("id");
		
		int idNumerico = Integer.parseInt(id);
		
		Pelicula p = gp.obtener(idNumerico);
		
		if(p != null) {
			//Podemos pasarle a la vista toda la informacion que queramos
			//mediante atributos clave-valor (Map)
			request.setAttribute("p", p);
					
			//Le decimos al servlet que vista queremos elegir
			request.getRequestDispatcher("detallePelicula.jsp").forward(request, response);	
		}else {
			request.getRequestDispatcher("errorPelicula.jsp").forward(request, response);	
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
