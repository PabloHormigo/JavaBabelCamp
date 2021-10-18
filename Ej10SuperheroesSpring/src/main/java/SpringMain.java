import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {

	public static ApplicationContext context = null;
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		int opcion=0;
			
		do {
			System.out.println("*** Menu de superheroes ***");
			System.out.println("\t1. Acceder a los 3 Superheroes de Spring.");
			System.out.println("\t2. Add Superheroe con potencia 100 a su lista.");
			System.out.println("\t3. Add Superheroe que pueda volar a su lista.");
			System.out.println("\t4. Listar Superheroes con potencia 100.");
			System.out.println("\t5. Listar Superheroes que puedan volar.");
			System.out.print("\tQue opcion desea? ");
			opcion = sc.nextInt();
			
			switch (opcion) {
			case 1:
				mostrarSuperheroesSpring();
				break;
				
			case 2:
				aniadirSuperheroePotencia();
				break;
				
			case 3:
				aniadirSuperheroeVolar();
				break;
				
			case 4:
				listarPotencia();
				break;
				
			case 5: 
				listarPoder();
				break;

			}
		}while(opcion>0 && opcion<6);
		
		System.out.println("***Adios!***");
		sc.close();

	}
	
	/**
	 * Con este metodo vamos a mostrar todos los superheroes que estan fijos en el archivo XML
	 */
	public static void mostrarSuperheroesSpring() {
		
		Superheroe homelander = context.getBean("super1",Superheroe.class);
		Superheroe maeve = context.getBean("super2",Superheroe.class);
		Superheroe starlight = context.getBean("super3",Superheroe.class);
		
		System.out.println("\n---Superheroes creados fijos en Spring: ");
		System.out.println("\t"+homelander);
		System.out.println("\t"+maeve);
		System.out.println("\t"+starlight+"\n");
	}
	
	/**
	 * Con este metodo vamos a añadir un nuevo superheroe con una potencia fijada en 100.
	 * Le pedimos al usuario el resto de datos y se añadira a su lista correspondiente.
	 */
	public static void aniadirSuperheroePotencia() {
		
		Superheroe s = context.getBean("super1Prototype",Superheroe.class);
		List<Superheroe> listaPoder = context.getBean("listaPoder",List.class);
		
		System.out.println("\n---Aniadir superheroe con potencia 100: ");
		
		System.out.print("\tIntroduzca el ID: ");
		s.setId(sc.nextInt());
		
		//Limpiamos el teclado ya que produce que el nombre se lo salte
		sc.nextLine();
		
		System.out.print("\tIntroduzca el nombre: ");
		s.setNombre(sc.nextLine());
		
		System.out.print("\tIntroduzca el super nombre: ");
		s.setSuperNombre(sc.nextLine());
		
		System.out.print("\tIntroduzca el super poder: ");
		s.setSuperPoder(sc.nextLine());
		
		System.out.println();
		
		listaPoder.add(s);
		
	}
	
	/**
	 * Con este metodo vamos a añadir un nuevo superheroe con un super poder fijado como Volar.
	 * Le pedimos al usuario el resto de los datos y lo añadimos a la lista correspondiente.
	 */
	public static void aniadirSuperheroeVolar() {
		
		Superheroe s = context.getBean("super2Prototype",Superheroe.class);
		List<Superheroe> listaSuperPoder = context.getBean("listaSuperPoder",List.class);
		
		System.out.println("\n---Aniadir superheroe con el super poder de Volar: ");
		System.out.print("\tIntroduzca el ID: ");
		s.setId(sc.nextInt());
		
		System.out.print("\tIntroduzca el nombre: ");
		s.setNombre(sc.next());
		
		
		System.out.print("\tIntroduzca el super nombre: ");
		s.setSuperNombre(sc.next());
		
		//Limpiamos el teclado ya que produce que la potencia se lo salte
		sc.nextLine();
		
		System.out.print("\tIntroduzca la potencia: ");
		s.setPoder(sc.nextInt());
		
		listaSuperPoder.add(s);
		System.out.println();
	}
	
	/**
	 * Accedemos a la lista con los superheroes con potencia 100, para ello nos traemos la lista del archivo XML.
	 */
	public static void listarPotencia() {
		List<Superheroe> listaPoder = context.getBean("listaPoder",List.class);
		
		System.out.println("\n---Superheroes con potencia 100: ");
		for(Superheroe s : listaPoder) {
			System.out.println("\t"+s);
		}
		System.out.println();
	}
	
	/**
	 * Accedemos a la lista con los superheroes con el super poder de Volar, para ello nos traemos la lista del archivo XML
	 */
	public static void listarPoder() {
		List<Superheroe> listaSuperPoder = context.getBean("listaSuperPoder",List.class);
		
		System.out.println("\n---Superheroes con el poder de Volar: ");
		for(Superheroe s : listaSuperPoder) {
			System.out.println("\t"+s);
		}
		System.out.println();
	}

}
