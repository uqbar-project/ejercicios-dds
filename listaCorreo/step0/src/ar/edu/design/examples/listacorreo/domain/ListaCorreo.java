package ar.edu.design.examples.listacorreo.domain;

import java.util.ArrayList;
import java.util.List;

import ar.edu.design.examples.listacorreo.observer.ListaCorreoObserver;

public class ListaCorreo {

	public TipoEnvioMails getTipoEnvio() {
		return tipoEnvio;
	}

	public void setTipoEnvio(TipoEnvioMails tipoEnvio) {
		this.tipoEnvio = tipoEnvio;
	}

	TipoEnvioMails tipoEnvio;
	List<ListaCorreoObserver> observers;
	
	public ListaCorreo() {
		observers = new ArrayList<ListaCorreoObserver>();
	}
	
	public void addObserver(ListaCorreoObserver observer) {
		observers.add(observer);
	}
	
	public void enviarCorreo(Mail mail) {
	    tipoEnvio.enviarCorreo(mail, this);
	}
	
	public void recibiMensaje(Mail mail) {
		for (ListaCorreoObserver observer : observers) {
			observer.notifyRecibiMensaje(mail);
		}
	}

	public boolean contieneUsuario(String mailOrigen) {
		// TODO: Implementarlo
		return true;
	}
	
}
