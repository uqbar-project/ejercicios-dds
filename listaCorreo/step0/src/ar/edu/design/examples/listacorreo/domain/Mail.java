package ar.edu.design.examples.listacorreo.domain;

public class Mail {
	
	private String asunto;
	private String mensaje;
	private String destinatarios;
	private String mailEmisor;
	
	public String getAsunto() {
		return asunto;
	}
	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public String getDestinatarios() {
		return destinatarios;
	}
	public void setDestinatarios(String destinatarios) {
		this.destinatarios = destinatarios;
	}
	public String getMailOrigen() {
		return mailEmisor;
	}
	public void setMailOrigen(String mailOrigen) {
		this.mailEmisor = mailOrigen;
	}
	
	public String toString() {
		return this.mensaje + " a " + this.destinatarios;
	}
}
