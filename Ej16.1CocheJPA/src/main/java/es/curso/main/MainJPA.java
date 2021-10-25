package es.curso.main;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import es.curso.cfg.ConfiguracionJPA;
import es.curso.modelo.entidad.Coche;
import es.curso.modelo.negocio.GestorCoche;

public class MainJPA {
	
	private static ApplicationContext context;

	public static void main(String[] args) {
		
		context = new AnnotationConfigApplicationContext(ConfiguracionJPA.class);
		GestorCoche gestorCoche = context.getBean(GestorCoche.class);
		Coche coche = context.getBean("coche",Coche.class);
		Scanner sc = new Scanner(System.in);
		int opcion = 0;

		String auxMatricula="";
		String auxMarca="";
		String auxModelo="";
		double auxKM=0;

		List<Coche> auxListaCoches;
		
		System.out.println("***Bienvenido al gestor de coches!***");

		do {
			System.out.println("\nElija una de las siguientes opciones: ");
				System.out.println("\t1. Dar de alta un coche.");
				System.out.println("\t2. Dar de baja un coche.");
				System.out.println("\t3. Modificar un coche.");
				System.out.println("\t4. Obtener un coche.");
				System.out.println("\t5. Listar todos los coches.");
				System.out.println("\t6. Exportar BBDD a PDF.");
				System.out.println("\t7. Exportar BBDD a Excel.");
				System.out.println("\t\t(Pulse cualquier otro numero para salir).");
				System.out.print("\tOpcion: ");
				opcion = sc.nextInt();

				switch (opcion) {
				case 1:
					
					darDeAltaCoche(sc, coche, gestorCoche, auxMatricula, auxMarca, auxModelo, auxKM);
					
					break;

				case 2:
					auxListaCoches = gestorCoche.listar();

					darDeBajaCoche(sc,auxListaCoches,gestorCoche,auxMatricula);

					break;

				case 3:
					auxListaCoches = gestorCoche.listar();

					modificarCoche(sc, coche, auxListaCoches, gestorCoche, auxMatricula, auxMarca, auxModelo, auxKM);

					break;

				case 4:
					auxListaCoches = gestorCoche.listar();

					buscarCoche(sc, auxListaCoches, coche, gestorCoche, auxMatricula);

					break;

				case 5:
					auxListaCoches = gestorCoche.listar();

					listarCoches(auxListaCoches);

					break;
					
				case 6:
					auxListaCoches = gestorCoche.listar();
					
					crearPdf(auxListaCoches);
					
					break;
					
				case 7:
					auxListaCoches = gestorCoche.listar();
					
					crearExcel(auxListaCoches);
			        
					break;

				}
			} while (opcion > 0 && opcion < 8);

		System.out.println("Adios!");
		sc.close();

	}
	
	public static void darDeAltaCoche(Scanner sc, Coche coche, GestorCoche gestorCoche,
			String auxMatricula, String auxMarca, String auxModelo, double auxKM) {
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

		String alta = gestorCoche.insertar(coche);
		
		if (!alta.equals("")) {
			System.out.println("***El coche se ha dado de alta correctamente!***");
		} else {
			System.err.println("(!!!) El coche no se ha podido dar de alta, la matricula debe tener "
					+ "7 caracteres y debe rellenar la marca y el modelo(!!!)");
		}

	}
	
	public static void darDeBajaCoche(Scanner sc, List<Coche> auxListaCoches, GestorCoche gestorCoche, String auxMatricula) {
		System.out.println("Que coche desea dar de baja? ");

		for (Coche c : auxListaCoches) {
			System.out.print(c.getMatricula() + " ");
		}

		System.out.print("\nPor favor, introduzca la matricula deseada: ");
		auxMatricula = sc.next();

		String baja = gestorCoche.borrar(auxMatricula);
		if (!baja.equals("")) {
			System.out.println("***El coche se ha dado de baja correctamente!***");
		} else {
			System.err.println("(!!!) El coche no se ha podido dar de baja (!!!)");
		}
	}

	public static void modificarCoche(Scanner sc, Coche coche, List<Coche> auxListaCoches, GestorCoche gestorCoche,
			String auxMatricula,String auxMarca, String auxModelo, double auxKM) {
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

		Coche modificar = gestorCoche.modidifcar(coche);
		if (!modificar.getMatricula().equals("")) {
			System.out.println("***El coche se ha modificado correctamente***");
		} else {
			System.out.println("(!!!) El coche no se ha podido modificar, debe rellenar "
					+ "la marca y el modelo del coche(!!!)");
		}
	}
	
	public static void buscarCoche(Scanner sc, List<Coche> auxListaCoches, Coche coche,
			GestorCoche gestorCoche, String auxMatricula) {
		System.out.println("Que coche desea ver? ");

		for (Coche c : auxListaCoches) {
			System.out.print(c.getMatricula() + " ");
		}
		System.out.print("\nPor favor, introduzca la matricula deseada: ");
		auxMatricula = sc.next();

		coche = gestorCoche.buscar(auxMatricula);
		if (coche != null) {
			System.out.println(coche.toString());
		} else {
			System.out.println("(!!!) No se puede mostrar ese coche (!!!)");
		}
	}
	
	public static void listarCoches(List<Coche> auxListaCoches) {
		System.out.println("---Lista de coches disponibles: ");

		for (Coche c : auxListaCoches) {
			System.out.println("\t" + c.toString());
		}
	}

	public static void crearPdf(List<Coche> auxListaCoches) {
		try(PDDocument doc = new PDDocument()){
			
			PDPage myPage = new PDPage();
			doc.addPage(myPage);
			
			try(PDPageContentStream cont = new PDPageContentStream(doc, myPage)){
				cont.beginText();

				cont.setFont(PDType1Font.TIMES_ROMAN, 12);
				cont.setLeading(14.5f);
				
				cont.newLineAtOffset(25, 700);
				for (Coche c : auxListaCoches) {
					cont.showText(c.toString());
					cont.newLine();
				}
				cont.endText();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
			
			doc.save("src/main/resources/coches.pdf");
			
		}catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	public static void crearExcel(List<Coche> auxListaCoches) {
		// Se crea el libro
        HSSFWorkbook book = new HSSFWorkbook();

        // Se crea una hoja dentro del libro
        HSSFSheet sheet = book.createSheet();
        
        for(int i=0;i<auxListaCoches.size();i++) {
        	// Se crea una fila dentro de la hoja
        	HSSFRow row = sheet.createRow(i);
        	
        	// Se crea una celda dentro de la fila
        	HSSFCell cell = row.createCell((short) 0);
        	
        	// Se crea el contenido de la celda y se mete en ella.
        	cell.setCellValue(auxListaCoches.get(i).getMatricula());
        	
        	cell = row.createCell((short) 1);
        	cell.setCellValue(auxListaCoches.get(i).getMarca());
        	
        	cell = row.createCell((short) 2);
        	cell.setCellValue(auxListaCoches.get(i).getModelo());
        	
        	cell = row.createCell((short) 3);
        	cell.setCellValue(auxListaCoches.get(i).getKm());
        }
        
        try(FileOutputStream file = new FileOutputStream("src/main/resources/coches.xls")){
        	book.write(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	
}

