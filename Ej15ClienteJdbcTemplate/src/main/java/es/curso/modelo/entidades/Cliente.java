package es.curso.modelo.entidades;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Cliente {

	private int id;
	private String nombre;
	private int edad;
	//private List<Pedido> listaPedidos;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getEdad() {
		return edad;
	}
	
	public void setEdad(int edad) {
		this.edad = edad;
	}

	@Override
	public String toString() {
		return "\tCliente [id=" + id + ", nombre=" + nombre + ", edad=" + edad + "]\n";
	}
	
/*	public List<Pedido> getListaPedidos() {
		return listaPedidos;
	}
	
	public void setListaPedidos(List<Pedido> listaPedidos) {
		this.listaPedidos = listaPedidos;
	}

	@Override
	public String toString() {
		return "\tCliente [id=" + id + ", nombre=" + nombre + ", edad=" + edad + ", listaPedidos=" + listaPedidos + "]\n";
	}
	*/
	
	
	
}
