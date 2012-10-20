package ar.edu.design.examples.manejoProyectos;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import ar.edu.design.examples.manejoProyectos.exceptions.BusinessException;


public class TestTarea {

	private Tarea fregar;
	private Tarea darClase;

	@Before
	public void initialize() {
		fregar = new Tarea();
		fregar.setTiempo(20);
		darClase = new Tarea();
		darClase.setCompuesta();
		darClase.setTiempo(15);
		darClase.agregarSubtarea(fregar);
		darClase.agregarSubtarea(fregar);
		darClase.agregarSubtarea(fregar);
		darClase.agregarSubtarea(fregar);
	}

	@Test
	public void testCostoSimple() {
		System.out.println(fregar);
		Assert.assertEquals(fregar.getCosto(), 500.0);
	}

	@Test
	public void testCostoCompuesta() {
		Assert.assertEquals(darClase.getCosto(), 390.0);
	}

	@Test(expected = BusinessException.class)
	public void testAgregarSubtareaATareaSimple() {
		fregar.agregarSubtarea(new Tarea());
	}

	@Test
	public void convertirASimple() {
		darClase.setSimple();
		Assert.assertEquals(darClase.getCosto(), 375.0);
	}

}
