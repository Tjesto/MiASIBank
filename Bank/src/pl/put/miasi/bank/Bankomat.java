package pl.put.miasi.bank;

/**
 * @author Miko�aj Ignaszak
 *
 */
public class Bankomat implements IAuthorization {

	private double cashAmount;
	
	public Bankomat(double cashAmount){
		this.cashAmount = cashAmount;		
	}
	
	public Boolean Authorization(Konto account, String pin){
		Boolean correct = false;
		
		if(pin==account.getPin())
			correct = true;
		else
			throw new IllegalArgumentException("B��dny PIN");
		
		return correct;
	}
	
	public void Wyplata(double outCash, Konto account, String accountPassword){
		if(Authorization(account, accountPassword) ){
			if(outCash<=this.cashAmount){				
			cashAmount -= outCash;
			account.wyplata(outCash);
			}
			else
				throw new IllegalArgumentException("Brak wystarczaj�cych �rodk�w w bankomacie");
		}
	}

	public Boolean Authorization(Konto account, Wlasciciel owner) {	
		return null;
	}
}
