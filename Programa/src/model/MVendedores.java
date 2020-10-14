package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;


public class MVendedores{
	private String nombre;
	private String ci;
	private String telefono;
	private String zona;
	private int id;
	private int idzona;
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
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCi() {
		return ci;
	}
	public void setCi(String ci) {
		this.ci = ci;
	}
	public String getTelefono(){
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public int getIdzona() {
		return idzona;
	}
	public void setIdzona(int idzona) {
		this.idzona = idzona;
	}
	public String getZona(){
		return zona;
	}
	public void setZona(String zona){
		this.zona = zona;
	}
}	