package ar.edu.design.examples.clientesTarjetaCredito.domain;

public class ClientePosta implements Cliente {

	int deuda;
	
	public ClientePosta() {
		deuda = 0;
	}
	
	public ClientePosta(int montoInicial) {
		deuda = montoInicial;
	}

	@Override
	public void comprar(int monto) {
		deuda += monto;
	}

	@Override
	public void pagarVencimiento(int monto) {
		deuda -= monto;

	}

	@Override
	public boolean esMoroso() {
		return deuda != 0;
	}

	@Override
	public int getDeuda() {
		return deuda;
	}

}
