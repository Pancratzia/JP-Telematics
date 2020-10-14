package view;
import javax.swing.DefaultComboBoxModel;

import controller.CVendedores;

public interface IVendedores {
	
	public static final String BUSCAR = "buscar";
	public static final String LIMPIAR = "limpiar";
	public static final String ACEPTAR = "aceptar";
	public static final String SALIR = "salir";
	public static final String EXIT = "exit";
	public static final String COMBO = "activar";
	public static final String COMBOI = "activar item";
	
	public void run();
	public void setController(CVendedores c);
	public void salir();
	public void limpiar();
	public void escribir(String tnom, String ttel, String tzon);
	public int getOperacion(); // 0 = crear, 1 = modificar, 2 = borrar 
	public int Preguntar(String pregunta);
	public String getCi();
	public String getNombre();
	public String getTelefono();
	public void setCombo(DefaultComboBoxModel<?> dcbm);
	public void setIdZona(String id);
	public void desplegar();
	public Object getComboItem();
	public int getIdZona();
	public void ValCombo();
	
	public boolean getValidez();
	
	public void VolverAlMenu();
	public void MensajeError(String mensaje);
	
	public boolean getCerrado();
	
}