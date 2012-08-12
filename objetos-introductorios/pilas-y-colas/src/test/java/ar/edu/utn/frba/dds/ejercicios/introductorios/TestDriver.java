package ar.edu.utn.frba.dds.ejercicios.introductorios;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Test;

import ar.edu.utn.frba.dds.ejercicios.introductorios.Cola;
import ar.edu.utn.frba.dds.ejercicios.introductorios.Pila;
/**
 * @author flbulgarelli
 */
public class TestDriver {
	

	@Test
	public void paraUnaPilaVaciaUnElementoAgregadoConAgregarSeRecuperaConTope() {
		Pila pila = new Pila();
		pila.agregar("hola");

		assertEquals("hola", pila.quitar());
	}

	@Test
	public void paraUnaColaVaciaUnElementoAgregadoConAgregarSeRecuperaConQuitar() {
		Cola cola = new Cola();
		cola.agregar("hola");

		assertEquals("hola", cola.quitar());
	}

	@Test
	public void unaPilaQuitaLosElementosEnElOrdenOpuestoASuAgregado() {
		Pila pila = new Pila();

		pila.agregar('a');
		pila.agregar('b');
		pila.agregar('c');

		assertEquals('c', pila.quitar());
		assertEquals('b', pila.quitar());
		assertEquals('a', pila.quitar());
	}

	@Test
	public void unaColaQuitaLosElementosEnElMismoOrdenEnQueFueronAgregados() {
		Cola cola = new Cola();

		cola.agregar('a');
		cola.agregar('b');
		cola.agregar('c');

		assertEquals('a', cola.quitar());
		assertEquals('b', cola.quitar());
		assertEquals('c', cola.quitar());
	}

	@Test(expected = NoSuchElementException.class)
	public void noSePuedeSacarNadaDeUnaPilaVacia() {
		new Pila().quitar();
	}

	@Test(expected = NoSuchElementException.class)
	public void noSePuedeSacarNadaDeUnaColaVacia() {
		new Cola().quitar();
	}

}

