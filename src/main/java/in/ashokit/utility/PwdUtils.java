package in.ashokit.utility;

import org.apache.commons.lang3.RandomStringUtils;

public class PwdUtils {
	
	public static String generateRandomPwd() {
		
		String possibleCharacters = (new String("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"));//.toCharArray();
		String pwd = RandomStringUtils.random(6 , possibleCharacters);
		//System.out.println( pwd);
		return pwd;
	}

}
