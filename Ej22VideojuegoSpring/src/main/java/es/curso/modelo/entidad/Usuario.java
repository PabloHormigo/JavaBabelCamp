package es.curso.modelo.entidad;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
@Entity
@Table(name="usuarios")
public class Usuario {
	
	@Id
	private String user;
	private String pwd;
	@Transient
	private List<Videojuego> carrito;
	
	public String getUser() {
		return user;
	}
	
	public void setUser(String user) {
		this.user = user;
	}
	
	public String getPwd() {
		return pwd;
	}
	
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	@Override
	public String toString() {
		return "Usuario [user=" + user + ", pwd=" + pwd + "]";
	}

	public List<Videojuego> getCarrito() {
		return carrito;
	}

	public void setCarrito(List<Videojuego> carrito) {
		this.carrito = carrito;
	}
	
	
}
