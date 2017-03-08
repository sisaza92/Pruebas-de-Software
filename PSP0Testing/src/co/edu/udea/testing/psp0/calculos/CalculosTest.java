/**
 * 
 */
package co.edu.udea.testing.psp0.calculos;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

/**
 * @author CristianCamilo
 *
 */
public class CalculosTest {

	LinkedList<Double> estimateProxySize;
	LinkedList<Double> developmentHours;
	Calculos calculos;
	
	
	
	public CalculosTest() {
		super();
		this.estimateProxySize = new LinkedList<>();
		this.developmentHours = new LinkedList<>();
		this.calculos = new Calculos();
	}

	/**
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

	@Test
	public void calcularMediaTest() {
		//fail("Not yet implemented");
		Double mediaProxiSize = calculos.calcularMedia(estimateProxySize);
		assertEquals("La media no es la esperada.", 550.6, mediaProxiSize, 0.001);
		Double mediaDevelopmenHour = calculos.calcularMedia(developmentHours);
		assertEquals("La media no es la esperada.", 60.32, mediaDevelopmenHour, 0.001);
	}
	

}
