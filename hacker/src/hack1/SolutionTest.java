package hack1;

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

@RunWith(Parameterized.class)
public class SolutionTest {
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
	public Path path_to_expected;

	@Parameters
	public static Path[][] data() {
		return new Path[][] {
				{ Path.of("testdata/hack1/TestCaseData1/input"), Path.of("testdata/hack1/TestCaseData1/output") },
				{ Path.of("testdata/hack1/TestCaseData2/input"), Path.of("testdata/hack2/TestCaseData2/output") }

		};
	}

	@Test
	public void testSolution() throws IOException {
		Path pathtoexpected = Path.of("testdata/hack1/TestCaseData1/output");
		Path pathtoinput = Path.of("testdata/hack1/TestCaseData1/input");
		final String expected = Files.readString(pathtoexpected);
		final String input = Files.readString(pathtoinput);
		provideInput(input);

		Solution.main(new String[0]);

		assertEquals(expected.trim(), getOutput());
	}
}