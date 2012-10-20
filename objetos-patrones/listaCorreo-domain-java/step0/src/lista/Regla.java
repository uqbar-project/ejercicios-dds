package lista;

public interface Regla {

	void aplicar(Mail mail);
	void siguiente(Regla regla);
	

}
