package entidades;

public class Avion extends Vehiculo{
	
	public Avion(int id, int cv, String nombre) {
		super(id,cv,nombre);
	}
	
	@Override
	public int mover(int distancia) {
		System.out.println("Me muevo por aire.");
		return distancia + (getCv()*3);
	}

}
