package ar.edu.design.examples.listacorreo.domain;


public abstract class TipoEnvioMails {

	public void enviarCorreo(Mail mail, ListaCorreo listaCorreo) {
		this.validarEnvio(mail, listaCorreo);
		listaCorreo.recibiMensaje(mail);
	}

	public void validarEnvio(Mail mail, ListaCorreo listaCorreo) {
	}

}
