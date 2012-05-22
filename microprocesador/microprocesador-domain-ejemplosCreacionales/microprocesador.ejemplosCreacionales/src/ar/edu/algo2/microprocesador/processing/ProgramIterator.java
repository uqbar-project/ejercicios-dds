package ar.edu.algo2.microprocesador.processing;

import java.util.Iterator;

import ar.edu.algo2.microprocesador.domain.instrucciones.Instruccion;
import ar.edu.algo2.microprocesador.exceptions.BusinessException;

public class ProgramIterator implements Iterator<Instruccion> {

	private byte[] bytecodes;
	private int programCounter;
	
	public int getProgramCounter() {
		return programCounter;
	}

	public ProgramIterator(byte[] bytecodes) {
		this.bytecodes = bytecodes;
		this.programCounter = 0;
	}
	
	/**
	 * Indica si hay instrucción siguiente
	 */
	@Override
	public boolean hasNext() {
		return this.getByteActual() != 0;
	}

	@Override
	public Instruccion next() {
		Instruccion instruction = InstruccionFactory.getInstance().getInstruction(this.readByteActual());
		instruction.prepare(this);
		return instruction;
	}

	private byte readByteActual() {
		byte value = this.getByteActual();
		this.programCounter++;
		return value;
	}
	
	private byte getByteActual() {
		return this.bytecodes[this.programCounter];
	}

	@Override
	public void remove() {
		throw new BusinessException("Operation not allowed");
	}

	public byte readValue() {
		return this.readByteActual();
	}

}
