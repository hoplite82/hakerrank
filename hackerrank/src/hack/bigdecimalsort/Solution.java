package hack.bigdecimalsort;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		// Input
		Scanner sc = new Scanner(new File("testdata/hack_BigDecimal/input"));
		int n = sc.nextInt();
		String[] s = new String[n + 2];
		for (int i = 0; i < n; i++) {
			s[i] = sc.next();
		}
		sc.close();
		String temp;
		// find duplets and store them in List and reduce Array
		List<String> eq = new ArrayList<>();

		List<String> ss = Arrays.asList(s);

		ss = ss.stream().filter(Objects::nonNull).sorted(
				(String s1, String s2) -> {
					BigDecimal num1 = new BigDecimal(s1);
					BigDecimal num2 = new BigDecimal(s2);					
					return num2.compareTo(num1);
				}
		).collect(Collectors.toList());
		
//		for (int i = 0; i < n; i++) {
//			for (int j = i + 1; j < n; j++) {
//				BigDecimal numi = new BigDecimal(ss.get(i));
//				BigDecimal numj = new BigDecimal(s[j]);
//
//				if (numi.compareTo(numj) == -1) {
//					temp = ss.get(i);
//					ss.add(i, s[j]);
//					ss.add(i, temp);
//				} else if (numi.compareTo(numj) == 0) {
//					eq.add(ss.get(i));
//				}
//
//			}
//		}
//		for (int i = 0; i < s.length; i++) {
//			BigDecimal numi = new BigDecimal(s[i]);
//			if(numi.compareTo(numj) == -1))
//		}

		/*
		 * BigDecimal[] nums = new BigDecimal[n]; for(int i=0;i<n;i++){ BigDecimal num =
		 * new BigDecimal(s[i]); num.intValueExact() nums[i]=num; }
		 * 
		 * Arrays.sort(nums,Collections.reverseOrder()); for(int i=0;i<n;i++){ s[i] =
		 * nums[i].toString(); }
		 */
		// Output
		for (int i = 0; i < n; i++) {
			System.out.println(ss.get(i));
		}
	}
}