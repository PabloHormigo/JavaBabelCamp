package es.curso.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.curso.modelo.entidades.Cliente;
import es.curso.modelo.persistencia.DaoCliente;

@Service
public class GestorCliente {
	
	@Autowired
	DaoCliente daoCliente;

	public int insertar(Cliente c) {
		if(!"".equals(c.getNombre()) && c.getEdad() != 0) {
			System.out.println("Cliente añadido con exito");
			return daoCliente.insertar(c);
		}
		else {
			return -1;
		}
	}
	
	public int modificar(Cliente c) {
		if(!"".equals(c.getNombre()) && c.getEdad() != 0) {
			return daoCliente.modificar(c);
		}
		else {
			return -1;
		}
	}
	
	public int borrar(int id) {
		System.out.println("Cliente borrado con exito");
		return daoCliente.borrar(id);
	}
	
	public Cliente buscarId(int id) {
		return daoCliente.buscarId(id);
	}
	
	public Cliente buscarNombre(String nombre) {
		return daoCliente.buscarNombre(nombre);
	}
	
	public List<Cliente> listar(){
		return daoCliente.listar();
	}
}
