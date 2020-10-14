package view;

import java.sql.ResultSet;

import controller.CReporteProductos;

public interface IReporteProductos {

final static String IMPRIMIR="mostrar reporte producto";
	
	public void setConsulta(ResultSet rs);
	public void setController(CReporteProductos c);
	public String getConsulta();
	public void run();
	public void desplegar();
	public boolean getCerrado();
}
