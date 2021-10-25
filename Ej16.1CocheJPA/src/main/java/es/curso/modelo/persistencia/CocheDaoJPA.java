package es.curso.modelo.persistencia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import es.curso.modelo.entidad.Coche;

@Repository
public class CocheDaoJPA implements CocheDao{
	
	@PersistenceContext
	private EntityManager em;
	
	public String insertar(Coche c) {
		em.persist(c);
		return c.getMatricula();
	}
	
	public Coche modificar(Coche c) {
		return em.merge(c);
	}
	
	public Coche buscar(String matricula) {
		return em.find(Coche.class, matricula);
	}
	
	public String borrar(String matricula) {
		Coche cAux = em.find(Coche.class, matricula);
		em.remove(cAux);
		return cAux.getMatricula();
	}
	
	@SuppressWarnings("unchecked")
	public List<Coche> listar(){
		List<Coche> listaCoches = em.createQuery("from Coche c").getResultList();
		return listaCoches;
	}

}
