package hack.dequeue.test;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import hack.dequeue.Solution2;

@RunWith(Parameterized.class)
public class SolutionTest2 {
	private final InputStream systemIn = System.in;
	private final PrintStream systemOut = System.out;

	private ByteArrayInputStream testIn;
	private ByteArrayOutputStream testOut;

	@Before
	public void setUpOutput() {
		testOut = new ByteArrayOutputStream();
		System.setOut(new PrintStream(testOut));
	}

	private void provideInput(String data) {
		testIn = new ByteArrayInputStream(data.getBytes());
		System.setIn(testIn);
	}
	
	private String getOutput() {
		return testOut.toString().trim();
	}

	@After
	public void restoreSystemInputOutput() {
		System.setIn(systemIn);
		System.setOut(systemOut);
	}

	@Parameter(0)
	public Path path_to_input;

	@Parameter(1)
	public String expected;
	
	

	@Parameters(name = "index: {index}: expected: {1}")
	public static Object[][] data() {
		return new Object[][] {
				{ Path.of("testdata/hack_dequeue/input01.txt"), "3"     },
				{ Path.of("testdata/hack_dequeue/input08.txt"), "94983" },
				{ Path.of("testdata/hack_dequeue/input02.txt"), "3"     },
				{ Path.of("testdata/hack_dequeue/input09.txt"), "94531" },
				{ Path.of("testdata/hack_dequeue/input10.txt"), "94055" },
		};
	}

	@Test
	public void testSolution() throws IOException {
//		Path pathtoexpected = Path.of("testdata/hack1/TestCaseData1/output");
//		Path pathtoinput = Path.of("testdata/hack1/TestCaseData1/input");
		
		final String input = Files.readString(path_to_input);
		provideInput(input);

		Solution2.main(new String[0]);
		
		assertEquals(expected.trim(), getOutput());
	}
}