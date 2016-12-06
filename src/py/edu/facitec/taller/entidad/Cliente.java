package py.edu.facitec.taller.entidad;

public class Cliente {
	
	private int codigo;
	private String nombre;
	private String apellido;
	private String direccion;
	private int ciudad_codigo;
	private String celular;
	private double credito;
	private boolean estado;
	private Ciudad ciudad;
	
	public Cliente() {
		codigo=0;
		nombre="";
		apellido="";
		direccion="";
		ciudad_codigo=0;
		celular="";
		credito=0;
		estado=false;
		ciudad=new Ciudad();

	}

	@Override
	public String toString() {
		return "Cliente [codigo=" + codigo + ", nombre=" + nombre
				+ ", apellido=" + apellido + ", direccion=" + direccion
				+ ", ciudad_codigo=" + ciudad_codigo + ", celular=" + celular
				+ ", credito=" + credito + ", estado=" + estado + ", ciudad="
				+ ciudad + "]";
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getCiudad_codigo() {
		return ciudad_codigo;
	}

	public void setCiudad_codigo(int ciudad_codigo) {
		this.ciudad_codigo = ciudad_codigo;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public double getCredito() {
		return credito;
	}

	public void setCredito(double credito) {
		this.credito = credito;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public Ciudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}

		

}

