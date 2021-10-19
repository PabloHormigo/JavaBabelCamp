package ejemplo06;

public class Persona {
	private String nombre;
	private int edad;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	//el nombre es arbitrario
	//Este metodo se ejecuta justo despues de construir el objeto
	//y de gaber asignado sus propiedades
	//Si es singleton se ejecutara cuando se cree el contexto
	//Si es prototipado se ejecutara cuando se pida el objeto contexto
	public void inicializar() {
		System.out.println("Inicializando");
		//podemos hacer conexion bbdd
		this.nombre = "";
		this.edad = 0;
	}
	
	//el nombre es arbitrario
		//Este metodo se ejecuta justo despues de destruir el contexto de spring
		//pero solo funciona para objetos que son de scope singleton, para los prototipados
		//no funciona
	public void destruir() {
		System.out.println("Argggggggggggggg muero!");
	}
}
