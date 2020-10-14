package view;

import java.sql.ResultSet;

import controller.CReporteMejoresClientes;

public interface IReporteMejoresClientes {
final static String IMPRIMIR = "mostrar listado de vendedores";
	
	public void setConsulta(ResultSet rs);
	public void setControlador(CReporteMejoresClientes c);
	public String getConsulta();
	public void run();
	public void desplegar();
	public boolean getCerrado();
}
