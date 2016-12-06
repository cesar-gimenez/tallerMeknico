package py.edu.facitec.taller.entidad;

public class Mantenimiento_Detalle {
	
	private int codigo;
	private double cantidad;
	private double precio;
	private double subtotal;
	
	public Mantenimiento_Detalle() {
		codigo=0;
		cantidad=0;
		precio=0;
		subtotal=0;
		
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public double getCantidad() {
		return cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	
	
	
	
	
	
	
	
	
	
	

}
