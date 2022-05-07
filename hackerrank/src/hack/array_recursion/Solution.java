package hack.array_recursion;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

	public static boolean canWin(int leap, int[] game) {
		if(leap==0) {
			for (int element : game) {
				if (element==1) return false;
			}
			return true;
		}
		return canWin(leap, game, 0, true);
	}
	
	public static boolean canWin2(int leap, int[] game) {
		 return isSolvable(leap, game, 0);
	}
	
	private static boolean isSolvable(int leap, int[] game, int i) {
	    // Base Cases
	    if (i >= game.length) {
	        return true;
	    } else if (i < 0 || game[i] == 1) {
	        return false;
	    }
	            
	    game[i] = 1; // marks as visited

	    // Recursive Cases
	    return isSolvable(leap, game, i + leap) || 
	           isSolvable(leap, game, i + 1) || 
	           isSolvable(leap, game, i - 1);
	}

	public static boolean canWin(int leap, int[] game, int i, boolean forward) {
		int n = game.length;
		if (i + 1 >= n || (i + leap) >= n) {
			return true;
		} else {
			while (game[i + 1] == 0 && forward) {
				if (i + 1 + leap >= n)
					return true;

				++i;
			}

			if (game[i + leap] == 0) {
				if (canWin(leap, game, i + leap, forward))
					return true;
			}
			int j = 1;
			while ((i - 1) >= 0 && (game[i - 1] == 0 & (leap - j) > 0)) {
				if (game[i - 1 + leap] == 0) {
					if (canWin(leap, game, i - 1 + leap, true))
						return true;

				}

				j++;
				i--;

			}

		}
		return false;
	}

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new FileInputStream(new File("testdata/hack_arraygame/input01.txt")));
		int q = scan.nextInt();
		while (q-- > 0) {
			int n = scan.nextInt();
			int leap = scan.nextInt();

			int[] game = new int[n];
			for (int i = 0; i < n; i++) {
				game[i] = scan.nextInt();

			}

			System.out.println(canWin(leap, game) ? "YES" : "NO");
		}
		scan.close();
	}
}