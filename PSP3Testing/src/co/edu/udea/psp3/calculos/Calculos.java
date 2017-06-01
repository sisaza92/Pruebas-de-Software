package co.edu.udea.psp3.calculos;

import java.util.LinkedList;

import co.edu.udea.testing.psp3.exceptions.CalculoException;

/**
 * Clase encargada de realizar todos los calculos
 * de la media y la desviaci�n est�ndar.
 * @author CristianCamilo
 * @email sisaza92@gmail.com
 */
public class Calculos {
	
	/**
	 * M�todo constructor de la clase
	 */
	public Calculos(){
		
	}
	
	/**
	 * Calcula la media de n numeros reales almacenados en una lista ligada.
	 * @param numerosReales Lista ligada que contiene los n numeros Reales.
	 * @return media de los n numeros reales.
	 * @throws CalculoException CalculoException se lanza cuando la lista de numeros se encuentra vac�a o nula.
	 */
	public Double calcularMedia(LinkedList<Double> numerosReales) throws CalculoException {

		Double media = 0.0;
		Double sumatoria = 0.0;
		
		try{
			
			Integer numeroDatos = numerosReales.size();
			
			if (numeroDatos == 0) {
				throw new CalculoException("Error calculando la Media: La lista de numeros se encuentra vac�a");
			}
			
			for (Double dato : numerosReales) {
				sumatoria = sumatoria + dato;
			}
			
			media = sumatoria/numeroDatos;
			
		}catch (NullPointerException exeption) {
			throw new NullPointerException("Error calculando la Desviaci�n: La Lista de numeros se encuentra Nula");
		}
		
		return media;
	}
	
	/**
	 * Calcula la desviaci�n estandar de n numeros reales almacenados en una lista ligada.
	 * @param numerosReales Lista ligada que contiene los n numeros Reales.
	 * @param media media de los n numeros reales.
	 * @return desviaci�n est�ndar de los n numeros reales.
	 * @throws CalculoException se lanza cuando la lista de numeros se encuentra vac�a o nula.
	 */
	public Double calcularDesviacion(LinkedList<Double> numerosReales) throws CalculoException{

		Double media;
		Integer numeroDatos;
		Double desviacion = 0.0;
		Double sumatoria = 0.0;
		
		try{
			numeroDatos = numerosReales.size();
			media = calcularMedia(numerosReales);
			if (numeroDatos == 1) {
				throw new CalculoException("Error calculando la Desviaci�n: La lista de numeros se encuentra vac�a");
			}
			
			for (Double dato : numerosReales) {
				sumatoria += Math.pow(dato-media, 2);
			}
			
			desviacion = Math.sqrt(sumatoria/(numeroDatos-1));
			
		}catch (NullPointerException e) {
			throw new NullPointerException("Error calculando la Desviaci�n: La Lista de numeros se encuentra Nula");
		}
		
		return desviacion;
	}

}
