package serviciorest.modelo.persistencia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import serviciorest.modelo.entidad.*;

@Repository
public interface DaoUsuario extends JpaRepository<Usuario,String>{

}
