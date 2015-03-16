package pl.put.miasi.bank;

import java.util.List;

/**
 * 
 * @author Ryszard Wojtkowiak
 * 
 */

public class Banki {
	
	private List<Bank> banki;
	
	private int prefixLength = 8;

	private int prefixGenerator;
	
	private String prefix;

	public String getId()
	{
		prefixGenerator++;
		
		String fill = prefix;
		int diff = Integer.toString(prefixGenerator).length() - prefixLength;
		if(diff < 0)
		{
			while( diff < 0 )
			{
				diff++;
				fill = fill + '0';
			}
		}
		String tmp = fill + Integer.toString(prefixGenerator);
		
		while (banki.contains(tmp)) {
			prefixGenerator++;
			
			fill = prefix;
			diff = Integer.toString(prefixGenerator).length() - prefixLength;
			if(diff < 0)
			{
				while( diff < 0 )
				{
					diff++;
					fill = fill + '0';
				}
			}
			tmp = fill + Integer.toString(prefixGenerator);
			
			tmp = prefix + Integer.toString(prefixGenerator);
		}
		return tmp;
	}

	public Banki() {
		this.prefix = new String();
		prefixGenerator = 0;
	}

	public Banki(String prefix) {
		this.prefix = prefix;
		prefixGenerator = 0;
	}

	public Banki(List<Bank> banki) {
		this.banki = banki;
		prefixGenerator = 0;
	}

	public Banki(String prefix, List<Bank> banki) {
		this.prefix = prefix;
		this.banki = banki;
		prefixGenerator = 0;
	}

	public int getPrefixLength() {
		return prefixLength;
	}

	public void setPrefixLength(int prefixLength) {
		this.prefixLength = prefixLength;
	}
	
	
}
