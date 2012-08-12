package ar.edu.utn.frba.dds.ejercicios.introductorios;

import java.util.Collection;

import net.sf.staccatocommons.collections.stream.Streams;

public class Secuencia extends AbstractPregunta<Collection<Character>> {

  public Secuencia(Collection<Character> respuestaCorrecta, Integer puntaje) {
    super(respuestaCorrecta, puntaje);
  }

  @Override
  public boolean esCorrecta(Collection<Character> respuesta) {
    return super.esCorrecta(respuesta)
      || super.esCorrecta(Streams.from(respuesta).reverse().toList());
  }

}
