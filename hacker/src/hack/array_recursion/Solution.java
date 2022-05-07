package hack.array_recursion;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

	public static boolean canWin(int leap, int[] game) {
		if(leap==0) {
			for (int i = 0; i < game.length; i++) {
				if (game[i]==1) return false;
			}
			return true;
		}
		return canWin(leap, game, 0, true);
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

// else if (game[i + 1] == 0) {
//		if (canWin(leap, game, i + 1))
//			return true;
//		else {
//			game[i] = -1;
//		}
//
//		game[i] = -1;
//	} else if (game[i - 1] == 0) {
//		if (canWin(leap, game, i + 1))
//			return true;
//		else
//			game[i] = -1;
//	}

//		} else {return false;}
//			
//			if (game[i-1]==-1) {
//			int j = 0;
//			while(game[--i]==-1 & j++ < leap ) j++;
//			
//		} else if (game[i - 1] == 0) {
//			if (canWin(leap, game, i - 1)) return true; else {
//				
//			}
//		} else return false;

//			
//			int j = 0;
//			while (i-1>0 && (game[i - 1] == 0 & (leap - j++) >= 0)) {
//				if (canWin(leap, game, i))
//					return true;
//				else
//					i--;
////					game[i] = -1;
//
//			}
//			i = i + j;
//			j = 0;
//			while (game[i] == 0 && (leap - j++) >= 0) {
//				if (canWin(leap, game, i))
//					return true;
//				else
//					i++;
//			}
//		}
//		return false;

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new FileInputStream(new File("testdata/hack_arraygame/input01.txt")));
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