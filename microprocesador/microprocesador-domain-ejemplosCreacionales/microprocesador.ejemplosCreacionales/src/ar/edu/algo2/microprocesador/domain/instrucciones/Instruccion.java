package ar.edu.algo2.microprocesador.domain.instrucciones;

import ar.edu.algo2.microprocesador.domain.Microcontroller;
import ar.edu.algo2.microprocesador.processing.ProgramIterator;

public abstract class Instruccion {

	public abstract void execute(Microcontroller micro);

	public void prepare(ProgramIterator programIterator) {
		// Por default no hago nada
	}
	
}
