package pl.put.miasi.bank;

import java.util.List;

/**
 * 
 * @author Ryszard Wojtkowiak
 * 
 */
public class Konta {

	private List<Konto> konta;

	private String prefix;
	
	private int prefixLength = 8;

	private int IDGenerator;

	public String getId() {
		IDGenerator++;
		
		String fill = prefix;
		int diff = Integer.toString(IDGenerator).length() - prefixLength;
		if(diff < 0)
		{
			while( diff < 0 )
			{
				diff++;
				fill = fill + '0';
			}
		}
		String tmp = fill + Integer.toString(IDGenerator);
		
		while (konta.contains(tmp)) {
			IDGenerator++;
			
			fill = prefix;
			diff = Integer.toString(IDGenerator).length() - prefixLength;
			if(diff < 0)
			{
				while( diff < 0 )
				{
					diff++;
					fill = fill + '0';
				}
			}
			tmp = fill + Integer.toString(IDGenerator);
			
			tmp = prefix + Integer.toString(IDGenerator);
		}
		return tmp;
	}

	public String getPrefix() throws Exception {
		if (prefix == null) {
			throw new Exception("prefix is null");
		}
		else if( !prefix.matches("[0-9]+")){
			throw new Exception("prefix contains not only numbers");
		}
		else if( prefix.length() != prefixLength )
		{
			throw new Exception("prefix is too long or too short");
		}
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public List<Konto> getKonta() {
		return konta;
	}

	public void setKonta(List<Konto> konta) {
		this.konta = konta;
	}

	public Konta() {
		this.prefix = new String();
		IDGenerator = 0;
	}

	public Konta(String prefix) {
		this.prefix = prefix;
		IDGenerator = 0;
	}

	public Konta(List<Konto> konta) {
		this.konta = konta;
		IDGenerator = 0;
	}

	public Konta(String prefix, List<Konto> konta) {
		this.prefix = prefix;
		this.konta = konta;
		IDGenerator = 0;
	}

	public int getPrefixLength() {
		return prefixLength;
	}

	public void setPrefixLength(int prefixLength) {
		this.prefixLength = prefixLength;
	}
}
