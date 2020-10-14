package model;

public class MLogin {

	private String usuario;
	private String password;
	private String respuesta;
	private String pregunta;
	private String newCon;
	private boolean borrado;
	private String id_usuario;
	private String nombre;
	private boolean admin;
	private int IdUsuario;

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isBorrado() {
		return borrado;
	}

	public void setBorrado(boolean borrado) {
		this.borrado = borrado;
	}

	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	public String getPregunta() {
		return pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	public String getNewCon() {
		return newCon;
	}

	public void setNewCon(String newCon) {
		this.newCon = newCon;
	}

	public int getId_pregunta() {
		return Integer.parseInt(id_usuario);
	}

	public void setId_pregunta(String string) {
		this.id_usuario = string;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean getAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public int getIdUsuario() {
		return IdUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		IdUsuario = idUsuario;
	}

}
