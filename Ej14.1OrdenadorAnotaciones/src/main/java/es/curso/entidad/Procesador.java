package es.curso.entidad;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

@Component
public class Procesador {
	
	@Value("#{generarNumeroAleatorio.generarNumero(500,24)}")
	private double precio;
	
	@Value("3700")
	private double hz;
	
	@Value("#{generarMarcaAleatoria.generarMarca()}")
	private String marca;
	
	@Autowired
	private TarjetaGrafica tarjetaGraficaIntegrada;
	
	public double getPrecio() {
		return precio;
	}
	
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public double getHz() {
		return hz;
	}
	
	public void setHz(double hz) {
		this.hz = hz;
	}
	
	public String getMarca() {
		return marca;
	}
	
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public TarjetaGrafica getTarjetaGraficaIntegrada() {
		return tarjetaGraficaIntegrada;
	}
	
	public void setTarjetaGraficaIntegrada(TarjetaGrafica tarjetaIntegrada) {
		this.tarjetaGraficaIntegrada = tarjetaIntegrada;
	}

	@Override
	public String toString() {
		return "Procesador [precio=" + precio + ", hz=" + hz + ", marca=" + marca + ", tarjetaIntegrada="
				+ tarjetaGraficaIntegrada + "]";
	}
	

}
