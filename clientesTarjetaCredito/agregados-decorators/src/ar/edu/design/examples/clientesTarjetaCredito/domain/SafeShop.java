package ar.edu.design.examples.clientesTarjetaCredito.domain;

import ar.edu.design.examples.clientesTarjetaCredito.exceptions.BusinessException;

public class SafeShop extends ClienteConCondicionComercial {

	private int montoMaximoSafeShop;

	@Override
	public void comprar(int monto) {
		if (monto > montoMaximoSafeShop) {
			throw new BusinessException("El monto " + monto + " supera " + montoMaximoSafeShop + " que es el monto máximo");
		}
		cliente.comprar(monto);
	}
	
	public SafeShop(int montoMaximoSafeShop, Cliente cliente) {
		this.montoMaximoSafeShop = montoMaximoSafeShop;
		this.cliente = cliente;
	}

}
