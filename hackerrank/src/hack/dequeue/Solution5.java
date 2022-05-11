package hack.dequeue;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Scanner;

public class Solution5 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Deque<Integer> deque = new ArrayDeque<>();
		int n = in.nextInt();
		int m = in.nextInt();
		int max = 0;
		HashSet<Integer> hs = new HashSet<Integer>();

		for (int i = 0; i < n; i++) {
			int num = in.nextInt();

			deque.add(num);
			hs.add(num);

			if (deque.size() == m + 1) {

				int q_out = (int) deque.remove();

				if (!deque.contains(q_out)) {
					hs.remove(q_out);

				}

			}

			max = Math.max(hs.size(), max);

		}
		
		System.out.println(max);
		in.close();
	}
}