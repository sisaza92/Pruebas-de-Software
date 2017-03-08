package co.edu.udea.testing.psp0.calculos;

import java.util.LinkedList;

/**
 * 
 * @author CristianCamilo
 * @email sisaza92@gmail.com
 */
public class Calculos {
	
	/**
	 * Método constructor de la clase
	 */
	public Calculos(){
		
	}
	
	/**
	 * Calcula la media de n numeros reales almacenados en una lista ligada.
	 * @param numerosReales Lista ligada que contiene los n numeros Reales.
	 * @return media de los n numeros reales.
	 */
	public Double calcularMedia(LinkedList<Double> numerosReales) {
		//TODO: validar que la lista no está vacía
		//TODO: Crear exceptions propias
		//TODO: Verificar y asegurar la calidad del archivo
		Double media = 0.0;
		Double sumatoria = 0.0;
		int numeroDatos = numerosReales.size();
		
		for (Double dato : numerosReales) {
			sumatoria = sumatoria + dato;
		}
		media = sumatoria/numeroDatos;
		return media;
	}
	
	public Double calcularDesviacion(LinkedList<Double> numerosReales,Double media){
		return null;
	}

}
