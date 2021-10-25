package es.curso.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.curso.modelo.entidades.Pedido;
import es.curso.modelo.persistencia.DaoPedido;

@Service
public class GestorPedido {
	
	@Autowired
	DaoPedido daoPedido;
	
	public int insertar(Pedido p) {
		if(p.getImporte() != 0) {
			return daoPedido.insertar(p);
		}
		else {
			return -1;
		}
	}
	
	public List<Pedido> listar(int id){
		return daoPedido.pedidosCliente(id);
	}
	
	

}
