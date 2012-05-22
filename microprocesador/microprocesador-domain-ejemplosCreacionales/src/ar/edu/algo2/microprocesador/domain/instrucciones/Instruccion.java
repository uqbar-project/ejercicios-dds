package ar.edu.algo2.microprocesador.domain.instrucciones;

import ar.edu.algo2.microprocesador.domain.Microcontroller;

public interface Instruccion {

	public void execute(Microcontroller micro);

	public void prepare(Microcontroller micro);
	
}
