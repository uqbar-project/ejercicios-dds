package ar.edu.design.examples.manejoProyectos;

public class ComplejidadMedia extends Complejidad {

	@Override
	public double getCosto(Tarea tarea) {
		return super.getCosto(tarea) * 1.05;
	}

}
