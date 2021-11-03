package es.curso.negocio;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.curso.entidad.Usuario;
import es.curso.persistencia.DaoUsuario;

@Service
public class GestorUsuario {
	@Autowired
	private DaoUsuario daoUsuario;
	
	@Transactional
	public String alta(Usuario u) {
		daoUsuario.save(u);
		return u.getUsuario();
	}
	
	@Transactional
	public String modificar(Usuario u) {
		daoUsuario.save(u);
		return u.getUsuario();
	}
	
	@Transactional
	public String baja(String id) {
		daoUsuario.deleteById(id);
		return id;
	}
	

	public Usuario obtener(String id){
		Usuario u = daoUsuario.findById(id).get();
		return u;
	}
	public boolean validar(String usuario, String contrasenia) {
		Optional <Usuario> uAux = daoUsuario.findByUsuario(usuario);
		return uAux.isPresent() ? true : false;
	}
}
