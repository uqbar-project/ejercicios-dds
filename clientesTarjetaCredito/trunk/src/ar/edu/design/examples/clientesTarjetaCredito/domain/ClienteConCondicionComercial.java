package ar.edu.design.examples.clientesTarjetaCredito.domain;

/**
 * 
 * Implementación de un decorator de Cliente
 * 
 * @author dodain
 *
 */
public abstract class ClienteConCondicionComercial implements Cliente {

	protected Cliente cliente;
	
	public abstract void comprar(int monto);

	/**
	 * Los métodos siguientes sólo delegan en el cliente
	 * 
	 */
	public void pagarVencimiento(int monto) {
		cliente.pagarVencimiento(monto);
	}

	public void agregarPuntos(int puntos) {
		cliente.agregarPuntos(puntos);
	}

	public int getDeuda() {
		return cliente.getDeuda();
	}

	public boolean esMoroso() {
		return cliente.esMoroso();
	}
	
	public int getPuntos() {
		return cliente.getPuntos();
	}
	
}
