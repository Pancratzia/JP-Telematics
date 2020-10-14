package model;

public class MPreguntas {
	private int Id;
	private String pregunta;
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getPregunta() {
		return pregunta;
	}
	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}
	
	public String toString(String pregunta) {
		return pregunta;
	}
}
