package view;

import controller.CTipoPersona;

public interface ITipoPersona {
	static final String CREAR="crea un registro";
	static final String MODIFICAR="modificar un registro";
	static final String BUSCAR="buscar un registro";
	static final String BORRAR="eliminar un registro";
	static final String LIMPIAR="limpiar un registro";
	public static final String EXIT="sale del todo el programa";
	
	public void setControlador(CTipoPersona c);
	public void escribir(String id, String identificador, String nombre, String borrado);
	public int getId();
	public String getIdentificador();
	public String getNom();

	public boolean getborr();
	public void run();
	public void salir();
	
	public boolean getValIdentificador();
	public boolean getValNombre();
	public void volveralmenu();
	
	public boolean getCerrado();
}
