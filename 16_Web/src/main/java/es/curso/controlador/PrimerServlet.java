package es.curso.controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.curso.modelo.entidad.Pelicula;
import es.curso.modelo.negocio.GestorPelicula;


/**
 * 
 * Un servlet es un objeto java unico (singleton) que puede recibir peticiones
 * HTTP.
 * 
 * Es creado mediante IoC, es decir, nosotros no tenemos control sobre el ciclo
 * de vida del objeto, es en este caso Tomcat quien lo crea y quien lo destruye
 * 
 * Estos objetos se daran de alta en el contexto de tomcat
 * 
 * Tenemos dos maneras de dar de alta estos objetos servlets, 
 * mediante anotaciones y mediante XML
 * 
 * Mediante anotaciones usaremos la anotacion @WebServlet y dentro de esta
 * le pondremos la URL a la cual queremos mapearlo
 * http://localhost:8080/16_web/PrimerServlet
 *
 */
@WebServlet("/PrimerServlet")
public class PrimerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;       

    public PrimerServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GestorPelicula gp = new GestorPelicula();
		
		List<Pelicula> listaPeliculas = gp.listar();
		System.out.println(listaPeliculas);
		
		//Podemos pasarle a la vista toda la informacion que queramos
		//mediante atributos clave-valor (Map)
		request.setAttribute("lista", listaPeliculas);
				
		//Le decimos al servlet que vista queremos elegir
		request.getRequestDispatcher("listadoPeliculas.jsp").forward(request, response);	
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
