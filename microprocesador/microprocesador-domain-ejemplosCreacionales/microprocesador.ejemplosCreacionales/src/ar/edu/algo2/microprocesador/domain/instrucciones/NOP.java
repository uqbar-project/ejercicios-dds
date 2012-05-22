package ar.edu.algo2.microprocesador.domain.instrucciones;

import ar.edu.algo2.microprocesador.domain.Microcontroller;

public class NOP extends Instruccion {

	@Override
	public void execute(Microcontroller micro) {
		System.out.println("Ejecuto NOP");
	}

}
