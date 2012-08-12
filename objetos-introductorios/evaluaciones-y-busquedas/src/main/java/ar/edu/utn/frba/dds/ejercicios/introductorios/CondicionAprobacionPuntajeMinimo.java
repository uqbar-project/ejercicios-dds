package ar.edu.utn.frba.dds.ejercicios.introductorios;

public class CondicionAprobacionPuntajeMinimo implements CondicionAprobacion {

  private final int puntajeMinimo;

  public CondicionAprobacionPuntajeMinimo(int puntajeMinimo) {
    this.puntajeMinimo = puntajeMinimo;
  }

  @Override
  public boolean aprobo(Examen examen) {
    return examen.puntaje() >= puntajeMinimo;
  }

}
