package es.curso.util;

import org.springframework.stereotype.Component;

@Component(value="generarMarcaAleatoria")
public class MarcaAleatoria {
	
	public String generarMarca() {
		
		NumeroAleatorio num = new NumeroAleatorio();
		String marcas[] = {"Intel","MSI", "Logitech","Gigabyte","Tempest","HP"};

		return marcas[num.generarNumero(0, marcas.length)];
		
	}

}
