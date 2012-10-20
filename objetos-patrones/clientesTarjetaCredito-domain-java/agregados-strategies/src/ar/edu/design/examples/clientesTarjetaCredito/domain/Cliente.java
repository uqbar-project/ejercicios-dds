package ar.edu.design.examples.clientesTarjetaCredito.domain;

public interface Cliente {

	public void comprar(int monto);
	
	public void pagarVencimiento(int monto);

	public void agregarPuntos(int puntos);

}
