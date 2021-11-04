package serviciorest.controlador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import serviciorest.modelo.entidad.*;
import serviciorest.modelo.negocio.GestorVideojuego;

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
	public ResponseEntity<Videojuego> altaVideojuego(@RequestBody Videojuego v){
		System.out.println("altaVideojuego: objeto videojuego: " + v);
		gv.insertar(v);
		return new ResponseEntity<Videojuego>(v,HttpStatus.CREATED);
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
		List<String> listaPrecios = new ArrayList<String>();
		double total = 0;
		
		for(int i=0;i<gv.listar().size();i++) {
			listaPrecios.add(gv.listar().get(i).getNombre()+": "+gv.listar().get(i).getPrecio());
			total+=gv.listar().get(i).getPrecio();
		}
		listaPrecios.add("Total: "+total);
		
		if(!listaPrecios.isEmpty()) {
			return new ResponseEntity<List<String>>(listaPrecios,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<List<String>>(HttpStatus.NOT_FOUND);
		}
	}

}
