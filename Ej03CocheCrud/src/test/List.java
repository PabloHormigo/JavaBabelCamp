package test;

import java.sql.*;

public class List {

	public static void main(String[] args) {
		String cadenaConexion = "jdbc:mysql://localhost:3306/bbdd";
		String user = "root";
		String pass = "";
		
		try (Connection con = DriverManager.getConnection(cadenaConexion, user, pass)){
			//Listamos
			PreparedStatement sentencia = con.prepareStatement("SELECT * FROM COCHES");
			ResultSet rs = sentencia.executeQuery();
			
			while (rs.next()) {
				System.out.print(rs.getInt("ID"));
				System.out.print(" - "); 
				System.out.print(rs.getString("MARCA"));
				System.out.print(" - "); 
				System.out.print(rs.getString("MODELO"));
				System.out.print(" - "); 
				System.out.print(rs.getDouble("NUMKM"));
				System.out.println();
				
			}
			
			System.out.println("Sentencia SQL ejecutada con éxito");
		}catch (SQLException e) {
			System.out.println("Error al realizar una operacion en la base de datos");
			System.out.println(e.getMessage());
		}

	}

}
