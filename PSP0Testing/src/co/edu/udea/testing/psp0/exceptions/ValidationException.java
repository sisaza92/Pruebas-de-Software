package co.edu.udea.testing.psp0.exceptions;

import java.util.logging.Logger;

import co.edu.udea.testing.psp0.util.Validacion;

/**
 * Clase que representa una excepción en los métodos de la clase {@link Validacion}.
 * @author CristianCamilo
 * @email sisaza92@gmail.com
 */
public class ValidationException extends Exception {
		
	Logger LOG = Logger.getLogger(this.getClass().getName());
	
	public ValidationException(String mensaje){
		super(mensaje);
		LOG.log(java.util.logging.Level.WARNING, mensaje);
	}
}
