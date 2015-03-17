package pl.put.miasi.bank;

/**
 * @author Miko³aj Ignaszak
 *
 */
public class Wplatomat implements IAuthorization {

	private double cashAmount;
	
	public Wplatomat(double cashAmount){
		this.cashAmount = cashAmount;		
	}
	
	public Boolean Authorization(Konto account, String pin){
		Boolean correct = false;
		
		if(pin==account.getPin())
			correct = true;
		else
			throw new IllegalArgumentException("B³êdny PIN");
		
		return correct;
	}
	
	public void Wplata(double inCash, Konto account, String accountPassword){
		if(Authorization(account, accountPassword)){
			cashAmount += inCash;
			account.wplata(inCash);
		}
	}
	
	public Boolean Authorization(Konto account, Wlasciciel owner) {		
		return null;
	}
}
