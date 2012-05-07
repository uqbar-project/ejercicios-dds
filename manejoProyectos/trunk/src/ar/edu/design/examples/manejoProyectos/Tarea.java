package ar.edu.design.examples.manejoProyectos;

import java.util.ArrayList;
import java.util.Collection;

public class Tarea {

	private Complejidad complejidad;
	private Collection<Impuesto> impuestos;
	private int tiempo;
	private TipoDeTarea tipoDeTarea;

	public Tarea() {
		this.complejidad = new ComplejidadMinima();
		this.impuestos = new ArrayList<Impuesto>();
		this.tiempo = 0;
		this.tipoDeTarea = new TareaSimple();
	}
	
	public double getCosto() {
		return tipoDeTarea.getCosto(this);
	}

	public double getCostoTotal() {
		return tipoDeTarea.getCostoTotal(this);
	}
	
	public double getCostoBase() {
		double costo = this.complejidad.getCosto(this);
		return costo + this.getCostoImpositivo(costo);	
	}

	public double getCostoImpositivo(double costo) {
		double total = 0;
		for (Impuesto impuesto : this.impuestos) {
			total += impuesto.getCostoImpositivo(costo);
		}
		return total;
	}

	public TipoDeTarea getTipoDeTarea() {
		return tipoDeTarea;
	}

	public void setCompuesta() {
		this.tipoDeTarea = new TareaCompuesta();
	}

	public void setSimple() {
		this.tipoDeTarea = new TareaSimple();
	}

	public int getTiempo() {
		return tiempo;
	}

	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}

	public void setComplejidad(Complejidad complejidad) {
		this.complejidad = complejidad;
	}

	public void agregarSubtarea(Tarea tarea) {
		this.tipoDeTarea.agregarSubtarea(tarea);
	}

}

