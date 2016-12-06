package py.edu.facitec.taller.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import py.edu.facitec.taller.entidad.Cliente;
import py.edu.facitec.taller.util.ConexionManager;

public class ClienteDao {
	
	//guardar
		public static void guardarCliente (Cliente cliente){
			String sql="insert into clientes (nombre, apellido, direccion, ciudad_codigo, celular,"
					+ " credito, estado)values ('"+cliente.getNombre()+"',"
							+ " '"+cliente.getApellido()+"', '"+cliente.getDireccion()+"',"
									+ " "+cliente.getCiudad_codigo()+",'"+cliente.getCelular()+"', "+cliente.getCredito()+","
											+ " "+cliente.isEstado()+") ";
			
			System.out.println("SQL: "+ sql);
			
			ConexionManager.abrirConexion();
			
			try {
				ConexionManager.stm.executeUpdate(sql);
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
			
			ConexionManager.cerrarConexion();
			
		}
		
		
		
		//buscar
		
		public static Cliente recuperarClientePorCodigo(int codigo){
			
			String sql = "select * from clientes where cliente_codigo = "+codigo+" ";
			
			ConexionManager.abrirConexion();
			
			Cliente cliente = null;
			
			try {
				ResultSet rs = ConexionManager.stm.executeQuery(sql);
				
				if(rs.next()){
					
					cliente = new Cliente();
					cliente.setNombre(rs.getString("nombre"));
					cliente.setApellido(rs.getString("apellido"));
					cliente.setDireccion(rs.getString("direccion"));
					cliente.setCiudad_codigo(rs.getInt("ciudad_codigo"));
					cliente.setCelular(rs.getString("celular"));
					cliente.setCredito(rs.getDouble("credito"));
					cliente.setEstado(rs.getBoolean("estado"));
				}
				
			} catch (SQLException e) {
			
				e.printStackTrace();
				
				ConexionManager.cerrarConexion();
			}
			return cliente;
		}
		
		//modificar
		public static void modificarCliente(Cliente cliente){
			String sql = "update clientes set nombre = '"+cliente.getNombre()+"', apellido = '"+cliente.getApellido()+"',"
					+ " direccion = '"+cliente.getDireccion()+"', ciudad_codigo = "+cliente.getCiudad_codigo()+","
							+ " celular = '"+cliente.getCelular()+"', credito = "+cliente.getCredito()+","
									+ " estado = "+cliente.isEstado()+" where cliente_codigo = "+cliente.getCodigo()+" ";
			
			ConexionManager.abrirConexion();
			
			try {
				ConexionManager.stm.executeUpdate(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ConexionManager.cerrarConexion();
		}
		
		public static void eliminarCliente(int codigo){
			String sql = "delete from clientes where cliente_codigo = "+codigo+"";
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
