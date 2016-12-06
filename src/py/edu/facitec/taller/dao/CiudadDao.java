package py.edu.facitec.taller.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import py.edu.facitec.taller.entidad.Ciudad;
import py.edu.facitec.taller.util.ConexionManager;

public class CiudadDao {
	//guardar
	public static void guardarCiudad(Ciudad ciudad){
		
		String sql="insert into ciudades(nombre, iso, estado) values"
				+ "('"+ciudad.getNombre()+"', '"+ciudad.getIso()+"',"
						+ " "+ciudad.isEstado()+") ";
		
		System.out.println("SQL: "+ sql);
		
		ConexionManager.abrirConexion();
		
		try {
			ConexionManager.stm.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ConexionManager.cerrarConexion();
		
	}
	//buscar
	public static Ciudad recuperarCiudadPorCodigo(int codigo){
		
		String sql = "select * from ciudades where ciudad_codigo = "+codigo+" ";
		
		ConexionManager.abrirConexion();
		
		Ciudad ciudad = null;
		
		try {
			ResultSet rs = ConexionManager.stm.executeQuery(sql);
			
			if(rs.next()){
				
				ciudad = new Ciudad();
				//ciudad.setCodigo(rs.getInt("ciudad_codigo"));
				ciudad.setNombre(rs.getString("nombre"));
				ciudad.setIso(rs.getString("iso"));
				ciudad.setEstado(rs.getBoolean("estado"));
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
			
			ConexionManager.cerrarConexion();
		}
		
		return ciudad;
	}
	
	//modificar
	public static void modificarCiudad(Ciudad ciudad){
		String sql = "update ciudades set nombre = '"+ciudad.getNombre()+"',"
				+ " iso='"+ciudad.getIso()+"', estado="+ciudad.isEstado()+""
						+ " where ciudad_codigo = "+ciudad.getCodigo()+" ";
		
		ConexionManager.abrirConexion();
		
		try {
			ConexionManager.stm.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ConexionManager.cerrarConexion();
	}
	
	public static void eliminarCiudad(int codigo){
		String sql="delete from ciudades where ciudad_codigo="+codigo+"";
		ConexionManager.abrirConexion();
		
		try {
			ConexionManager.stm.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ConexionManager.cerrarConexion();
	}
	

}
