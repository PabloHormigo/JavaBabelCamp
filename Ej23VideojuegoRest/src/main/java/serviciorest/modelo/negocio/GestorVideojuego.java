package serviciorest.modelo.negocio;

import serviciorest.modelo.persistencia.DaoVideojuego;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import serviciorest.modelo.entidad.*;

@Service
public class GestorVideojuego {
	
	@Autowired
	private DaoVideojuego videojuegoDao;
	
	@Transactional
	public int insertar(Videojuego v) {
		if(!v.getNombre().equals("") && !v.getCreador().equals("") && !v.getCompania().equals("") &&
				!v.getEnlace().equals("") && v.getNotaMedia() >=0) {
			videojuegoDao.save(v);
			return v.getId();
		}
		return -1;
	}
	
	@Transactional
	public Videojuego borrar(int id) {
		Videojuego v = videojuegoDao.getById(id);
		if(v!=null) {
			videojuegoDao.deleteById(id);
		}
		
		return v;
	}
	
	@Transactional
	public Videojuego modificar(Videojuego v) {
		if(!v.getNombre().equals("") && !v.getCreador().equals("") && !v.getCompania().equals("") &&
				!v.getEnlace().equals("") && v.getNotaMedia() >=0) {
			return videojuegoDao.save(v);
		}
		return null;
		
	}
	
	public List<Videojuego> buscarNombreOrCompania(String nombre, String compania) {
		return videojuegoDao.findByNombreOrCompania(nombre,compania);
	}
	
	public List<Videojuego> listar(){
		return videojuegoDao.findAll();
	}
	
	
	
	
	public Videojuego obtener(int id) {
		return videojuegoDao.findById(id).get();
	}

}
