/**
 * 
 */
package co.edu.udea.testing.psp0.util;

import static org.junit.Assert.*;

import java.awt.List;
import java.io.IOException;
import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

import co.edu.udea.testing.psp0.exceptions.ValidationException;

/**
 * Esta clase contiene las pruebas para verificar el 
 * correcto funcionamiento de la clase <{@link Recoleccion}>
 * @author CristianCamilo
 * @email sisaza92@gmail.com 
 */
public class RecoleccionTest {

	private final String rutaArchivo = "E:\\Archivos\\Workspaces\\Semestre 10\\Pruebas\\PSP0Testing\\test\\co\\edu\\udea\\testing\\psp0\\util\\WellFormedNumbers.txt";
	
	Recoleccion recoleccion;
	LinkedList<Double> expectedList;
	
	
	/**
	 * Configura el ambiente de pruebas con los objetos necesarios y 
	 * sus respectivos atributos.
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		
		recoleccion = new Recoleccion();
		expectedList = new LinkedList<>();
		
		expectedList.add(160.0);
		expectedList.add(591.0);
		expectedList.add(114.0);
		expectedList.add(229.0);
		expectedList.add(230.0);
		expectedList.add(270.0);
		expectedList.add(128.0);
		expectedList.add(1657.0);
		expectedList.add(624.0);
		expectedList.add(1503.0);
	}

	/**
	 * Prueba el método de lectura de los numeros desde
	 * un archivo de texto dada una ruta.
	 */
	@Test
	public void leerDesdeArchivoTest() {
		//fail("Not yet implemented");
		/**
		 * Prueba que el contenido retornado se corresponda con
		 * el contenido del archivo.
		 */
		LinkedList<Double> resultList;
		try {
			resultList = recoleccion.leerDesdeArchivo(rutaArchivo);
			assertArrayEquals(expectedList.toArray(), resultList.toArray());
		} catch (IOException | ValidationException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
	}
	
//	@Test
//	public void leerDesdeTecladoTest() {
//		fail("Not yet implemented");
//	}

}
