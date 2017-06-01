/**
 * 
 */
package co.edu.udea.psp3.calculos;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

import co.edu.udea.testing.psp3.exceptions.CalculoException;



/**
 * Se encarga de Realizar las pruebas en los m�todos de calculo
 * de la media y la desviaci�n est�ndar.
 * @author CristianCamilo
 * @email sisaza92@gmail.com
 */
public class CalculosTest {

	LinkedList<Double> estimateProxySize;
	LinkedList<Double> developmentHours;
	LinkedList<Double> listaVacia;
	LinkedList<Double> listaNula;
	Calculos calculos;
	
	
	/**
	 * m�todo constructor que inicializa las variables de clase.
	 */
	public CalculosTest() {
		super();
		this.estimateProxySize = new LinkedList<>();
		this.developmentHours = new LinkedList<>();
		this.listaVacia = new LinkedList<>();
		this.calculos = new Calculos();
	}

	/**
	 * M�todo que prepara los datos de prueba a�adiendo los casos
	 * como numeros a las listas que ser�n dadas como par�metros 
	 * de los metodos probados.
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		
		/**
		 * Se Prepara la lista EstimateProxySize para la prueba #1
		 */
		estimateProxySize.add(160.0);
		estimateProxySize.add(591.0);
		estimateProxySize.add(114.0);
		estimateProxySize.add(229.0);
		estimateProxySize.add(230.0);
		estimateProxySize.add(270.0);
		estimateProxySize.add(128.0);
		estimateProxySize.add(1657.0);
		estimateProxySize.add(624.0);
		estimateProxySize.add(1503.0);
		
		/**
		 * Se Prepara la lista DevelopmentHours para la prueba #2
		 */
		developmentHours.add(15.0);
		developmentHours.add(69.9);
		developmentHours.add(6.5);
		developmentHours.add(22.4);
		developmentHours.add(28.4);
		developmentHours.add(65.9);
		developmentHours.add(19.4);
		developmentHours.add(198.7);
		developmentHours.add(38.8);
		developmentHours.add(138.2);
	}

	/**
	 * Prueba el m�todo encargado de calcular la media.
	 */
	@Test
	public void calcularMediaTest() {
		//fail("Not yet implemented");
		
		Double mediaProxiSize;
		Double mediaDevelopmentHour;
		
		try {
			mediaProxiSize = calculos.calcularMedia(estimateProxySize);
			assertEquals("La media no es la esperada.", 550.6, mediaProxiSize, 0.001);
			mediaDevelopmentHour = calculos.calcularMedia(developmentHours);
			assertEquals("La media no es la esperada.", 60.32, mediaDevelopmentHour, 0.001);
		} catch (CalculoException e) {
			// TODO Auto-generated catch block
			//assertTrue(e.getMessage(), false);
		}
		try {
			calculos.calcularMedia(listaNula);
			fail("Se esperaba Excepci�n de lista nula");
		} catch (NullPointerException | CalculoException e) {
			// TODO: handle exception
		}
		try {			
			calculos.calcularMedia(listaVacia);
			fail("Se esperaba Excepci�n de lista vac�a");
		} catch (NullPointerException | CalculoException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
	}
	
	/**
	 * Prueba el m�todo encargado de calcular la desviaci�n est�ndar.
	 */
	@Test
	public void calcularDesviacionTest() {
		//fail("Not yet implemented");
		
		Double mediaProxiSize;
		Double mediaDevelopmenHour;
		
		try {
			mediaProxiSize = calculos.calcularDesviacion(estimateProxySize);
			assertEquals("La Desviaci�n no es la esperada.", 572.03, mediaProxiSize, 0.01);
			mediaDevelopmenHour = calculos.calcularDesviacion(developmentHours);
			assertEquals("La Desviaci�n no es la esperada.", 62.26, mediaDevelopmenHour, 0.01);
		} catch (CalculoException e) {
			// TODO Auto-generated catch block
			//assertTrue(e.getMessage(), false);
		}
		
		try {
			calculos.calcularDesviacion(listaNula);
			fail("Se esperaba Excepci�n de lista nula");
		} catch (NullPointerException | CalculoException e1) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
		}
		
		try {
			calculos.calcularDesviacion(listaVacia);
			fail("Se esperaba Excepci�n de lista vac�a");
		} catch (CalculoException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
	}
	

}
