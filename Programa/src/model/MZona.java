package model;

public class MZona {
	private int id;
	private String codigo;
	private String nombre;
	private boolean borrado;
	private int estado1;
	private int estado2;
	private int estado3;
	private int contador;
	private int cantestado;
	
	
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
	public int getEstado1() {
		return estado1;
	}
	public void setEstado1(int estado1) {
		this.estado1 = estado1;
	}
	public int getEstado2() {
		return estado2;
	}
	public void setEstado2(int estado2) {
		this.estado2 = estado2;
	}
	public int getEstado3() {
		return estado3;
	}
	public void setEstado3(int estado3) {
		this.estado3 = estado3;
	}
	public int getContador() {
		return contador;
	}
	public void setContador(int contador) {
		this.contador = contador;
	}
	public int getCantEstado() {
		return cantestado;
	}
	public void setCantEstado(int cantestado) {
		this.cantestado = cantestado;
	}

}
