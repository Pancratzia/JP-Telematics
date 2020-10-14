package view;

import java.sql.ResultSet;

import javax.swing.event.ChangeEvent;

import controller.CAuditoria;

public interface IAuditoria
{
	public static final String Buscar="Buscar";
	public static final String BuscarC="BuscarC";
	public static final String SALIR = "exit";
	public static final String LIMPIAR = "limpiar";
	
	public String getUsuario();
	public void setConsulta(ResultSet rs);
	public void setConsulta1(ResultSet rs);
	public void setControlador(CAuditoria ca);
	public String getConsulta();
	public String getConsulta1();
	public void run();
	public void salir();
	public void limpiar();
	public void desplegar();
	public boolean getCerrado();
	
}

