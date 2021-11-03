package es.curso.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.curso.entidad.Videojuego;
import es.curso.persistencia.DaoVideojuego;

@Service
public class GestorVideojuegos {
	@Autowired
	private DaoVideojuego daoVideojuego;
	
	@Transactional
	public String alta(Videojuego v) {
		daoVideojuego.save(v);
		return v.getNombre();
	}
	
	@Transactional
	public String modificar(Videojuego v) {
		daoVideojuego.save(v);
		return v.getNombre();
	}
	
	@Transactional
	public int baja(int id) {
		daoVideojuego.deleteById(id);
		return id;
	}
	
	public List<Videojuego> listar() {
		List <Videojuego> lista = daoVideojuego.findAll();
		return lista;
	}
	
	public Videojuego obtener (int id) {
		return daoVideojuego.findById(id).get();
	}

}
