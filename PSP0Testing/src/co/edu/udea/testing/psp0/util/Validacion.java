package co.edu.udea.testing.psp0.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import co.edu.udea.testing.psp0.exceptions.ValidationException;


/**
 * Clase encargada de realizar las validaciones del archivo y de cada linea del mismo.
 * @author CristianCamilo
 * @email sisaza92@gmail.com
 */
public class Validacion {

	/**
	 * Valida un archivo dada su ruta.
	 * @param rutaArchivo ruta del archivo
	 * @return boolean verdadero si el archivo está bien formado.
	 * @throws ValidationException se lanza si existe una linea con caracteres no numericos en el archivo.
	 * @throws FileNotFoundException se lanza si no se encuetra archivo en la ruta especificada.
	 * @throws IOException se lanza si el archivo no se puede leer.
	 */
	public boolean validarArchivo(String rutaArchivo) throws ValidationException, FileNotFoundException, IOException{
		
		Boolean valido = true;
		
		try {			
			FileReader fileReader = new FileReader(rutaArchivo);
		    BufferedReader bufferedReader = new BufferedReader(fileReader);
		    String linea = bufferedReader.readLine();
		    Integer posicion = 0;
		    
	        while(linea != null) {
	        	
	        	posicion++;
	        	valido = valido && validarEntrada(linea);
	        	if(!valido){
	        		bufferedReader.close();
	        		throw new ValidationException("Existen caracteres no válidos en la linea "+posicion+".");
	        	}        		
	        	linea = bufferedReader.readLine();
	        }
		    bufferedReader.close();
		    
		} catch (FileNotFoundException e) {
			// TODO: handle exception
			throw new FileNotFoundException("El archivo especificado no existe.");
        				
		}catch (IOException e) {
			// TODO: handle exception
			throw new IOException("No se pudo Leer el Archivo.");
        	
		}
		
		return valido;
	}
	
	/**
	 * Valida una linea del archivo o una entrada del teclado.
	 * @param entrada linea del archivo que se validará.
	 * @return verdadero si la entrada solo contiene caracteres numericos.
	 */
	public boolean validarEntrada(String entrada){
		return entrada.matches("([0-9]|\\.)+");
	}
}
