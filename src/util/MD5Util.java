package util;

import java.security.MessageDigest;

import static oracle.jdbc.driver.OracleLog.byteToHexString;

public class MD5Util {
	private final static String[] hexDigits = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d",
			"e", "f" };
	private static MD5Util md5Util;
	private MD5Util(){}

	public static MD5Util getInstance(){
		if(md5Util != null){
			md5Util = new MD5Util();
		}
		return md5Util;
	}

	public String encodeByMD5(String originString) {
		if (originString != null) {
			try {
				MessageDigest md = MessageDigest.getInstance("MD5");
				byte[] results = md.digest(originString.getBytes());
				String resultString = byteArrayToHexString(results);
				return resultString.toUpperCase();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return null;
	}

	private static String byteArrayToHexString(byte[] results) {
		StringBuffer resultSb = new StringBuffer();
		for (int i = 0; i < results.length; i++) {
			resultSb.append(byteToHexString(results[i]));
		}
		return resultSb.toString();
	}

	private static String byteToHexString(byte b) {
		int n = b;
		if (n < 0) {
			n = 256 + n;
		}
		int d1 = n / 16;
		int d2 = n % 16;
		return hexDigits[d1] + hexDigits[d2];
	}
}
