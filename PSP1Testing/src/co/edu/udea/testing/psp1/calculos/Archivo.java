package co.edu.udea.testing.psp1.calculos;
import co.edu.udea.testing.psp1.calculos.Regresion;

import java.io.*;
import java.util.*;
import java.math.*;


public class Archivo {
	
	public LinkedList <Programa> lista;

	//beta0
	public double b0;
	//beta1
	public double b1;
	//Número de programas
	public int n;
	
	public int xk;
	public double yk;

	public Archivo() {
		lista = new LinkedList<Programa>();
		yk = b0 = b1 = 0.0;
		xk = n = 0;
	}

	public void run() {
		obtenerArchivo("");
		
		Regresion r = new Regresion();
		r.calcularRegresion(lista);
	}

	public LinkedList<Programa> obtenerArchivo(String ruta) {
		
		BufferedReader data = null;
		String filename, line;
		filename = ruta;
		
		
		if (ruta.equals("")) {
			
			filename = line = null;
			
			// Leer el nombre del archivo
			try {
					data = new BufferedReader (new InputStreamReader (System.in));
					System.out.print ("\nIngrese la ruta del archivo: ");
					filename = data.readLine();
				}catch (IOException ex) {
				ex.printStackTrace();
				System.exit(1);
			}

			try {
				data.close();
			}catch (IOException ex) {	
				ex.printStackTrace();
				System.exit(2);
			}
		}
    
		// Se abre el archivo
		try {
			data = new BufferedReader (new FileReader (filename));
		}catch (FileNotFoundException ex) {
			System.out.println("File not found.");
			System.exit(3);
		}
		
		Programa pl = new Programa();
		
		try {
			String[] splitter;
			line = data.readLine();
			splitter = line.split(" ");
			int firstValue = Integer.parseInt(splitter[0]);
			int secondValue = Integer.parseInt(splitter[1]);
			
			while (line != null) {
				pl = new Programa();
				splitter = line.split(" ");
				firstValue = Integer.parseInt(splitter[0]);
				secondValue = Integer.parseInt(splitter[1]);
				pl.estimado = firstValue;
				pl.actual = secondValue;
				line = data.readLine();
				
				System.out.println("Entró acá");
				
				lista.add(pl);
			}
		}catch (IOException ex){
			ex.printStackTrace();
			System.exit(4);
		}

		n = lista.size();

		try {
			data.close();
			//return lista;
		}catch (IOException ex) {
			ex.printStackTrace();
			System.exit(5);
		}
	
	
		return lista;
		
	}

}
