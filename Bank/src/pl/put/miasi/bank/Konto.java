package pl.put.miasi.bank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author Mikołaj Szychowiak
 *
 */
public class Konto {

	protected static class Wpis {
		private final Operacja operacja;
		private final List<Object> params;		
		public Wpis(Operacja operacja, Object... params) {
			this.operacja = operacja;
			this.params = new ArrayList<Object>(Arrays.asList(params));
		}
		public Operacja getOperacja() {
			return operacja;
		}
		public List<Object> getParams() {
			return params;
		}
		
	}
	
	private double saldo;
	
	private String ID;
	
	private final Wlasciciel wlasciciel;
	
	private final Map<Date, Wpis> historia;//co zamiast inta?

	private double debet;
	
	public Konto(Wlasciciel wlasciciel) {
		this(wlasciciel, 0);
	}
	
	public Konto(Wlasciciel wlasciciel, double saldo) {
		this.wlasciciel = wlasciciel;		
		this.saldo = saldo;
		historia = new HashMap<Date, Wpis>();		
	}	
	
	public void wplata(double kwota) {
		if (kwota >=0) {
			historia.put(new Date(System.currentTimeMillis()), new Wpis(Operacja.WPLATA, kwota));
			saldo += kwota;
		} else {
			throw new IllegalArgumentException("Wpłata nie może być ujemna");
		}
	}
	
	public void wyplata(double kwota) {
		if (kwota >=0 && saldo - kwota >= -debet) {
			historia.put(new Date(System.currentTimeMillis()), new Wpis(Operacja.WYPLATA, kwota));
			saldo += kwota;
		} else if (kwota >=0) {
			throw new IllegalStateException("Brak wystarczających środków na koncie");
		} else {
			throw new IllegalArgumentException("Wypłata nie może być ujemna");
		}
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public Wlasciciel getWlasciciel() {
		return wlasciciel;
	}

	public Map<Date, Wpis> getHistoria() {
		return historia;
	}

	public double getDebet() {
		return debet;
	}

	public void setDebet(double debet) {
		this.debet = debet;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}
	
}
