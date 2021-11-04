package es.curso.modelo.persistencia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.*;

import es.curso.modelo.entidad.*;

@Repository
public interface DaoVideojuego extends JpaRepository<Videojuego,Integer>{
	
	
}
