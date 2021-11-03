package es.curso.controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import es.curso.entidad.Usuario;
import es.curso.entidad.Videojuego;
import es.curso.negocio.GestorUsuario;
import es.curso.negocio.GestorVideojuegos;


@Controller
public class ControladorLogin {
	

	@Autowired
	private GestorVideojuegos gestorVideojuegos;
	@Autowired
	private GestorUsuario gestorUsuario;
	
	private  List<Videojuego> listaVideojuegos;
	
	//Es llamado desde index.html y devuelve el nombre del jsp a cargar
	@RequestMapping("mvc/formulario")
	public String verFormulario() {
		System.out.println("Entrado en form");
		return "mvc/formulario";
	}
	
	@RequestMapping("nuevoUsuario")
	public String nuevoUsuario() {
		return "nuevoUsuario";
	}
	
	@RequestMapping("altaJuego")
	public String altaJuego() {
		return "altaJuego";
	}
	
	@RequestMapping("modificarJuego")
	public String modificarJuego() {
		return "modificarJuego";
	}
	
	@RequestMapping("bajaJuego")
	public String bajaJuego() {
		return "bajaJuego";
	}
	
	//Recibe usuario y nombre de formulario.jsp
	@RequestMapping(path="login",method=RequestMethod.POST)
	public String metodoFormulario(
			@RequestParam("usuario")String usuario,
			@RequestParam("contrasenia") String contrasenia,
			Model model) throws Exception {
		
		try {
			if(gestorUsuario.validar(usuario, contrasenia)) {
				//exito
				actualizarLista();
				model.addAttribute("lista", listaVideojuegos);
				return "listadoVideoJuegos"; 
				
			}else {//fallo
				
				return "errorLogin";
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e);
			return "usuarioNoExiste";
		}
		
	}

	private void actualizarLista() {
		listaVideojuegos = gestorVideojuegos.listar();
	}
	
	@RequestMapping(path="detalleJuego", method=RequestMethod.POST)
	public ModelAndView detalleJuego(@RequestParam("id") int id,
			ModelAndView mav) {
		
			Videojuego vAux = gestorVideojuegos.obtener(id);
			if(vAux !=null) {
				mav.addObject("v",vAux);
				mav.setViewName("detalleVideojuego");
				
			}else {
				mav.setViewName("errorVideojuego");
			}
		return mav;
	}
	@RequestMapping(path="doNuevoUsuario",method=RequestMethod.POST)
	public String crearNuevoUsuario(
			@RequestParam("usuario")String usuario,
			@RequestParam("contrasenia") String contrasenia) throws ServletException, IOException { 
		
			Usuario u = new Usuario(usuario,contrasenia);
		try {
			gestorUsuario.alta(u);
			
		}catch (Exception e) {
			System.err.println(e);
		}
		return "redirect:formulario";
		
		
	}
	
	@RequestMapping(path="doAltaJuego",method=RequestMethod.POST)
	public String crearNuevoJuego(@RequestParam("id")int id,
			@RequestParam("nombre") String nombre,
			@RequestParam("compania") String compania,
			@RequestParam("creador") String creador,
			@RequestParam("link") String link,
			@RequestParam("notaMedia") double notaMedia,
			Model model) throws ServletException, IOException {
			Videojuego v = new Videojuego(id, nombre, compania, notaMedia, creador, link);
		try {
			gestorVideojuegos.alta(v);
			
		}catch (Exception e) {
			System.err.println(e);
		}
		actualizarLista();
		model.addAttribute("lista", listaVideojuegos);
		return "redirect:listadoVideoJuegos";
		
		
	}
	@RequestMapping(path="doModificarJuego",method=RequestMethod.POST)
	public String ModificarJuego(@RequestParam("id")int id,
			@RequestParam("nombre") String nombre,
			@RequestParam("compania") String compania,
			@RequestParam("creador") String creador,
			@RequestParam("link") String link,
			@RequestParam("notaMedia") double notaMedia,
			Model model) throws ServletException, IOException {
			Videojuego v = new Videojuego(id, nombre, compania, notaMedia, creador, link);
		try {
			gestorVideojuegos.modificar(v);
			
		}catch (Exception e) {
			System.err.println(e);
		}
		actualizarLista();
		model.addAttribute("lista", listaVideojuegos);
		return "redirect:listadoVideoJuegos";
		
	}
	
	@RequestMapping(path="doBajaJuego",method=RequestMethod.POST)
	public String bajaJuego(@RequestParam("id")int id,
			Model model) throws ServletException, IOException {
		try {
			gestorVideojuegos.baja(id);
			
		}catch (Exception e) {
			System.err.println(e);
		}
		actualizarLista();
		model.addAttribute("lista", listaVideojuegos);
		return"redirect:listadoVideoJuegos";
		
		
	}
	
}
