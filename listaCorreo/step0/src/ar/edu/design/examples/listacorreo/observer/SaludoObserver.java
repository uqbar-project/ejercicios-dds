package ar.edu.design.examples.listacorreo.observer;

import ar.edu.design.examples.listacorreo.domain.Mail;

public class SaludoObserver implements ListaCorreoObserver {

	@Override
	public void notifyRecibiMensaje(Mail mail) {
		if (mail.getAsunto().contains("Hola")) {
			System.err.println("OJO: Este mail tiene hola: " + mail);
		}

	}

}
