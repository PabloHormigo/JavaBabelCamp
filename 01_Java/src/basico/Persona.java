package basico;

//Plantilla de objetos

//En java todo son clase y todo son objetos por lo que vamos a ver
//que dependiendo de lo que queramos implemenytar, las clases representaran
//una funcion dada en esa logica a implementar.

//En eset caso esta clase va a representar una entidad, que son clases 
//destinadas a trabajar con informacion
//Las clases de entidad en Java suelen llevar una estructura que se llama
//estructura de JavaBean
//Esta estructura nos dice que tenemos que tener :
//	1. Constructor por defecto
//	2. Atributos privados
//	3. Tener metodos accesores (getters) y modificadores (setters) publicos

//Esta estructura es un convenio que utilizan muchisimos frameworks
public class Persona {
	//En una clase podemos encontrar atributos y metodos
	
	//Los atributos representan las caracteristicas que tienen los objetos
	
	//El valor que tienen los atributos en un instante de tiempo dado se conoce 
	//como el estado de un objeto
	
	//Los atributps y metodos tienen una visibilidad 
	//private -> solo en la clase
	//(default) -> en la clase y en el paquete
	//protected -> en la clase, en el paquete y en las herencias
	//public -> en todo el programa
	
	//Como se inicializan los atributos por defecto de un objecto
	// 	1. si es una referencia el valor es "null"
	//	2. si es un primitivo, 0 en caso de valor numerico, false en caso booleano
	private String nombre;
	private int edad;
	private double peso;

	//Cuando una entidad responde a la pregunta "tiene un" estamos ante
	//una relacion de asociacion o composicion y se representa poniendo
	//un atributo de dicha clase
	private Direccion direccion;
	
	//Los metodos representan la funcionalidad de los objetos
	//Los metodos tienen lo que se conoce como una firma de metodo
	//que es lo que hace que un metodo sea unico dentro de una clase
	
	//La firma de un metodo se compone de:
	//1- El numero de parametros de entrada al metodo
	//2- El nombre del metodo
	//3- El tipo de parametros de entrada
	public void presentar() {
		System.out.println("Me llamo "+nombre);
	}
	
	//Java no permite dentro de la misma clase tener dos metodos con la misma firma
	/*public String presentar2() {
		System.out.println("Me llamo "+nombre);
		return null;
	}*/
	
	//Si cambiamos alguno de las tres cosas que componen la firma de un metodo
	//estamos ante una sobrecarga
	public void presentar2() {
		System.out.println("Me llamo "+nombre);
	}
	
	//Si hacemos un metodo en una clase padre y creamos un metodo con la misma 
	//firma estamos ante una sobreescritura
	
	//No hace falta poner el @Override para sobreescribir un metodo
	//La anotacion @Override es una anotacion que se ejecuta en tiempo de
	//compilacion, y lo que hace es asegurarnos de que estamos sobreescribiendo
	//el metodo de la clase padre y no nos hemos equivocado en la firma
	/*
	  @Override
	  	public String toString(){
	  		return "Persona [nombre=" +nombre +", edad= "+edad+ ", peso= "+peso+"]";
	  }
	 */

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

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", edad=" + edad + ", peso=" + peso + ", direccion=" + direccion + "]";
	}
	
	
}
