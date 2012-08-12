package ar.edu.utn.frba.dds.ejercicios.introductorios;
import static net.sf.staccatocommons.lambda.Lambda.$;
import static net.sf.staccatocommons.lambda.Lambda._;
import static net.sf.staccatocommons.lambda.Lambda.lambda2;
import static net.sf.staccatocommons.numbers.NumberTypes.integer;

import java.util.Collection;

import net.sf.staccatocommons.collections.stream.Streams;
import net.sf.staccatocommons.defs.predicate.Predicate2;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class SimpleModeloExamen implements ModeloExamen {

  private final CondicionAprobacion condicionAprobacion;
  private final Collection<Pregunta> preguntas;

  public SimpleModeloExamen(CondicionAprobacion condicionAprobacion, Collection<Pregunta> preguntas) {
    this.condicionAprobacion = condicionAprobacion;
    this.preguntas = preguntas;
  }

  @Override
  public int puntaje(Collection<Object> respuestas) {
    return Streams
      .from(preguntas)
      .zip(respuestas, lambda2($(Pregunta.class).puntaje(_)))
      .sum(integer());
  }

  @Override
  public int cantidadRespuestasCorrectas(Collection<Object> respuestas) {
    return Streams
      .from(preguntas)
      .zip(respuestas)
      .countOf(l2($(Pregunta.class).esCorrecta(_)).uncurry());
  }
  
  private Predicate2 l2(boolean esCorrecta) {
    return lambda2(esCorrecta);
  }

  @Override
  public boolean aprobo(Examen examen) {
    return condicionAprobacion.aprobo(examen);
  }

}
