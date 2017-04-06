package co.edu.udea.testing.psp1.calculos;

public class Programa {
	
	/*** Número de líneas de codigo estimadas. **/
	public int estimado;

	/*** El Número actual de líneas de código. **/
	public int actual;

	/**
	 * Constructor
	 **/
	public Programa() {
	  estimado = 0;
	  actual = 0;
	}

	@Override
	public boolean equals(Object obj) {
		Programa programa = (Programa)obj;
		
		if(programa.estimado==this.estimado && programa.actual == this.actual){
			return true;
		}
		
		// TODO Auto-generated method stub	
		
		return false;
	}
	

}



