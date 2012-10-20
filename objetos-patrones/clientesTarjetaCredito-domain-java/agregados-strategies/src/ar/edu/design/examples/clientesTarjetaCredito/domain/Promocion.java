package ar.edu.design.examples.clientesTarjetaCredito.domain;

public class Promocion implements CondicionComercial {

	@Override
	public void comprar(int monto, Cliente cliente) {
		if (monto > 50) {
			cliente.agregarPuntos(15);
		}
	}

}
