package es.curso.modelo.persistencia;

import java.util.List;

import es.curso.modelo.entidad.Coche;

public interface CocheDao {
	
	String insertar(Coche c);
	String borrar(String matricula);
	Coche modificar(Coche c);
	Coche buscar(String matricula);
	List<Coche> listar();

}
