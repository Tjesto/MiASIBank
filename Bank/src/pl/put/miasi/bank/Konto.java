package pl.put.miasi.bank;

/**
 * 
 * @author Mikołaj Szychowiak
 *
 */
public class Konto {

	private double saldo;
	
	private String ID;
	
	private final Wlasciciel wlasciciel;
	
	public Konto(Wlasciciel wlasciciel) {
		this.wlasciciel = wlasciciel;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}
	
}
