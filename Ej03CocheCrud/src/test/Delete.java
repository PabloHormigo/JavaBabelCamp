package test;

import java.sql.*;

public class Delete {

	public static void main(String[] args) {
		String cadenaConexion = "jdbc:mysql://localhost:3306/bbdd";
		String user = "root";
		String pass = "";
				
		try (Connection con = DriverManager.getConnection(cadenaConexion, user, pass);){
			
			String sql = "DELETE FROM COCHES WHERE ID=?"; 
			
			//Eliminamos el coche con id 6
			int id = 6;
			
			PreparedStatement sentencia = con.prepareStatement(sql);
			sentencia.setInt(1, id);
			
			sentencia.executeUpdate();
			System.out.println("Sentencia SQL ejecutada con éxito");
			
		} catch (SQLException e) {
			System.out.println("Error al borrar el coche");
			System.out.println(e.getMessage());
		}

	}

}
