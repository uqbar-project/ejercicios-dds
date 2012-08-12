package ar.edu.utn.frba.dds.ejercicios.introductorios;

public class Cola extends ColeccionEnlazada {

	private NodoComun ultimoNodo;

	protected void agregarEnVacia(Object elemento) {
		ultimoNodo = NodoComun.nuevo(elemento);
		setPrimerNodo(ultimoNodo);
	}

	protected void agregarEnLlena(Object elemento) {
		NodoComun nodo = NodoComun.nuevo(elemento);
		ultimoNodo.setSiguiente(nodo);
		ultimoNodo = nodo;
	}

	@Override
	protected void reiniciarUltimoNodo() {
		ultimoNodo = null;
	}

}
