package interfaz;

public interface Movible {
	
	default int mover(int distancia) {
		System.out.println("Me muevo por tierra.");
		return distancia;
	}

}
