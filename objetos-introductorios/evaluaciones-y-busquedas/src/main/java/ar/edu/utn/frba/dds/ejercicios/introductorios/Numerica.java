package ar.edu.utn.frba.dds.ejercicios.introductorios;

import net.sf.staccatocommons.check.Ensure;
import net.sf.staccatocommons.util.Range;

public class Numerica extends AbstractPregunta<Integer> {

  public Numerica(Integer respuestaCorrecta, Integer puntaje, Range<Integer> rangoCorrecto,
    Integer puntajeRango) {
    super(respuestaCorrecta, puntaje);
    this.rangoCorrecto = rangoCorrecto;
    this.puntajeRango = puntajeRango;
  }

  private final Range<Integer> rangoCorrecto;
  private final Integer puntajeRango;

  @Override
  public Integer puntajeAproximado(Integer respuesta) {
    return puntajeRango;
  }

  @Override
  protected boolean esAproximada(Integer respuesta) {
    return (rangoCorrecto.contains(respuesta));
  }

}
