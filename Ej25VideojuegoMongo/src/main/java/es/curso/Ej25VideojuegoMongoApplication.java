package es.curso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import es.curso.entidad.Videojuego;
import es.curso.negocio.GestorVideojuego;
import es.curso.persistencia.DaoVideojuego;

@SpringBootApplication
public class Ej25VideojuegoMongoApplication implements CommandLineRunner{
	
	@Autowired
	private GestorVideojuego gv;

	public static void main(String[] args) {
		SpringApplication.run(Ej25VideojuegoMongoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Videojuego v1 = new Videojuego();
		v1.setId(1);
		v1.setNombre("The Last of Us Parte II");
		v1.setCompania("Naughty Dog");
		v1.setNotaMedia(9);
		v1.setCreador("Neil Druckmann");
		v1.setEnlace("https://www.playstation.com/es-es/games/the-last-of-us-part-ii/");
		v1.setPrecio(20);
		gv.insertar(v1);
		
		v1.setId(2);
		v1.setNombre("Death Stranding");
		v1.setCompania("Kojima Productions");
		v1.setNotaMedia(8);
		v1.setCreador("Hideo Kojima");
		v1.setEnlace("https://www.playstation.com/es-es/games/death-stranding/");
		v1.setPrecio(20);
		gv.insertar(v1);
		
		System.out.println("**************************");
		System.out.println(gv.obtener(2));
		
		gv.borrar(2);
		
	}

}
