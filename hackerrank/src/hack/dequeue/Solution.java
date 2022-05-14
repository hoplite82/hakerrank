package hack.dequeue;
<<<<<<< HEAD

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

=======
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<>();
        HashSet<Integer> set = new HashSet<>();
        
        int n = in.nextInt();
        int m = in.nextInt();
        int max = 0;

        for (int i = 0; i < n; i++) {
            int input = in.nextInt();
            
            deque.add(input);
            set.add(input);
            
            if (deque.size() >= m) {
                if (set.size() > max) max = set.size();
                int first = deque.remove();
                if (set.contains(first) && !deque.contains(first)) set.remove(first);
            }
            
        }
        in.close();
        System.out.println(max);
    }
>>>>>>> refs/heads/localbranch
}
