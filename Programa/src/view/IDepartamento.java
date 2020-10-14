package view;

import controller.CDepartamento;
public interface IDepartamento 

{

	public static final String BUSCAR = "buscar";
	public static final String ACEPTAR = "aceptar";
	public static final String SALIR = "salir";
	public static final String LIMPIAR = "limpiar";
	public static final String EXIT = "exit";

	
	
	public void run();
	public void salir();
	public int getOperacion();
	public void limpiar();
	public void escribir (String tcod, String tnom);
	public String getNombre();
	public String getCodigo();
	public boolean getValidez();
	public int Preguntar(String mensaje);
	public void VolverAlMenu();
	void setcontroller(CDepartamento c);
	public boolean getCerrado();

}
