import java.util.Scanner;

public class MainHiloPrimo {
	
	public static void main(String[] args) {
		
		int auxNum;
		Scanner sc = new Scanner(System.in);

		System.out.print("Introduzca el primer numero: ");
		auxNum = sc.nextInt();
		HiloPrimos hilo1 = new HiloPrimos(auxNum);
		hilo1.setName("Hilo 1");
		
		System.out.print("Introduzca el segundo numero: ");
		auxNum = sc.nextInt();
		HiloPrimos hilo2 = new HiloPrimos(auxNum);
		hilo2.setName("Hilo 2");
		
		System.out.print("Introduzca el tercer numero: ");
		auxNum = sc.nextInt();
		HiloPrimos hilo3 = new HiloPrimos(auxNum);
		hilo3.setName("Hilo 3");
		
		hilo1.start();
		hilo2.start();
		hilo3.start();
		
		sc.close();
	}

}
