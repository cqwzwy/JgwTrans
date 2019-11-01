package T_valition;

import java.math.BigInteger;

public class getChars {
	
	public static char[] getChars(String hex) {
		
		Integer code=new BigInteger(hex,16).intValue();
		
		System.out.println(code);
		
		return Character.toChars(code);
	}
	
}
