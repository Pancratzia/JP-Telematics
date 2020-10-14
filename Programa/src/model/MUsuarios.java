package model;

public class MUsuarios {
	private int id;
	private String nombreusuario;
	private String clave;
	private int administrador;
	private int idpregunta;
	private String respuesta; 
	private String nombre;
	private int iddepartamento;
	private String nomdepartamento;
	private String coddepartamento;
	private String usuario;
	private String pregunta;
	private boolean borrado;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombreusuario() {
		return nombreusuario;
	}
	public void setNombreusuario(String nombreusuario) {
		this.nombreusuario = nombreusuario;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public int getAdministrador() {
		return administrador;
	}
	public void setAdministrador(int administrador) {
		this.administrador = administrador;
	}
	public int getIdpregunta() {
		return idpregunta;
	}
	public void setIdpregunta(int idpregunta) {
		this.idpregunta = idpregunta;
	}
	public String getRespuesta() {
		return respuesta;
	}
	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getIddepartamento() {
		return iddepartamento;
	}
	public void setIddepartamento(int iddepartamento) {
		this.iddepartamento = iddepartamento;
	}
	public boolean isBorrado() {
		return borrado;
	}
	public void setBorrado(boolean borrado) {
		this.borrado = borrado;
	}
	public String getNombreDepartamento() {
		return nomdepartamento;
	}
	public void setNombreDepartamento(String nomdepartamento) {
		this.nomdepartamento = nomdepartamento;
	}
	public String getCodDepartamento() {
		return coddepartamento;
	}
	public void setCodDepartamento(String coddepartamento) {
		this.coddepartamento = coddepartamento;
	}
	public String getPregunta() {
		return pregunta;
	}
	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
}