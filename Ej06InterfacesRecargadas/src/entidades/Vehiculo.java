package entidades;

import interfaz.Movible;

public class Vehiculo implements Movible{
	
	private int id;
	private int cv;
	private String nombre;
	
	public Vehiculo(int id, int cv, String nombre) {
		this.id = id;
		this.cv = cv;
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCv() {
		return cv;
	}

	public void setCv(int cv) {
		this.cv = cv;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
