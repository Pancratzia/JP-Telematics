package view;

import java.sql.ResultSet;

import controller.CReporteVendedores;

public interface IReporteVendedores {
final static String IMPRIMIR = "mostrar listado de vendedores";
	
	public void setConsulta(ResultSet rs);
	public void setControlador(CReporteVendedores c);
	public String getConsulta();
	public void run();
	public void desplegar();
	public boolean getCerrado();
}
