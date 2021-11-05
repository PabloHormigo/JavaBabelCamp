package es.curso.persistencia;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import es.curso.entidad.Videojuego;


@Repository
public interface DaoVideojuego extends MongoRepository<Videojuego,Integer>{
	
	public List<Videojuego> findByNombreOrCompania(String nombre, String compania);
}
