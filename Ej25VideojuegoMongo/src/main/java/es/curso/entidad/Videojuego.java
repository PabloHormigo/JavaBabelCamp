package es.curso.entidad;

import org.springframework.context.annotation.Scope;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Document(collection = "videojuegos")
public class Videojuego {
	
	@Id
	private int id;
	private String nombre;
	private String compania;
	private double notaMedia;
	private String creador;
	private String enlace;
	private double precio;
	
	public Videojuego() {
		
	}
	
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
	
	public String getCompania() {
		return compania;
	}
	
	public void setCompania(String compania) {
		this.compania = compania;
	}
	
	public double getNotaMedia() {
		return notaMedia;
	}
	
	public void setNotaMedia(double notaMedia) {
		this.notaMedia = notaMedia;
	}
	
	public String getCreador() {
		return creador;
	}

	public void setCreador(String creador) {
		this.creador = creador;
	}

	public String getEnlace() {
		return enlace;
	}

	public void setEnlace(String enlace) {
		this.enlace = enlace;
	}
	
	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Videojuego [id=" + id + ", nombre=" + nombre + ", precio=" + precio + "]";
	}

	
	
	
}

