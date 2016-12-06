package py.edu.facitec.taller.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionManager {
	
	private static Connection conexion;
	public static Statement stm;
	
	private static final String URL="jdbc:postgresql://localhost:5432/taller_mecanico";
	private static final String USER="postgres";
	private static final String PASSWORD="12345";
	
	
	public static Connection abrirConexion(){
		
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
		
		try {
			conexion=DriverManager.getConnection(URL, USER, PASSWORD);
			stm=conexion.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conexion;
		
	}
	
	public static void cerrarConexion(){
		
		if(conexion != null){
			
			try {
				stm.close();
				conexion.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	

}
