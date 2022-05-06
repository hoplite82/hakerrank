package hack.array_recursion;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.Stack;

public class Solution {

	public static boolean canWin(int leap, int[] game) {
		if (game[0] != 0)
			return false;
		else
			return canWin(leap, game, 0);

	}


	public static boolean canWin(int leap, int[] game, int i) {
		int n = game.length;
		if (i + 1 >= n || (i + leap) >= n) {
			return true;
		} else {
			int j = 0;
			while (game[i - 1] == 0 && (leap - j++) >= 0) {
				if (canWin(leap, game, i))
					return true;
				else
					i--;
//					game[i] = -1;

			}
			i = i + j;
			j = 0;
			while (game[i] == 0 && (leap - j++) >= 0) {
				if (canWin(leap, game, i))
					return true;
				else
					i--;
			}
		}
		return false;
	}


	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new FileInputStream(new File("testdata/hack_arraygame/input02.txt")));
		int q = scan.nextInt();
		while (q-- > 0) {
			int n = scan.nextInt();
			int leap = scan.nextInt();

			int[] game = new int[n];
			for (int i = 0; i < n; i++) {
				game[i] = scan.nextInt();
//				System.out.print(i + " ");
			}
//			System.out.println();
//			String line = canWin(leap, game) ? "YES\n" : "NO\n";
//
//			Files.write(Path.of("testdata/hack_arraygame/out.txt"),
//					line.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
//			System.out.println(canWin(leap, game) ? ((5000 - q) + " YES") : ((5000 - q) + " NO"));
			System.out.println(canWin(leap, game) ? "YES" : "NO");
		}
		scan.close();
	}
}