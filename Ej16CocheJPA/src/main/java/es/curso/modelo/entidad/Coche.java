package es.curso.modelo.entidad;

import javax.persistence.*;

import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Entity
@Table(name="coches")
public class Coche {
	
	@Id
	private String matricula;
	private String marca;
	private String modelo;
	private double km;
	
	public Coche() {
		
	}
	
	public Coche(String matricula, String marca, String modelo, double km) {
		this.matricula = matricula;
		this.marca = marca;
		this.modelo = modelo;
		this.km = km;
	}
	
	public String getMatricula() {
		return matricula;
	}
	
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	public String getMarca() {
		return marca;
	}
	
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public String getModelo() {
		return modelo;
	}
	
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public double getKm() {
		return km;
	}
	public void setKm(double km) {
		this.km = km;
	}
	
	@Override
	public String toString() {
		return "Coche [matricula=" + matricula + ", marca=" + marca + ", modelo=" + modelo + ", km=" + km + "]";
	} 
	
}
