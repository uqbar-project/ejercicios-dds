package ar.edu.utn.frba.dds.ejercicios.funcional;

import java.util.NoSuchElementException;

/**
 * @author flbulgarelli
 *
 * @param <A> el tipo de elemento de la cola
 */
public abstract class Cola<A> implements Coleccion<A> {
	
	public static <A>  Coleccion<A> nueva(A elemento) {
		return new ColaUnSoloElemento<A>(elemento);
	}

	public static <A> Coleccion<A> nueva() {
		return new ColaVacia<A>();
	}
	
	static class ColaVacia<A> extends Cola<A> {

		@Override
		public final Coleccion<A> agregar(A elemento) {
			return new ColaUnSoloElemento<A>(elemento);
		}

		@Override
		public Coleccion<A> quitar() {
			throw new NoSuchElementException();
		}

		@Override
		public A tope() {
			throw new NoSuchElementException();
		}
	}

	static abstract class ColaLlena<A> extends Cola<A> {
		@Override
		public Coleccion<A> agregar(A elemento) {
			return new ColaDosOMasElementos<A>(this, elemento);
		}
	}

	static class ColaDosOMasElementos<A> extends ColaLlena<A> {

		private ColaLlena<A> tope;
		private A ultimo;

		public ColaDosOMasElementos(ColaLlena<A> tope, A ultimo) {
			this.tope = tope;
			this.ultimo = ultimo;
		}

		@Override
		public Coleccion<A> quitar() {
			return tope.quitar().agregar(ultimo);
		}

		@Override
		public A tope() {
			return tope.tope();
		}

	}

	static class ColaUnSoloElemento<A> extends ColaLlena<A> {

		private final A tope;

		public ColaUnSoloElemento(A elemento) {
			this.tope = elemento;
		}

		@Override
		public Coleccion<A> quitar() {
			return nueva();
		}

		@Override
		public A tope() {
			return tope;
		}
	}

}
