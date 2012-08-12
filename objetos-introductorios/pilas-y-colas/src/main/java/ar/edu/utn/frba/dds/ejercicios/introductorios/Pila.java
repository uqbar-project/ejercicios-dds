package ar.edu.utn.frba.dds.ejercicios.introductorios;

public class Pila extends ColeccionEnlazada {

	@Override
	protected void agregarEnLlena(Object elemento) {
		NodoComun nodo = NodoComun.nuevo(elemento);
		nodo.setSiguiente(getPrimerNodo());
		setPrimerNodo(nodo);
	}

	@Override
	protected void agregarEnVacia(Object elemento) {
		setPrimerNodo(NodoComun.nuevo(elemento));
	}

	@Override
	protected void reiniciarUltimoNodo() {
		// nada - las pilas no manejan ultimo nodo
	}

}
