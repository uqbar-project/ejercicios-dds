package ar.edu.utn.frba.dds.ejercicios.introductorios;

import java.util.Collection;

public class SimpleExamen implements Examen {

  private final ModeloExamen modeloExamen;
  private final Collection<Object> respuestas;

  public SimpleExamen(ModeloExamen modeloExamen, Collection<Object> respuestas) {
    this.modeloExamen = modeloExamen;
    this.respuestas = respuestas;
  }

  @Override
  public int puntaje() {
    return modeloExamen.puntaje(respuestas);
  }

  @Override
  public int cantidadRespuestasCorrectas() {
    return modeloExamen.cantidadRespuestasCorrectas(respuestas);
  }

  @Override
  public boolean aprobo() {
    return modeloExamen.aprobo(this);
  }

}
