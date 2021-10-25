package es.curso.modelo.persistencia;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import es.curso.modelo.entidades.Cliente;

@Repository
public class DaoClienteJdbcTemplate implements DaoCliente{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private DaoClienteRowMapper daoClienteRowMapper;
	
	public void crearTablaClientes() {
		jdbcTemplate.execute("CREATE TABLE clientes (" + 
				"id int NOT NULL AUTO_INCREMENT," + 
				"nombre varchar(40)," + 
				"edad int," + 
				"PRIMARY KEY (id)"+
				"); ");
	}
	
	public int insertar(Cliente c) {
		String query = "insert into clientes (ID,NOMBRE,EDAD) value(?,?,?)";
		
		int id = jdbcTemplate.update(query,
				c.getId(),
				c.getNombre(),
				c.getEdad());
		
		return id;
	}

	public int modificar(Cliente c) {
		String query = "update clientes set NOMBRE=?, EDAD=? where id=?";
		
		int id = jdbcTemplate.update(query,
				c.getNombre(),
				c.getEdad(),
				c.getId());
		
		return id;
	}

	public int borrar(int id) {
		String query = "delete from clientes where id=?";
		
		return jdbcTemplate.update(query,id);
	}

	public Cliente buscarId(int id) {
		String query = "select * from clientes where id=?";
		Cliente cliente = null;
		
		try {
			cliente = jdbcTemplate.queryForObject(query, daoClienteRowMapper, id);
		}catch(EmptyResultDataAccessException e) {
			System.out.println("EmptyResultDataAccessException: " + e.getMessage());
		}
		
		return cliente;
	}

	public Cliente buscarNombre(String nombre) {
		String query = "select * from clientes where nombre=?";
		Cliente cliente = null;
		
		try {
			cliente = jdbcTemplate.queryForObject(query, daoClienteRowMapper, nombre);
		}catch(EmptyResultDataAccessException e) {
			System.out.println("EmptyResultDataAccessException: " + e.getMessage());
		}
		
		return cliente;
	}

	public List<Cliente> listar() {
		String query = "select * from clientes";
		
		return jdbcTemplate.query(query, daoClienteRowMapper);
	}
	

}
