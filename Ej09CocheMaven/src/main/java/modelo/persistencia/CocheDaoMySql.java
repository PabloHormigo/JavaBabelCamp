package modelo.persistencia;

import java.sql.*;
import java.util.*;

import modelo.entidad.Coche;
import modelo.persistencia.interfaces.CocheDao;

public class CocheDaoMySql implements CocheDao {

	private Connection conexion;

	public boolean abrirConexion() {
		String url = "jdbc:mysql://localhost:3306/bbdd";
		String usuario = "root";
		String password = "";
		try {
			conexion = DriverManager.getConnection(url, usuario, password);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean cerrarConexion() {
		try {
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean alta(Coche c) {

		if (!abrirConexion()) {
			return false;
		}

		boolean alta = true;

		String query = "INSERT INTO COCHES (MATRICULA, MARCA, MODELO, KM)" + "VALUES(?,?,?,?)";

		try {

			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setString(1, c.getMatricula());
			ps.setString(2, c.getMarca());
			ps.setString(3, c.getModelo());
			ps.setDouble(4, c.getKm());

			int numeroFilasAfectadas = ps.executeUpdate();
			if (numeroFilasAfectadas == 0) {
				alta = false;
			}

		} catch (SQLException e) {
			System.out.println("alta -> Error al insertar: " + c);
			alta = false;
			e.printStackTrace();
		} finally {
			cerrarConexion();
		}

		return alta;
	}

	public boolean baja(String matricula) {

		if (!abrirConexion()) {
			return false;
		}

		boolean borrado = true;

		String query = "DELETE FROM COCHES WHERE MATRICULA = ?";

		try {

			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setString(1, matricula);

			int numeroFilasAfectadas = ps.executeUpdate();
			if (numeroFilasAfectadas == 0) {
				borrado = false;
			}

		} catch (SQLException e) {
			System.out.println("baja -> No se ha podido dar de baja la matricula " + matricula);
			e.printStackTrace();
		} finally {
			cerrarConexion();
		}
		return borrado;

	}

	public boolean modificar(Coche c) {
		
		if(!abrirConexion()) {
			return false;
		}
		
		boolean modificado = true;
		
		String query = "UPDATE COCHES SET MATRICULA=?, MARCA=?, MODELO=?, KM=? WHERE MATRICULA=?";
		
		try {
			
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setString(1, c.getMatricula());
			ps.setString(2, c.getMarca());
			ps.setString(3, c.getModelo());
			ps.setDouble(4, c.getKm());
			ps.setString(5, c.getMatricula());
			
			int numeroFilasAfectadas = ps.executeUpdate();
			if(numeroFilasAfectadas == 0) {
				modificado = false;
			}
			
		} catch (SQLException e) {
			System.out.println("modificar -> error al modificar el coche " + c);
			modificado = false;
			e.printStackTrace();
		} finally{
			cerrarConexion();
		}
		
		return modificado;
	}
	
	public Coche obtener(String matricula) {
		
		if(!abrirConexion()) {
			return null;
		}
		
		Coche coche = null;
		
		String query = "SELECT * FROM COCHES WHERE MATRICULA=?";
		
		try {
			
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setString(1, matricula);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				
				coche = new Coche();
				coche.setMatricula(rs.getString(1));
				coche.setMarca(rs.getString(2));
				coche.setModelo(rs.getString(3));
				coche.setKm(rs.getDouble(4));
			}
			
		} catch (SQLException e) {
			System.out.println("obtener -> error al obtener el coche con matricula " +matricula);
			e.printStackTrace();
		} finally {
			cerrarConexion();
		}
		
		return coche;
	}
	
	public List<Coche> listar(){
		
		if(!abrirConexion()) {
			return null;
		}
		
		List<Coche> listaCoches = new ArrayList<Coche>();
		
		String query = "SELECT * FROM COCHES";
		
		try {
			
			PreparedStatement ps = conexion.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Coche coche = new Coche();
				
				coche.setMatricula(rs.getString(1));
				coche.setMarca(rs.getString(2));
				coche.setModelo(rs.getString(3));
				coche.setKm(rs.getDouble(4));
				
				listaCoches.add(coche);
			}
			
		}catch (SQLException e) {
			System.out.println("listar -> error al obtener los coches");
			e.printStackTrace();
		} finally {
			cerrarConexion();
		}
		
		return listaCoches;
	}

}
