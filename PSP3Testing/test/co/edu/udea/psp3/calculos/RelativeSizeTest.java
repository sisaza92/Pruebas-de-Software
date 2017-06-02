/**
 * 
 */
package co.edu.udea.psp3.calculos;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import co.edu.udea.testing.psp3.exceptions.CalculoException;

/**
 * @author Isaza
 *
 */
public class RelativeSizeTest {

	RelativeSize relativeSize;
	List<Double> partSizeList;
	List<Double> numberItemsList;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		relativeSize = null;
		
		partSizeList = new LinkedList<>();
		numberItemsList = new LinkedList<>();

		partSizeList.add(18.0);
		partSizeList.add(18.0);
		partSizeList.add(25.0);
		partSizeList.add(31.0);
		partSizeList.add(37.0);
		partSizeList.add(82.0);
		partSizeList.add(82.0);
		partSizeList.add(87.0);
		partSizeList.add(89.0);
		partSizeList.add(230.0);
		partSizeList.add(85.0);
		partSizeList.add(87.0);
		partSizeList.add(558.0);
		
		numberItemsList.add(3.0);
		numberItemsList.add(3.0);
		numberItemsList.add(3.0);
		numberItemsList.add(3.0);
		numberItemsList.add(3.0);
		numberItemsList.add(5.0);
		numberItemsList.add(4.0);
		numberItemsList.add(4.0);
		numberItemsList.add(4.0);
		numberItemsList.add(10.0);
		numberItemsList.add(3.0);
		numberItemsList.add(3.0);
		numberItemsList.add(10.0);
		
		relativeSize = new RelativeSize(partSizeList, numberItemsList);
		
	}



	/**
	 * Test method for {@link co.edu.udea.psp3.calculos.RelativeSize#getVerySmall()}.
	 */
	@Test
	public void testGetVerySmall() {
		assertEquals("Very Small value not match.",4.3953, relativeSize.getVerySmall(),0.001);
	}

	/**
	 * Test method for {@link co.edu.udea.psp3.calculos.RelativeSize#getSmall()}.
	 */
	@Test
	public void testGetSmall() {
		assertEquals("Small value not match.",8.5081, relativeSize.getSmall(),0.001);
	}

	/**
	 * Test method for {@link co.edu.udea.psp3.calculos.RelativeSize#getMedium()}.
	 */
	@Test
	public void testGetMedium() {
		assertEquals("Medium value not match.",16.4696, relativeSize.getMedium(),0.001);
	}

	/**
	 * Test method for {@link co.edu.udea.psp3.calculos.RelativeSize#getLarge()}.
	 */
	@Test
	public void testGetLarge() {
		assertEquals("Medium value not match.",31.8811, relativeSize.getLarge(),0.001);
	}

	/**
	 * Test method for {@link co.edu.udea.psp3.calculos.RelativeSize#getVeryLarge()}.
	 */
	@Test
	public void testGetVeryLarge() {
		assertEquals("Medium value not match.",61.7137, relativeSize.getVeryLarge(),0.001);
	}

	/**
	 * Test method for {@link co.edu.udea.psp3.calculos.RelativeSize#addPartSizeWithNumberItems(java.lang.Double, java.lang.Double)}.
	 */
	@Test
	public void testAddPartSizeWithNumberItems() {
		fail("Not yet implemented");
	}

}
