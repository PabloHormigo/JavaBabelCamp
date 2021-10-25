package es.curso.modelo.persistencia;

import java.util.List;

import es.curso.modelo.entidades.Cliente;

public interface DaoCliente {
	
	int insertar(Cliente c);
	int modificar(Cliente c);
	int borrar(int id);
	Cliente buscarId(int id);
	Cliente buscarNombre(String nombre);
	List<Cliente> listar();

}
