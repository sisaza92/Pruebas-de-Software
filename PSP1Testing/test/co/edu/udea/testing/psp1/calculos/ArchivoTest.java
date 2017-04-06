package co.edu.udea.testing.psp1.calculos;

import static org.junit.Assert.*;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import co.edu.udea.testing.psp1.calculos.Archivo;
import co.edu.udea.testing.psp1.calculos.Programa;

import org.junit.Before;
import org.junit.Test;

public class ArchivoTest {
	
	private final String rutaArchivo = "/Users/diego/git/Pruebas-de-Software4/PSP0Testing/bin/co/edu/udea/testing/psp0/util/WellFormedNumbers.txt";
	
	Archivo archivo;
	Programa programa;
	public LinkedList <Programa> lista;
	int estimados [] = {130, 650, 99, 150, 128, 302, 95, 945, 368, 961};
	int actual [] = {186, 699, 132, 272, 291, 331, 199, 1890, 788, 1601};

	
	
	@Test
	public void leerDesdeArchivoTest() {
		
		archivo = new Archivo();
		lista = new LinkedList<Programa>();
		
		for (int i = 0; i < estimados.length; i++) {
			
			programa = new Programa();
			
			programa.estimado = estimados [i];
			programa.actual = actual [i];
			lista.add(i, programa);
		
		}
		
		LinkedList <Programa> listaResultante = new LinkedList<Programa>();
		listaResultante = archivo.obtenerArchivo(rutaArchivo);
		
		assertArrayEquals(lista.toArray(), listaResultante.toArray());
	
	}
	
}
