package ejDeArchivos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Siniestro {

	private Map<String, List<Cliente>> siniestros = new TreeMap<String, List<Cliente>>();

	public void procesarArchivo(String archivo) throws IOException {
		try {
			FileReader fr = new FileReader(new File(archivo));
			BufferedReader br = new BufferedReader(fr);
			String linea;
			String[] datos;
			String matricula;
			String fecha;
			String detalles;
			String key;
			List<Cliente> aux;
			linea = br.readLine();
			while (linea != null) {
				datos = linea.split(" ");
				matricula = datos[0];
				fecha = datos[1];
				detalles = datos[2];
				Cliente c = new Cliente(matricula, fecha, detalles);
				key = c.getNumMatricula();
				if (siniestros.containsKey(key)) {
					aux = siniestros.get(key);
				} else {
					aux = new ArrayList<Cliente>();
				}
				aux.add(c);
				siniestros.put(key, aux);
				linea = br.readLine();
			}
			fr.close();
		} catch (FileNotFoundException fnfo) {
			System.err.print("Archivo no encontrado");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void emitirArchivo(String salida) throws IOException {

		PrintWriter pw = new PrintWriter(new FileWriter(salida));
		List<Cliente> aux;
		
		
		for (Entry<String, List<Cliente>> cadaSiniestro : siniestros.entrySet()) {
			String key = cadaSiniestro.getKey();
			aux = cadaSiniestro.getValue();
			
			Collections.sort(aux);
			
			for (Cliente cadaCliente : aux) {
				pw.println(key + " " + cadaCliente.getFecha() + " " + cadaCliente.getDetalles());
			}

		}
		pw.close();
	}

	
	public static void main(String[] args) throws IOException {
		Siniestro s1 = new Siniestro();
		s1.procesarArchivo("Siniestros.txt");
		s1.emitirArchivo("Siniestros.out.txt");
		}
	
	
	
}
