package ar.edu.utn.frba.dds.ejercicios.introductorios.uniformes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import ar.edu.utn.frba.dds.ejercicios.introductorios.uniformes.CentroProcesamiento;
import ar.edu.utn.frba.dds.ejercicios.introductorios.uniformes.Fabrica;
import ar.edu.utn.frba.dds.ejercicios.introductorios.uniformes.Material;
import ar.edu.utn.frba.dds.ejercicios.introductorios.uniformes.Oficina;
import ar.edu.utn.frba.dds.ejercicios.introductorios.uniformes.TintoreriaGrosa;
import ar.edu.utn.frba.dds.ejercicios.introductorios.uniformes.TintoreriaNormal;
import ar.edu.utn.frba.dds.ejercicios.introductorios.uniformes.Uniforme;

public class UniformesTestDriver {
	
	private Uniforme uniforme1, uniforme2, sacoAzul, pantalonBlanco;
	private Oficina manliba;
	private Fabrica inducol;
	private TintoreriaGrosa nakasone, nakamura;
	private TintoreriaNormal higa;
	
	@Before
	public void setUp() {
		Material lino = /*new Material(4);*/null;
		Material algodon = /*new Material(9);*/null;
		
		uniforme1 = /*new Uniforme(lino, "rojo", 2, 3);*/null;
		uniforme2 = /*new Uniforme(algodon, "negro", 5);*/null;
		sacoAzul = /*new Uniforme(algodon, "azul");*/null;
		pantalonBlanco = /*new Uniforme(lino, "blanco", 1);*/null;
		
		manliba = /*new Oficina("rojo");*/null;
		inducol = /*new Fabrica(9);*/null;
		
		uniforme1.setClienteAsignado(manliba);
		sacoAzul.setClienteAsignado(manliba);
		pantalonBlanco.setClienteAsignado(manliba);
		uniforme2.setClienteAsignado(inducol);
		
		nakasone = /*new TintoreriaGrosa();*/null;
		higa = /*new TintoreriaNormal();*/null;
		higa.aceptarMaterial(algodon);
		higa.aceptarColor("rojo");
		higa.aceptarColor("azul");
		nakamura  = /*new TintoreriaGrosa();*/null;
		
		CentroProcesamiento liniers = /*new CentroProcesamiento()*/null;
		liniers.agregarTaller(nakasone);
		liniers.agregarTaller(higa);
		liniers.recibirUniforme(uniforme2);
		liniers.recibirUniforme(sacoAzul);
		liniers.recibirUniforme(pantalonBlanco);
		
		CentroProcesamiento mataderos = /*new CentroProcesamiento();*/null;
		mataderos.agregarTaller(nakamura);
		mataderos.recibirUniforme(uniforme1);
	}
	

	@Test
	public void resistenciaUniforme1Es8Pepines() {
		assertEquals(8, uniforme1.getResistencia(), 0);
	}

	/**
	 * La resistencia del {@code uniforme2} es
	 * 
	 * <pre>
	 * resistencia base del algodón + 0.5 * refuezos = 9  + 0.5 * 5 = 9 + 2.5 = 11.5
	 * </pre>
	 */
	@Test
	public void resistenciaUniformes2Es11PepinesYMedio() {
		assertEquals(11.5, uniforme2.getResistencia(), 0);
	}

	/**
	 * {@code uniforme1} es rojo y {@code manliba} (el cliente
	 * asignado) quiere uniformes de ese color.
	 */
	@Test
	public void uniformes2EstáListo() {
		assertTrue(uniforme1.isListo());
	}
	
	/**
	 * El {@code sacoAzul} es azul y {@code manliba} (el cliente asignado) quiere uniformes rojos.
	 */
	@Test
	public void sacoAzulNoEstaListo() {
		assertFalse(sacoAzul.isListo());
	}
	
	/**
	 * El {@code uniforme1} tiene una resistencia de 11.5 pepines > 9 que es lo
	 * que pretende {@code inducol} (el cliente asignado)
	 */
	@Test
	public void uniforme2EstaListo() {
		assertTrue(uniforme2.isListo());
	}
	
	/**
	 * No tiene sentido (el uniforme 1 está listo).
	 */
	@Test(expected = IllegalStateException.class)
	public void noSePuedeIngresarUniforme1EnHiga() {
		higa.ingresar(uniforme1); 
	}
	
	/**
	 * El taller no permite al {@code lino} como material
	 */
	@Test(expected = IllegalStateException.class)  
	public void noSePuedeIngresarPantalonBlancoEnHiga() {
		higa.ingresar(pantalonBlanco);
	}
	
	/**
	 * Debe poderse, de manera que al final del test se verifique que:
	el sacoAzul esté dentro de los uniformes pendientes de trabajar por parte de higa
	el sacoAzul tenga un nuevo movimiento de stock.
	 * @throws Exception
	 */
	@Test
	public void sePuedeIngresarSacoAzuloEnHiga() throws Exception {
		fail("unimplemented");

	}
	/**9 Verificar que el test anterior no tuvo efecto colateral.	Debe verificarse que la lista de uniformes pendientes de la tintorería higa esté vacía. Entonces el envío simulado en el test anterior no trajo efecto colateral (tuvo efecto sólo dentro del test anterior)*/
	@Test
	public void testName2() throws Exception {
		fail("unimplemented");
	}
	
	@Test
	public void sacoAzulSeIngresaYTrabajaEnDosMovimientosYQuedaListo() throws Exception {
		higa.ingresar(sacoAzul);
	    higa.trabajar(sacoAzul);  
	    assertEquals(2, sacoAzul.cantidadMovimientos());
	    assertTrue(sacoAzul.isListo());		
	}
	
	/**
	 * 
	 * 11 Registrar:
	el envío del sacoAzul del centro de procesamiento liniers a la tintorería higa
	el trabajo de la tintorería higa sobre el sacoAzul
	el envío al cliente manliba de todos los uniformes listos
	Hay que verificar:
	que el centro de procesamiento genere un envío con un uniforme listo (el sacoAzul)
	El pantalonBlanco no debe formar parte del envío a manliba
	la tintorería higa no debe quedar con uniformes pendientes
	el centro de procesamiento liniers debe tener al pantalonBlanco como uniforme pendiente
	el centro de procesamiento liniers no debe tener al sacoAzul como uniforme pendiente
	 */
	@Test
	public void testName4() throws Exception {
		fail("unimplemented");
	}
	
}
