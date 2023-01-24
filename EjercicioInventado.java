package ejDeArchivos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class EjercicioInventado {

	private Map<Integer, List<Persona>> personas = new TreeMap<Integer, List<Persona>>();

	public void LeerPersonas(String archivo) {
		try {
			FileReader fr = new FileReader(new File(archivo));
			BufferedReader br = new BufferedReader(fr);
			String linea;
			String[] datos;
			int numIden;
			String nombre;
			String apellido;
			Integer key;
			List<Persona> aux;
			linea = br.readLine();
			while (linea != null) {
				datos = linea.split(" ");

				numIden = Integer.parseInt(datos[0]);

				nombre = datos[1];

				apellido = datos[2];

				Persona p = new Persona(numIden, nombre, apellido);

				key = p.getIdentificador();

				if (personas.containsKey(key)) {

					aux = personas.get(key);

				} else {
					aux = new ArrayList<Persona>();
				}
				aux.add(p);

				personas.put(key, aux);

				linea = br.readLine();

			}
			fr.close();
			
		} catch (FileNotFoundException fnfo) {

			System.err.print("Archivo no encontrado");
			
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	
	public void escribirArchivo(String salida) throws IOException {
		PrintWriter pw = new PrintWriter(new FileWriter(salida));
		
		List<Persona> aux;
		
		for (Map.Entry<Integer, List<Persona>> cadaPersonas : personas.entrySet()) {
			Integer key = cadaPersonas.getKey();
			aux = cadaPersonas.getValue();
			
			for (Persona cadaPersona : aux) {
				pw.print(key + " " + cadaPersona.getApellido() + " " + cadaPersona.getNombre()+ "\n");
			}
			
		}
		pw.close();
	}
	
	public static void main(String[] args)	throws IOException {
		
		EjercicioInventado e1 = new EjercicioInventado();
		e1.LeerPersonas("personas.txt");
		e1.escribirArchivo("personas.out.txt");
		
		
	}
	
}
