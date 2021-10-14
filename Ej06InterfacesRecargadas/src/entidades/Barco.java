package entidades;

public class Barco extends Vehiculo{
	
	public Barco(int id, int cv, String nombre) {
		super(id,cv,nombre);
	}
	
	@Override
	public int mover(int distancia) {
		System.out.println("Me muevo por agua.");
		return distancia + (getCv()*2);
	}
}
