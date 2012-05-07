package ar.edu.design.examples.manejoProyectos;

public interface TipoDeTarea {

	public double getCosto(Tarea tarea);
	public double getCostoTotal(Tarea tarea);
	public void agregarSubtarea(Tarea tarea);
	
}
