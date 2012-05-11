package ar.edu.design.examples.clientesTarjetaCredito.domain;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import ar.edu.design.examples.clientesTarjetaCredito.exceptions.BusinessException;

public class ClienteTest {

	Cliente cliente;
	Cliente gastatutti;
	Cliente promosao;
	Cliente mixto;

	@Before
	public void setUp() throws Exception {
		cliente = new ClientePosta(50);
		gastatutti = new SafeShop(30, new ClientePosta(150));
		promosao = new Promocion(new ClientePosta(40));
		mixto = new SafeShop(100, new Promocion(new ClientePosta(50)));
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

//	no puedo probarlo de manera sencilla, debo agregar una validación
//	hardcoded en el constructor de Promocion ==> si el cliente es
//	de tipo SafeShop kaboommm throw an Exception
//	@Test(expected = BusinessException.class)
//	public void testClienteConPromocionYDespuesSafeShop() {
//		ClientePosta badCustomer = new ClientePosta(50);
//		badCustomer.agregarPromocion();
//		badCustomer.agregarSafeShop(88);
//	}

	/**
	 * 
	 * public void agregarSafeShop(int montoMaximoSafeShop) { if
	 * (!this.condicionesCompra.isEmpty()) { throw new BusinessException(
	 * "No puede agregar safe shop a clientes con otras condiciones"); }
	 * this.condicionesCompra.add(new SafeShop(montoMaximoSafeShop)); }
	 * 
	 * public void agregarPromocion() { this.condicionesCompra.add(new
	 * Promocion()); }
	 */
}
