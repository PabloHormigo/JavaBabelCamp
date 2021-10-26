package es.curso.modelo.negocio;

import java.util.List;

import es.curso.modelo.entidad.Pelicula;
import es.curso.modelo.persistencia.DaoPelicula;

public class GestorPelicula {	

	private DaoPelicula peliculaDao;
	
	public List<Pelicula> listar(){
		peliculaDao = new DaoPelicula();
		return peliculaDao.listar();
	}
	
	public Pelicula obtener(int id) {
		peliculaDao = new DaoPelicula();
		return peliculaDao.obtener(id);
	}
	
}
