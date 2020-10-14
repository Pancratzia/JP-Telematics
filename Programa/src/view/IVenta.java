package view;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import controller.CVenta;
import model.MIva;

public interface IVenta {
	
	public static final String PROCESAR = "procesar";
	public static final String LIMPIAR = "limpiar";
	public static final String SALIR = "salir";
	public static final String LUPA = "lupa";
	public static final String LUPA1 = "lupa1";
	public static final String EXIT = "exit";
	public static final String COMBO ="exit_";
	
	public void salir();
	public void limpiar();
	public void run();
	public void setControlador(CVenta c);
	public void setCombo(JComboBox cbi);
	public void runHora();
	public void cargarCB();
	public String getIDCombo();
	public int getCantidadVenta();
	public String getRifCliente();
	public String getCodigoProducto();
	public void escribirCliente(String tcnom,String tcdir,String tctipo,String tctel,String tcest);
	public void escribirVendedor(String ced,String nom,String tel, String zon);
	public void escribirProducto(String tpnom,double tppre);
	public void escribirVenta(String tsub,String tiva,String ttot);
	public String getVerificacion();
	public String getVerificacion2();
	public String getVerificacion3();
	public boolean getCerrado();
	public boolean getValidez();
}
