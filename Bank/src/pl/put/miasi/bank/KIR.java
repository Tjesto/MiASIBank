package pl.put.miasi.bank;

/**
 * @author Mikołaj Szychowiak
 *
 */
public final class KIR {

	private static KIR kir;
	
	private KIR() {
		//empty
	}
	
	public static KIR getKir() {
		if (kir == null) {
			kir = new KIR();
		}
		return kir;
	}
	
}
