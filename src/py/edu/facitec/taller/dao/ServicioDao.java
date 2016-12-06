package py.edu.facitec.taller.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import py.edu.facitec.taller.entidad.Servicio;
import py.edu.facitec.taller.util.ConexionManager;

public class ServicioDao {
	
	//guardar
	public static void guardarServicio (Servicio servicio){
		String sql="insert into servicios (nombre, descripcion, valor_unitario, estado) values"
				+ "('"+servicio.getNombre()+"', '"+servicio.getDescripcion()+"',"
						+ " "+servicio.getValor_unitario()+", "+servicio.isEstado()+")";
		
		System.out.println("SQL: " + sql);
		
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
	
	public static Servicio recuperarServicioPorCodigo(int codigo){
		
		String sql= "select * from servicios where servicio_codigo = "+codigo+" ";
		
		ConexionManager.abrirConexion();
		
		Servicio servicio = null;
		
		try {
			ResultSet rs = ConexionManager.stm.executeQuery(sql);
			
			if(rs.next()){
				servicio = new Servicio();
				servicio.setNombre(rs.getString("nombre"));
				servicio.setDescripcion(rs.getString("descripcion"));
				servicio.setValor_unitario(rs.getDouble("valor_unitario"));
				servicio.setEstado(rs.getBoolean("estado"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return servicio;
	}
	
	//modificar
	public static void modificarServicio(Servicio servicio){
		
		String sql = "update servicios set nombre = '"+servicio.getNombre()+"', "
				+ " descripcion = '"+servicio.getDescripcion()+"', valor_unitario = "+servicio.getValor_unitario()+","
						+ " estado = "+servicio.isEstado()+" where servicio_codigo = "+servicio.getCodigo()+"";
		
		ConexionManager.abrirConexion();
		
		try {
			ConexionManager.stm.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ConexionManager.cerrarConexion();
	}
	
	//eliminar
	
	public static void eliminarServicio(int codigo){
		String sql = "delete from servicios where servicio_codigo = "+codigo+"";
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
