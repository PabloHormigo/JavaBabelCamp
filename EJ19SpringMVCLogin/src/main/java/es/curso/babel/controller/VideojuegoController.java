package es.curso.babel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import es.curso.babel.model.entity.Videojuego;
import es.curso.babel.model.service.VideojuegoService;

@Controller
//Si poneis dentro del RquestMapping una URL, esta URL sera la base para
//todas las URLs de los metodos de esta clase
@RequestMapping("videojuegos")
public class VideojuegoController {
	
	@Autowired
	private VideojuegoService videoService;

	@GetMapping("")
	public ModelAndView getVideojuegos() {
		ModelAndView modelView = new ModelAndView("videojuegos");
		modelView.addObject("videojuegos", videoService.getAllVideojuegos());
		return modelView;
	}
	
	@GetMapping("/detalle")
	public ModelAndView getVideojuegoDetalle(@RequestParam("id") int id) {
		ModelAndView modelView = new ModelAndView("videojuegoDetalle");
		modelView.addObject("videojuego", videoService.findVideojuegoById(id));
		return modelView;
	}
	
	@GetMapping("/delete")
	public String eliminarVideojuego(@RequestParam("id") int id, Model model) {
		videoService.eliminarVideojuego(id);
		return "redirect:/videojuegos";
	}
	
	@GetMapping("/formVideojuego")
	public String getFormVideojuego(@RequestParam(required=false) Integer id, Model model) {
		
		if (id != null) {
			model.addAttribute("videojuego", videoService.findVideojuegoById(id));
		} else {
			model.addAttribute("videojuego", new Videojuego());
		}
		return "formVideojuego";
	}
	
	@PostMapping("/doFormVideojuego")
	public String newVideojuego(
			@ModelAttribute("videojuego") Videojuego videojuego, Model model) {
		
		videojuego.setImagen("imagen-default.jpg");
		
		List<String> messages = videoService.añadirVideojuego(videojuego);
		if (messages.get(0) == "Alta correcta") {
			return "redirect:/videojuegos";
		} else {
			model.addAttribute("messages", messages);
			return "formVideojuego";
		}
		
	}

}
