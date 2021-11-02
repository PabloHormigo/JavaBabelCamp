package es.curso.babel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.curso.babel.model.service.UsuarioService;

@Controller
public class LoginController {
	
	@Autowired
	private UsuarioService userService;
	
	@RequestMapping(value= {"", "login"})
	public String getLogin() {
		return "login";
	}

	@PostMapping("doLogin")
	public String login(@RequestParam("username") String username, 
			@RequestParam("password") String password, Model model) {

		if (userService.isUsuarioRegistered(username, password)) {
			return "redirect:/videojuegos";
		} else {
			model.addAttribute("message", "El usuario no se encuentra registrado");
			return "redirect:login";
		}

	}
	
	@GetMapping("registration")
	public String getFormLogin() {
		return "formRegistro";
	}
	
	//Siempre que hagais cambios sobre la bbdd (alta, modificacion o borrar)
	//deberiais de hacer un redirect en vez de un dispatcher, ya que 
	//debemos de cambiar la URL para que en caso de que el cliente
	//haga un F5 o un refresh no se vuelva a enviar la informcion para
	//modificar la bbdd
	@PostMapping("doRegistration")
	public String newUser(@RequestParam("username") String username, 
			@RequestParam("password") String password, Model model) {
		
		System.out.println("doRegistration -> entrando");
		List<String> messages = userService.añadirUsuario(username, password);
		
		if (messages.get(0) == "Usuario registrado correctamente") {
			model.addAttribute("message", messages.get(0));
			return "redirect:login";
		} else {
			model.addAttribute("messages", messages);
			return "formRegistro";
		}
		
	}

}
