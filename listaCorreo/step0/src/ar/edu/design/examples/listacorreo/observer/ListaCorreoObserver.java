package ar.edu.design.examples.listacorreo.observer;

import ar.edu.design.examples.listacorreo.domain.Mail;

public interface ListaCorreoObserver {

	void notifyRecibiMensaje(Mail mail);

}
