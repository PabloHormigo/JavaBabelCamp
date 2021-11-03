package es.curso.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.curso.modelo.entidad.Usuario;
import es.curso.modelo.entidad.Videojuego;
import es.curso.modelo.negocio.GestorVideojuego;
import es.curso.modelo.persistencia.DaoVideojuego;

@Controller
public class ControladorVideojuego {
	
	@Autowired
	private GestorVideojuego gv;
	
	@Autowired
	private DaoVideojuego dv;
	
	@Autowired
	private Usuario u;
	
	@Autowired
	private Videojuego v;
	
	private double totalPagar=0;
	
	@GetMapping("nuevoVideojuego")
	public String nuevoVideojuego() {
		return "crearVideojuego";
	}
	
	
	@GetMapping("crearVideojuego")
	public String crearVideojuego(@RequestParam("videogameName") String videogameName,
			@RequestParam("videogameCompany") String videogameCompany,
			@RequestParam("videogameNote") String videogameNote,
			@RequestParam("videogameCreator") String videogameCreator,
			@RequestParam("videogamePrice") String videogamePrice,
			@RequestParam("videogameLink") String videogameLink,
			Model model) {
	
		v.setNombre(videogameName);
		v.setCreador(videogameCreator);
		v.setCompania(videogameCompany);
		v.setPrecio(Double.parseDouble(videogamePrice));
		v.setEnlace(videogameLink);
		v.setNotaMedia(Double.parseDouble(videogameNote));
		
		dv.save(v);
		
		List<Videojuego> listaVideojuegos = gv.listar();
		System.out.println(listaVideojuegos);
		model.addAttribute("userName", u.getUser());
		model.addAttribute("lista", listaVideojuegos);
		
		return "listadoVideojuegos";
	}
	
	@GetMapping("listadoVideojuegos")
	public String listadoVideojuegos(Model model) {
		
		List<Videojuego> listaVideojuegos = gv.listar();
		model.addAttribute("userName", u.getUser());
		model.addAttribute("lista", listaVideojuegos);
		model.addAttribute("listaCarrito", u.getCarrito());
		
		return "listadoVideojuegos";
	}
	
	@GetMapping("detalleVideojuego")
	public String verDetalle(@RequestParam("id") String id,
			Model model) {
		
		System.out.println("ID recibido: "+id);
		int idAux = Integer.parseInt(id);
		
		
		if(dv.existsById(idAux)) {
			Videojuego v = dv.findById(idAux).get();
			System.out.println(v);
			model.addAttribute("v", v);
			return "detalleVideojuego";
		}
		else {
			List<Videojuego> listaVideojuegos = gv.listar();
			model.addAttribute("lista", listaVideojuegos);
			model.addAttribute("userName", u.getUser());
			model.addAttribute("mensajeError", "No existe el videojuego");
			return "listadoVideojuegos";
		}
	}
	
	@GetMapping("eliminarVideojuego")
	public String eliminarVideojuego(@RequestParam("idEliminar") String idEliminar,
			Model model) {
		int idAux = Integer.parseInt(idEliminar);
		
		if(dv.existsById(idAux)) {
			Videojuego v = dv.findById(idAux).get();
			dv.delete(v);
			List<Videojuego> listaVideojuegos = gv.listar();
			model.addAttribute("userName", u.getUser());
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
		
		if(dv.existsById(idAux)) {
			Videojuego v = dv.findById(idAux).get();
			model.addAttribute("v", v);
			return "modificarVideojuego";
		}
		else {
			List<Videojuego> listaVideojuegos = gv.listar();
			model.addAttribute("lista", listaVideojuegos);
			model.addAttribute("userName", u.getUser());
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
			@RequestParam("videogamePrice") String videogamePrice,
			@RequestParam("videogameId") String videogameId,
			Model model) {
		
		Videojuego v = new Videojuego();
		
		v.setId(Integer.parseInt(videogameId));
		v.setNombre(videogameName);
		v.setCreador(videogameCreator);
		v.setCompania(videogameCompany);
		v.setPrecio(Double.parseDouble(videogamePrice));
		v.setEnlace(videogameLink);
		v.setNotaMedia(Double.parseDouble(videogameNote));
		
		gv.modificar(v);
		
		List<Videojuego> listaVideojuegos = gv.listar();
		System.out.println(listaVideojuegos);
		model.addAttribute("userName", u.getUser());
		model.addAttribute("lista", listaVideojuegos);
		
		return "listadoVideojuegos";
	}
	
	@GetMapping("anadirCarrito")
	public String anadirCarrito(@RequestParam("idAnadir") String id,
			Model model) {
		
		int idAux = Integer.parseInt(id);
		
		if(dv.existsById(idAux)) {
			Videojuego v = dv.findById(idAux).get();
			u.getCarrito().add(v);
			
			model.addAttribute("listaCarrito",u.getCarrito());
			
			totalPagar+=v.getPrecio();
			model.addAttribute("totalPagar", totalPagar);
			
			List<Videojuego> listaVideojuegos = gv.listar();
			model.addAttribute("lista", listaVideojuegos);
			
			model.addAttribute("userName", u.getUser());
			
			return "listadoVideojuegos";
		}
		else {
			List<Videojuego> listaVideojuegos = gv.listar();
			model.addAttribute("userName", u.getUser());
			model.addAttribute("lista", listaVideojuegos);
			model.addAttribute("listaCarrito",u.getCarrito());
			model.addAttribute("totalPagar", totalPagar);
			model.addAttribute("mensajeError", "No existe el videojuego");
			return "listadoVideojuegos";
		}
		
	}

}
