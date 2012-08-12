package ar.edu.utn.frba.dds.ejercicios.introductorios;

import net.sf.staccatocommons.util.Range;
import static org.junit.Assert.*;
import org.junit.Test;

import ar.edu.utn.frba.dds.ejercicios.introductorios.Numerica;

public class NumericaUnitTest {
  Numerica cantidadProvinciasArgentina = new Numerica(23, 3, Range.from(22, 24), 1);

  @Test
  public void numeroFueraDeRangoEsIncorrecto() throws Exception {
    assertFalse(cantidadProvinciasArgentina.esCorrecta(5));
    assertFalse(cantidadProvinciasArgentina.esCorrecta(25));
  }

  @Test
  public void numeroEnRangoPeroIncorrectoEsIncorrecto() throws Exception {
    assertFalse(cantidadProvinciasArgentina.esCorrecta(22));
  }

  @Test
  public void numeroExactoEsCorrecto() throws Exception {
    assertTrue(cantidadProvinciasArgentina.esCorrecta(23));
  }

  @Test
  public void numeroEnRangoTienePuntajeAproximado() throws Exception {
    assertEquals(1, (int) cantidadProvinciasArgentina.puntaje(22));
  }

  @Test
  public void numeroExactoTienePuntajeMaximo() throws Exception {
    assertEquals(3, (int) cantidadProvinciasArgentina.puntaje(23));
  }
  
  @Test
  public void numeroFueraDeRangoTienePuntajeCero() throws Exception {
    assertEquals(0, (int) cantidadProvinciasArgentina.puntaje(8));
  }

}
