package es.curso.modelo.negocio;

import es.curso.modelo.persistencia.DaoVideojuego;

import java.util.List;

import org.springframework.stereotype.Component;

import es.curso.modelo.entidad.*;

@Component
public class GestorVideojuego {
	
	private DaoVideojuego videojuegoDao;
	
	public List<Videojuego> listar(){
		videojuegoDao = new DaoVideojuego();
		return videojuegoDao.listar();
	}
	
	public Videojuego obtener(int id) {
		videojuegoDao = new DaoVideojuego();
		return videojuegoDao.obtener(id);
	}

}
