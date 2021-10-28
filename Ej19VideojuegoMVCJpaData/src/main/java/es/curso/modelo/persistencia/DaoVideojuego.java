package es.curso.modelo.persistencia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.*;

import es.curso.modelo.entidad.*;

@Repository
public interface DaoVideojuego extends JpaRepository<Videojuego,Integer>{
	/*
	public List<Videojuego> listar(){
		List<Videojuego> listaVideojuegos = new ArrayList<Videojuego>();
		Videojuego v = new Videojuego();
		
		//Primer juego
		v.setId(1);
		v.setNombre("The Last of Us Parte II");
		v.setCompania("Naughty Dog");
		v.setNotaMedia(9);
		v.setCreador("Neil Druckmann");
		v.setEnlace("https://www.playstation.com/es-es/games/the-last-of-us-part-ii/");
		listaVideojuegos.add(v);
		
		//Segundo juego
		v = new Videojuego();
		v.setId(2);
		v.setNombre("Red Dead Redemption II");
		v.setCompania("Rockstar");
		v.setNotaMedia(9.5);
		v.setCreador("Steve Martin");
		v.setEnlace("https://www.playstation.com/es-es/games/red-dead-redemption-2/");
		listaVideojuegos.add(v);
		
		//Tercer juego
		v = new Videojuego();
		v.setId(3);
		v.setNombre("Bloodborne");
		v.setCompania("From Software");
		v.setNotaMedia(10);
		v.setCreador("Hidetaka Miyazaki");
		v.setEnlace("https://www.playstation.com/es-es/games/bloodborne/");
		listaVideojuegos.add(v);
	
		return listaVideojuegos;
	}
	
	public Videojuego obtener(int id) {
		List<Videojuego> listaVideojuegos = listar();
		Videojuego vAux = null;
		
		for(Videojuego v : listaVideojuegos) {
			if(v.getId() == id) {
				vAux = new Videojuego();
				vAux.setId(id);
				vAux.setNombre(v.getNombre());
				vAux.setCompania(v.getCompania());
				vAux.setNotaMedia(v.getNotaMedia());
				vAux.setCreador(v.getCreador());
				vAux.setEnlace(v.getEnlace());
			}
		}
		
		return vAux;
	}
*/
}
