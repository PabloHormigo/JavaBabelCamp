package es.curso;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import org.apache.pdfbox.pdmodel.*;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.poi.hssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import es.curso.modelo.entidad.Coche;
import es.curso.modelo.persistencia.DaoCocheJPAData;

@SpringBootApplication
public class Application implements CommandLineRunner{

	@Autowired
	public DaoCocheJPAData dc;
	
	@Autowired
	public Coche c;
	
	public Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
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
					
					darDeAltaCoche(sc, c, dc, auxMatricula, auxMarca, auxModelo, auxKM);
					
					break;

				case 2:
					auxListaCoches = dc.findAll();

					darDeBajaCoche(sc,auxListaCoches,dc,auxMatricula);

					break;

				case 3:
					auxListaCoches = dc.findAll();

					modificarCoche(sc, c, auxListaCoches, dc, auxMatricula, auxMarca, auxModelo, auxKM);

					break;

				case 4:
					auxListaCoches = dc.findAll();

					buscarCoche(sc, auxListaCoches, c, dc, auxMatricula);

					break;

				case 5:
					auxListaCoches = dc.findAll();

					listarCoches(auxListaCoches);

					break;
					
				case 6:
					auxListaCoches = dc.findAll();
					
					crearPdf(auxListaCoches);
					
					break;
					
				case 7:
					auxListaCoches = dc.findAll();
					
					crearExcel(auxListaCoches);
			        
					break;

				}
			} while (opcion > 0 && opcion < 8);

		System.out.println("Adios!");
		sc.close();

		
	}
	
	public static void darDeAltaCoche(Scanner sc, Coche coche, DaoCocheJPAData dc,
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

		if (dc.save(coche)!=null) {
			System.out.println("***El coche se ha dado de alta correctamente!***");
		} else {
			System.err.println("(!!!) El coche no se ha podido dar de alta, la matricula debe tener "
					+ "7 caracteres y debe rellenar la marca y el modelo(!!!)");
		}

	}
	
	public static void darDeBajaCoche(Scanner sc, List<Coche> auxListaCoches, DaoCocheJPAData dc, String auxMatricula) {
		System.out.println("Que coche desea dar de baja? ");

		for (Coche c : auxListaCoches) {
			System.out.print(c.getMatricula() + " ");
		}

		System.out.print("\nPor favor, introduzca la matricula deseada: ");
		auxMatricula = sc.next();

		dc.delete(dc.findById(auxMatricula).get());
	}

	public static void modificarCoche(Scanner sc, Coche coche, List<Coche> auxListaCoches, DaoCocheJPAData dc,
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

		if (!dc.save(coche).getMatricula().equals("")) {
			System.out.println("***El coche se ha modificado correctamente***");
		} else {
			System.out.println("(!!!) El coche no se ha podido modificar, debe rellenar "
					+ "la marca y el modelo del coche(!!!)");
		}
	}
	
	public static void buscarCoche(Scanner sc, List<Coche> auxListaCoches, Coche coche,
			DaoCocheJPAData dc, String auxMatricula) {
		System.out.println("Que coche desea ver? ");

		for (Coche c : auxListaCoches) {
			System.out.print(c.getMatricula() + " ");
		}
		System.out.print("\nPor favor, introduzca la matricula deseada: ");
		auxMatricula = sc.next();

		System.out.println(dc.findById(auxMatricula).get());
		
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
