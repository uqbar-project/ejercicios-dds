package ar.edu.utn.frba.dds.ejercicios.funcional;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Test;

import ar.edu.utn.frba.dds.ejercicios.funcional.Cola;
import ar.edu.utn.frba.dds.ejercicios.funcional.Coleccion;
import ar.edu.utn.frba.dds.ejercicios.funcional.Pila;

/**
 * @author flbulgarelli 
 */
public class TestDriver {

	@Test
	public void paraUnaPilaVaciaUnElementoAgregadoConAgregarSeRecuperaConQuitar() {
		assertEquals("hola", Pila.nueva("hola").tope());
	}

	@Test
	public void paraUnaColaVaciaUnElementoAgregadoConAgregarSeRecuperaConQuitar() {
		assertEquals("hola", Cola.nueva("hola").tope());
	}

	@Test
	public void unaPilaQuitaLosElementosEnElOrdenOpuestoASuAgregado() {
		Coleccion<Character> pila = Pila //
				.<Character> nueva() //
				.agregar('a') //
				.agregar('b') //
				.agregar('c');

		assertEquals((Character) 'c', pila.tope());
		
		pila = pila.quitar();
		assertEquals((Character) 'b', pila.tope());
		
		pila = pila.quitar();
		assertEquals((Character) 'a', pila.tope());
	}

	@Test
	public void unaColaQuitaLosElementosEnElMismoOrdenEnQueFueronAgregados() {
		Coleccion<Character> cola = Cola //
				.<Character> nueva() //
				.agregar('a') //
				.agregar('b') //
				.agregar('c');

		assertEquals((Character) 'a', cola.tope());
		
		cola = cola.quitar();
		assertEquals((Character) 'b', cola.tope());
		
		cola = cola.quitar();
		assertEquals((Character) 'c', cola.tope());
	}

	@Test(expected = NoSuchElementException.class)
	public void noSePuedeSacarNadaDeUnaPilaVacia() {
		Pila.nueva().quitar();
	}

	@Test(expected = NoSuchElementException.class)
	public void noSePuedeSacarNadaDeUnaColaVacia() {
		Cola.nueva().quitar();
	}

}
