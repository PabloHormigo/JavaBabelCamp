package test;

import java.sql.*;

public class Insert {

	public static void main(String[] args) {
		String cadenaConexion = "jdbc:mysql://localhost:3306/bbdd";
		String user = "root";
		String pass = "";
		
		try (Connection con = DriverManager.getConnection(cadenaConexion, user, pass)){
			String sql = "INSERT INTO COCHES (MARCA, MODELO, NUMKM) VALUES (?, ?, ?)";
			
			//Insertamos primer coche
			String marca = "Skoda";
			String modelo = "Fabia";
			double numKM = 200000.50;
			
			PreparedStatement sentencia;
			sentencia = con.prepareStatement(sql);
			
			sentencia.setString(1, marca);
			sentencia.setString(2, modelo);
			sentencia.setDouble(3, numKM);
			sentencia.executeUpdate();
			
			//Insertamos segundo coche
			marca = "Kia";
			modelo = "Picanto";
			numKM = 45000;
			
			sentencia.setString(1, marca);
			sentencia.setString(2, modelo);
			sentencia.setDouble(3, numKM);
			sentencia.executeUpdate();
			
			//Insertamos tercer coche
			marca = "MarcaInventada";
			modelo = "ModeloInventado";
			numKM = 0;
			
			sentencia.setString(1, marca);
			sentencia.setString(2, modelo);
			sentencia.setDouble(3, numKM);
			sentencia.executeUpdate();
			
			System.out.println("Sentencia SQL ejecutada con éxito");
		}catch (SQLException e) {
			System.out.println("Error al añadir un nuevo coche");
			System.out.println(e.getMessage());
		}
	}

}
