package ar.edu.design.examples.clientesTarjetaCredito.domain;


import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import ar.edu.design.examples.clientesTarjetaCredito.exceptions.BusinessException;

public class ClienteTest {
	
	ClientePosta cliente;
	ClientePosta gastatutti;
	ClientePosta promosao;
	ClientePosta mixto;

	@Before
	public void setUp() throws Exception {
		cliente = new ClientePosta(50);
		gastatutti = new ClientePosta(150, 30);
		promosao = new ClientePosta(40, true);
		mixto = new ClientePosta(50);
		mixto.agregarSafeShop(100);
		mixto.agregarPromocion();
	}
	
	@Test
	public void testPagar() {
		cliente.pagarVencimiento(50);
		Assert.assertFalse("El cliente es moroso", cliente.esMoroso());
	}

	@Test
	public void testComprar() {
		cliente.comprar(50);
		Assert.assertEquals(cliente.getDeuda(), 100);
	}

	@Test(expected = BusinessException.class)
	public void testComprarSafeShopNoDebo() {
		gastatutti.comprar(31);
	}

	@Test
	public void testComprarSafeShopPuedo() {
		gastatutti.comprar(30);
	}
	
	@Test
	public void testComprarPromocionSinAcumular() {
		promosao.comprar(30);
		Assert.assertEquals(0, promosao.getPuntos());
	}

	@Test
	public void testComprarPromocionAcumulandoPuntos() {
		promosao.comprar(60);
		Assert.assertEquals(15, promosao.getPuntos());
	}
	
	@Test
	public void testComprarAcumulandoPuntosParaMixto() {
		mixto.comprar(60);
		Assert.assertEquals(15, mixto.getPuntos());
		Assert.assertEquals(110, mixto.getDeuda());
	}
	
	@Test(expected = BusinessException.class)
	public void testComprarSobrepasandoMaximoSafeShopParaMixto() {
		mixto.comprar(110);
	}
}
