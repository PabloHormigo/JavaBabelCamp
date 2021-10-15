package modelo.negocio;

import java.util.List;

import modelo.entidad.Coche;
import modelo.persistencia.CocheDaoMySql;
import modelo.persistencia.interfaces.CocheDao;

public class GestorCoche {

	CocheDao cocheDao = new CocheDaoMySql();
	
	public boolean alta(Coche c) {
		if(c.getMatricula().length() == 7 && c.getMarca().length()!=0 && 
				c.getModelo().length()!=0 && c.getMatricula().length()!=0) {
			boolean alta = cocheDao.alta(c);
			return alta;
		}
		else {
			return false;
		}	
	}
	
	public boolean baja(String matricula) {
		boolean baja = cocheDao.baja(matricula);
		return baja;
	}
	
	public boolean modidifcar(Coche c) {
		if(c.getMatricula().length() == 7 && c.getMarca().length()!=0 && 
				c.getModelo().length()!=0) {
			boolean modificado = cocheDao.modificar(c);
			return modificado;
		}
		else {
			return false;
		}	
	}
	
	public Coche obtener(String matricula) {
		Coche coche = cocheDao.obtener(matricula);
		return coche;
	}
	
	public List<Coche> listar(){
		List<Coche> listaCoches = cocheDao.listar();
		return listaCoches;
	}
}
