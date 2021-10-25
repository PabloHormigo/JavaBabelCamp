package es.curso.modelo.negocio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.curso.modelo.entidad.Coche;
import es.curso.modelo.persistencia.DaoCocheJPAData;

@Service
public class GestorCoche {
	
	@Autowired
	private DaoCocheJPAData cocheDao;
	
	@Transactional
	public String insertar(Coche c) {
		if(c.getMatricula().length() == 7 && c.getMarca().length()!=0 && 
				c.getModelo().length()!=0 && c.getMatricula().length()!=0) {
			return cocheDao.save(c).getMatricula();
		}
		else {
			return "";
		}
	}
	
	@Transactional
	public String borrar(String matricula) {
		cocheDao.deleteById(matricula);
		return matricula;
	}
	
	@Transactional
	public Coche modidifcar(Coche c) {
		if(c.getMatricula().length() == 7 && c.getMarca().length()!=0 && 
				c.getModelo().length()!=0) {
			return cocheDao.save(c);
		}
		else {
			return null;
		}	
	}
	
	public Coche buscar(String matricula) {
		Coche coche = cocheDao.getOne(matricula);
		return coche;
	}
	
	public List<Coche> listar(){
		List<Coche> listaCoches = cocheDao.findAll();
		return listaCoches;
	}

}
