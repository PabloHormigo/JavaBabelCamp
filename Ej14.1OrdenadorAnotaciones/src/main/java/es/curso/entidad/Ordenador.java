package es.curso.entidad;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Component;

@Component
public class Ordenador {
	
	@Value("#{generarMarcaAleatoria.generarMarca()}")
	private String marca;
	
	@Autowired
	private ArrayList<Ram> listaRam;
	
	@Autowired
	private Procesador procesador;
	
	@Autowired
	private ArrayList<TarjetaGrafica> listaTarjetasGraficas;
	
	@Autowired
	private ArrayList<Periferico> listaPerifericos;
	
	@Autowired
	private PlacaBase placaBase;
	
	@Value("#{ordenador.calcularPrecioComponentes()}")
	private double precio;
	
	public String getMarca() {
		return marca;
	}
	
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public ArrayList<Ram> getListaRam() {
		return listaRam;
	}
	
	public void setListaRam(ArrayList<Ram> listaRam) {
		this.listaRam = listaRam;
	}
	
	public Procesador getProcesador() {
		return procesador;
	}
	
	public void setProcesador(Procesador procesador) {
		this.procesador = procesador;
	}
	
	public ArrayList<TarjetaGrafica> getListaTarjetasGraficas() {
		return listaTarjetasGraficas;
	}
	
	public void setListaTarjetasGraficas(ArrayList<TarjetaGrafica> listaTarjetasGraficas) {
		this.listaTarjetasGraficas = listaTarjetasGraficas;
	}
	
	public ArrayList<Periferico> getListaPerifericos() {
		return listaPerifericos;
	}
	
	public void setListaPerifericos(ArrayList<Periferico> listaPerifericos) {
		this.listaPerifericos = listaPerifericos;
	}
	
	public PlacaBase getPlacaBase() {
		return placaBase;
	}
	
	public void setPlacaBase(PlacaBase placaBase) {
		this.placaBase = placaBase;
	}
	
	public double getPrecio() {
		return precio;
	}
	
	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Ordenador [precio=" + precio + ", marca=" + marca + ", listaRam=" + listaRam + ", procesador="
				+ procesador + ", listaTarjetaGraficas=" + listaTarjetasGraficas + ", listaPerifericos="
				+ listaPerifericos + ", placaBase=" + placaBase + "]";
	}
	
	public double calcularPrecioComponentes() {
		double total = 0;
		
		for(int i=0;i<listaRam.size();i++) {
			total+=listaRam.get(i).getPrecio();
		}
		
		for(int i=0;i<listaTarjetasGraficas.size();i++) {
			total+=listaTarjetasGraficas.get(i).getPrecio();
		}
		
		for(int i=0;i<listaPerifericos.size();i++) {
			total+=listaPerifericos.get(i).getPrecio();
		}
		
		total+=procesador.getPrecio();
		total+=placaBase.getPrecio();
		
		return total;
	}
	
	

}
