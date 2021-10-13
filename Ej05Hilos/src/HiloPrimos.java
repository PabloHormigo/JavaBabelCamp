public class HiloPrimos extends Thread{
	
	private int auxNum;
	
	public HiloPrimos(int auxNum) {
		this.auxNum = auxNum;
	}

	@Override
	public void run() {
		
		System.out.println("Arrancando hilo: "+Thread.currentThread().getName());
		
		if(esPrimo(auxNum)) {
			System.out.println("El "+Thread.currentThread().getName()+" ha calculado que el numero "+auxNum+" es primo");
		}
		else {
			System.out.println("El "+Thread.currentThread().getName()+" ha calculado que el numero "+auxNum+" NO es primo");
		}
		
	}
	
	public static boolean esPrimo(int numero){
		  int contador = 2;
		  boolean primo=true;
		  while ((primo) && (contador!=numero)){
		    if (numero % contador == 0)
		      primo = false;
		    contador++;
		  }
		  return primo;
		}
}
