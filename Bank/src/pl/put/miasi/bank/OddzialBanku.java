package pl.put.miasi.bank;

/**
 * @author Miko�aj Ignaszak
 *
 */
public class OddzialBanku implements IAuthorization {

	private double cashAmount;
	
	public OddzialBanku(double cashAmount){
		this.cashAmount = cashAmount;		
	}

	public Boolean Authorization(Konto account, String pin) {
		
		return null;
	}

	public Boolean Authorization(Konto account, Wlasciciel owner) {
		Boolean correct = false;
		
		if(owner==account.getWlasciciel())
			correct = true;
		else
			throw new IllegalArgumentException("Brak dost�pu dla osoby nie b�d�cej w�a�cicielem konta");
		
		return correct;
	}
	
	public void Wplata(double inCash, Konto account, String accountPassword){
		if(Authorization(account, accountPassword)){
			cashAmount += inCash;
			account.wplata(inCash);
		}
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
}
