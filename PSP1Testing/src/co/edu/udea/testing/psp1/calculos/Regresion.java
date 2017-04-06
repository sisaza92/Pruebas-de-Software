package co.edu.udea.testing.psp1.calculos;

import java.util.Iterator;
import java.util.LinkedList;

public class Regresion {

	//beta0
	public double b0;
	//beta1
	public double b1;
	//Número de programas
	public int n;
	
	public int xk;
	public double yk;

	public Regresion() {
		yk = b0 = b1 = 0.0;
		xk = n = 0;
	}
	
	
	protected double [] calcularRegresion(LinkedList <Programa> lista) {
		
		n = lista.size();
		System.out.println("n= " + n);
		int xiyiSum, xi2Sum;
		double xiSum, yiSum, xAve, yAve;
		xiyiSum = xi2Sum = 0;
		xiSum = yiSum = xAve = yAve = 0.0;

		Programa pl;
		for (Iterator<Programa> it = lista.iterator(); it.hasNext();) {
			pl = (Programa)it.next();
			xiyiSum += pl.estimado * pl.actual;
			xi2Sum += Math.pow(pl.estimado, 2.0);
			xiSum += pl.estimado;
			yiSum += pl.actual;
		}
		xAve = xiSum / n;
		yAve = yiSum / n;

		double b1Numerator = xiyiSum - (n * xAve * yAve);
		double b1Denominator = xi2Sum - (n * Math.pow(xAve, 2.0));
		b1 = b1Numerator / b1Denominator;
		b0 = yAve - (b1 * xAve);
		yk = (b0 + (b1 * xk));
		
		System.out.println("B1= " + b1);
		System.out.println("B0= " + b0);
		
		return new double[] {b1, b0};
		
		
	}
	
}
