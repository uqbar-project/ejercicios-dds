package ar.edu.design.examples.clientesTarjetaCredito.domain;

import ar.edu.design.examples.clientesTarjetaCredito.exceptions.BusinessException;

public class SafeShop implements CondicionComercial {

	private int montoMaximoSafeShop;

	@Override
	public void comprar(int monto, Cliente cliente) {
		if (monto > montoMaximoSafeShop) {
			throw new BusinessException("El monto " + monto + " supera " + montoMaximoSafeShop + " que es el monto máximo");
		}
	}
	
	public SafeShop(int montoMaximoSafeShop) {
		this.montoMaximoSafeShop = montoMaximoSafeShop;
	}

}
