package es.curso.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.curso.cfg.ConfiguracionJPA;
import es.curso.modelo.entidad.Videojuego;
import es.curso.modelo.negocio.GestorVideojuego;
import es.curso.modelo.persistencia.DaoVideojuego;

@Controller
public class ControladorVideojuego {
	
private static ApplicationContext context;
	
	@Autowired
	private GestorVideojuego gv;
	
	@Autowired
	private DaoVideojuego dv;
	
	@GetMapping("crearVideojuego")
	public String crearVideojuego(@RequestParam("videogameName") String videogameName,
			@RequestParam("videogameCompany") String videogameCompany,
			@RequestParam("videogameNote") String videogameNote,
			@RequestParam("videogameCreator") String videogameCreator,
			@RequestParam("videogameLink") String videogameLink,
			Model model) {
		context = new AnnotationConfigApplicationContext(ConfiguracionJPA.class);
	
		Videojuego v = context.getBean("videojuego",Videojuego.class);
		v.setNombre(videogameName);
		v.setCreador(videogameCreator);
		v.setCompania(videogameCompany);
		v.setEnlace(videogameLink);
		v.setNotaMedia(Double.parseDouble(videogameNote));
		
		gv.insertar(v);
		
		List<Videojuego> listaVideojuegos = gv.listar();
		System.out.println(listaVideojuegos);
		model.addAttribute("lista", listaVideojuegos);
		
		return "listadoVideojuegos";
	}
	
	@GetMapping("nuevoVideojuego")
	public String nuevoVideojuego() {
		return "crearVideojuego";
	}
	
	@GetMapping("listadoVideojuegos")
	public String listadoVideojuegos(Model model) {
		
		List<Videojuego> listaVideojuegos = gv.listar();
		model.addAttribute("lista", listaVideojuegos);
		
		return "listadoVideojuegos";
	}
	
	@GetMapping("detalleVideojuego")
	public String verDetalle(@RequestParam("id") String id,
			Model model) {
		
		System.out.println("ID recibido: "+id);
		int idAux = Integer.parseInt(id);
		
		
		if(idAux<=gv.listar().size()) {
			Videojuego v = dv.findById(idAux).get();
			System.out.println(v);
			model.addAttribute("v", v);
			return "detalleVideojuego";
		}
		else {
			List<Videojuego> listaVideojuegos = gv.listar();
			model.addAttribute("lista", listaVideojuegos);
			model.addAttribute("mensajeError", "No existe el videojuego");
			return "listadoVideojuegos";
		}
	}
	
	@GetMapping("eliminarVideojuego")
	public String eliminarVideojuego(@RequestParam("idEliminar") String idEliminar,
			Model model) {
		int idAux = Integer.parseInt(idEliminar);
		
		if(idAux<=gv.listar().size()) {
			Videojuego v = dv.findById(idAux).get();
			dv.delete(v);
			List<Videojuego> listaVideojuegos = gv.listar();
			model.addAttribute("lista", listaVideojuegos);
			return "listadoVideojuegos";
		}
		else {
			List<Videojuego> listaVideojuegos = gv.listar();
			model.addAttribute("lista", listaVideojuegos);
			model.addAttribute("mensajeError", "No existe el videojuego");
			return "listadoVideojuegos";
		}
	}
	
	@GetMapping("modificarVideojuego")
	public String modificarVideojuego(@RequestParam("idModificar") String id,
			Model model) {
		int idAux = Integer.parseInt(id);
		
		if(idAux<=gv.listar().size()) {
			Videojuego v = dv.findById(idAux).get();
			model.addAttribute("v", v);
			return "modificarVideojuego";
		}
		else {
			List<Videojuego> listaVideojuegos = gv.listar();
			model.addAttribute("lista", listaVideojuegos);
			model.addAttribute("mensajeError", "No existe el videojuego");
			return "listadoVideojuegos";
		}
	}
	
	@GetMapping("setModificacionVideojuego")
	public String setModificacionVideojuego(@RequestParam("videogameName") String videogameName,
			@RequestParam("videogameCompany") String videogameCompany,
			@RequestParam("videogameNote") String videogameNote,
			@RequestParam("videogameCreator") String videogameCreator,
			@RequestParam("videogameLink") String videogameLink,
			@RequestParam("videogameId") String videogameId,
			Model model) {
		
		Videojuego v = new Videojuego();
		
		v.setId(Integer.parseInt(videogameId));
		v.setNombre(videogameName);
		v.setCreador(videogameCreator);
		v.setCompania(videogameCompany);
		v.setEnlace(videogameLink);
		v.setNotaMedia(Double.parseDouble(videogameNote));
		
		gv.modificar(v);
		
		List<Videojuego> listaVideojuegos = gv.listar();
		System.out.println(listaVideojuegos);
		model.addAttribute("lista", listaVideojuegos);
		
		return "listadoVideojuegos";
	}

}
