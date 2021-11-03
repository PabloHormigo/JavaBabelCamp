package es.curso.entidad;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@Scope("prototype")

@Entity
@Table(name="videojuegos")
public class Videojuego {
	@Id
	private int id;
	private String nombre;
	private String compania;
	private double notaMedia;
	private String creador;
	private String link;
	
	public Videojuego() {
		
	}
	public Videojuego(int id, String nombre, String compania, double notaMedia, String creador, String link) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.compania = compania;
		this.notaMedia = notaMedia;
		this.creador = creador;
		this.link = link;
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
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	@Override
	public String toString() {
		return "Videojuego [id=" + id + ", nombre=" + nombre + ", compania=" + compania + ", notaMedia=" + notaMedia
				+  "]";
	}
}
