package py.edu.facitec.taller.entidad;

public class Servicio {
	
	private int codigo;
	private String nombre;
	private String descripcion;
	private double valor_unitario;
	private boolean estado;
	
	public Servicio() {
		
		codigo=0;
		nombre="";
		descripcion="";
		valor_unitario=0;
		estado=false;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getValor_unitario() {
		return valor_unitario;
	}

	public void setValor_unitario(double valor_unitario) {
		this.valor_unitario = valor_unitario;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	

}
