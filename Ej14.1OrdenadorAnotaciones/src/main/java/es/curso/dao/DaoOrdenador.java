package es.curso.dao;

import java.io.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Component;

import es.curso.entidad.Ordenador;

@Component
public class DaoOrdenador {
	
	@Autowired
	private Ordenador ordenador;

	public Ordenador getOrdenador() {
		return ordenador;
	}

	public void setOrdenador(Ordenador ordenador) {
		this.ordenador = ordenador;
	}
	
	public void generarFichero() {
		try(FileWriter fw = new FileWriter("ordenadores.txt",true);
				BufferedWriter pw = new BufferedWriter(fw);) {
			
			pw.write(ordenador.toString());
			pw.newLine();
			pw.flush();
			System.out.println("El precio del ordenador es de "+String.format("%.2f", ordenador.calcularPrecioComponentes())+" €");
			System.out.println("El ordenador se ha añadido con exito al fichero!");
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	

}
