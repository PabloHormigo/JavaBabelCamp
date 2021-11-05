package es.curso.negocio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.curso.entidad.Videojuego;
import es.curso.persistencia.DaoVideojuego;


@Service
public class GestorVideojuego {
	
	@Autowired
	private DaoVideojuego videojuegoDao;
	
	@Transactional
	public int insertar(Videojuego v) {
		if("".equals(v.getNombre()) || v.getNombre() == null){
			return 1;
		}else if("".equals(v.getCreador()) || v.getCreador() == null){
			return 2;
		}else if("".equals(v.getCompania()) || v.getCompania()== null){
			return 3;
		}else if("".equals(v.getEnlace()) || v.getEnlace() == null){
			return 4;
		}else if(v.getNotaMedia() < 0 || v.getNotaMedia() > 10) {
			return 5;
		}
		
		videojuegoDao.save(v);
		return 0;
	}
	
	@Transactional
	public Videojuego borrar(int id) {
		Optional<Videojuego> v = videojuegoDao.findById(id);
		if(v!=null) {
			videojuegoDao.deleteById(id);
		}
		
		return v.orElse(null);
	}
	
	@Transactional
	public int modificar(Videojuego v) {
		if("".equals(v.getNombre()) || v.getNombre() == null){
			return 1;
		}else if("".equals(v.getCreador()) || v.getCreador() == null){
			return 2;
		}else if("".equals(v.getCompania()) || v.getCompania()== null){
			return 3;
		}else if("".equals(v.getEnlace()) || v.getEnlace() == null){
			return 4;
		}else if(v.getNotaMedia() < 0 || v.getNotaMedia() > 10) {
			return 5;
		}
		
		videojuegoDao.save(v);
		return 0;
		
	}
	
	public List<Videojuego> buscarNombreOrCompania(String nombre, String compania) {
		return videojuegoDao.findByNombreOrCompania(nombre,compania);
	}
	
	public List<Videojuego> listar(){
		return videojuegoDao.findAll();
	}
		
	public Videojuego obtener(int id) {
		Optional<Videojuego> v = videojuegoDao.findById(id);
		return v.orElse(null);
	}
	
	public List<String> obtenerPrecios(){
		List<String> listaPrecios = new ArrayList<String>();
		double total = 0;
		
		for(Videojuego v : listar()) {
			listaPrecios.add(v.getNombre()+": "+v.getPrecio());
			total+=v.getPrecio();
		}
		listaPrecios.add("Total: "+total);
		
		return listaPrecios;
	}

}
