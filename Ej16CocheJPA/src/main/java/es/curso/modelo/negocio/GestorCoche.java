package es.curso.modelo.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.curso.modelo.entidad.Coche;
import es.curso.modelo.persistencia.CocheDaoJPA;

@Service
public class GestorCoche {
	
	@Autowired
	private CocheDaoJPA cocheDao;
	
	@Transactional
	public String insertar(Coche c) {
		if(c.getMatricula().length() == 7 && c.getMarca().length()!=0 && 
				c.getModelo().length()!=0 && c.getMatricula().length()!=0) {
			return cocheDao.insertar(c);
		}
		else {
			return "";
		}
	}
	
	@Transactional
	public String borrar(String matricula) {
		return cocheDao.borrar(matricula);
	}
	
	@Transactional
	public Coche modidifcar(Coche c) {
		if(c.getMatricula().length() == 7 && c.getMarca().length()!=0 && 
				c.getModelo().length()!=0) {
			return cocheDao.modificar(c);
		}
		else {
			return null;
		}	
	}
	
	public Coche buscar(String matricula) {
		Coche coche = cocheDao.buscar(matricula);
		return coche;
	}
	
	public List<Coche> listar(){
		List<Coche> listaCoches = cocheDao.listar();
		return listaCoches;
	}

}
