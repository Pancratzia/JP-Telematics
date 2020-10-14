package model;

public class MProductos {
	private int id;
	private String codigo;
	private String nombre;
	private double costo;
	private boolean borrado;
	
	
	public boolean getBorrado() {
		return borrado;
	}
	public void setBorrado(boolean borrado) {
		this.borrado = borrado;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getPrecio() {
		return costo;
	}
	public void setPrecio(double costo) {
		this.costo = costo;
	}

	

}
