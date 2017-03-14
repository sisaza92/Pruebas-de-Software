package co.edu.udea.testing.psp0.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

import co.edu.udea.testing.psp0.exceptions.ValidationException;

public class Recoleccion {

	/**
	 * Se encarga de leer una archivo dada una ruta
	 * @param rutaArchivo Ruta en la que se encuentra almacenado el archivo a leer.
	 * @return LinkedList<Double> Lista ligada con los numeros leidos.
	 * @throws FileNotFoundException Se lanza cuando no se encuentra el archivo en la ruta dada.
	 * @throws IOException Se lanza si no se puede leer el archivo dado.
	 * @throws ValidationException Se lanza si existen caracteres no numericos en una de las lineas del archivo.
	 */
	public LinkedList<Double> leerDesdeArchivo(String rutaArchivo) throws FileNotFoundException, IOException, ValidationException{
		//TODO: Verificar y asegurarfileReaderd del archivo
		LinkedList<Double> numeros = new LinkedList<>();
		Validacion validacion = new Validacion();
		FileReader fileReader = new FileReader(rutaArchivo);
	    BufferedReader bufferedReader = new BufferedReader(fileReader);
	    String linea = bufferedReader.readLine();
	    Integer posicion = 0;
	    
        while(linea != null) {
        	
        	posicion++;
        	
        	if(validacion.validarEntrada(linea)){
        		Double numero = Double.valueOf(linea);
        		numeros.add(numero);
        	}else{
        		bufferedReader.close();
        		throw new ValidationException("Existen caracteres no válidos en la linea "+posicion+".");
        	}        		
        	linea = bufferedReader.readLine();
        }
	    bufferedReader.close();
	    return numeros;		
	}
	
	
//	public LinkedList<Double> leerDesdeTeclado(){
//		return null;
//		
//	}
	
}
