package proyectosv1

abstract class Complejidad {
  def costoTarea(tarea: Tarea): BigDecimal
}

object ComplejidadMinima extends Complejidad {
  def costoTarea(tarea: Tarea) = tarea.costoBase
}

object ComplejidadMedia extends Complejidad {
  def costoTarea(tarea: Tarea) = tarea.costoBase * 1.05
}

object ComplejidadMaxima extends Complejidad {

  def costoTarea(tarea: Tarea) = {
    val costoSinAtrasos = tarea.costoBase * 1.07
    if (tarea.duracionEnDias <= 10)
      costoSinAtrasos
    else
      costoSinAtrasos + (tarea.duracionEnDias - 10) * 10
  }
}
