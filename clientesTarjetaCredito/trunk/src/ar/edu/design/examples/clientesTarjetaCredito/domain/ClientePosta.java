package ar.edu.design.examples.clientesTarjetaCredito.domain;


public class ClientePosta implements Cliente {

	private int deuda;
	private int puntos;
	
	/**
	 * METODOS ORIGINALES DEL REQUERIMIENTO
	 * 
	 */
	@Override
	public void comprar(int monto) {
		deuda += monto;
	}
	
	@Override
	public void pagarVencimiento(int monto) {
		deuda -= monto;
	}
	
	/**
	 * METODOS QUE SURGIERON POR LOS TESTS
	 */
	public ClientePosta() {
		initialize();
	}
	
	public ClientePosta(int montoInicial) {
		initialize();
		deuda = montoInicial;
	}
	
	public void initialize() {
		this.deuda = 0;
		this.puntos = 0;
	}
	
	public int getPuntos() {
		return puntos;
	}

	public boolean esMoroso() {
		return deuda != 0;
	}

	public int getDeuda() {
		return deuda;
	}
	
	public void agregarPuntos(int puntos) {
		this.puntos += puntos;
	}

}
