package ar.edu.design.examples.listacorreo.domain;

import ar.edu.design.examples.listacorreo.exception.BusinessException;

public class EnvioRestringidoMiembros extends TipoEnvioMails {

	@Override
	public void validarEnvio(Mail mail, ListaCorreo listaCorreo) {
		if (!listaCorreo.contieneUsuario(mail.getMailOrigen())) {
			throw new BusinessException(
					"El usuario no pertenece a la lista, no puede enviar mensajes a una lista restringida");
		}
	}

}
