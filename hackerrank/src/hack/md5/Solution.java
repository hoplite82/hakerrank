package hack.md5;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.next();
		in.close();

		System.out.println(getMd5(s));
	}

	public static String getMd5(String input) {
		try {

			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] digest = md.digest(input.getBytes());
			 StringBuilder strBuilder = new StringBuilder();
			for (byte b : digest) {
				strBuilder.append(String.format("%02x", b));
			}
			String strHash = strBuilder.toString();
			return strHash;
		}

		// For specifying wrong message digest algorithms
		catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}

}
