package ar.edu.utn.frba.dds.ejercicios.introductorios;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import net.sf.staccatocommons.collections.Lists;
import net.sf.staccatocommons.util.Range;

import org.junit.Before;
import org.junit.Test;

import ar.edu.utn.frba.dds.ejercicios.introductorios.CondicionAprobacionPuntajeMinimo;
import ar.edu.utn.frba.dds.ejercicios.introductorios.Examen;
import ar.edu.utn.frba.dds.ejercicios.introductorios.Numerica;
import ar.edu.utn.frba.dds.ejercicios.introductorios.Pregunta;
import ar.edu.utn.frba.dds.ejercicios.introductorios.Secuencia;
import ar.edu.utn.frba.dds.ejercicios.introductorios.SimpleExamen;
import ar.edu.utn.frba.dds.ejercicios.introductorios.SimpleModeloExamen;

@SuppressWarnings("rawtypes")
public class SimpleExamenTestDriver {

  Examen examen;

  @Before
  public void setup() {
    examen = new SimpleExamen( //
      new SimpleModeloExamen( //
        new CondicionAprobacionPuntajeMinimo(4),
        Lists.<Pregunta> from(
          new Numerica(1922, 5, Range.from(1920, 1925), 2),
          new Secuencia(Lists.from('a', 'd', 'c', 'b'), 5))), //
      Lists.from(1924, Lists.from('a', 'd', 'c', 'b')));
  }

  @Test
  public void puntajeExamen() throws Exception {
    assertEquals(7, examen.puntaje());
  }

  @Test
  public void aproboExamen() throws Exception {
    assertTrue(examen.aprobo());
  }

}
