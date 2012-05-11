package ar.edu.design.examples.clientesTarjetaCredito.domain;

import java.util.ArrayList;
import java.util.List;

import ar.edu.design.examples.clientesTarjetaCredito.exceptions.BusinessException;

public class ClientePosta implements Cliente {

	private int deuda;
	private List<CondicionComercial> condicionesCompra;
	private int puntos;
	
	/**
	 * METODOS ORIGINALES DEL REQUERIMIENTO
	 * 
	 */
	@Override
	public void comprar(int monto) {
		for (CondicionComercial condicion : condicionesCompra) {
			condicion.comprar(monto, this);
		}
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
		this.condicionesCompra = new ArrayList<CondicionComercial>();
	}
	
	public void agregarSafeShop(int montoMaximoSafeShop) {
		if (!this.condicionesCompra.isEmpty()) {
			throw new BusinessException("No puede agregar safe shop a clientes con otras condiciones");
		}
		this.condicionesCompra.add(new SafeShop(montoMaximoSafeShop));
	}

	public void agregarPromocion() {
		this.condicionesCompra.add(new Promocion());
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
