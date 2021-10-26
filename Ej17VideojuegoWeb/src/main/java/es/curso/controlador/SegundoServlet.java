package es.curso.controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.curso.modelo.entidad.Videojuego;
import es.curso.modelo.negocio.GestorVideojuego;

@WebServlet("/SegundoServlet")
public class SegundoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SegundoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GestorVideojuego gv = new GestorVideojuego();
		String id = request.getParameter("id");
		int idNumerico = Integer.parseInt(id);
		
		Videojuego v = gv.obtener(idNumerico);
		
		if(v != null) {
			request.setAttribute("v", v);
			request.getRequestDispatcher("detalleVideojuego.jsp").forward(request, response);	
		}
		else {
			List<Videojuego> listaVideojuegos = gv.listar();
			request.setAttribute("lista", listaVideojuegos);
			request.setAttribute("mensajeError", "No existe el videojuego");
			request.getRequestDispatcher("listadoVideojuegos.jsp").forward(request, response);	
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
