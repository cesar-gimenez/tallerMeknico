package py.edu.facitec.taller.entidad;

import java.util.Date;

public class Mantenimiento {
	
	private int codigo;
	private Date fecha;
	private int cliente_codigo;
	private String condicion;
	private double importe_total;
	private String observacion;
	private String situacion;
	
	public Mantenimiento() {
		codigo=0;
		fecha= new Date();
		cliente_codigo= 0;
		condicion="";
		importe_total=0;
		observacion="";
		situacion="";
	}

	@Override
	public String toString() {
		return "Mantenimiento [codigo=" + codigo + ", fecha=" + fecha
				+ ", cliente_codigo=" + cliente_codigo + ", condicion="
				+ condicion + ", importe_total=" + importe_total
				+ ", observacion=" + observacion + ", situacion=" + situacion
				+ "]";
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getCliente_codigo() {
		return cliente_codigo;
	}

	public void setCliente_codigo(int cliente_codigo) {
		this.cliente_codigo = cliente_codigo;
	}

	public String getCondicion() {
		return condicion;
	}

	public void setCondicion(String condicion) {
		this.condicion = condicion;
	}

	public double getImporte_total() {
		return importe_total;
	}

	public void setImporte_total(double importe_total) {
		this.importe_total = importe_total;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public String getSituacion() {
		return situacion;
	}

	public void setSituacion(String situacion) {
		this.situacion = situacion;
	}


	
}
