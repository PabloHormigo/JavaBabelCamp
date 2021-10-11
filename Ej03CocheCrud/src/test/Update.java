package test;

import java.sql.*;

public class Update {
	public static void main(String[] args) {
		String cadenaConexion = "jdbc:mysql://localhost:3306/bbdd";
		String user = "root";
		String pass = "";
		
		try (Connection con = DriverManager.getConnection(cadenaConexion, user, pass);){
			
			String sql = "UPDATE COCHES SET MARCA=?, MODELO=?, NUMKM=? WHERE ID=?";
			
			//Actualizamos el coche con id 5
			String marca = "Seat";
			String modelo = "Leon";
			double numKM = 100000.28;
			int id = 5;
			
			PreparedStatement sentencia = con.prepareStatement(sql);
			
			sentencia.setString(1, marca);
			sentencia.setString(2, modelo);
			sentencia.setDouble(3, numKM);
			sentencia.setInt(4, id);
			
			sentencia.executeUpdate();
			
			System.out.println("Sentencia SQL ejecutada con éxito");
			
		}catch (SQLException e) {
			System.out.println("Error al actualizar los coches");
			System.out.println(e.getMessage());
		}	
	}
}
