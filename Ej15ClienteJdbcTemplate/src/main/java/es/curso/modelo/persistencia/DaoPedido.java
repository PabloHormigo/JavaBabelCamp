package es.curso.modelo.persistencia;

import java.util.List;

import es.curso.modelo.entidades.Pedido;

public interface DaoPedido {
	
	int insertar(Pedido p);
/*	int modificar(Pedido p);
	int borrar(int id);
	Pedido buscar(int id);
	List<Pedido> listar();
*/
	List<Pedido> pedidosCliente(int id);

}
