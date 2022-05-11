package hack.dequeue;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
//		System.out.println(
//				"""
//				10 3
//				1 2 1 1 1 2 3 1 1 2
//				""");
		Scanner in = new Scanner(new FileInputStream(new File("testdata/hack_dequeue/input08.txt")));

		int n = in.nextInt();
		int m = in.nextInt();
		int max = Integer.MIN_VALUE;

		Deque<Integer> deque = new ArrayDeque<>(m);

		for (int i = 0; i < n; i++) {
			int num = in.nextInt();
			System.out.println(num +" "+ max);
			if (i < m) {
				deque.add(num);
				int c = (int) deque.stream().distinct().count();				
				if (max < c)
					max = c;
			} else if(i<m){
				deque.add(num);
				deque.remove();
				int c = (int) deque.stream().distinct().count();				
				if (max < c)
					max = c;
				
			}
			

		}
		System.out.println(max);
	}

}
