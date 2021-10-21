package es.curso.util;

public class MarcaAleatoria {
	
	public String generarMarca() {
		
		NumeroAleatorio num = new NumeroAleatorio();
		String marcas[] = {"Intel","MSI", "Logitech","Gigabyte","Tempest","HP"};

		return marcas[num.generarNumero(0, marcas.length)];
		
	}

}
