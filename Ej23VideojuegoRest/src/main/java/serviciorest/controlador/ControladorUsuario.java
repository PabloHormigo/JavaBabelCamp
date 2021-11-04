package serviciorest.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import serviciorest.modelo.entidad.Usuario;
import serviciorest.modelo.negocio.GestorUsuario;
import serviciorest.modelo.persistencia.DaoUsuario;

@RestController
public class ControladorUsuario {
	
	@Autowired
	private GestorUsuario gu;
	
	@Autowired
	private DaoUsuario du;
	
	@GetMapping(path="usuarios", 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Usuario>> getUsuarios(){
		List<Usuario> listaUsuarios = du.findAll();
		if(listaUsuarios != null) {
			return new ResponseEntity<List<Usuario>>(listaUsuarios, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<List<Usuario>>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping(path="usuarios",consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> altaUsuario(@RequestBody Usuario u){
		System.out.println("altaUsuario: objeto usuario: " + u);
		gu.insertar(u);
		return new ResponseEntity<Usuario>(u,HttpStatus.CREATED);
	}
	
	@DeleteMapping(path="usuarios/{user}")
	public ResponseEntity<Usuario> borrarUsuario(@PathVariable String user){
		du.deleteById(user);
		return new ResponseEntity<Usuario>(HttpStatus.OK);
		
	}

}
