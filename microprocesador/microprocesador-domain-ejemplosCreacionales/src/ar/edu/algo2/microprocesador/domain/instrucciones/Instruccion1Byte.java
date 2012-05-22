package ar.edu.algo2.microprocesador.domain.instrucciones;

import ar.edu.algo2.microprocesador.domain.Microcontroller;

public abstract class Instruccion1Byte implements Instruccion {

	@Override
	public abstract void execute(Microcontroller micro);

	@Override
	public void prepare(Microcontroller micro) {
		// Por default, no hago nada
	}

}
