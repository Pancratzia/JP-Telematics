package view;

import java.lang.reflect.Array;

import controller.CZona;

public interface IZona {
	
	public static final String BUSCAR = "buscar";
	public static final String LIMPIAR = "limpiar";
	public static final String ACEPTAR = "aceptar";
	public static final String SALIR = "salir";
	public static final String EXIT = "exit";
	
	public void run();
	public void setController(CZona c);
	public void salir();
	public void limpiar();
	public void escribir(String tcodigo, String tnomzona, int estado1, int estado2, int estado3);
	public int getOperacion(); // 0 = CREAR, 1 = MODIFICAR, 2 = BORRAR
	
	public String getNombre();
	public String getCodigo();
	public boolean getValidez();
	
	public int getEstado1();
	public int getEstado2();
	public int getEstado3();
	public int getContador();
	public void VolverAlMenu();
	public int Preguntar(String pregunta);
	public void MostrarEstados();
	public boolean getCerrado();
}
