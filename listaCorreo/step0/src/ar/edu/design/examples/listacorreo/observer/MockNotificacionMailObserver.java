package ar.edu.design.examples.listacorreo.observer;

import java.util.ArrayList;
import java.util.List;

import ar.edu.design.examples.listacorreo.domain.Mail;

public class MockNotificacionMailObserver implements ListaCorreoObserver {

	private List<Mail> casilla;
	
	public MockNotificacionMailObserver() {
		casilla = new ArrayList<Mail>();
	}
	
	@Override
	public void notifyRecibiMensaje(Mail mail) {
		System.out.println("Recibí un mensaje de " + mail.getMailOrigen() + ": " + mail.getAsunto());
		casilla.add(mail);
	}

	public int getCantidadMailsRecibidos() {
		return casilla.size();
	}
	
}
