/**
 * 
 */
package co.edu.udea.testing.psp0.util;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import co.edu.udea.testing.psp0.exceptions.ValidationException;

/**
 * @author CristianCamilo
 *
 */
public class ValidacionTest {

	private final String RUTA_BIEN_FORMADO
	="E:\\Archivos\\Workspaces\\Semestre 10\\Pruebas\\PSP0Testing\\test\\co\\edu\\udea\\testing\\psp0\\util\\WellFormedNumbers.txt";
	private final String RUTA_MAL_FORMADO 
	= "E:\\Archivos\\Workspaces\\Semestre 10\\Pruebas\\PSP0Testing\\test\\co\\edu\\udea\\testing\\psp0\\util\\BadFormedNumbers.txt";
	
	private final Validacion validacion = new Validacion();
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * Prueba que la validación de un documento bien
	 * formado retorne verdadero o falle de lo contrario.
	 */
	@Test
	public void validarArchivoBienFormado(){
		try {
			assertTrue("El archivo especificado está bien formado pero la validación falló", validacion.validarArchivo(RUTA_BIEN_FORMADO));
		} catch (ValidationException | IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
	}
	

	/**
	 * Prueba que se lance la excepción de documento 
	 * mal formado si existen caracteres alfanumericos
	 * en el archivo o falle si no se lanza.
	 */
	@Test
	public void validarArchivoMalFormado(){
		try {
			validacion.validarArchivo(RUTA_MAL_FORMADO);
			fail("Se esperaba Excepcion de documento mal formado");
		}catch (ValidationException | IOException e) {
			// TODO: handle exception
		}
	}
	
	/**
	 * Prueba que se lance la excepción de Archivo 
	 * inexistente si no se encuentra un archivo con 
	 * la ruta dada o falle si no se lanza la excepcion.
	 */
	@Test
	public void validarArchivoInexistente() throws ValidationException, FileNotFoundException, IOException {
		//fail("Not yet implemented");
		try {
			validacion.validarArchivo("");
			fail("Se esperaba Excepcion de Archivo Inexistente");
		}catch (FileNotFoundException e) {
			// TODO: handle exception
		}
	}
	
	/**
	 * Prueba que se lance la excepción de Fallo en
	 * la lectura del archivo si el archivo se encuentra 
	 * bloqueado y no se puede leer, o falle si
	 *  no se lanza la excepcion.
	 */
	@Test
	public void validarLecturaDeArchivo(){
			fail("No Implementado aún");	
//		try {
//			FileReader fileReader = new FileReader(rutaBienFormado);
//		    BufferedReader bufferedReader = new BufferedReader(fileReader);
//		    validacion.validarArchivo("");
//		    bufferedReader.close();
//			fail("Se esperaba Excepcion de Lectura de Archivo");
//		} catch (IOException e) {
//			// TODO: handle exception
//		}
	}
	
	/**
	 * Prueba que una linea de entrada sea valida
	 * solo si se ingresan numeros.
	 */
	@Test
	public void validarEntradaTest() {
		//fail("Not yet implemented");
		assertTrue("Validación erronea", validacion.validarEntrada("123"));
		assertTrue("Validación erronea", validacion.validarEntrada("5.0"));
		assertFalse("La entrada no debe contener Letras", validacion.validarEntrada("5a5"));
		assertFalse("El elemento de separación de decimales debe ser el punto", validacion.validarEntrada("5,0"));
		
	}

}
