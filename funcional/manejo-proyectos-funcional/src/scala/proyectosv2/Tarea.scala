package proyectosv2

sealed abstract class Tarea {
  def costo: BigDecimal = this match {
    case TareaSimple(_, complejidad, impuestos) => {
      val totalImpuestos = impuestos.sum
      complejidad(this) * (1 + totalImpuestos / 100)
    }
    case TareaCompuesta(tareas) => tareas.view.map(_.costo).sum
  }
  def duracionEnDias: Int = this match {
    case TareaSimple(duracion, _, _) => duracion
    case TareaCompuesta(tareas) => tareas.view.map(_.duracionEnDias).sum
  }
  def costoBase : BigDecimal = duracionEnDias * 25
}

final case class TareaSimple(
  duracion: Int,
  complejidad: Complejidad,
  impuestos: Collection[Impuesto]) extends Tarea

final case class TareaCompuesta(tareas: Collection[Tarea]) extends Tarea


