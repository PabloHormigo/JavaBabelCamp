package es.curso.modelo.persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import es.curso.modelo.entidades.Cliente;

@Component
public class DaoClienteRowMapper implements RowMapper<Cliente>{
	
	public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException{
		Cliente c = new Cliente();
		
		c.setId(rs.getInt("ID"));
		c.setNombre(rs.getString("NOMBRE"));
		c.setEdad(rs.getInt("EDAD"));
				
		return c;
	}
	

}
