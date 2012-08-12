package ar.edu.utn.frba.dds.ejercicios.funcional;

import java.util.NoSuchElementException;

/**
 * {@link Coleccion} es una interfaz para colecciones inmutables muy simples,
 * con tres mensajes:
 * 
 * <ul>
 * <li>{@link #agregar(Object)}: agrega un elemento dado</li>
 * <li>{@link #quitar()}: quita un elemento cualquiera</li>
 * <li>{@link #tope()}: devuelve un elemento cualquiera</li>
 * </ul>
 * 
 * <p>
 * Por <strong>elemento cualquiera</strong> no se quiere decir que sea un
 * elemento al azar, sino que la estrategia de determinación de dicho elemento
 * depende de cada implementación de {@link Coleccion}. Por ejemplo, las pilas
 * devolverán el último elemento agregado, las colas, el primero, y en las
 * bolsas, no estará especificado.
 * </p>
 * <p>
 * En una correcta implementacción de Coleccion, estos tres mensajes deben ser
 * libres de efectos.
 * </p>
 * 
 * @author flbulgarelli
 * 
 * @param <A>
 *            el tipo de elemento de la colección
 */
public interface Coleccion<A> {

	/**
	 * Agrega un elemento
	 * 
	 * @param elemento
	 *            el elemento a agregar
	 * @return una colección equivalente a esta con el elemento agregado
	 */
	Coleccion<A> agregar(A elemento);

	/**
	 * Quita un elemento cualquiera
	 * 
	 * @return una colección equivalente a esta sin dicho elemento
	 * @throws NoSuchElementException
	 *             si esta colección es vacia
	 */
	Coleccion<A> quitar();

	/**
	 * Devuelve un elemento cualquiera
	 * 
	 * @throws NoSuchElementException
	 *             si esta colección es vacia
	 */
	A tope();

}
