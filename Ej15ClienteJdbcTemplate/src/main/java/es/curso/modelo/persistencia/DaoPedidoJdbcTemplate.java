package es.curso.modelo.persistencia;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import es.curso.modelo.entidades.Pedido;

@Repository
public class DaoPedidoJdbcTemplate implements DaoPedido{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private DaoPedidoRowMapper daoPedidoRowMapper;
	
	public void crearTablaPedidos() {
		jdbcTemplate.execute("CREATE TABLE pedidos (" + 
				"id int NOT NULL," + 
				"importe double," + 
				"fecha date" + 
				"); ");
	}
	
	public int insertar(Pedido p) {
		String query = "insert into pedidos (ID,IMPORTE,FECHA) values(?,?,?)";
		
		int id = jdbcTemplate.update(query,
				p.getId(),
				p.getImporte(),
				p.getFecha()
			);
		
		return id;
	}
	
	public List<Pedido> pedidosCliente(int id){
		String query = "select * from pedidos where id="+id;
		
		return jdbcTemplate.query(query,daoPedidoRowMapper);
	}

}
