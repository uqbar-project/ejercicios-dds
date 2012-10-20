package ar.edu.design.examples.manejoProyectos;

public class Impuesto {

	private double porcentaje;
	
	public double getCostoImpositivo(double costo) {
		return this.porcentaje * costo / 100;
	}

}
