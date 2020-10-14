package view;

import java.sql.ResultSet;

import controller.CReporteClientes;

public interface IReporteClientes {
final static String IMPRIMIR = "mostrar listado de vendedores";
	
	public void setConsulta(ResultSet rs);
	public void setControlador(CReporteClientes c);
	public String getConsulta();
	public void run();
	public void desplegar();
	public boolean getCerrado();
}
