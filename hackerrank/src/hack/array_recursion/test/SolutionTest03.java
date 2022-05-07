package hack.array_recursion.test;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import hack.array_recursion.Solution;

@RunWith(Parameterized.class)
public class SolutionTest03 {

	@Parameter(0)
	public int[] game_array;

	@Parameter(1)
	public int leap;

	@Parameter(2)
	public String expected;

	@Parameters(name = "index: {index}: leap: {1} expected; {2} ")
	public static Object[][] data() throws IOException {
		List<TestInput> inputs = getInputs();
		List<String> expected = getExpected();
		int numberofcasesin = inputs.size();

		Object[][] testcasedata = new Object[numberofcasesin][3];
		for (int i = 0; i < testcasedata.length; i++) {
			TestInput in = inputs.get(i);
			testcasedata[i][0] = in.game;
			testcasedata[i][1] = in.leap;
			testcasedata[i][2] = expected.get(i);

		}

		return testcasedata;
	}

	public static List<TestInput> getInputs() throws FileNotFoundException {
		List<TestInput> inputs = new ArrayList<>();
		Scanner scan = new Scanner(new FileInputStream(new File("testdata/hack_arraygame/input03.txt")));
		int q = scan.nextInt();
		while (q-- > 0) {
			int n = scan.nextInt();
			int leap = scan.nextInt();

			int[] game = new int[n];
			for (int i = 0; i < n; i++) {
				game[i] = scan.nextInt();
			}
			TestInput casein = new TestInput(game, leap);
			inputs.add(casein);

		}
		scan.close();
		return inputs;
	}

	private static List<String> getExpected() throws FileNotFoundException {
		List<String> expected = new ArrayList<>();
		Scanner scan2 = new Scanner(new FileInputStream(new File("testdata/hack_arraygame/output03.txt")));
		expected = new ArrayList<String>();
		while (scan2.hasNextLine()) {
			expected.add(scan2.nextLine());
		}
		return expected;
	}

	

	@Test
	public void testCanWin() throws IOException {

		String actual = Solution.canWin(leap, game_array) ? "YES" : "NO";

		assertEquals(expected, actual);

	}
}
