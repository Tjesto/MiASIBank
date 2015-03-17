package pl.put.miasi.bank;

/**
 * @author Miko�aj Ignaszak
 *
 */
public interface IAuthorization {

	abstract Boolean Authorization(Konto account, String pin);
	
	abstract Boolean Authorization(Konto account, Wlasciciel owner);
}
