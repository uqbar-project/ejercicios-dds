package ar.edu.utn.frba.dds.ejercicios.introductorios;

import java.util.Collection;

public interface ModeloExamen {

  int puntaje(Collection<Object> respuestas);

  boolean aprobo(Examen examen);

  int cantidadRespuestasCorrectas(Collection<Object> respuestas);

}
