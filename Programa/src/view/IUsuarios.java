package view;

import javax.swing.DefaultComboBoxModel;

import controller.CUsuarios;

public interface IUsuarios {
	
	public static final String BUSCAR = "buscar";
	public static final String BUSCAR1 = "buscar1";
	public static final String LIMPIAR = "limpiar";
	public static final String ACEPTAR = "aceptar";
	public static final String SALIR = "salir";
	public static final String EXIT = "exit";
	public static final String COMBO = "activar combo";
	public static final String COMBOI = "activar item";
	
	public void run();
	public void setController(CUsuarios c);
	public void salir();
	public int getOperacion(); // 0 = CREAR, 1 = MODIFICAR, 2 = BORRAR
	public void limpiar();
	
	public String getUsuario();
	public String getClave();
	public String getRespuesta();
	public String getNombre();
	public void setDepartamento(String depa);
	public String getCod();
	
	public boolean getValidez();
	public void setCombo(DefaultComboBoxModel<?> dcbm);
	public Object getComboItem();
	
	public int getIdPregunta();
	public void VolverAlMenu();
	
	public int Preguntar(String pregunta);
	public int getAdmin();
	
	public void cargarCB();
	public  void escribir1(String departamento);
	public void escribir(String nombre, String pregunta, String departamento, String code, int i);


}
