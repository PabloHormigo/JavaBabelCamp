package es.curso.entidad;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component(value="placaBase")
public class PlacaBase {
	
	@Value("#{generarNumeroAleatorio.generarNumero(500,24)}")
	private double precio;
	
	@Value("#{generarMarcaAleatoria.generarMarca()}")
	private String marca;
	
	@Value("X4070")
	private String modelo;
	
	public double getPrecio() {
		return precio;
	}
	
	public void setPrecio(double precio) {
		this.precio = precio;
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

	@Override
	public String toString() {
		return "PlacaBase [precio=" + precio + ", marca=" + marca + ", modelo=" + modelo + "]";
	}
	
	

}
