package main;

import java.util.*;

import entidades.*;

public class Main {

	public static void main(String[] args) {
		
		Moto moto = new Moto(1,256,"Moto1");
		Coche coche = new Coche(2,110,"Coche1");
		Barco barco = new Barco(3,1000,"Barco1");
		Avion avion = new Avion(4,1200,"Avion1");
		
		List<Vehiculo> listaVehiculos = new ArrayList<Vehiculo>();
		listaVehiculos.add(moto);
		listaVehiculos.add(coche);
		listaVehiculos.add(barco);
		listaVehiculos.add(avion);
		
		moverVehiculos(listaVehiculos);
	}
	
	public static void moverVehiculos(List<Vehiculo> listaVehiculos) {
		for(int i=0;i<listaVehiculos.size();i++) {
			System.out.println("\tSoy "+listaVehiculos.get(i).getNombre()+
					" y me he movido "+listaVehiculos.get(i).mover(100)+" metros\n");
		}
	}

}
