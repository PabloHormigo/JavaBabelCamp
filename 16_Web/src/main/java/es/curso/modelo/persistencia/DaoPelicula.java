package es.curso.modelo.persistencia;

import java.util.ArrayList;
import java.util.List;

import es.curso.modelo.entidad.Pelicula;


public class DaoPelicula {

	public DaoPelicula() {
		
	}
	
	public List<Pelicula> listar(){
		List<Pelicula> listaPelicula = new ArrayList<Pelicula>();
		
		Pelicula p = new Pelicula();
		p.setId(1);
		p.setTitulo("La guerra de las galaxias");
		p.setGenero("Scifi");		
		p.setDirector("George Lucas");
		p.setYear(1975);
		
		listaPelicula.add(p);
		
		p = new Pelicula();
		p.setId(2);
		p.setTitulo("El imperio contra ataca");
		p.setGenero("Scifi");
		p.setDirector("George Lucas");
		p.setYear(1979);
		
		listaPelicula.add(p);

		return listaPelicula;
	}
	
	public Pelicula obtener(int id){
		
		if(id == 1) {
			Pelicula p = new Pelicula();
			p.setId(1);
			p.setTitulo("La guerra de las galaxias");
			p.setGenero("Scifi");		
			p.setDirector("George Lucas");
			p.setYear(1975);
			return p;
		}else if(id == 2) {
			Pelicula p = new Pelicula();
			p.setId(2);
			p.setTitulo("El imperio contra ataca");
			p.setGenero("Scifi");
			p.setDirector("George Lucas");
			p.setYear(1979);
			
			return p;
		} else {
			return null;
		}
	}
}
