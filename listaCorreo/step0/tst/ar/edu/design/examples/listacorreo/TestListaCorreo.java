package ar.edu.design.examples.listacorreo;


import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import ar.edu.design.examples.listacorreo.domain.EnvioAbierto;
import ar.edu.design.examples.listacorreo.domain.ListaCorreo;
import ar.edu.design.examples.listacorreo.domain.Mail;
import ar.edu.design.examples.listacorreo.observer.MockNotificacionMailObserver;
import ar.edu.design.examples.listacorreo.observer.SaludoObserver;

public class TestListaCorreo {

	private ListaCorreo listaDeGugle;
	private Mail mailParaSaludar;
	private MockNotificacionMailObserver notificacionObserver;

	@Before
	public void setUp() throws Exception {
		listaDeGugle = new ListaCorreo();
		notificacionObserver = new MockNotificacionMailObserver();
		listaDeGugle.addObserver(notificacionObserver);
		listaDeGugle.addObserver(new SaludoObserver());

		listaDeGugle.setTipoEnvio(new EnvioAbierto());
		mailParaSaludar = new Mail();
		mailParaSaludar.setAsunto("Hola mundo");
		mailParaSaludar.setMailOrigen("fdodino@algo2.com");
		mailParaSaludar.setDestinatarios("npasserini@phm.com");
		mailParaSaludar.setMensaje("Hey everybody");
	}
	
	@Test
	public void enviarMailOkListaAbierta() {
		listaDeGugle.enviarCorreo(mailParaSaludar);
		Assert.assertEquals(1, notificacionObserver.getCantidadMailsRecibidos());
	}

}
