import java.util.Scanner;

public class MainHiloPrimo {
	
	public static void main(String[] args) {
		
		int auxNum;
		Scanner sc = new Scanner(System.in);

		System.out.print("Introduzca el primer numero: ");
		auxNum = sc.nextInt();
		HiloPrimos hilo1 = new HiloPrimos(auxNum);
		Thread t1 = new Thread(hilo1.r1);
		t1.setName("Hilo 1");
		
		System.out.print("Introduzca el segundo numero: ");
		auxNum = sc.nextInt();
		HiloPrimos hilo2 = new HiloPrimos(auxNum);
		Thread t2 = new Thread(hilo2.r1);
		t2.setName("Hilo 2");
		
		System.out.print("Introduzca el tercer numero: ");
		auxNum = sc.nextInt();
		HiloPrimos hilo3 = new HiloPrimos(auxNum);
		Thread t3 = new Thread(hilo3.r1);
		t3.setName("Hilo 3");
		
		t1.start();
		t2.start();
		t3.start();
		
		sc.close();
	}

}
