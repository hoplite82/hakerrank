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
			return canWin(leap, game, 0, true, null);
//		int n = game.length - 1;
//		int i = n-1;		
//
//		Deque<Integer> winPoses;
//		do {
//			winPoses = findAllWinPos(leap, game, i);
//			
//			
//			
//		} while (!winPoses.isEmpty());
//		return false;

	}

	static Deque<Integer> findAllWinPos(int leap, int[] game, int i) {
		Deque<Integer> winPoses = new ArrayDeque<>();
		int j = i;
		while (game[j--] == 0)
			leap++;
		while (leap >= 0) {
			if (game[i - leap] == 0)
				winPoses.add(i - leap);
			leap--;
		}
		return winPoses;
	}

	public static boolean canWin(int leap, int[] game, int i, boolean forward, Deque<Integer> leapposes) {
		int n = game.length;

		if (i + 1 >= n || (i + leap) >= n) {
			return true;
		} else if (game[i - 1] == 0) {
			return canWin(leap, game, i - 1, false);
		}
			
			
			
			leapposes = new ArrayDeque<>();
			if (game[i + 1] == 0 && forward) {
				if (game[i + leap] == 0)
					leapposes.push(i);
			} else if (game[i + leap] == 0) {
				return canWin(leap, game, i + leap, true, leapposes);
			}  else if (!leapposes.isEmpty()) {
				i = leapposes.pop();
				return canWin(leap, game, i + leap, true, leapposes);
			} else {
			
			} else if(i - 1 < 0) {
				return false;
			}
		}
		return false;

//				
//
//				for (int j = 1; i + j <= i + leap; j++) {
//					if (game[j + i] == 0)
//						stack.push(j+1);
//						next.add(j + i);
//				}
//				if (!next.isEmpty()) {
//					while(!next.isEmpty()) {
//						int nextpos = next.pollLast();
//						int nextinstack = next.pop();
//						
//						
//					}
////					if (game[i - 1] == 0) {
////						return canWin(leap, game, i - 1, false);
////					} else {
////						// calc jumps
////						return false;
////					}

	}

	}

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new FileInputStream(new File("testdata/hack_arraygame/inunit.txt")));
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