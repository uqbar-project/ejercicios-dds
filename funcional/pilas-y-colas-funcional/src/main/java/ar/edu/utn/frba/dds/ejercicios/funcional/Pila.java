package ar.edu.utn.frba.dds.ejercicios.funcional;

import java.util.NoSuchElementException;

/**
 * 
 * @author flbulgarelli
 * 
 * @param <A>
 *            el tipo de elemento
 */
public abstract class Pila<A> implements Coleccion<A> {

	public static <A> Coleccion<A> nueva() {
		return new PilaVacia<A>();
	}

	public static <A> Coleccion<A> nueva(A elemento) {
		return Pila.<A> nueva().agregar(elemento);
	}

	public final Coleccion<A> agregar(A elemento) {
		return new PilaLlena<A>(elemento, this);
	}

	static class PilaVacia<A> extends Pila<A> {

		@Override
		public Pila<A> quitar() {
			throw new NoSuchElementException();
		}

		@Override
		public A tope() {
			throw new NoSuchElementException();
		}
	}

	static class PilaLlena<A> extends Pila<A> {

		private final A cabeza;
		private final Pila<A> cola;

		public PilaLlena(A cabeza, Pila<A> cola) {
			this.cabeza = cabeza;
			this.cola = cola;
		}

		@Override
		public Pila<A> quitar() {
			return cola;
		}

		@Override
		public A tope() {
			return cabeza;
		}
	}
}
