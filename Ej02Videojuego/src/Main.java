import PJ.*;
import Weapons.*;

public class Main {

	public static void main(String[] args) {

		Personaje p1 = generarPersonaje();
		configurarPersonaje(p1,1);

		Personaje p2 = generarPersonaje();
		configurarPersonaje(p2,2);

		System.out.println("\n***Ptos de vida iniciales Jugador 1: " + p1.getPuntosVida());
		System.out.println("***Ptos de vida iniciales Jugador 2: " + p2.getPuntosVida()+"\n");

		pelear(p1,p2);
		
	}
	
	public static Personaje generarPersonaje() {
		int aux = 0;
		Curandero curandero = new Curandero();
		Guerrero guerrero = new Guerrero();
		Mago mago = new Mago();
		Personaje[] tipoPersonajes = {curandero, guerrero, mago};
		aux = (int)Math.floor(Math.random()*3);
		
		return tipoPersonajes[aux];
	}
	
	public static Arma generarArma() {
		int aux = 0;
		Arco arco = new Arco();
		Espada espada = new Espada();
		Hechizo hechizo = new Hechizo();
		Rezo rezo = new Rezo();
		Arma[] tipoArmas = { arco, espada, hechizo, rezo };
		aux = (int) Math.floor(Math.random() * 4);

		return tipoArmas[aux];
	}
	
	public static void configurarPersonaje(Personaje p, int numero) {
		p.setNombre("Jugador "+numero);
		if(p instanceof Guerrero) {
			p.setAtributo("Fuerza");
		}
		if(p instanceof Curandero) {
			p.setAtributo("Sabiduria");
		}
		if(p instanceof Mago) {
			p.setAtributo("Inteligencia");
		}
		
		p.setArma(generarArma());
		if(p.getArma() instanceof Arco) {
			p.getArma().setTipo("Arco");
		}
		if(p.getArma() instanceof Espada) {
			p.getArma().setTipo("Espada");
		}
		if(p.getArma() instanceof Hechizo) {
			p.getArma().setTipo("Hechizo");
		}
		if(p.getArma() instanceof Rezo) {
			p.getArma().setTipo("Rezo");
		}
		
		p.setPuntosVida(generarVida());
		
		System.out.println("El "+p.getNombre()+ " posee el atributo de la "+p.getAtributo()
				+ ", atacará mediante un "+p.getArma().getTipo());
		p.getArma().setDanio(generarDanio(p, p.getArma()));
	}
	
	public static int generarVida() {
		return (int) Math.floor(Math.random() * 50 + 50);
	}

	public static int generarDanio(Personaje p, Arma a) {
		int danio = 0;

		if (p instanceof Guerrero && p.getArma() instanceof Espada) {
			System.out.println("Daño adicional de arma adquirido para el "+p.getNombre()+"!\n");
			danio = (int) Math.floor(Math.random() * 10 + 10) + 10;
		} else if (p instanceof Guerrero && p.getArma() instanceof Arco) {
			System.out.println("Daño adicional de arma adquirido para el "+p.getNombre()+"!\n");
			danio = (int) Math.floor(Math.random() * 10 + 10) + 10;
		} else if (p instanceof Mago && p.getArma() instanceof Hechizo) {
			System.out.println("Daño adicional de arma adquirido para el "+p.getNombre()+"!\n");
			danio = (int) Math.floor(Math.random() * 10 + 10) + 10;
		} else if (p instanceof Curandero && p.getArma() instanceof Rezo) {
			danio = (int) Math.floor(Math.random() * 10 + 10) + 10;
			System.out.println("Daño adicional de arma adquirido para el "+p.getNombre()+"!\n");
		} else {
			danio = (int) Math.floor(Math.random() * 10 + 10);
		}

		return danio;
	}
	
	public static void pelear(Personaje p1, Personaje p2) {
		while (p1.getPuntosVida() > 0 && p2.getPuntosVida() > 0) {
			if (p2.getPuntosVida() > 0 && p2.getPuntosVida() > 0) {
				p1.atacar(p1, p2);
				if (p2.getPuntosVida() <= 0) {
					System.out.println("JUGADOR 2 HA MUERTO!");
				} else {
					System.out.println("---Ptos de vida restantes Jugador 2: " + p2.getPuntosVida()+"\n");
				}
			}
			if (p1.getPuntosVida() > 0 && p2.getPuntosVida() > 0) {
				p2.atacar(p2, p1);
				if (p1.getPuntosVida() <= 0) {
					System.out.println("JUGADOR 1 HA MUERTO!");
				} else {
					System.out.println("---Ptos de vida restantes Jugador 1: " + p1.getPuntosVida()+"\n");
				}
			}
		}
	}

}
