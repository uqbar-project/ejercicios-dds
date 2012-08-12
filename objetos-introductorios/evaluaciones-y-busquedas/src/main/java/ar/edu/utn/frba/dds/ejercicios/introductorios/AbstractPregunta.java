package ar.edu.utn.frba.dds.ejercicios.introductorios;

public abstract class AbstractPregunta<TipoRespuesta> implements Pregunta<TipoRespuesta> {

  private final TipoRespuesta respuestaCorrecta;
  private final Integer puntaje;
  
  public AbstractPregunta(TipoRespuesta respuestaCorrecta, Integer puntaje) {
    this.respuestaCorrecta = respuestaCorrecta;
    this.puntaje = puntaje;
  }

  @Override
  public Integer puntaje(TipoRespuesta respuesta) {
    if (esCorrecta(respuesta))
      return puntaje;

    if (esAproximada(respuesta))
      return puntajeAproximado(respuesta);

    return 0;
  }

  @Override
  public boolean esCorrecta(TipoRespuesta respuesta) {
    return respuestaCorrecta.equals(respuesta);
  }

  protected Integer puntajeAproximado(TipoRespuesta respuesta) {
    throw new UnsupportedOperationException();
  }

  protected boolean esAproximada(TipoRespuesta respuesta) {
    return false;
  }

}
