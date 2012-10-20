package lista;

public interface ListaDeCorreo {

	void agregarUsuario (Usuario usuario);
	void agregarUsuarioPendiente (Usuario usuario);
	void suscribir(Usuario usuario);
	void confirmar (Usuario usuario);
	void agregarObservador(Observer observer);
}
