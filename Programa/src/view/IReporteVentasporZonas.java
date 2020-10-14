package view;

import java.sql.ResultSet;

import controller.CReporteVentasporZonas;

public interface IReporteVentasporZonas {

	final static String IMPRIMIR = "mostrar listado de ventas por zonas";

	public void setConsulta(ResultSet rs);

	public void setControlador(CReporteVentasporZonas c);

	public String getConsulta();

	public void run();

	public void desplegar();
	public boolean getCerrado();
}
