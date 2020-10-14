package model;

public class MMDI {
	private String nVendedor,nProducto;
	private int nVentas,nVentasProducto,totalClientes;
	private String totalVendido;
	
	public String getnVendedor() {
		return nVendedor;
	}
	public void setnVendedor(String nVendedor) {
		this.nVendedor = nVendedor;
	}
	public String getnProducto() {
		return nProducto;
	}
	public void setnProducto(String nProducto) {
		this.nProducto = nProducto;
	}
	public int getnVentas() {
		return nVentas;
	}
	public void setnVentas(int nVentas) {
		this.nVentas = nVentas;
	}
	public int getnVentasProducto() {
		return nVentasProducto;
	}
	public void setnVentasProducto(int nVentasProducto) {
		this.nVentasProducto = nVentasProducto;
	}
	public int getTotalClientes() {
		return totalClientes;
	}
	public void setTotalClientes(int totalClientes) {
		this.totalClientes = totalClientes;
	}
	public String getTotalVendido() {
		return totalVendido;
	}
	public void setTotalVendido(String totalVendido) {
		this.totalVendido = totalVendido;
	}
	
}
