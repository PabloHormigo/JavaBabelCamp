package basico;

public class Main {

	public static void main(String[] args) {
		System.out.println("Hola Mundo");
		
		//El ciclo de vida de un objeto en java es desde que se crea
		//y mientras tenga una referencia apuntandolo, ya que 
		//los objetos que no tienen referencia seran eliminados 
		//por el recolector de basura.      
		
	/*	int contador = 0;
		while(contador > -1) {
			//El ciclo de vida de una referencia es desde que se crea 
			//hasta el final del bloque en el que se ha definido
			//(el bloque es donde empieza con { y acaba con }
			Persona p1 = new Persona();
			System.out.println(++contador + " - "+p1.toString());
		} //muere p1
	*/
		System.out.println("Creando otro objeto...");
		Persona p1 = new Persona();
		p1.setNombre("Steve Rogers");
		p1.setEdad(45);
		
		Persona p2 = p1; //no he creado objeto
		p1.setEdad(55);
		System.out.println(p1.getEdad()); //55
		System.out.println(p2.getEdad()); //55
		
		int numero = 5;
		int numero2 = numero;
		
		numero2 = 10;
		System.out.println(numero); //5
		System.out.println(numero2); //10
	
		cambiarEdad(p1);
		System.out.println(p1.getEdad());
		
		int cp = 02345;
		int hex = 0x123ABDE;
		int oct = 0b101;
		
		Persona p3 = new Persona();
		p3.setNombre("Tony Stark");
		p3.setEdad(49);
		p3.setPeso(85.7);
		Direccion d1 = new Direccion();
		p3.setDireccion(d1);
		p3.getDireccion().setCiudad("New York");
		p3.getDireccion().setCp("09876");
		
		System.out.println(p3);
		
		p3.getDireccion().setCiudad("Roma");
		System.out.println(d1.getCiudad());
	}
	
	public static void cambiarEdad(Persona p) {
		p.setEdad(43);
	}//muere p

}
