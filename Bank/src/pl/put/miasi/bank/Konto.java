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
 * @author Mikolaj Szychowiak
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
	
	private String Id;
	
	private final Wlasciciel wlasciciel;
	
	private final Map<Date, Wpis> historia;//co zamiast inta?

	private double debet;
	
	private String pin;
	
	public Konto(Wlasciciel wlasciciel) {
		this(wlasciciel, 0);
	}
	
	public Konto(Wlasciciel wlasciciel, double saldo) {
		this.wlasciciel = wlasciciel;			
		this.saldo = Math.max(saldo, 0);
		historia = new HashMap<Date, Wpis>();		
	}	
	
	public void wplata(double kwota) throws IllegalArgumentException {
		if (kwota >=0) {
			historia.put(new Date(System.currentTimeMillis()), new Wpis(Operacja.WPLATA, kwota));
			saldo += kwota;
		} else {
			throw new IllegalArgumentException("Wp�ata nie mo�e by� ujemna");
		}
	}
	
	public void wyplata(double kwota) {
		if (kwota >=0 && saldo - kwota >= -debet) {
			historia.put(new Date(System.currentTimeMillis()), new Wpis(Operacja.WYPLATA, kwota));
			saldo -= kwota;
		} else if (kwota >=0) {
			throw new IllegalStateException("Brak wystarczaj�cych �rodk�w na koncie");
		} else {
			throw new IllegalArgumentException("Wyp�ata nie mo�e by� ujemna");
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

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		this.Id = id;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}
}
