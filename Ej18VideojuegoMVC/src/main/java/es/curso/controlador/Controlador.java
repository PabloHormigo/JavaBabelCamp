package es.curso.controlador;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import es.curso.modelo.entidad.Videojuego;
import es.curso.modelo.negocio.GestorVideojuego;

@Controller
public class Controlador {
	
	@Autowired
	private GestorVideojuego gv;
	
	@RequestMapping(path="login",method=RequestMethod.POST)
	public ModelAndView verListado(@RequestParam("user") String user, @RequestParam("pwd") String pwd,
			HttpServletRequest request,
			HttpServletResponse response,
			ModelAndView mav) {
		
		if(user.equals("user") && pwd.equals("1234")) {
			mav.setViewName("redirect:listadoVideojuegos");
		}
		
		return mav;
	}
	
	@GetMapping("listadoVideojuegos")
	public String listadoVideojuegos(Model model) {
		List<Videojuego> listaVideojuegos = gv.listar();
		System.out.println(listaVideojuegos);
		model.addAttribute("lista", listaVideojuegos);
		
		return "listadoVideojuegos";
	}
	
	@RequestMapping(path="detalleVideojuego",method=RequestMethod.POST)
	public ModelAndView verDetalle(@RequestParam("id") String id,
			HttpServletRequest request,
			HttpServletResponse response,
			ModelAndView mav) {
		
		int idNumerico = Integer.parseInt(id);
		Videojuego v = gv.obtener(idNumerico);
		
		if(v!=null) {
			mav.addObject("v",v);
			mav.setViewName("detalleVideojuego");
		}
		else {
			List<Videojuego> listaVideojuegos = gv.listar();
			mav.addObject("lista", listaVideojuegos);
			mav.addObject("mensajeError", "No existe el videojuego");
			mav.setViewName("listadoVideojuegos");
		}
		
		return mav;
	}
	
	

}
