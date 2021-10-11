package test;

import java.util.*;

import modelo.entidad.Coche;
import modelo.negocio.GestorCoche;

public class Test {

	public static void main(String[] args) {

		GestorCoche gestorCoche = new GestorCoche();
		Scanner sc = new Scanner(System.in);
		int opcion = 0;

		Coche coche = new Coche();
		String auxMatricula;
		String auxMarca;
		String auxModelo;
		double auxKM;

		List<Coche> auxListaCoches;

		System.out.println("***Bienvenido al gestor de coches!***");

		do {
			System.out.println("\nElija una de las siguientes opciones: ");
				System.out.println("\t1. Dar de alta un coche.");
				System.out.println("\t2. Dar de baja un coche.");
				System.out.println("\t3. Modificar un coche.");
				System.out.println("\t4. Obtener un coche.");
				System.out.println("\t5. Listar todos los coches.");
				System.out.println("\t\t(Pulse cualquier otro numero para salir).");
				System.out.print("\tOpcion: ");
				opcion = sc.nextInt();

				switch (opcion) {
				case 1:

					System.out.print("Introduzca la matricula del coche que quiere dar de alta: ");
					auxMatricula = sc.next();
					System.out.print("Introduzca la marca del coche: ");
					auxMarca = sc.next();
					System.out.print("Introduzca el modelo del coche: ");
					auxModelo = sc.next();
					System.out.print("Introduzca los kilometros del coche: ");
					auxKM = sc.nextDouble();

					coche.setMatricula(auxMatricula);
					coche.setMarca(auxMarca);
					coche.setModelo(auxModelo);
					coche.setKm(auxKM);

					boolean alta = gestorCoche.alta(coche);
					if (alta) {
						System.out.println("***El coche se ha dado de alta correctamente!***");
					} else {
						System.err.println("(!!!) El coche no se ha podido dar de alta, la matricula debe tener "
								+ "7 caracteres y debe rellenar la marca y el modelo(!!!)");
					}

					break;

				case 2:
					auxListaCoches = gestorCoche.listar();

					System.out.println("Que coche desea dar de baja? ");

					for (Coche c : auxListaCoches) {
						System.out.print(c.getMatricula() + " ");
					}

					System.out.print("\nPor favor, introduzca la matricula deseada: ");
					auxMatricula = sc.next();

					boolean baja = gestorCoche.baja(auxMatricula);
					if (baja) {
						System.out.println("***El coche se ha dado de baja correctamente!***");
					} else {
						System.err.println("(!!!) El coche no se ha podido dar de baja (!!!)");
					}

					break;

				case 3:
					auxListaCoches = gestorCoche.listar();

					System.out.println("Que coche desea modificar? ");

					for (Coche c : auxListaCoches) {
						System.out.print(c.getMatricula() + " ");
					}
					System.out.print("\nPor favor, introduzca la matricula deseada: ");
					auxMatricula = sc.next();

					System.out.print("Introduzca la marca del coche: ");
					auxMarca = sc.next();
					System.out.print("Introduzca el modelo del coche: ");
					auxModelo = sc.next();
					System.out.print("Introduzca los kilometros del coche: ");
					auxKM = sc.nextDouble();

					coche.setMatricula(auxMatricula);
					coche.setMarca(auxMarca);
					coche.setModelo(auxModelo);
					coche.setKm(auxKM);

					boolean modificar = gestorCoche.modidifcar(coche);
					if (modificar) {
						System.out.println("***El coche se ha modificado correctamente***");
					} else {
						System.out.println("(!!!) El coche no se ha podido modificar, debe rellenar "
								+ "la marca y el modelo del coche(!!!)");
					}

					break;

				case 4:
					auxListaCoches = gestorCoche.listar();

					System.out.println("Que coche desea ver? ");

					for (Coche c : auxListaCoches) {
						System.out.print(c.getMatricula() + " ");
					}
					System.out.print("\nPor favor, introduzca la matricula deseada: ");
					auxMatricula = sc.next();

					coche = gestorCoche.obtener(auxMatricula);
					if (coche != null) {
						System.out.println(coche.toString());
					} else {
						System.out.println("(!!!) No se puede mostrar ese coche (!!!)");
					}

					break;

				case 5:
					auxListaCoches = gestorCoche.listar();

					System.out.println("---Lista de coches disponibles: ");

					for (Coche c : auxListaCoches) {
						System.out.println("\t" + c.toString());
					}

					break;

				}
			} while (opcion > 0 && opcion < 6);

		System.out.println("Adios!");
		sc.close();

	}

}
