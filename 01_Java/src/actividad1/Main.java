package actividad1;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		//Ram
		ArrayList<Ram> listaRam = new ArrayList<Ram>();
		
		Ram ram1 = new Ram();
		ram1.setPrecio(113.05);
		ram1.setHz(3200);
		ram1.setGeneracion("4º generacion");
		listaRam.add(ram1);
		
		Ram ram2 = new Ram();
		ram2.setPrecio(149.98);
		ram2.setHz(4000);
		ram2.setGeneracion("4º generacion");
		listaRam.add(ram2);
		
		//Tarjeta grafica
		ArrayList<TarjetaGrafica> listaTarjetasGraficas = new ArrayList<TarjetaGrafica>();
		
		TarjetaGrafica tarjetaGraficaIntegrada = new TarjetaGrafica();
		tarjetaGraficaIntegrada.setMarca("Intel");
		tarjetaGraficaIntegrada.setModelo("HD620");
		tarjetaGraficaIntegrada.setRam(ram1);
		tarjetaGraficaIntegrada.setPrecio(100);
		
		TarjetaGrafica tarjetaGrafica1 = new TarjetaGrafica();
		tarjetaGrafica1.setMarca("MSI");
		tarjetaGrafica1.setModelo("GeForce RTX 3070");
		tarjetaGrafica1.setPrecio(999.90);
		tarjetaGrafica1.setRam(ram1);
		listaTarjetasGraficas.add(tarjetaGrafica1);
		
		
		//Procesador
		Procesador procesador = new Procesador();
		procesador.setHz(3700);
		procesador.setMarca("Intel");
		procesador.setPrecio(440.97);
		procesador.setTarjetaIntegrada(tarjetaGraficaIntegrada);
		
		//Perifericos
		ArrayList<Periferico> listaPerifericos = new ArrayList<Periferico>();
		
		Periferico periferico1 = new Periferico();
		periferico1.setMarca("Logitech");
		periferico1.setPrecio(24.99);
		periferico1.setTipo(TipoPeriferico.RATON.toString());
		listaPerifericos.add(periferico1);
		
		Periferico periferico2 = new Periferico();
		periferico2.setMarca("Tempest");
		periferico2.setPrecio(38.99);
		periferico2.setTipo(TipoPeriferico.TECLADO.toString());
		listaPerifericos.add(periferico2);
		
		Periferico periferico3 = new Periferico();
		periferico3.setMarca("Gigabyte");
		periferico3.setPrecio(399.99);
		periferico3.setTipo(TipoPeriferico.MONITOR.toString());
		listaPerifericos.add(periferico3);
		
		//PlacaBase
		PlacaBase placaBase = new PlacaBase();
		placaBase.setMarca("MSI");
		placaBase.setModelo("X470");
		placaBase.setPrecio(97.95);
		
		//Ordenador
		Ordenador ordenador1 = new Ordenador();
		ordenador1.setPlacaBase(placaBase);
		ordenador1.setProcesador(procesador);
		ordenador1.setListaTarjetaGraficas(listaTarjetasGraficas);
		ordenador1.setListaRam(listaRam);
		ordenador1.setListaPerifericos(listaPerifericos);
		ordenador1.setMarca("HP");
		ordenador1.setPrecio(1800);
		
		System.out.println("El precio de los componentes del ordenador es de "+String.format("%.2f", ordenador1.calcularPrecioComponentes())+" €");

	}

}
