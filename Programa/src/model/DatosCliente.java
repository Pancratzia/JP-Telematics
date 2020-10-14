package model;

public class DatosCliente {
	   private String rif;
	   private String direccion;
	   private String nombrec;
	   private boolean borrado;
       private int borradoVendedor;
       private int idc;//c de cliente
	   private String nEstado,nVendedor,nTipo;//n de nombre
	   private  int idVendedor,idEstado,idTipo;
	   private String telefono;
	   
	public int getBorradoVendedor() {
		return borradoVendedor;
	}
	public void setBorradoVendedor(int borradoVendedor) {
		this.borradoVendedor = borradoVendedor;
	}
	    
	public String getRif() {
		return rif;
	}
	public void setRif(String rif) {
		this.rif = rif;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getNombrec() {
		return nombrec;
	}
	public void setNombrec(String nombrec) {
		this.nombrec = nombrec;
	}
	public boolean isBorrado() {
		return borrado;
	}
	public void setBorrado(boolean borrado) {
		this.borrado = borrado;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public int getIdVendedor() {
		return idVendedor;
	}
	public void setIdVendedor(int idVendedor) {
		this.idVendedor = idVendedor;
	}
	public int getIdEstado() {
		return idEstado;
	}
	public void setIdEstado(int idEstado) {
		this.idEstado = idEstado;
	}
	public int getIdTipo() {
		return idTipo;
	}
	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}
	public int getIdc() {
		return idc;
	}
	public void setIdc(int idc) {
		this.idc = idc;
	}
		
	public String getnEstado() {
			return nEstado;
		}
	public void setnEstado(String nEstado) {
			this.nEstado = nEstado;
		}
	public String getnVendedor() {
			return nVendedor;
		}
	public void setnVendedor(String nVendedor) {
			this.nVendedor = nVendedor;
		}
	public String getnTipo() {
			return nTipo;
		}
	public void setnTipo(String nTipo) {
			this.nTipo = nTipo;
		}

}
