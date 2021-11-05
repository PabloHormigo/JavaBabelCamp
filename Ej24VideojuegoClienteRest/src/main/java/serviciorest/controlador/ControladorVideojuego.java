package serviciorest.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import serviciorest.cliente.negocio.GestorVideojuego;
import serviciorest.cliente.entidad.*;

@RestController
public class ControladorVideojuego {
	
	@Autowired
	private GestorVideojuego gv;
	
	@GetMapping(path="videojuegos", 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Videojuego>> listar(@RequestParam(name="nombre",required=false) String nombre,
			@RequestParam(name="compania",required=false) String compania){
		List<Videojuego> listaVideojuegos = null;
		
		if(nombre==null && compania==null) {
			listaVideojuegos = gv.listar();
			return new ResponseEntity<List<Videojuego>>(listaVideojuegos,HttpStatus.OK);
		}
		else {
			listaVideojuegos = gv.buscarNombreOrCompania(nombre,compania);
			return new ResponseEntity<List<Videojuego>>(listaVideojuegos,HttpStatus.OK);
		}
	}
	
	@PostMapping(path="videojuegos",consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> altaVideojuego(@RequestBody Videojuego v){
		System.out.println("altaVideojuego: objeto videojuego: " + v);
		int control = gv.insertar(v);
		if(control == 0) {
			return new ResponseEntity<Videojuego>(v,HttpStatus.CREATED);
		}else {
			return new ResponseEntity<Integer>(control,HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@PutMapping(path="videojuegos/{id}",consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> modificarVideojuego(
			@RequestBody Videojuego v,
			@PathVariable("id") int id){
		System.out.println("modificarVideojuego: objeto videojuego: " + v);
		v.setId(id);
		int control = gv.modificar(v);
		if(control == 0) {
			return new ResponseEntity<Videojuego>(v,HttpStatus.OK);
		}else {
			return new ResponseEntity<Integer>(control,HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@DeleteMapping(path="videojuegos/{id}")
	public ResponseEntity<Videojuego>bajaVideojuego(@PathVariable int id){
		Videojuego v = gv.borrar(id);
		if(v!=null) {
			return new ResponseEntity<Videojuego>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Videojuego>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@GetMapping(path="videojuegos/precio",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<String>>precioVideojuegos(){
		
		List<String> listaPrecios = gv.obtenerPrecios();
		
		if(!listaPrecios.isEmpty()) {
			return new ResponseEntity<List<String>>(listaPrecios,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<List<String>>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(path="videojuegos/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Videojuego>obtenerVideojuegoPorId(@PathVariable("id") int id){
		
		Videojuego v = gv.obtener(id);
		
		if(v != null) {
			return new ResponseEntity<Videojuego>(v,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Videojuego>(HttpStatus.NOT_FOUND);
		}
	}

}
