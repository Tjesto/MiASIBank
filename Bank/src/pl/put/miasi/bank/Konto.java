package pl.put.miasi.bank;

/**
 * 
 * @author Mikołaj Szychowiak
 *
 */
public class Konto {

	private double saldo;
	
	private final Wlasciciel wlasciciel;
	
	public Konto(Wlasciciel wlasciciel) {
		this.wlasciciel = wlasciciel;
	}
	
}
