package es.curso.persistencia;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.curso.entidad.Usuario;

@Repository
public interface DaoUsuario extends JpaRepository<Usuario,String> {
	//Automáticamente reconoce el método
	public Optional<Usuario> findByUsuario(String usuario);

}
