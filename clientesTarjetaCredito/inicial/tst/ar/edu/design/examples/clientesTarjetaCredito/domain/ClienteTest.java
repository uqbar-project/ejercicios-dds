package ar.edu.design.examples.clientesTarjetaCredito.domain;


import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class ClienteTest {
	
	Cliente cliente;

	@Before
	public void setUp() throws Exception {
		cliente = new ClientePosta(50);
	}
	
	@Test
	public void testPagar() {
		cliente.pagarVencimiento(50);
		Assert.assertFalse("El cliente no es moroso", cliente.esMoroso());
	}

	@Test
	public void testComprar() {
		cliente.comprar(50);
		Assert.assertEquals(cliente.getDeuda(), 100);
	}
	
}
