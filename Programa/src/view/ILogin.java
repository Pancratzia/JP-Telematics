package view;

import controller.CLogin;

public interface ILogin {

	public static final String INGRESAR = "ingresar";
	public static final String ACEPTAR = "aceptar";
	public static final String VOLVER = "volver";
	public static final String OLVIDO = "olvido";
	public static final String BUSCAR = "buscar";

	public String getUsuario();

	public String getContraseña();

	public String getRespuesta();

	public String getNewPass();

	public void setController(CLogin c);

	public void run();

	public void LimpiarR();

	public void LimpiarUP();

	public void volver();

	public void habilitar();

	public void cerrar();

	public void setPregunta(String pregunta);

	public void MensajeError(String mensaje);

	public boolean getValidez();
}
