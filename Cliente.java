package ejDeArchivos;


public class Cliente implements Comparable<Cliente>{

	private String numMatricula;
	private String fecha;
	private String detalles;
	
	public Cliente(String numMatricula, String fecha, String detalles) {
		this.numMatricula = numMatricula;
		this.fecha = fecha;
		this.detalles = detalles;
	}

	public String getNumMatricula() {
		return numMatricula;
	}

	public String getFecha() {
		return fecha;
	}

	public String getDetalles() {
		return detalles;
	}

	@Override
	public int compareTo(Cliente o) {
		if(Integer.parseInt(numMatricula) > Integer.parseInt(o.getNumMatricula()))
			return 1;
		if(Integer.parseInt(numMatricula) < Integer.parseInt(o.getNumMatricula()))
			return -1;
		else
		return 0;
	}

	
	
	
	
	
}
