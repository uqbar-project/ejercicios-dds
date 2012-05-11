package ar.edu.design.examples.clientesTarjetaCredito.domain;

import ar.edu.design.examples.clientesTarjetaCredito.exceptions.BusinessException;

public class ClientePosta implements Cliente {

	private int deuda;
	private int puntos;
	private boolean adheridoPromocion;
	private boolean adheridoSafeShop;
	private int montoMaximoSafeShop;
	
	/**
	 * METODOS ORIGINALES DEL REQUERIMIENTO
	 * 
	 */
	@Override
	public void comprar(int monto) {
		if (adheridoSafeShop && monto > montoMaximoSafeShop) {
			throw new BusinessException("El monto " + monto + " supera " + montoMaximoSafeShop + " que es el monto máximo");
		}
		deuda += monto;
		if (adheridoPromocion && monto > 50) {
			puntos += 15;
		}
	}
	
	@Override
	public void pagarVencimiento(int monto) {
		deuda -= monto;
		
	}
	
	/**
	 * METODOS QUE SURGIERON POR LOS TESTS
	 */
	public ClientePosta() {
		deuda = 0;
	}
	
	public ClientePosta(int montoInicial) {
		deuda = montoInicial;
	}
	
	public ClientePosta(int montoInicial, int montoMaximoSafeShop) {
		deuda = montoInicial;
		this.agregarSafeShop(montoMaximoSafeShop);
	}
	
	public void agregarSafeShop(int montoMaximoSafeShop) {
		this.adheridoSafeShop = true;
		this.montoMaximoSafeShop = montoMaximoSafeShop;
	}

	public void agregarPromocion() {
		this.adheridoPromocion = true;
	}
	
	public boolean isAdheridoSafeShop() {
		return adheridoSafeShop;
	}

	public int getPuntos() {
		return puntos;
	}

	public ClientePosta(int montoInicial, boolean adhierePromocion) {
		deuda = montoInicial;
		adheridoPromocion = adhierePromocion;
		puntos = 0;
	}

	public boolean esMoroso() {
		return deuda != 0;
	}

	public int getDeuda() {
		return deuda;
	}

}
