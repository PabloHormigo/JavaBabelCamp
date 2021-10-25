package es.curso.main;

import java.util.Date;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import es.curso.config.Configuracion;
import es.curso.modelo.entidades.Cliente;
import es.curso.modelo.entidades.Pedido;
import es.curso.negocio.GestorCliente;
import es.curso.negocio.GestorPedido;

public class MainJdbcTemplate {
	
	private static ApplicationContext context;

	public static void main(String[] args) {
		
		context = new AnnotationConfigApplicationContext(Configuracion.class);
		GestorPedido gp = context.getBean("gestorPedido",GestorPedido.class);
		GestorCliente gc = context.getBean("gestorCliente",GestorCliente.class);
		Pedido p = context.getBean("pedido",Pedido.class);
		Cliente c = context.getBean("cliente",Cliente.class);

		Scanner sc = new Scanner(System.in);
		int opcion = 0;
		
		do {	
			System.out.println("******* Bienvenido *******");
			System.out.println("\t1. Alta cliente");
			System.out.println("\t2. Borrar cliente");
			System.out.println("\t3. Modificar cliente");
			System.out.println("\t4. Buscar cliente por nombre");
			System.out.println("\t5. Buscar cliente por ID");
			System.out.println("\t6. Aniadir pedido a cliente por ID");
			System.out.println("\t7. Listar pedidos de cliente por ID");
			System.out.println("\t--Que opcion desea?");
			opcion = sc.nextInt();
	
			switch(opcion) {
			case 1:
				altaCliente(gc,c,sc);
				break;
				
			case 2:
				borrarCliente(gc,sc);
				break;
				
			case 3:
				modificarCliente(gc, sc);
				break;
				
			case 4:
				buscarClienteNombre(gc, sc);
				break;
				
			case 5:
				buscarClienteId(gc, sc);
				break;
				
			case 6:
				altaPedido(gc, gp, p, c, sc);
				break;
				
			case 7:
				listarPedidos(gc, gp, sc);
				break;
			}
			
		}while(opcion>0 && opcion<8);
		
	}
	
	public static void altaCliente(GestorCliente gc, Cliente c, Scanner sc) {
		String nombre = "";
		int edad = 0;
		
		System.out.println("\t*** Alta cliente ***");
		System.out.println("\tIntroduzca su nombre: ");
		nombre= sc.next();
		
		System.out.println("\tIntroduzca su edad");
		edad = sc.nextInt();
		
		c.setNombre(nombre);
		c.setEdad(edad);
		
		gc.insertar(c);
		
	}
	
	public static void borrarCliente(GestorCliente gc, Scanner sc) {
		int id = 0;
		
		System.out.println("\t*** Borrar cliente ***");
		System.out.println("\tIntroduzca el cliente que desea borrar: ");
		id=sc.nextInt();
		
		gc.borrar(id);
	}
	
	public static void modificarCliente(GestorCliente gc, Scanner sc) {
		String nombre = "";
		int edad = 0;
		int clienteId = 0;
		Cliente c = null;
		
		System.out.println("\t*** Modificar cliente ***");
		System.out.println("\tIntroduzca el cliente que va a modificar: ");
		clienteId = sc.nextInt();
		System.out.println("\tIntroduzca el nuevo nombre: ");
		nombre = sc.next();
		System.out.println("\tIntroduzca la nueva edad: ");
		edad = sc.nextInt();
			
		c = gc.buscarId(clienteId);
		c.setNombre(nombre);
		c.setEdad(edad);
		gc.modificar(c);
	}
	
	public static void buscarClienteNombre(GestorCliente gc, Scanner sc) {
		String nombre = "";
		Cliente c;
		
		System.out.println("\t*** Buscar cliente por nombre ***");
		System.out.println("\tIntroduzca el nombre que desea buscar: ");
		nombre = sc.next();
		
		c = gc.buscarNombre(nombre);
		System.out.println(c.toString());
	}
	
	public static void buscarClienteId(GestorCliente gc, Scanner sc) {
		int id = 0;
		Cliente c = null;
		
		System.out.println("\t*** Buscar cliente por ID ***");
		System.out.println("\tIntroduzca el ID que desea buscar: ");
		id = sc.nextInt();
		
		c = gc.buscarId(id);
		System.out.println(c.toString());
	}

	public static void altaPedido(GestorCliente gc, GestorPedido gp, Pedido p, Cliente c, Scanner sc) {
		int id = 0;
		double precio = 0;
		
		System.out.println("\t*** Anadir pedido a un cliente ***");
		System.out.println("\tA que cliente quiere anadirle un pedido? ");
		System.out.println(gc.listar());
		id = sc.nextInt();
		
		p.setId(id);
		c = gc.buscarId(id);
		
		System.out.println("\tCuanto ha costado el pedido? ");
		precio = sc.nextDouble();
		p.setImporte(precio);
		p.setFecha(new Date());
		
		gp.insertar(p);
	}
	
	public static void listarPedidos(GestorCliente gc, GestorPedido gp, Scanner sc) {
		int id = 0;
		
		System.out.println("\t*** Listar pedidos cliente ***");
		System.out.println("\tLos pedidos de que cliente quiere ver? ");
		System.out.println(gc.listar());
		id = sc.nextInt();
		
		System.out.println(gp.listar(id));
	}
}
