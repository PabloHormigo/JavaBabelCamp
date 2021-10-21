package es.curso.cfg;

import java.util.*;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;

import es.curso.dao.DaoOrdenador;
import es.curso.entidad.*;
import es.curso.util.*;

@Configuration
public class ConfiguracionSpring {
	
	@Bean
	public NumeroAleatorio numeroAleatorio() {
		NumeroAleatorio numeroAleatorio = new NumeroAleatorio();
		return numeroAleatorio;
	}
	
	@Bean
	public MarcaAleatoria marcaAleatoria() {
		MarcaAleatoria marcaAleatoria = new MarcaAleatoria();
		return marcaAleatoria;
	}
	
	@Bean
	public Ram ram1() {
		Ram ram = new Ram();
		
		ram.setPrecio(numeroAleatorio().generarNumero(500, 24));
		ram.setHz(3200);
		ram.setGeneracion("4º generacion");
		
		return ram;
	}
	
	@Bean
	public Ram ram2() {
		Ram ram = new Ram();
		
		ram.setPrecio(numeroAleatorio().generarNumero(500, 24));
		ram.setHz(4000);
		ram.setGeneracion("4º generacion");
		
		return ram;
	}
	
	@Bean
	public Ram ramGraficaIntegrada() {
		Ram ram = new Ram();
		
		ram.setPrecio(numeroAleatorio().generarNumero(500, 24));
		ram.setHz(3200);
		ram.setGeneracion("4º generacion");
		
		return ram;
	}
	
	@Bean
	public Ram ramGrafica() {
		Ram ram = new Ram();
		
		ram.setPrecio(numeroAleatorio().generarNumero(500, 24));
		ram.setHz(4000);
		ram.setGeneracion("4º generacion");
		
		return ram;
	}

	@Bean
	public ArrayList<Ram> listaRam(){
		ArrayList<Ram> listaRam = new ArrayList<Ram>();
		listaRam.add(ram1());
		listaRam.add(ram2());
		
		return listaRam;
	}
	
	@Bean
	public TarjetaGrafica tarjetaGraficaIntegrada() {
		TarjetaGrafica tarjetaGraficaIntegrada = new TarjetaGrafica();
		
		tarjetaGraficaIntegrada.setPrecio(numeroAleatorio().generarNumero(500,24));
		tarjetaGraficaIntegrada.setMarca(marcaAleatoria().generarMarca());
		tarjetaGraficaIntegrada.setModelo("HD620");
		tarjetaGraficaIntegrada.setRam(ramGraficaIntegrada());
		
		return tarjetaGraficaIntegrada;
	}
	
	@Bean
	public TarjetaGrafica tarjetaGrafica1() {
		TarjetaGrafica tarjetaGrafica1 = new TarjetaGrafica();
		
		tarjetaGrafica1.setPrecio(numeroAleatorio().generarNumero(500,24));
		tarjetaGrafica1.setMarca(marcaAleatoria().generarMarca());
		tarjetaGrafica1.setModelo("GeForce RTX 3070");
		tarjetaGrafica1.setRam(ramGrafica());
		
		return tarjetaGrafica1;
	}
	
	@Bean
	public ArrayList<TarjetaGrafica> listaTarjetasGraficas(){
		ArrayList<TarjetaGrafica> listaTarjetasGraficas = new ArrayList<TarjetaGrafica>();
		
		listaTarjetasGraficas.add(tarjetaGraficaIntegrada());
		listaTarjetasGraficas.add(tarjetaGrafica1());
		
		return listaTarjetasGraficas;
	}
	
	@Bean
	public Procesador procesador() {
		Procesador procesador = new Procesador();
		
		procesador.setPrecio(numeroAleatorio().generarNumero(500, 24));
		procesador.setHz(3700);
		procesador.setMarca(marcaAleatoria().generarMarca());
		procesador.setTarjetaGraficaIntegrada(tarjetaGraficaIntegrada());
		
		return procesador;
	}
	
	@Bean
	public Periferico periferico1() {
		Periferico periferico1 = new Periferico();
		
		periferico1.setMarca(marcaAleatoria().generarMarca());
		periferico1.setPrecio(numeroAleatorio().generarNumero(500, 24));
		periferico1.setTipo(TipoPeriferico.RATON);
		
		return periferico1;
	}
	
	@Bean
	public Periferico periferico2() {
		Periferico periferico2 = new Periferico();
		
		periferico2.setMarca(marcaAleatoria().generarMarca());
		periferico2.setPrecio(numeroAleatorio().generarNumero(500, 24));
		periferico2.setTipo(TipoPeriferico.TECLADO);
		
		return periferico2;
	}
	
	@Bean
	public Periferico periferico3() {
		Periferico periferico3 = new Periferico();
		
		periferico3.setMarca(marcaAleatoria().generarMarca());
		periferico3.setPrecio(numeroAleatorio().generarNumero(500, 24));
		periferico3.setTipo(TipoPeriferico.MONITOR);
		
		return periferico3;
	}
	
	@Bean
	public ArrayList<Periferico> listaPerifericos(){
		ArrayList<Periferico> listaPerifericos = new ArrayList<Periferico>();
		
		listaPerifericos.add(periferico1());
		listaPerifericos.add(periferico2());
		listaPerifericos.add(periferico3());
		
		return listaPerifericos;
	}
	
	@Bean
	public PlacaBase placaBase() {
		PlacaBase placaBase = new PlacaBase();
		
		placaBase.setPrecio(numeroAleatorio().generarNumero(500,24));
		placaBase.setMarca(marcaAleatoria().generarMarca());
		placaBase.setModelo("X4070");
		
		return placaBase;
	}
	
	@Bean
	public Ordenador ordenador() {
		Ordenador ordenador = new Ordenador();
		
		ordenador.setMarca(marcaAleatoria().generarMarca());
		ordenador.setListaRam(listaRam());
		ordenador.setProcesador(procesador());
		ordenador.setListaTarjetasGraficas(listaTarjetasGraficas());
		ordenador.setListaPerifericos(listaPerifericos());
		ordenador.setPlacaBase(placaBase());
		ordenador.setPrecio(ordenador.calcularPrecioComponentes());
		
		return ordenador;
	}
	
	@Bean 
	public DaoOrdenador daoOrdenador(@Qualifier("ordenador") Ordenador ordenador) {
		DaoOrdenador daoOrdenador = new DaoOrdenador();
		
		daoOrdenador.setOrdenador(ordenador);
		
		return daoOrdenador;
	}
	
}
