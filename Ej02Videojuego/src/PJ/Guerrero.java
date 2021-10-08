package PJ;

public class Guerrero extends Personaje{
	
	public void atacar(Personaje p1,Personaje p2) {
		
		int ataque = 0;
		
		System.out.println("Arggggg soy "+getNombre()+"!");
		ataque = p2.getPuntosVida() - p1.getArma().usar();
		p2.setPuntosVida(ataque);
		
	}
}
