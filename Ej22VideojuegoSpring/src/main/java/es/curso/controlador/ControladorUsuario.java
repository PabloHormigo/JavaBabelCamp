package es.curso.controlador;

import java.util.ArrayList;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import es.curso.modelo.entidad.Usuario;
import es.curso.modelo.entidad.Videojuego;
import es.curso.modelo.negocio.GestorUsuario;
import es.curso.modelo.persistencia.DaoUsuario;

@Controller
public class ControladorUsuario {

	@Autowired
	private GestorUsuario gu;
	
	@Autowired
	private DaoUsuario du;
	
	@Autowired
	private Usuario u;
	
	
	@GetMapping("crearUsuario")
	public String crearUsuario(@RequestParam("userNamer") String userName,
			@RequestParam("userPwd") String userPwd) {

		Usuario uAux = new Usuario();
		uAux.setUser(userName);
		uAux.setPwd(userPwd);
		gu.insertar(uAux);
		
		return "login";
	}
	
	@GetMapping("volverLogin")
	public String volverLogin() {
		return "login";
	}
	
	@PostMapping("login")
	public ModelAndView verListado(@RequestParam("user") String user, @RequestParam("pwd") String pwd,
			HttpServletRequest request,
			HttpServletResponse response,
			ModelAndView mav) {
		
		Optional<Usuario> usuarioAux = du.findById(user);
		
		if(usuarioAux.get().getUser().equals(user) && usuarioAux.get().getPwd().equals(pwd)) {
			u.setUser(usuarioAux.get().getUser());
			u.setPwd(usuarioAux.get().getPwd());
			if(u.getCarrito() == null) {
				u.setCarrito(new ArrayList<Videojuego>());
			}
			else {
				u.setCarrito(u.getCarrito());
			}
			mav.addObject("user", u.getUser());
			mav.setViewName("redirect:listadoVideojuegos");
		}
		
		return mav;
	}
	
	@GetMapping("nuevoUsuario")
	public String nuevoUsuario() {
		return "nuevoUsuario";
	}

}
