package co.edu.udea.testing.psp3.exceptions;

import java.util.logging.Logger;



/**
 * Clase que representa una excepción en los métodos de la Clase {@link Calculos}.
 * @author CristianCamilo
 * @email sisaza92@gmail.com
 */
public class CalculoException extends Exception{

	private static final long serialVersionUID = 2228204404883173939L;
	
	Logger LOG = Logger.getLogger(this.getClass().getName());
	
	public CalculoException(String mensaje){
		super(mensaje);
		LOG.log(java.util.logging.Level.WARNING, mensaje);
	}
}
