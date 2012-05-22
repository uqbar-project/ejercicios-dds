package ar.edu.algo2.microprocesador.exceptions;

public class BusinessException extends RuntimeException {

	public BusinessException(String msg) {
		super(msg);
	}

	public BusinessException(String msg, Throwable e) {
		super(msg, e);
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
