package ar.edu.utn.frba.dds.ejercicios.introductorios;

public interface Pregunta<TipoRespuesta> {

  Integer puntaje(TipoRespuesta respuesta);

  boolean esCorrecta(TipoRespuesta respuesta);

}
