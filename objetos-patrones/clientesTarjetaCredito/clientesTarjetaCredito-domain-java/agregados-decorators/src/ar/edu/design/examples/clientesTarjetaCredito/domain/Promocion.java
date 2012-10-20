package ar.edu.design.examples.clientesTarjetaCredito.domain;

public class Promocion extends ClienteConCondicionComercial {

	public Promocion(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public void comprar(int monto) {
		cliente.comprar(monto);
		if (monto > 50) {
			cliente.agregarPuntos(15);
		}
	}

}
