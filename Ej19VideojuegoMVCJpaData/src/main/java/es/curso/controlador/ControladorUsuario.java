package es.curso.controlador;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import es.curso.cfg.ConfiguracionJPA;
import es.curso.modelo.entidad.Usuario;
import es.curso.modelo.negocio.GestorUsuario;
import es.curso.modelo.persistencia.DaoUsuario;

@Controller
public class ControladorUsuario {
	
	private static ApplicationContext context;

	@Autowired
	private GestorUsuario gu;
	
	@Autowired
	private DaoUsuario du;
	
	@GetMapping("crearUsuario")
	public String crearUsuario(@RequestParam("userNamer") String userName,
			@RequestParam("userPwd") String userPwd) {
		context = new AnnotationConfigApplicationContext(ConfiguracionJPA.class);

		Usuario u = context.getBean("usuario",Usuario.class);
		u.setUser(userName);
		u.setPwd(userPwd);
		gu.insertar(u);
		
		return "login";
	}
	
	@RequestMapping(path="login",method=RequestMethod.POST)
	public ModelAndView verListado(@RequestParam("user") String user, @RequestParam("pwd") String pwd,
			HttpServletRequest request,
			HttpServletResponse response,
			ModelAndView mav) {
		
		Optional<Usuario> usuarioAux = du.findById(user);

		if(usuarioAux.get().getUser().equals(user) && usuarioAux.get().getPwd().equals(pwd)) {
			mav.setViewName("redirect:listadoVideojuegos");
		}
		
		return mav;
	}
	
	@GetMapping("nuevoUsuario")
	public String nuevoUsuario() {
		return "nuevoUsuario";
	}

}
