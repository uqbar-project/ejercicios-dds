package ar.edu.design.examples.manejoProyectos;

public abstract class Complejidad {

	public double getCosto(Tarea tarea) {
		return tarea.getTiempo() * 25;
	}

}
