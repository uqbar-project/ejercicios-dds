package ar.edu.algo2.microprocesador.domain;

import java.util.Iterator;

import ar.edu.algo2.microprocesador.domain.instrucciones.Instruccion;
import ar.edu.algo2.microprocesador.exceptions.BusinessException;
import ar.edu.algo2.microprocesador.processing.ProgramIterator;

public class MicrocontrollerImpl implements Microcontroller {

	private ProgramIterator programIterator;
	private boolean programStarted;
	private byte[] dataMemory;
	private byte aAcumulator;
	private byte bAcumulator;

	// TODO: Canales de E/S

	public MicrocontrollerImpl() {
		this.reset();
	}

	@Override
	public void loadProgram(byte[] program) {
		if (this.programStarted) {
			throw new BusinessException("Ya hay un programa en ejecución");
		}
		this.reset();
		this.programIterator = new ProgramIterator(program);
	}

	@Override
	public void reset() {
		this.programStarted = false;
		this.aAcumulator = (byte) 0;
		this.bAcumulator = (byte) 0;
		this.dataMemory = new byte[1024];
		this.programIterator = null;
	}

	@Override
	public void start() {
		this.programStarted = true;
	}

	@Override
	public void stop() {
		this.programStarted = false;
	}

	@Override
	public void step() {
		this.validarEjecucion();
		if (!this.programIterator.hasNext()) {
			throw new BusinessException("El programa ya terminó");
		}
		programIterator.next().execute(this);
	}

	public void validarEjecucion() {
		if (!this.programStarted) {
			throw new BusinessException("No hay un programa en ejecución");
		}
		if (this.programIterator == null) {
			throw new BusinessException("No hay un programa cargado en memoria");
		}
	}

	@Override
	public void setInput(byte channel, byte value) {
		// TODO Auto-generated method stub

	}

	@Override
	public byte getAAcumulator() {
		return this.aAcumulator;
	}

	@Override
	public void setAAcumulator(byte value) {
		this.aAcumulator = value;
	}

	@Override
	public byte getBAcumulator() {
		return this.bAcumulator;
	}

	@Override
	public void setBAcumulator(byte value) {
		this.bAcumulator = value;
	}

	@Override
	public byte getData(int addr) {
		return this.dataMemory[addr];
	}

	@Override
	public void setData(int addr, byte value) {
		this.dataMemory[addr] = value;
	}

	@Override
	public void updateAccumulators(int suma) {
		this.setBAcumulator(this.parteBaja(suma));
		this.setAAcumulator(this.parteAlta(suma));
	}

	private byte parteAlta(int valor) {
		return (byte) (Math.max(valor - Byte.MAX_VALUE, 0));
	}

	private byte parteBaja(int valor) {
		return (byte) (Math.min(Byte.MAX_VALUE, valor));
	}
	
	@Override
	public void run() {
		this.start();
		this.validarEjecucion();
		Iterator<Instruccion> it = this.programIterator;
		while (it.hasNext()) {
			Instruccion instruccion = (Instruccion) it.next();
			instruccion.execute(this);
		}
		this.stop();
	}

	@Override
	public int getPC() {
		return this.programIterator.getProgramCounter();
	}

}
