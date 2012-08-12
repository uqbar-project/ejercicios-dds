package ar.edu.utn.frba.dds.ejercicios.introductorios;

import java.util.NoSuchElementException;

public abstract class ColeccionEnlazada implements Coleccion {

	private Nodo primerNodo = new NodoNull();

	@Override
	public void agregar(Object elemento) {
		primerNodo.agregar(this, elemento);
	}

	@Override
	public Object quitar() {
		Object tope = tope();
		primerNodo.quitar(this);
		return tope;
	}

	@Override
	public Object tope() {
		return primerNodo.tope(this);
	}

	protected void setPrimerNodo(Nodo primerNodo) {
		this.primerNodo = primerNodo;
	}

	protected Nodo getPrimerNodo() {
		return primerNodo;
	}

	protected abstract void agregarEnVacia(Object elemento);

	protected abstract void agregarEnLlena(Object elemento);

	protected abstract void reiniciarUltimoNodo();

	interface Nodo {
		void agregar(ColeccionEnlazada cola, Object elemento);

		Object tope(ColeccionEnlazada cola);

		void quitar(ColeccionEnlazada cola);

		void reiniciarUltimoNodo(ColeccionEnlazada cola);
	}

	static class NodoNull implements Nodo {

		@Override
		public void agregar(ColeccionEnlazada coleccion, Object elemento) {
			coleccion.agregarEnVacia(elemento);
		}

		@Override
		public Object tope(ColeccionEnlazada cola) {
			throw new NoSuchElementException();
		}

		@Override
		public void quitar(ColeccionEnlazada cola) {
			throw new NoSuchElementException();
		}

		@Override
		public void reiniciarUltimoNodo(ColeccionEnlazada cola) {
			cola.reiniciarUltimoNodo();
		}
	}

	static class NodoComun implements Nodo {

		private Object elemento;
		private Nodo siguiente = new NodoNull();

		public NodoComun(Object elemento) {
			this.elemento = elemento;
		}

		@Override
		public void agregar(ColeccionEnlazada coleccion, Object elemento) {
			coleccion.agregarEnLlena(elemento);
		}

		@Override
		public Object tope(ColeccionEnlazada cola) {
			return elemento;
		}

		@Override
		public void quitar(ColeccionEnlazada cola) {
			cola.primerNodo = siguiente;
			siguiente.reiniciarUltimoNodo(cola);
		}

		@Override
		public void reiniciarUltimoNodo(ColeccionEnlazada cola) {

		}

		public void setSiguiente(Nodo siguiente) {
			this.siguiente = siguiente;
		}

		public static NodoComun nuevo(Object elemento) {
			return new NodoComun(elemento);
		}
	}
}
