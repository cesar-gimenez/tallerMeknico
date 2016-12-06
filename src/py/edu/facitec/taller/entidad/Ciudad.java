package py.edu.facitec.taller.entidad;

public class Ciudad {
	
	private int codigo;
	private String nombre;
	private String iso;
	private boolean estado;
	
	 public Ciudad() {
		
		codigo=0;
		nombre="";
		iso="";
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

	public String getIso() {
		return iso;
	}

	public void setIso(String iso) {
		this.iso = iso;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

		
	

}
