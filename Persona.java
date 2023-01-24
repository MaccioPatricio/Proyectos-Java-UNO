package ejDeArchivos;

public class Persona {

	private int identificador;
	private String nombre;
	private String apellido;
	
	public Persona(int identificador, String nombre, String apellido) {
		this.identificador = identificador;
		this.nombre = nombre;
		this.apellido = apellido;
	}

	public int getIdentificador() {
		return identificador;
	}

	public String getNombre() {
		return nombre;
	}
	
	public String getApellido() {
		return apellido;
	}
	
	
}
