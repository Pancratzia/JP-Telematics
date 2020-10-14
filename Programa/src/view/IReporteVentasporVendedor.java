package view;

import java.sql.ResultSet;

import controller.CReporteVentasporVendedor;

public interface IReporteVentasporVendedor {
	
	final static String IMPRIMIR="mostrar listado de ventas por vendedor";
	
	public void setConsulta(ResultSet rs);
	public void setControlador(CReporteVentasporVendedor c);
	public String getConsulta();
	public void run();
	public void desplegar();
	public boolean getCerrado();
}
