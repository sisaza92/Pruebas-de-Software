package co.edu.udea.testing.psp1.calculos;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;


public class RegresionTest {
	
		Regresion regresion;
		Programa programa;
		LinkedList <Programa> lista;
	
		double b0;
		double b1;
		int n;
		int xk;
		double yk;
		
		int estimados [] = {130, 650, 99, 150, 128, 302, 95, 945, 368, 961};
		int actual [] = {186, 699, 132, 272, 291, 331, 199, 1890, 788, 1601};
		double betas [] = {0, 0};
		
	
	@Test
	public void calcularRegresionTest() {
		
		regresion = new Regresion();
		
		
		
		lista = new LinkedList<Programa>();
		
		for (int i = 0; i < estimados.length; i++) {
			
			programa = new Programa();
			
			programa.estimado = estimados [i];
			programa.actual = actual [i];
			lista.add(i, programa);
		
		}
		
		
		betas = regresion.calcularRegresion(lista);
		
		b1 = betas[0];
		b0 = betas[1];
		
		
		assertEquals("b1 no es el esperado", 1.727932426206986, b1, 0.001);
		assertEquals("b0 no es el esparado", -22.552532752034267, b0, 0.001);
		
		
	}

}
