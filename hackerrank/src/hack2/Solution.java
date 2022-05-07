package hack2;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		List<BigInteger> inputs = new ArrayList<>();	
		List<BigInteger> primes = new ArrayList<>();
		int ni=5;
		while(ni-- >0 && scan.hasNextInt()) {
			BigInteger bi = BigInteger.valueOf(scan.nextInt());
			inputs.add(bi);
		}
		scan.close();
		for (int i=0;i<inputs.size();i++) {
			BigInteger bi = inputs.get(i);
			if(bi.isProbablePrime(100) || i==1) {
				if(i!=1) primes.add(bi);
				for(BigInteger prime : primes) System.out.print(prime+" ");				
				System.out.println("");
			} else {
				if(primes.size()==0) System.out.println(" ");
			}
		}
		
	}

}
