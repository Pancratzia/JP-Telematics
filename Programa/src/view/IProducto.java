package view;

import controller.CProducto;

public interface IProducto {
	
	public static final String BUSCAR = "buscar";
	public static final String LIMPIAR = "limpiar";
	public static final String ACEPTAR = "aceptar";
	public static final String SALIR = "salir";
	public static final String EXIT = "exit";
	
	public void run();
	public void setController(CProducto c);
	public void salir();
	public int getOperacion(); // 0 = CREAR, 1 = MODIFICAR, 2 = BORRAR
	public void limpiar();
	public void escribir(String tcod, String tnom, String tpre );
	public String getNombre();
	public String getCodigo();
	public double getPrecio();
	public boolean getValidez();
	public void VolverAlMenu();
	public int Preguntar(String pregunta);
	public boolean getCerrado();

}
