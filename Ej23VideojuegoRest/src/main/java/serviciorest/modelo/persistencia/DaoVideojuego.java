package serviciorest.modelo.persistencia;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.*;

import serviciorest.modelo.entidad.*;

@Repository
public interface DaoVideojuego extends JpaRepository<Videojuego,Integer>{
	
	public List<Videojuego> findByNombreOrCompania(String nombre, String compania);
}
