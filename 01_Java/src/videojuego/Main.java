package videojuego;

public class Main {

	public static void main(String[] args) {
		Guerrero g1 = new Guerrero();
		g1.setNombre("Conan");
		Espada espada = new Espada();
		//inyeccion de dependencias
		g1.setArma(espada);
		g1.atacar();
		
		Guerrero g2 = new Guerrero();
		g2.setNombre("Legolas");
		Arco arco = new Arco();
		//inyeccion de dependencias
		g2.setArma(arco);
		g2.atacar();

	}

}
